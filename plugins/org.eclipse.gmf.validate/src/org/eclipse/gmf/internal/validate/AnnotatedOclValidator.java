/*
 * Copyright (c) 2005, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *    Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.validate;

import java.text.MessageFormat;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.validate.expressions.ExpressionProviderRegistry;
import org.eclipse.gmf.internal.validate.expressions.IModelExpression;
import org.eclipse.gmf.validate.ValidationOptions;
import org.eclipse.osgi.util.NLS;

/**
 * This validator extends the checker for basic EObject constraints
 * with validation of OCL constraint annotation. 
 * 
 * @author dvorak
 */
public class AnnotatedOclValidator extends AbstractValidator implements EValidator {	
	
	/**
	 * Handles elements related to OCL annotations 
	 */
	private static ConstraintHandler oclHandler = new ConstraintHandler();
		
	/**
	 * Constructs validator
	 */
	public AnnotatedOclValidator() {
	}
			
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}
	
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validateOCL(eObject, diagnostics, context);
	}

	/**
	 * Performs <code>OCL annotation checks on the given object</code>
	 * </p>
	 * @param eObject the subject for validation 
	 * @param diagnostics diagnostics object to collect the results 
	 * @param context the context of validation activity
	 * @return <code>true</code>if object is valid; <code>false</code> otherwise
	 */
	protected boolean validateOCL(EObject eObject, final DiagnosticChain diagnostics, Map<Object, Object> context) {		
		if(eObject instanceof EAnnotation) {
			return oclHandler.handleEAnnotation((EAnnotation)eObject, diagnostics, context);
		}
		else if(eObject.eClass().getEPackage() != EcorePackage.eINSTANCE) {
			return oclHandler.handleMetaModel(eObject.eClass(), eObject, diagnostics, context);
		} 		
		
		return true;
	}	
		
	private static class ConstraintHandler {
		public ConstraintHandler() {}
		
		protected EClass getContextType(EModelElement constrainedElement) {
			if(constrainedElement instanceof EClass) {
				return (EClass)constrainedElement;
			} 
			else if(constrainedElement instanceof EStructuralFeature) {
				return ((EStructuralFeature)constrainedElement).getEContainingClass();
			}			
			return null;
		}
		
		protected boolean handleEAnnotation(EAnnotation annotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
			return handleEAnnotation(annotation, null /* no instance to evaluate against */, diagnostics, context);
		}
		
		protected boolean handleEAnnotation(EAnnotation annotation, EObject contextInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
			if(!Annotations.CONSTRAINTS_URI.equals(annotation.getSource())) {
				return true;
			}

			boolean isValid = true;
			for(Map.Entry<String,String> nextDetail : annotation.getDetails()) {
				String key = String.valueOf(nextDetail.getKey());
				if(ExpressionProviderRegistry.getInstance().getLanguages().contains(key)) {
					String body = readBodyDetail(nextDetail, diagnostics);
					if(body != null) {
						EModelElement constrainedElement = annotation.getEModelElement();
						EClass contextClass = getContextType(constrainedElement);
						if(contextClass != null) {
							IModelExpression expression = getExpression(key, body, contextClass, context);
							assert expression != null;
							
							ConstraintAdapter constraint = new ConstraintAdapter(expression, 
									getDiagnosticSeverity(annotation, diagnostics), 
									getDescriptionDetail(annotation));																				
							if(contextInstance != null) {
								isValid &= handleConstraintDefition(constraint, contextInstance, diagnostics);								
								isValid &= handleConstrainedElement(constraint, contextInstance, diagnostics, context);
							} else {
								isValid &= handleConstraintDefition(constraint, nextDetail, diagnostics);								
							}
						} else {
							diagnostics.add(new BasicDiagnostic(
								Diagnostic.WARNING, DIAGNOSTIC_SOURCE, StatusCodes.INVALID_CONSTRAINT_CONTEXT, 
								MessageFormat.format(Messages.validation_ConstraintInInvalidContext,  
									new Object[] { LabelProvider.INSTANCE.getObjectLabel(constrainedElement) }),
									new Object[] { nextDetail }));					
						}
					} // end of body processing
				}
			}
			return isValid;
		}
		
		/**
		 * Gets Diagnostic.severity level from the given annotation
		 * 
		 * @param constraintAnnotation annotation defining a constraint
		 * @param diagnostics container for possible problems on the severity definition
		 * @return Diagnostic.ERROR|WARN|INFO integer
		 * 
		 * @see Diagnostic
		 */
		private static int getDiagnosticSeverity(EAnnotation constraintAnnotation, DiagnosticChain diagnostics) {
			int severity = IStatus.ERROR; // default and also fall-back value
			Object val = constraintAnnotation.getDetails().get(Annotations.SEVERITY);
			String strVal = (val instanceof String) ? ((String)val).trim() : null;
			if(Annotations.SEVERITY_INFO.equals(strVal)) {
				severity = Diagnostic.INFO;
			} else if(Annotations.SEVERITY_WARN.equals(strVal)) {
				severity = Diagnostic.WARNING;
			} else if(Annotations.SEVERITY_ERROR.equals(strVal)) {
				severity = Diagnostic.ERROR;
			} else if(strVal != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 
						StatusCodes.INVALID_CONSTRAINT_SEVERITY,
						NLS.bind(Messages.invalidConstraintSeverity, new Object[] { 
								strVal, Annotations.SEVERITY_ERROR, Annotations.SEVERITY_WARN, Annotations.SEVERITY_INFO})
						, new Object[] { val }));
			}
			return severity;
		}

		private static String getDescriptionDetail(EAnnotation annotation) {
			Object val = annotation.getDetails().get(Annotations.DESCRIPTION);
			return val != null ? String.valueOf(val) : null; 		
		}
		
		private static String readBodyDetail(Map.Entry<String, String> bodyEntry, DiagnosticChain diagnostics) {
			String body = bodyEntry.getValue();
			if(body != null && body.trim().length() > 0) {
				return body;
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, 
					DIAGNOSTIC_SOURCE, StatusCodes.EMPTY_CONSTRAINT_BODY, 
					Messages.validation_EmptyExpressionBody,  
					new Object[] { bodyEntry }));
			return null;
		}
		
		protected boolean handleMetaModel(EClass eClass, EObject modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
			boolean isValid = true;
			
			for (EAnnotation nextAnnocation : eClass.getEAnnotations()) {
				if(Annotations.CONSTRAINTS_URI.equals(nextAnnocation.getSource())) {
					isValid &= handleEAnnotation(nextAnnocation, modelElement, diagnostics, context);					
				}
			}
			// FIXME do not duplicate same &= handleEAnnotation three times, 
			for (EOperation nextOperation : eClass.getEOperations()) {
				for(EAnnotation annotation : nextOperation.getEAnnotations()) {
					if(Annotations.CONSTRAINTS_URI.equals(annotation.getSource())) {
						isValid &= handleEAnnotation(annotation, modelElement, diagnostics, context);						
					}
				}
			}
			
			for (EStructuralFeature nextFeature : eClass.getEStructuralFeatures()) {
				for(EAnnotation annotation : nextFeature.getEAnnotations()) {
					if(Annotations.CONSTRAINTS_URI.equals(annotation.getSource())) {
						isValid &= handleEAnnotation(annotation, modelElement, diagnostics, context);					
					}
				}
			}			
			
			for (EClass nextSuperType : eClass.getESuperTypes()) {
				isValid &= handleMetaModel(nextSuperType, modelElement, diagnostics, context); 
			}			
			
			return isValid;
		}
		


		protected boolean handleConstraintDefition(ConstraintAdapter constraintProxy, Object target, DiagnosticChain diagnostics) {			
			IStatus constraintStatus = constraintProxy.getStatus();

			if(Trace.shouldTrace(DebugOptions.META_DEFINITIONS)) {
				String msgPtn = "[metamodel-constraint] context={0} body={1}"; //$NON-NLS-1$
				Trace.trace(MessageFormat.format(msgPtn, new Object[] { 
					LabelProvider.INSTANCE.getObjectLabel(constraintProxy.getContext()), 
					constraintProxy.getBody() 
				}));
			}
			
			
			if(!constraintStatus.isOK()) {
				String message = MessageFormat.format(Messages.invalidExpressionBody, 
						new Object[] { constraintProxy.getBody(), 
						constraintStatus.getMessage() });
				diagnostics.add(new BasicDiagnostic(
						Diagnostic.ERROR, DIAGNOSTIC_SOURCE, constraintStatus.getCode(), 
						message, new Object[] { target }));
				return false;			
			} 
			
			return true;			
		}
		
		protected boolean handleConstrainedElement(ConstraintAdapter constraint, EObject constrainedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
			if(!constraint.isSatisfied(constrainedElement)) {
				String message = null;
				if(constraint.getDescription() == null) {
					message = MessageFormat.format(Messages.validation_ConstraintViolation, new Object[] { 
							constraint.getBody(), 
							LabelProvider.INSTANCE.getObjectLabel(constrainedElement) });
				} else {
					// TODO - user constraint ID as a key, support localication for messages
					message = constraint.getDescription(); 
				}
				diagnostics.add(new BasicDiagnostic(constraint.getSeverity(), DIAGNOSTIC_SOURCE, 
						StatusCodes.CONSTRAINT_VIOLATION, message, new Object[] { constrainedElement }));				
				return false;
			} else {
				ValidationOptions opts = getOptions(context);
				if(opts.isReportSuccess()) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.OK, DIAGNOSTIC_SOURCE, StatusCodes.CONSTRAINT_SATISFIED,
							MessageFormat.format(Messages.validation_ConstraintSatisfied, new Object[] { 
								constraint.getBody(), LabelProvider.INSTANCE.getObjectLabel(constrainedElement) }), 
								new Object[] { constrainedElement }));
				}
			}
			
			return true;
		}
	}
}
