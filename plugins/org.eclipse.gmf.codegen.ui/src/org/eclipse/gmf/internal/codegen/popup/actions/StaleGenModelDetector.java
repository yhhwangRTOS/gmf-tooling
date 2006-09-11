/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.importer.ui.GenModelReloadActionDelegate;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;

/**
 * @author artem
 */
class StaleGenModelDetector {

	private final GenModel myGenModel;
	private boolean shouldRefresh = false;

	private URI myOutdatedResource;
	private Date myOutdatedResourceTimeStamp;
	private Date myGenModelTimeStamp;

	public StaleGenModelDetector(GenModel genModel) {
		myGenModel = genModel;
	}

	/**
	 * Uses local time stamp to detect staleness, though would be better to use IResource#modificationStamp 
	 * to tell whether resource has changed or not  
	 * @return
	 */
	public boolean isStale() {
		if (myGenModel.eResource() == null) {
			return false;
		}
		URI genModelURI = myGenModel.eResource().getURI();
		if (!isFileURI(genModelURI)) {
			return false;
		}
		HashSet<URI> ecoreURIs = new HashSet<URI>(); 
		for (Iterator it = myGenModel.getAllGenAndUsedGenPackagesWithClassifiers().iterator(); it.hasNext();) {
			GenPackage next = (GenPackage) it.next();
			if (next.getEcorePackage().eResource() != null) {
				final URI uri = next.getEcorePackage().eResource().getURI();
				if (isFileURI(uri)) {
					// check only file uris
					// though we don't check non-file uris, it's not bad to make sure at least  
					// files are up to date
					ecoreURIs.add(uri);
				}
			}
		}
		Date genModelTimeStamp = timestamp(genModelURI);
		for (URI uri : ecoreURIs) {
			Date ts = timestamp(uri);
			/* HACK
			 * @see ModelImporter#saveGenModelAndEPackages
			 * saves both ecore and genmodel files regardless of the fact .ecore was not modified,
			 * hence, we adjust the timestamp to avoid false stale detection
			 */
			if (new Date(genModelTimeStamp.getTime() + 3000).before(ts)) {
				myOutdatedResource = uri;
				myOutdatedResourceTimeStamp = ts;
				myGenModelTimeStamp = genModelTimeStamp;
				return true;
			}
		}
		return false;
	}

	private static boolean isFileURI(URI uri) {
		return "platform".equals(uri.scheme()) && "resource".equals(uri.segment(0));
	}

	private static Date timestamp(URI uri) {
		IFile f = getFile(uri);
		if (!f.exists()) {
			return new Date(0);
		}
		return new Date(f.getLocalTimeStamp());
	}

	private static IFile getFile(URI platformFileUri) {
		IPath p = new Path(platformFileUri.path()).removeFirstSegments(1);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(p);
	}
	
	/**
	 * The fact whether user decided to force refresh or not is internal knowledge of this class
	 * and should be handled in the {@link #refresh()} method
	 * @return cancel status if user cancels the operation, ok otherwise.  
	 */
	public IStatus queryUser(Shell shell) {
		String msg = "GenModel seems to be stale, would you like to try to reload it?";
		if (myOutdatedResource != null) {
			String format = "\n Resource {0} is newer ({1,date}) than genmodel ({2,date})";
			msg += MessageFormat.format(format, myOutdatedResource, myOutdatedResourceTimeStamp, myGenModelTimeStamp);
		}
		final String[] btns = new String[] {IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL};
		int r = new MessageDialog(shell, "Stale GenModel", null, msg, MessageDialog.QUESTION, btns, 0).open();
		if (r == 2) {
			return Status.CANCEL_STATUS;
		}
		shouldRefresh = r == 0;
		return Status.OK_STATUS;
	}

	public void forceRefresh() {
		shouldRefresh = true;
	}

	/**
	 * XXX Note, current implementation invokes ui
	 */
	public GenModel refresh() {
		if (!shouldRefresh) {
			return myGenModel;
		}
		IFile genModelFile = getFile();
		// XXX do it without UI
		GenModelReloadActionDelegate action = new GenModelReloadActionDelegate();
		IAction uiAction = new Action() {
		};
		action.selectionChanged(uiAction, new StructuredSelection(genModelFile));
		action.run(uiAction);
		return rereadResource();
	}

	private GenModel rereadResource() {
		Resource res = myGenModel.eResource();
		Map loadOptions = res.getResourceSet().getLoadOptions();
		res.unload();
		try {
			res.load(loadOptions);
			return (GenModel) res.getContents().get(0);
		} catch (IOException ex) {
			CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("Failed to reread genmodel resource", ex));
			return myGenModel;
		}
	}

	private IFile getFile() {
		return getFile(myGenModel.eResource().getURI());
	}
}
