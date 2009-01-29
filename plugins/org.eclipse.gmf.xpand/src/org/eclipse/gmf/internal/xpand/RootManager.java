/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.internal.xpand.build.WorkspaceResourceManager;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;

/**
 * Tracks template roots for a given project.
 */
public class RootManager {
	static final IPath PROJECT_RELATIVE_PATH_TO_CONFIG_FILE = new Path(".xpand-root");	//$NON-NLS-1$
	private final IFile myConfig;
	private List<RootDescription> myRoots;
	private List<IRootChangeListener> myListeners = new ArrayList<IRootChangeListener>(2);
//	private RootDescription myFallbackRoot;

	public RootManager(IProject project) {
		myConfig = project.getFile(PROJECT_RELATIVE_PATH_TO_CONFIG_FILE);
	}

	public void addRootChangeListener(IRootChangeListener l) {
		if (l != null && !myListeners.contains(l)) {
			myListeners.add(l);
		}
	}

	public void removeRootChangeListener(IRootChangeListener l) {
		myListeners.remove(l);
	}

	void rootsChanged() {
		if (myRoots != null) {
			for (RootDescription nextRootDescription : myRoots) {
				nextRootDescription.dispose();
			}
		}
		myRoots = null;
		for (IRootChangeListener next : myListeners) {
			next.rootsChanged(this);
		}
	}

	protected IProject getProject() {
		return myConfig.getProject();
	}

	public WorkspaceResourceManager getResourceManager(IFile file) {
		for (RootDescription nextDescription : getRoots()) {
			if (nextDescription.contains(file)) {
				return nextDescription.getManager();
			}
		}
//		return getFallbackRoot().getManager();
		return null;
	}

//	private RootDescription getFallbackRoot() {
//		if (myFallbackRoot == null) {
//			myFallbackRoot = new RootDescription(Collections.<IPath>singletonList(new Path("")));
//		}
//		return myFallbackRoot;
//	}

	private List<RootDescription> getRoots() {
		if (myRoots == null) {
			reloadRoots();
		}
		return myRoots;
	}

