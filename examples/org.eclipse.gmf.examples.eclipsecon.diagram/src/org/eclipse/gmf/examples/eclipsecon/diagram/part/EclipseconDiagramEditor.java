package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.EclipseconEditPartFactory;

/**
 * @generated
 */
public class EclipseconDiagramEditor extends FileDiagramEditor implements
		IGotoMarker {

	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorID";

	/**
	 * @generated
	 */
	public EclipseconDiagramEditor() {
		super(true);
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		setDocumentProvider(new EclipseconDocumentProvider());
	}

	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer()
				.getRootEditPart();
		LayeredPane printableLayers = (LayeredPane) root
				.getLayer(LayerConstants.PRINTABLE_LAYERS);
		FreeformLayer extLabelsLayer = new FreeformLayer();
		extLabelsLayer.setLayoutManager(new DelegatingLayout());
		printableLayers.addLayerAfter(extLabelsLayer,
				EclipseconEditPartFactory.EXTERNAL_NODE_LABELS_LAYER,
				LayerConstants.PRIMARY_LAYER);
	}
}
