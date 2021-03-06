/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.simplemappings.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLabelNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMappingElementWithFigure;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNodeReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleSubNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleTopNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage
 * @generated
 */
public class SimplemappingsAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SimplemappingsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplemappingsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SimplemappingsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimplemappingsSwitch<Adapter> modelSwitch = new SimplemappingsSwitch<Adapter>() {

		@Override
		public Adapter caseSimpleMapping(SimpleMapping object) {
			return createSimpleMappingAdapter();
		}

		@Override
		public Adapter caseSimpleTopNode(SimpleTopNode object) {
			return createSimpleTopNodeAdapter();
		}

		@Override
		public Adapter caseSimpleCompartment(SimpleCompartment object) {
			return createSimpleCompartmentAdapter();
		}

		@Override
		public Adapter caseSimpleLabelNode(SimpleLabelNode object) {
			return createSimpleLabelNodeAdapter();
		}

		@Override
		public Adapter caseSimpleLinkMapping(SimpleLinkMapping object) {
			return createSimpleLinkMappingAdapter();
		}

		@Override
		public Adapter caseSimpleNode(SimpleNode object) {
			return createSimpleNodeAdapter();
		}

		@Override
		public Adapter caseSimpleParentNode(SimpleParentNode object) {
			return createSimpleParentNodeAdapter();
		}

		@Override
		public Adapter caseSimpleChildNode(SimpleChildNode object) {
			return createSimpleChildNodeAdapter();
		}

		@Override
		public Adapter caseSimpleSubNode(SimpleSubNode object) {
			return createSimpleSubNodeAdapter();
		}

		@Override
		public Adapter caseSimpleMappingElementWithFigure(SimpleMappingElementWithFigure object) {
			return createSimpleMappingElementWithFigureAdapter();
		}

		@Override
		public Adapter caseSimpleChildReference(SimpleChildReference object) {
			return createSimpleChildReferenceAdapter();
		}

		@Override
		public Adapter caseSimpleNodeReference(SimpleNodeReference object) {
			return createSimpleNodeReferenceAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping <em>Simple Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping
	 * @generated
	 */
	public Adapter createSimpleMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleTopNode <em>Simple Top Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleTopNode
	 * @generated
	 */
	public Adapter createSimpleTopNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment <em>Simple Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment
	 * @generated
	 */
	public Adapter createSimpleCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLabelNode <em>Simple Label Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLabelNode
	 * @generated
	 */
	public Adapter createSimpleLabelNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping <em>Simple Link Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping
	 * @generated
	 */
	public Adapter createSimpleLinkMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode <em>Simple Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode
	 * @generated
	 */
	public Adapter createSimpleNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode <em>Simple Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode
	 * @generated
	 */
	public Adapter createSimpleParentNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode <em>Simple Child Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode
	 * @generated
	 */
	public Adapter createSimpleChildNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleSubNode <em>Simple Sub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleSubNode
	 * @generated
	 */
	public Adapter createSimpleSubNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMappingElementWithFigure <em>Simple Mapping Element With Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMappingElementWithFigure
	 * @generated
	 */
	public Adapter createSimpleMappingElementWithFigureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference <em>Simple Child Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference
	 * @generated
	 */
	public Adapter createSimpleChildReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNodeReference <em>Simple Node Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNodeReference
	 * @generated
	 */
	public Adapter createSimpleNodeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SimplemappingsAdapterFactory
