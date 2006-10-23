/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;
import org.eclipse.gmf.internal.xpand.xtend.parser.XtendLexer;
import org.eclipse.gmf.internal.xpand.xtend.parser.XtendParser;

public class XtendResourceParser {

    public XtendResource parse(final IFile file) {
        ExtensionFile tpl = null;
        XtendLexer scanner = null;
        final char[] buffer;
        try {
            buffer = new StreamConverter().toCharArray(file);
        } catch (final CoreException e1) {
            Activator.log(e1.getStatus());
            return null;
		} catch (UnsupportedEncodingException ex) {
			Activator.logError(ex);
			return null;
		} catch (IOException ex) {
			Activator.logError(ex);
			return null;
		}
        try {
            scanner = new XtendLexer(buffer, file.getName());
            XtendParser parser = new XtendParser(scanner);
            scanner.lexer(parser);
            tpl = parser.parser();
			// FIXME handle errors
//        } catch (final MismatchedTokenException e) {
//            final Token t = e.token;
//            OawMarkerManager.deleteMarkers(file);
//            OawMarkerManager.addErrorMarker(file, e.getMessage(), IMarker.SEVERITY_ERROR, start(t), end(t));
//        } catch (final NoViableAltException e) {
//            final Token t = e.token;
//            if (t.getType() == ExtensionParserTokenTypes.EOF) {
//                OawMarkerManager.addErrorMarker(file, "Unexpected end of file. (Forget a semicolon?)",
//                        IMarker.SEVERITY_ERROR, t.getColumn() - 2, t.getColumn() - 1);
//            } else {
//                OawMarkerManager.deleteMarkers(file);
//                OawMarkerManager.addErrorMarker(file, e.getMessage(), IMarker.SEVERITY_ERROR, start(t), end(t));
//            }
        } catch (final Exception e) {
            final int start = scanner.getStreamIndex() - 1;
            final int end = start + 1;
            OawMarkerManager.deleteMarkers(file);
            OawMarkerManager.addErrorMarker(file, e.getMessage(), start, end);
        }
        if (tpl != null) {
            tpl.setFullyQualifiedName(Activator.getQualifiedName(file));
            return tpl;
        }
        return null;
    }
}
