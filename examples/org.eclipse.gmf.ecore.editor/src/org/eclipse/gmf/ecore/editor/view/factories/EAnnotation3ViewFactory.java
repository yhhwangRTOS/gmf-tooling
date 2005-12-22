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
public class EAnnotation3ViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("VisualID");
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("value", "1003");
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EAnnotation_1003Labels.EANNOTATIONSOURCE_4011_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EAnnotation_1003Compartments.DETAILS_5009, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
