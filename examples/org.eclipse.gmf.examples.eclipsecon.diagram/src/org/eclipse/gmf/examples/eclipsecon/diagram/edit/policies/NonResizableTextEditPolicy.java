package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class NonResizableTextEditPolicy extends NonResizableEditPolicyEx {

	/**
	 * @generated
	 */
	private WrapLabel getLabel() {
		return (WrapLabel) ((GraphicalEditPart) getHost()).getFigure();
	}

	/**
	 * @generated
	 */
	protected void hideFocus() {
		getLabel().setFocus(false);
	}

	/**
	 * @generated
	 */
	protected void hideSelection() {
		getLabel().setSelected(false);
		getLabel().setFocus(false);
		super.hideSelection();
	}

	/**
	 * @generated
	 */
	protected void showFocus() {
		getLabel().setFocus(true);
	}

	/**
	 * @generated
	 */
	protected void showPrimarySelection() {
		super.showPrimarySelection();
		getLabel().setFocus(true);
	}

	/**
	 * @generated
	 */
	protected void showSelection() {
		super.showSelection();
		getLabel().setSelected(true);
		getLabel().setFocus(false);
	}

	/**
	 * @generated
	 */
	protected List createSelectionHandles() {
		MoveHandle moveHandle = new MoveHandle((GraphicalEditPart) getHost());
		moveHandle.setBorder(null);
		moveHandle.setDragTracker(new DragEditPartsTrackerEx(getHost()));
		return Collections.singletonList(moveHandle);
	}
}
