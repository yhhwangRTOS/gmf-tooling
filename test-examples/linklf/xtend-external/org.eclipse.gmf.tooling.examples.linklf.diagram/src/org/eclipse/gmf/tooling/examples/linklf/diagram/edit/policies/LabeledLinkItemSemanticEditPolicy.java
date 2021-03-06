package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;

/**
 * @generated
 */
public class LabeledLinkItemSemanticEditPolicy extends LinklfBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LabeledLinkItemSemanticEditPolicy() {
		super(LinklfElementTypes.LabeledLink_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
