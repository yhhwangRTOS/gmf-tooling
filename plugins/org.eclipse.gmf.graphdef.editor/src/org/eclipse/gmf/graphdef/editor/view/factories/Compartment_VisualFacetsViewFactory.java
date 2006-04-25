package org.eclipse.gmf.graphdef.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.graphdef.editor.edit.parts.CanvasEditPart;

import org.eclipse.gmf.graphdef.editor.part.GMFGraphVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Compartment_VisualFacetsViewFactory extends ListCompartmentViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = GMFGraphVisualIDRegistry.getType(org.eclipse.gmf.graphdef.editor.edit.parts.Compartment_VisualFacetsEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!CanvasEditPart.MODEL_ID.equals(GMFGraphVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", CanvasEditPart.MODEL_ID);
			view.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
