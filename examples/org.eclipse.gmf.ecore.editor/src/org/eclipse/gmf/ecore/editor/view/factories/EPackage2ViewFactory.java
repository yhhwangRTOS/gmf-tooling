package org.eclipse.gmf.ecore.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.providers.EcoreSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

/**
 * @generated
 */
public class EPackage2ViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("VisualID");
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("value", "1002");
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Labels.EPACKAGENAME_4005_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Compartments.CLASSES_5004, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Compartments.PACKAGES_5005, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Compartments.DATA_TYPES_5006, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Compartments.ENUMS_5007, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EPackage_1002Compartments.PACKAGE_ANNOTATIONS_5008, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
