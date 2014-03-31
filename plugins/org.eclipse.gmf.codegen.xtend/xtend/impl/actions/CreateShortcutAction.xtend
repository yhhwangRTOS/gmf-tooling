/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [174961] migration to Commands/Handlers 
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.actions

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto
import xpt.diagram.commands.CreateShortcutDecorationsCommand
import xpt.editor.ShortcutCreationWizard
import xpt.editor.ElementChooser
import xpt.editor.DiagramEditorUtilimport xpt.CodeStyle

@com.google.inject.Singleton class CreateShortcutAction {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension CodeStyle;
	@Inject extension ExternalizerUtils_qvto;

	@Inject ShortcutCreationWizard xptShortcutCreationWizard;
	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;
	@Inject CreateShortcutDecorationsCommand xptCreateShortcutDecorationCommand;
	@Inject ElementChooser xptElementChooser;
	@Inject DiagramEditorUtil xptDiagramEditorUtil;

	def className(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«lastSegment(qualifiedClassName)»'''

	def packageName(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«withoutLastSegment(qualifiedClassName)»'''

	def qualifiedClassName(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«packageName(it)».«className(it)»'''

	def fullPath(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«qualifiedClassName(it)»'''

	def Main(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
		«copyright(it.owner.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
			«constructors(it)»
			«createChooserDialog(it)»
			«createShortcutDecorationCommand(it)»
			«additions(it)»
		}
	'''

	def extendsList(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''extends org.eclipse.gmf.tooling.runtime.part.DefaultCreateShortcutHandler'''

	def implementsList(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) ''''''

	def constructors(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
		«generatedMemberComment»
		public «className(it)»() {
			this(«xptActivator.qualifiedClassName(it.owner.editorGen.plugin)».getInstance().getLogHelper());
		}

		«generatedMemberComment»
		public «className(it)»(org.eclipse.gmf.tooling.runtime.LogHelper logHelper) {
			super(logHelper, «xptActivator.preferenceHintAccess(it.owner.editorGen)»);
		}
	'''

	def createShortcutDecorationCommand(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
		«generatedMemberComment»
		«overrideC(owner.editorGen.diagram)»
		public org.eclipse.gmf.runtime.common.core.command.ICommand createShortcutDecorationCommand(org.eclipse.gmf.runtime.notation.View view, org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> descriptors) {
			return new «owner.editorGen.diagram.getCreateShortcutDecorationsCommandQualifiedClassName()»(editingDomain, view, descriptors);
		}
	'''

def createChooserDialog(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
	«generatedMemberComment»
	«overrideC(owner.editorGen.diagram)»
	public org.eclipse.gmf.tooling.runtime.part.DefaultElementChooserDialog createChooserDialog(org.eclipse.swt.widgets.Shell parentShell, org.eclipse.gmf.runtime.notation.View view) {
		return new «owner.editorGen.diagram.getElementChooserQualifiedClassName()»(parentShell, view);
	}
'''

	def additions(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) ''''''

	def i18nValues(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.messageEntry(titleKey(i18nKeyForCreateShortcutOpenModel()), 'Select model to reference')»
			«xptExternalizer.messageEntry(titleKey(i18nKeyForCreateShortcutWizard()), 'Create shortcut')»
		«ENDIF»
	'''

	def i18nAccessors(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.accessorField(titleKey(i18nKeyForCreateShortcutOpenModel()))»
			«xptExternalizer.accessorField(titleKey(i18nKeyForCreateShortcutWizard()))»
		«ENDIF»
	'''

	@Localization def String i18nKeyForCreateShortcutWizard() {
		return 'CreateShortcutAction.Wizard'
	}

	@Localization def String i18nKeyForCreateShortcutOpenModel() {
		return 'CreateShortcutAction.OpenModel'
	}

}
