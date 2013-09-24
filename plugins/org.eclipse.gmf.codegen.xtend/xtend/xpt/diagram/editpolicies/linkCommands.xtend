/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Dmitry Stadnik (Borland) - creation logic was moved in commands
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    							- #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd
import xpt.Common
import xpt.providers.ElementTypes
import xpt.QualifiedClassNameProvider

/**
 * Start  		start of link creation. 
 *				User click to this editpart and start dragging with link tool.
 * Complete 	end of the command
 *				User points to this editpart as a link target and release mouse button.
 *
 * Outgoing 	the node is link source
 *				This element could be a source for this type of link.
 * Incoming		the node is link destination
 *				This element could be a target for this type of link.
 *
 * Parameters:
 *
 * 	diagram 	GenDiagram used to collect all defined links
 *
 *	this		Instance of GenLinkEnd for the element link could be creates to/from.
 *				This could be GenNode or GenLink in case of links to links, 
 *              in the latter case it is assumed that its a TypeLink (so its model facet is LinkTypeModelFacet), 
 *              because RefLinks don't have underlying semantic identity   
 *
*/
class linkCommands {
	@Inject extension Utils_qvto;
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;
	
	@Inject ElementTypes xptElementTypes;
	
	def aaa() '''aaa'''

	def linkCommands(GenLinkEnd it) '''
		«IF getAllPotentialLinks(it).size > 0»
			«createLinkCommands(it)»
		«ENDIF»
		«IF getReroutableTypeLinks(it).size > 0»
			«reorientTypeLinkCommands(it)»
		«ENDIF»
		«IF getReroutableRefLinks(it).size > 0»
			«reorientRefLinkCommands(it)»
		«ENDIF»
	'''

	def createLinkCommands(GenLinkEnd it) '''
		
		«generatedMemberComment(it)»
		protected org.eclipse.gef.commands.Command getCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			org.eclipse.gef.commands.Command command = req.getTarget() == null ?
			getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
			return command != null ? command : super.getCreateRelationshipCommand(req);
		}
		
		«generatedMemberComment(it)»
		protected org.eclipse.gef.commands.Command getStartCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			«FOR l : getAllPotentialLinks(it)»
			«startLinkCommands(l, it)»
			«ENDFOR»
			return null;
		}
		
		«generatedMemberComment(it)»
		protected org.eclipse.gef.commands.Command getCompleteCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			«FOR l : getAllPotentialLinks(it)»
			«completeLinkCommands(l, it)»
			«ENDFOR»
			return null;
		}
	'''

	def startLinkCommands(GenLink it, GenLinkEnd linkEnd) '''
		if («xptElementTypes.accessElementType(it)» == req.getElementType()) {
			«IF createStartLinkCommand(it, linkEnd)»
				return getGEFWrapper(new «getCreateCommandQualifiedClassName(it)»(req,
					«IF createStartIncomingLinkCommand(it, linkEnd)»
						req.getTarget(), req.getSource()
					«ELSE»
						req.getSource(), req.getTarget()
					«ENDIF»
				));
			«ELSE»
				return null;
			«ENDIF»
		}
	'''

	def completeLinkCommands(GenLink it, GenLinkEnd linkEnd) '''
		if («xptElementTypes.accessElementType(it)» == req.getElementType()) {
			«IF createCompleteLinkCommand(it, linkEnd)»
				return getGEFWrapper(new «getCreateCommandQualifiedClassName(it)»(req,
					«IF createCompleteOutgoingLinkCommand(it, linkEnd)»
						req.getTarget(), req.getSource()
					«ELSE»
						req.getSource(), req.getTarget()
					«ENDIF»
				));
			«ELSE»
				return null;
			«ENDIF»
		}
	'''

	def reorientTypeLinkCommands(GenLinkEnd it) '''
		
		«generatedMemberComment(
			it,
			'Returns command to reorient EClass based link. New link target or source\n' +
				'should be the domain model element associated with this node.\n'
		)»
		protected org.eclipse.gef.commands.Command getReorientRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest req) {
			switch (getVisualID(req)) {
			«FOR l : getReroutableTypeLinks(it)»
			«reorientLinkCommand(l)»
			«ENDFOR»
			}
			return super.getReorientRelationshipCommand(req);
		}
	'''

	def reorientRefLinkCommands(GenLinkEnd it) '''
		
		«generatedMemberComment(
			it,
			'Returns command to reorient EReference based link. New link target or source\n' +
				'should be the domain model element associated with this node.\n'
		)»
		protected org.eclipse.gef.commands.Command getReorientReferenceRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest req) {
			switch (getVisualID(req)) {
			«FOR l : getReroutableRefLinks(it)»
			«reorientLinkCommand(l)»
			«ENDFOR»
			}
			return super.getReorientReferenceRelationshipCommand(req);
		}
	'''

	def reorientLinkCommand(GenLink it) '''
		«caseVisualID(it)»
			return getGEFWrapper(new «getReorientCommandQualifiedClassName(it)»(req));
	'''

}
