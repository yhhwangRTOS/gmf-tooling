/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.sketch.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.sketch.SketchPackage
 * @generated
 */
public class SketchSwitch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SketchPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchSwitch() {
		if (modelPackage == null) {
			modelPackage = SketchPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case SketchPackage.SKETCH_ELEMENT: {
			SketchElement sketchElement = (SketchElement) theEObject;
			T result = caseSketchElement(sketchElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_DIAGRAM_ELEMENT: {
			SketchDiagramElement sketchDiagramElement = (SketchDiagramElement) theEObject;
			T result = caseSketchDiagramElement(sketchDiagramElement);
			if (result == null)
				result = caseSketchElement(sketchDiagramElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_DIAGRAM: {
			SketchDiagram sketchDiagram = (SketchDiagram) theEObject;
			T result = caseSketchDiagram(sketchDiagram);
			if (result == null)
				result = caseSketchDiagramElement(sketchDiagram);
			if (result == null)
				result = caseSketchElement(sketchDiagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_NODE: {
			SketchNode sketchNode = (SketchNode) theEObject;
			T result = caseSketchNode(sketchNode);
			if (result == null)
				result = caseSketchDiagramElement(sketchNode);
			if (result == null)
				result = caseSketchElement(sketchNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_COMPARTMENT: {
			SketchCompartment sketchCompartment = (SketchCompartment) theEObject;
			T result = caseSketchCompartment(sketchCompartment);
			if (result == null)
				result = caseSketchDiagramElement(sketchCompartment);
			if (result == null)
				result = caseSketchElement(sketchCompartment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_LINK: {
			SketchLink sketchLink = (SketchLink) theEObject;
			T result = caseSketchLink(sketchLink);
			if (result == null)
				result = caseSketchDiagramElement(sketchLink);
			if (result == null)
				result = caseSketchElement(sketchLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SketchPackage.SKETCH_LABEL: {
			SketchLabel sketchLabel = (SketchLabel) theEObject;
			T result = caseSketchLabel(sketchLabel);
			if (result == null)
				result = caseSketchDiagramElement(sketchLabel);
			if (result == null)
				result = caseSketchElement(sketchLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchElement(SketchElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchDiagramElement(SketchDiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchDiagram(SketchDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchNode(SketchNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchCompartment(SketchCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchLink(SketchLink object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSketchLabel(SketchLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SketchSwitch
