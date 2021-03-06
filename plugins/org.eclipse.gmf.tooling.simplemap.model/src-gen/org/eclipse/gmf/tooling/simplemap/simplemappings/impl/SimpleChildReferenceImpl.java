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
package org.eclipse.gmf.tooling.simplemap.simplemappings.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Child Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getParentMapping <em>Parent Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getParentMetaElement <em>Parent Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getReferencedChild <em>Referenced Child</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleChildReferenceImpl#getReferencedSimpleNode <em>Referenced Simple Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleChildReferenceImpl extends SimpleNodeReferenceImpl implements SimpleChildReference {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleChildReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplemappingsPackage.Literals.SIMPLE_CHILD_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleParentNode getParentNode() {
		return (SimpleParentNode) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentNode(SimpleParentNode newParentNode) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_NODE, newParentNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleMapping getParentMapping() {
		return (SimpleMapping) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_MAPPING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMapping(SimpleMapping newParentMapping) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_MAPPING, newParentMapping);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNode getParent() {
		return (SimpleNode) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SimpleNode newParent) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT, newParent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentMetaElement() {
		return (EClass) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMetaElement(EClass newParentMetaElement) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT, newParentMetaElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMapping getReferencedChild() {
		return (NodeMapping) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_REFERENCE__REFERENCED_CHILD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedChild(NodeMapping newReferencedChild) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_REFERENCE__REFERENCED_CHILD, newReferencedChild);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNode getReferencedSimpleNode() {
		return (SimpleNode) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_REFERENCE__REFERENCED_SIMPLE_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedSimpleNode(SimpleNode newReferencedSimpleNode) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_REFERENCE__REFERENCED_SIMPLE_NODE, newReferencedSimpleNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SimpleChildNode.class) {
			switch (derivedFeatureID) {
			case SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_NODE:
				return SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_NODE;
			case SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_MAPPING:
				return SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_MAPPING;
			case SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT:
				return SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT;
			case SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_META_ELEMENT:
				return SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SimpleChildNode.class) {
			switch (baseFeatureID) {
			case SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_NODE:
				return SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_NODE;
			case SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_MAPPING:
				return SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_MAPPING;
			case SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT:
				return SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT;
			case SimplemappingsPackage.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT:
				return SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__PARENT_META_ELEMENT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SimpleChildReferenceImpl
