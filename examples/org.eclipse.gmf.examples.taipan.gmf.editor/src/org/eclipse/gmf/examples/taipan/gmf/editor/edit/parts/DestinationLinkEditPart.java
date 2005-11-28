/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.Shape;

import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipDestinationLinkItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanReferenceConnectionEditPolicy;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * @generated
 */
public class DestinationLinkEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public DestinationLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new TaiPanReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ShipDestinationLinkItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected PolylineConnection createConnectionShape() {
		return new PolylineConnectionEx();
	}

	/**
	 * @generated
	 */
	protected void decorateConnectionShape(PolylineConnection shape) {

		shape.setLineStyle(Graphics.LINE_SOLID);
		RotatableDecoration sourceDecoration = createSourceDecoration();
		if (sourceDecoration != null) {
			shape.setSourceDecoration(sourceDecoration);
			if (sourceDecoration instanceof Shape) {
				((Shape) sourceDecoration).setLineWidth(shape.getLineWidth());
			}
		}
		RotatableDecoration targetDecoration = createTargetDecoration();
		if (targetDecoration != null) {
			shape.setTargetDecoration(targetDecoration);
			if (targetDecoration instanceof Shape) {
				((Shape) targetDecoration).setLineWidth(shape.getLineWidth());
			}
		}
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		PolylineConnection shape = createConnectionShape();
		decorateConnectionShape(shape);
		return shape;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createSourceDecoration() {

		return null;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createTargetDecoration() {

		PolylineDecoration decoration = new PolylineDecoration();
		decoration.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
		return decoration;
	}
}
