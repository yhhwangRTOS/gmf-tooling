/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anna Karjakina (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef

@com.google.inject.Singleton class ExternalizerUtils_qvto {

	@MetaDef def String getExternalizerPackageName(GenEditorGenerator generator) {
		return generator.editor.packageName
	}

	@MetaDef def String getExternalizerClassName() {
		return 'Messages'
	}

	def String escapeIllegalKeySymbols(String key) {
		return key.replaceAll('[=&\"]', '').replaceAll('[ .]', '_');
	}

	def String escapeIllegalMessageSymbols(String message) {
		return message.replaceAll('!', '\\\\!')
	}

	def String titleKey(String dialogKey) {
		return dialogKey + 'Title'
	}

	def String messageKey(String dialogKey) {
		return dialogKey + 'Message'
	}

	def String nameKey(String dialogKey) {
		return dialogKey + 'Name'
	}

	def String descriptionKey(String dialogKey) {
		return dialogKey + 'Description'
	}

}