	private void reloadRoots() {
		if (!myConfig.exists()) {
			myRoots = Collections.singletonList(new RootDescription(DEFAULT_ROOTS));
			return;
		}
		final ArrayList<RootDescription> read = new ArrayList<RootDescription>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(myConfig.getContents(), myConfig.getCharset()));
			String line;
			while((line = in.readLine()) != null) {
				line = line.trim();
				if (line.length() > 0 && line.charAt(0) != '#') {
					String[] split = line.split(",");
					ArrayList<IPath> nextPaths = new ArrayList<IPath>(split.length);
					for (String nextPath : split) {
						nextPath = nextPath.trim();
						if (nextPath.length() > 0) {
							IPath toAdd = new Path(nextPath);
							//Absolute paths specify resources relative to workbench and/or 
							if (toAdd.isAbsolute() && toAdd.segmentCount() < 2) {
								continue;
							}
							nextPaths.add(toAdd);
						}
					}
					read.add(new RootDescription(nextPaths));
				}
			}
		} catch (CoreException ex) {
			// IGNORE
		} catch (IOException ex) {
			// IGNORE
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					/* IGNORE */
				}
			}
		}
		myRoots = read;
	}

	public Set<IProject> getReferencedProjects() {
		Set<IProject> result = new LinkedHashSet<IProject>();
		for (RootDescription nextDescription : getRoots()) {
			result.addAll(nextDescription.getReferencedProjects());
		}
		return result;
	}

	boolean containsProject(IPath projectPath) {
		if (myRoots == null) {
			return false;
		}
		for (RootDescription nextRoots : myRoots) {
			for (IPath next : nextRoots.getRoots()) {
				if (next.isAbsolute() && projectPath.isPrefixOf(next)) {
					return true;
				}
			}
		}
		return false;
	}

	private static final List<IPath> DEFAULT_ROOTS = Collections.<IPath>singletonList(new Path("templates"));	//$NON-NLS-1$

	public interface IRootChangeListener {
		public void rootsChanged(RootManager rootManager);
	}

	private class RootDescription {
		private final List<IPath> myRoots;
		private SoftReference<WorkspaceResourceManager> myResourceManagerReference; 
		private IResourceChangeListener myQvtoFileChangeTracker;
		private Set<IProject> myReferencedProjects;
		
		public RootDescription(List<IPath> roots) {
			myRoots = roots;
			myQvtoFileChangeTracker = new QvtoFileChangeTracker();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(myQvtoFileChangeTracker);
		}

		public Set<IProject> getReferencedProjects() {
			if (myReferencedProjects == null) {
				myReferencedProjects = new LinkedHashSet<IProject>();
				for (IPath next : getRoots()) {
					if (next.isAbsolute() && next.segmentCount() > 1) {
						IProject candidate = ResourcesPlugin.getWorkspace().getRoot().getProject(next.segment(0));
						if (candidate.isAccessible()) {
							myReferencedProjects.add(candidate);
						}
					}
				}
			}
			return myReferencedProjects;
		}

		public void dispose() {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(myQvtoFileChangeTracker);
		}

		public List<IPath> getRoots() {
			return myRoots;
		}

		void resetManager() {
			if (myResourceManagerReference != null) {
				myResourceManagerReference.clear();
			}
		}

		public WorkspaceResourceManager getManager() {
			WorkspaceResourceManager manager = myResourceManagerReference == null ? null : myResourceManagerReference.get();
			if (manager == null) {
				manager = new WorkspaceResourceManager(getProject(), myRoots.toArray(new IPath[myRoots.size()]));
				myResourceManagerReference = new SoftReference<WorkspaceResourceManager>(manager);
			}
			return manager;
		}
		public boolean contains(IResource resource) {
			if (resource == null) {
				return false;
			}
			for (IPath nextRoot : myRoots) {
				if (nextRoot.isAbsolute()) {
					if (nextRoot.isPrefixOf(resource.getFullPath())) {
						return true;
					}
				} else {
					if (resource.getProject().equals(getProject()) && nextRoot.isPrefixOf(resource.getProjectRelativePath())) {
						return true;
					}
				}
			}
			return false;
		}

		private class QvtoFileChangeTracker implements IResourceChangeListener {

			public void resourceChanged(IResourceChangeEvent event) {
				if (event == null || event.getDelta() == null) {
					return;
				}
				IResourceDelta rootDelta = event.getDelta();
				for (IResourceDelta projectDelta : rootDelta.getAffectedChildren()) {
					IResource project = projectDelta.getResource();
					if (getReferencedProjects().contains(project) || getProject() == project) {
						QvtoChangeDeltaVisitor visitor = new QvtoChangeDeltaVisitor();
						try {
							projectDelta.accept(visitor);
						} catch (CoreException e) {
							// Visitor code do not throw any exceptions
						}
						if (visitor.isModified()) {
							resetManager();
							return;
						}
					}
				}

			}

			private class QvtoChangeDeltaVisitor implements IResourceDeltaVisitor {

				private boolean myModified = false;

				public boolean visit(IResourceDelta delta) {
					if (delta != null && delta.getResource() instanceof IFile) {
						IFile file = (IFile) delta.getResource();
						if (QvtResource.FILE_EXTENSION.equals(file.getFullPath().getFileExtension()) && !isTouch(delta)) {
							myModified = true;
							return false;
						}
					}
					return true;
				}

				public boolean isModified() {
					return myModified;
				}

			}

			public boolean isTouch(IResourceDelta delta) {
				return (delta.getKind() & (IResourceDelta.ADDED | IResourceDelta.CHANGED | IResourceDelta.REMOVED)) == 0;
			}

		}
	}
}
