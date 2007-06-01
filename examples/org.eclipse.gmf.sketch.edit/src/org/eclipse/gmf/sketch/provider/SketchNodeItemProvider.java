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
package org.eclipse.gmf.sketch.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.gmf.sketch.SketchFactory;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.gmf.sketch.SketchNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SketchNodeItemProvider extends SketchDiagramElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addReferencedNodesPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addAttributesPropertyDescriptor(object);
			addOnBorderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Referenced Nodes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedNodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchNode_referencedNodes_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchNode_referencedNodes_feature", "_UI_SketchNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_NODE__REFERENCED_NODES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchNode_type_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchNode_type_feature", "_UI_SketchNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_NODE__TYPE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchNode_attributes_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchNode_attributes_feature", "_UI_SketchNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_NODE__ATTRIBUTES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the On Border feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnBorderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchNode_onBorder_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchNode_onBorder_feature", "_UI_SketchNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_NODE__ON_BORDER, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SketchPackage.Literals.SKETCH_NODE__NODES);
			childrenFeatures.add(SketchPackage.Literals.SKETCH_NODE__COMPARTMENTS);
			childrenFeatures.add(SketchPackage.Literals.SKETCH_NODE__LABELS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SketchNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SketchNode")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextGen(Object object) {
		String label = ((SketchNode) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SketchNode_type") : //$NON-NLS-1$
				getString("_UI_SketchNode_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getText(Object object) {
		String text = getTextGen(object) + " ["; //$NON-NLS-1$
		EClass type = ((SketchNode) object).getType();
		if (type != null) {
			text += type.getName();
		}
		return text + "] " + ((SketchNode) object).getVisualID(); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SketchNode.class)) {
		case SketchPackage.SKETCH_NODE__ON_BORDER:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case SketchPackage.SKETCH_NODE__NODES:
		case SketchPackage.SKETCH_NODE__COMPARTMENTS:
		case SketchPackage.SKETCH_NODE__LABELS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(SketchPackage.Literals.SKETCH_NODE__NODES, SketchFactory.eINSTANCE.createSketchNode()));

		newChildDescriptors.add(createChildParameter(SketchPackage.Literals.SKETCH_NODE__COMPARTMENTS, SketchFactory.eINSTANCE.createSketchCompartment()));

		newChildDescriptors.add(createChildParameter(SketchPackage.Literals.SKETCH_NODE__LABELS, SketchFactory.eINSTANCE.createSketchLabel()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SketchEditPlugin.INSTANCE;
	}

}
