/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.TaiPanEditPartFactory;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider;

import org.eclipse.ui.IStorageEditorInput;

/**
 * @generated
 */
public class TaiPanDiagramEditor extends FileDiagramEditor implements IGotoMarker {

	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public TaiPanDiagramEditor() {
		super(true);
	}

	/**
	 * @generated
	 */
	protected String getEditingDomainID() {
		return "org.eclipse.gmf.examples.taipan.gmf.editor.EditingDomain"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = super.createEditingDomain();
		domain.setID(getEditingDomainID());
		return domain;
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IStorageEditorInput) {
			setDocumentProvider(new StorageDiagramDocumentProvider());
		} else {
			setDocumentProvider(new TaiPanDocumentProvider());
		}
	}

	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();
		LayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);
		FreeformLayer extLabelsLayer = new FreeformLayer();
		extLabelsLayer.setLayoutManager(new DelegatingLayout());
		printableLayers.addLayerAfter(extLabelsLayer, TaiPanEditPartFactory.EXTERNAL_NODE_LABELS_LAYER, LayerConstants.PRIMARY_LAYER);
		LayeredPane scalableLayers = (LayeredPane) root.getLayer(LayerConstants.SCALABLE_LAYERS);
		FreeformLayer scaledFeedbackLayer = new FreeformLayer();
		scaledFeedbackLayer.setEnabled(false);
		scalableLayers.addLayerAfter(scaledFeedbackLayer, LayerConstants.SCALED_FEEDBACK_LAYER, DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
	}
}
