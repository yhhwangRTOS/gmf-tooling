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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMappingElementWithFigure;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Link Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getParentMapping <em>Parent Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getParentMetaElement <em>Parent Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getNodeFigure <em>Node Figure</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getLabelFigure <em>Label Figure</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getLinkMapping <em>Link Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getDiagramLink <em>Diagram Link</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getDiagramLabel <em>Diagram Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleLinkMappingImpl#getTool <em>Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleLinkMappingImpl extends EObjectImpl implements SimpleLinkMapping {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleLinkMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
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
	@SuppressWarnings("unchecked")
	public EList<SimpleChildNode> getChildren() {
		return (EList<SimpleChildNode>) eGet(SimplemappingsPackage.Literals.SIMPLE_PARENT_NODE__CHILDREN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkMapping getLinkMapping() {
		return (LinkMapping) eGet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__LINK_MAPPING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkMapping(LinkMapping newLinkMapping) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__LINK_MAPPING, newLinkMapping);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getDiagramLink() {
		return (Connection) eGet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__DIAGRAM_LINK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramLink(Connection newDiagramLink) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__DIAGRAM_LINK, newDiagramLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramLabel getDiagramLabel() {
		return (DiagramLabel) eGet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__DIAGRAM_LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiagramLabel() {
		return eIsSet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__DIAGRAM_LABEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTool getTool() {
		return (AbstractTool) eGet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__TOOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTool() {
		return eIsSet(SimplemappingsPackage.Literals.SIMPLE_LINK_MAPPING__TOOL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Figure getNodeFigure() {
		return (Figure) eGet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeFigure(Figure newNodeFigure) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE, newNodeFigure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Figure getLabelFigure() {
		return (Figure) eGet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelFigure(Figure newLabelFigure) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE, newLabelFigure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SimpleParentNode.class) {
			switch (derivedFeatureID) {
			case SimplemappingsPackage.SIMPLE_LINK_MAPPING__CHILDREN:
				return SimplemappingsPackage.SIMPLE_PARENT_NODE__CHILDREN;
			default:
				return -1;
			}
		}
		if (baseClass == SimpleMappingElementWithFigure.class) {
			switch (derivedFeatureID) {
			case SimplemappingsPackage.SIMPLE_LINK_MAPPING__NODE_FIGURE:
				return SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE;
			case SimplemappingsPackage.SIMPLE_LINK_MAPPING__LABEL_FIGURE:
				return SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE;
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
		if (baseClass == SimpleParentNode.class) {
			switch (baseFeatureID) {
			case SimplemappingsPackage.SIMPLE_PARENT_NODE__CHILDREN:
				return SimplemappingsPackage.SIMPLE_LINK_MAPPING__CHILDREN;
			default:
				return -1;
			}
		}
		if (baseClass == SimpleMappingElementWithFigure.class) {
			switch (baseFeatureID) {
			case SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE:
				return SimplemappingsPackage.SIMPLE_LINK_MAPPING__NODE_FIGURE;
			case SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE:
				return SimplemappingsPackage.SIMPLE_LINK_MAPPING__LABEL_FIGURE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SimpleLinkMappingImpl
