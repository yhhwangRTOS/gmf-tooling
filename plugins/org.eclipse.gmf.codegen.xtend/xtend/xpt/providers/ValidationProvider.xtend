/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - introduced GenAuditContext entity
 *                                 straightforward and simple #validate() implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule
import org.eclipse.gmf.codegen.gmfgen.GenAuditable
import org.eclipse.gmf.codegen.gmfgen.GenAuditedMetricTarget
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget
import org.eclipse.gmf.codegen.gmfgen.GenDomainAttributeTarget
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider
import xpt.Common
import xpt.Common_qvto
import xpt.GenAuditRoot_qvto
import xpt.editor.VisualIDRegistry
import xpt.expressions.getExpression
import xpt.QualifiedClassNameProvider

class ValidationProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension GenAuditRoot_qvto; 
	@Inject extension QualifiedClassNameProvider;
	
	@Inject MetaModel xptMetaModel;
	@Inject getExpression xptGetExpression;
	@Inject MetricProvider xptMetricProvider;
	@Inject VisualIDRegistry xptVisualIDRegistry;

	def className(GenDiagram it) '''«it.validationProviderClassName»'''

	def packageName(GenDiagram it) '''«it.providersPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def ValidationProvider(GenDiagram it) '''
		«copyright(it.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» {
		
			«constraintsActive(it)»
		
			«shouldConstraintsBePrivate(it)»
		
			«runWithActiveConstraints(it)»
		
			«isInDefaultEditorContext(it)»
		
			«selectors(editorGen.audits)»
		
			«strategy_support(it)»
		
			«constraintAdapters(editorGen.audits, it)»
		
			«additions(it)»
		}
	'''

	def constraintsActive(GenDiagram it) '''
		«generatedMemberComment»
		private static boolean constraintsActive = false;	
	'''

	def shouldConstraintsBePrivate(GenDiagram it) '''
		«generatedMemberComment»
		public static boolean shouldConstraintsBePrivate() {
			return false;
		}
	'''

	def runWithActiveConstraints(GenDiagram it) '''
	«generatedMemberComment»
	public static void runWithConstraints(org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if(editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				«getActivatorQualifiedClassName(editorGen.plugin)».getInstance().logError("Validation failed", e); «nonNLS(1)»
			}
		} else {
			task.run();
		}
	}
	'''

	def additions(GenDiagram it) ''''''

	def selectors(GenAuditRoot it) '''
	«FOR ctx : it.clientContexts»
		«generatedMemberComment»
		public static class «ctx.className» implements org.eclipse.emf.validation.model.IClientSelector {
			
			«generatedMemberComment»
			public boolean selects(Object object) {
			«IF ctx.ruleTargets.filter(typeof(GenDiagramElementTarget)).notEmpty»
				if (isInDefaultEditorContext(object) && object instanceof org.eclipse.gmf.runtime.notation.View) {
					final int id = «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»((org.eclipse.gmf.runtime.notation.View) object);
					boolean result = false;
				«FOR e : getTargetDiagramElements(ctx)»
					result = result || id == «VisualIDRegistry::visualID(e)»;
				«ENDFOR»
					return result;
				}
				return false;
			«ELSE»
				return isInDefaultEditorContext(object);
			«ENDIF»
			}
		}
	«ENDFOR»
	'''

	def isInDefaultEditorContext(GenDiagram it) '''
	«generatedMemberComment»
	static boolean isInDefaultEditorContext(Object object) {
		if(shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof org.eclipse.gmf.runtime.notation.View) {
			return constraintsActive && «VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»((org.eclipse.gmf.runtime.notation.View) object));
		}
		return true;
	}
	'''


	def strategy_support(GenDiagram it) '''
	«IF hasDiagramElementTargetRule(editorGen.audits)»
	«generatedMemberComment»
	public static org.eclipse.emf.validation.service.ITraversalStrategy getNotationTraversalStrategy(
			org.eclipse.emf.validation.service.IBatchValidator validator) {
		return new CtxSwitchStrategy(validator);
	}

	«generatedMemberComment»
	private static class CtxSwitchStrategy implements org.eclipse.emf.validation.service.ITraversalStrategy {

		«generatedMemberComment»
		private org.eclipse.emf.validation.service.ITraversalStrategy defaultStrategy;

		«generatedMemberComment»
		private int currentSemanticCtxId = -1;

		«generatedMemberComment»
		private boolean ctxChanged = true;

		«generatedMemberComment»
		private org.eclipse.emf.ecore.EObject currentTarget;

		«generatedMemberComment»
		private org.eclipse.emf.ecore.EObject preFetchedNextTarget;

		«generatedMemberComment»
		private final int[] contextSwitchingIdentifiers;

		«generatedMemberComment»
		CtxSwitchStrategy(org.eclipse.emf.validation.service.IBatchValidator validator) {
			this.defaultStrategy = validator.getDefaultTraversalStrategy();
			this.contextSwitchingIdentifiers = new int[] {
				«FOR e : getAllTargetDiagramElements(editorGen.audits) SEPARATOR ','»«VisualIDRegistry::visualID(e)»«ENDFOR»
			};
			java.util.Arrays.sort(this.contextSwitchingIdentifiers);
		}

		«generatedMemberComment»
		public void elementValidated(org.eclipse.emf.ecore.EObject element,
				org.eclipse.core.runtime.IStatus status) {
			defaultStrategy.elementValidated(element, status);
		}

		«generatedMemberComment»
		public boolean hasNext() {
			return defaultStrategy.hasNext();
		}

		«generatedMemberComment»
		public boolean isClientContextChanged() {
			if (preFetchedNextTarget == null) {
				preFetchedNextTarget = next();
				prepareNextClientContext(preFetchedNextTarget);
			}
			return ctxChanged;
		}

		«generatedMemberComment»
		public org.eclipse.emf.ecore.EObject next() {
			org.eclipse.emf.ecore.EObject nextTarget = preFetchedNextTarget;
			if (nextTarget == null) {
				nextTarget = defaultStrategy.next();
			}
			this.preFetchedNextTarget = null;
			return this.currentTarget = nextTarget;
		}

		«generatedMemberComment»
		public void startTraversal(java.util.Collection traversalRoots,	org.eclipse.core.runtime.IProgressMonitor monitor) {
			defaultStrategy.startTraversal(traversalRoots, monitor);
		}

		«generatedMemberComment»
		private void prepareNextClientContext(org.eclipse.emf.ecore.EObject nextTarget) { 
			if (nextTarget != null && currentTarget != null) {
				if (nextTarget instanceof org.eclipse.gmf.runtime.notation.View) {
					final int id = «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»((org.eclipse.gmf.runtime.notation.View) nextTarget);
					int nextSemanticId = (id != -1 && java.util.Arrays.binarySearch(contextSwitchingIdentifiers, id) >= 0) ? id : -1;
					if ((currentSemanticCtxId != -1 && currentSemanticCtxId != nextSemanticId)
							|| (nextSemanticId != -1 && nextSemanticId != currentSemanticCtxId)) {
						this.ctxChanged = true;
					}«/*[artem] not sure why not ctxChanged = <expr>, is it intentional not to reset ctxChanged if condition did not match? I doubt. FIXME?*/»
					currentSemanticCtxId = nextSemanticId;
				} else {
					// context of domain model
					this.ctxChanged = currentSemanticCtxId != -1;
					currentSemanticCtxId = -1;
				}
			} else {
				this.ctxChanged = false;
			}
		}
	}
	«ENDIF»
	'''

	def constraintAdapters(GenAuditRoot it, GenDiagram diagram) '''
		«IF diagram.editorGen.expressionProviders != null»
		«FOR next : it.rules.filter[a | a.requiresConstraintAdapter]»
			«constraintAdapter(next, diagram.editorGen.expressionProviders)»
		«ENDFOR»
		
		«IF it.rules.exists[a | a.requiresConstraintAdapter]»
		«constraintAdapters_formatMethod(it)»
		«ENDIF»
		«ENDIF»
	'''

	def constraintAdapter(GenAuditRule it, GenExpressionProviderContainer container) '''
	«IF target != null && target.context != null»

		«generatedMemberComment»
		public static class «getConstraintAdapterLocalClassName()» extends org.eclipse.emf.validation.AbstractModelConstraint {
			
			«generatedMemberComment»
			public org.eclipse.core.runtime.IStatus validate(org.eclipse.emf.validation.IValidationContext ctx) {
				«constraintAdapter_initContext(it.target, it)»
				«constraintAdapter_validateMethod(it.rule.provider, it)»
			}
		}
	«ENDIF»
	'''


	def constraintAdapters_formatMethod(GenAuditRoot it) '''
		«generatedMemberComment»
		static String formatElement(org.eclipse.emf.ecore.EObject object) {
			return org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.getQualifiedName(object, true);
		}
	'''
 
	def dispatch constraintAdapter_validateMethod(GenExpressionProviderBase it, GenAuditRule audit) '''«ERROR('No idea how to evaluate an audit rule for ' + it)»'''

	def dispatch constraintAdapter_validateMethod(GenExpressionInterpreter it, GenAuditRule audit) '''
		Object result = «xptGetExpression.getExpression(it, audit.rule, audit.target.getContext())».evaluate(context);
		if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
			return org.eclipse.core.runtime.Status.OK_STATUS;«/* XXX why not ctx.createSuccessStatus()??? */»
		}
		return ctx.createFailureStatus(new Object[] { formatElement(ctx.getTarget()) });
	'''

	def dispatch constraintAdapter_validateMethod(GenJavaExpressionProvider it, GenAuditRule audit) '''
		«IF injectExpressionBody && !audit.rule.body.nullOrEmpty»
			«audit.rule.body»
		«ELSEIF throwException || (injectExpressionBody && audit.rule.body.nullOrEmpty)»
			// TODO: put validation code here
			// Ensure that you remove @generated tag or use @generated NOT
			//
			// To construct approprate return value, use ctx.createSuccessStatus()
			// or ctx.createFailureStatus(...)
			throw new java.lang.UnsupportedOperationException("No user java implementation provided for #validate(IValidationContext) operation"); «nonNLS(1)»
		«ELSE»
			return ctx.createFailureStatus(new Object[] { "No user java implementation provided for #validate(IValidationContext) operation" }); «nonNLS(1)»
		«ENDIF»
	'''

	/**
	 *	Contract: declare variable with the name 'context' of appropriate type
	 */
	def dispatch constraintAdapter_initContext(GenAuditable it, GenAuditRule audit) '''
	«xptMetaModel.DeclareAndAssign(it.context, 'context', 'ctx.getTarget()', false)»
	'''
	
	def dispatch constraintAdapter_initContext(GenDomainAttributeTarget it, GenAuditRule audit) '''
		final Object«/* Actual context type is genDomainAttributeTarget.getContext() */» context = ctx.getTarget().eGet(«xptMetaModel.MetaFeature(attribute)»);
		«/*
		 * For now, leave reflective access that gives Object-compatible result.
		 * FIXME: introduce xptMetaModel.DeclareAndAssignAttributeValueAsObject, that would 
		 *	check if attibute type is primitive and wrap accordingly, but access attribute directly!
		 */»if (context == null) {
		«IF nullAsError»
			return ctx.createFailureStatus(new Object[] { formatElement(ctx.getTarget()) });
		«ELSE»
			return org.eclipse.core.runtime.Status.OK_STATUS;
		«ENDIF»
		}
	'''

	def dispatch constraintAdapter_initContext(GenAuditedMetricTarget it, GenAuditRule audit) '''
		«IF it.metric == null /*though metamodel constraint should not allow this*/»
		final Number context = null /*FIXME: metric target was not correctly specified in the model*/;
		«ELSE»
		final Number context = «xptMetricProvider.invokeCalcMethod(metric, 'ctx.getTarget()', false)»;
		«ENDIF»
	'''
}
