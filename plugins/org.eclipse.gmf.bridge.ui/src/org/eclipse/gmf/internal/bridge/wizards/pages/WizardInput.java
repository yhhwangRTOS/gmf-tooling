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
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.provider.GMFGraphItemProviderAdapterFactory;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.mappings.provider.GMFMapItemProviderAdapterFactory;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.eclipse.gmf.tooldef.provider.GMFToolItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.IMessageProvider;

/**
 * @author artem
 */
public class WizardInput {
	public static final String TOOLDEF_FILE_EXT = "gmftool"; //$NON-NLS-1$
	public static final String GRAPHDEF_FILE_EXT = "gmfgraph"; //$NON-NLS-1$
	public static final String ECORE_FILE_EXT = "ecore"; //$NON-NLS-1$

	private EPackage myDomainModel;
	private Canvas myCanvas;
	private ToolRegistry myRegistry;
	private Mapping mapInstance;
	private EditingDomain myEditingDomain;
	private AdapterFactory myAdapterFactory;
	private IFile myResultFile = null;
	private MapDefFeeder myFeeder;
	private String initialECoreFile = null;
	private String initialGraphFile = null;
	private String initialToolFile = null;
	private boolean myIsBlankToolDef = false;

	public WizardInput() {
	}
	
	public AdapterFactory getAdapterFactory() {
		if (myAdapterFactory == null) {
			List factories = new ArrayList();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new GMFMapItemProviderAdapterFactory());
			factories.add(new GMFGraphItemProviderAdapterFactory());
			factories.add(new GMFToolItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());

			myAdapterFactory = new ComposedAdapterFactory(factories);
		}
		return myAdapterFactory;
	}
	
	public EditingDomain getEditingDomain() {
		if (myEditingDomain == null) {
			myEditingDomain = new AdapterFactoryEditingDomain(getAdapterFactory(), new BasicCommandStack());
		}
		return myEditingDomain;
	}

	public ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	public void setDomainModel(EPackage aPackage) {
		checkUnload(myDomainModel);
		myDomainModel = aPackage;
	}

	public void setGraphDef(Canvas canvas) {
		checkUnload(myCanvas);
		myCanvas = canvas;
	}

	public Canvas getCanvasDef() {
		return myCanvas;
	}

	public boolean isNewBlankToolDef() {
		return myIsBlankToolDef;
	}

	public URI createBlankToolDef() {
		checkUnload(myRegistry);
		myRegistry = null;
		IPath toolDefFile = getMappingFile().getFullPath().removeFileExtension().addFileExtension(TOOLDEF_FILE_EXT);
		String baseName = getMappingFile().getFullPath().removeFileExtension().lastSegment();
		int i = 1;
		final IWorkspace wr = getMappingFile().getProject().getWorkspace(); 
		while (wr.getRoot().findMember(toolDefFile) != null) {
			toolDefFile = toolDefFile.removeLastSegments(1).append(baseName + i).addFileExtension(TOOLDEF_FILE_EXT);
			i++;
		}
		URI toolDefURI = URI.createPlatformResourceURI(toolDefFile.toString());
		myRegistry = GMFToolFactory.eINSTANCE.createToolRegistry();
		myRegistry.setPalette(GMFToolFactory.eINSTANCE.createPalette());
		getResourceSet().createResource(toolDefURI).getContents().add(myRegistry);
		myIsBlankToolDef  = true;
		return toolDefURI;
	}

	public void setToolDef(ToolRegistry registry) {
		checkUnload(myRegistry);
		myRegistry = registry;
		myIsBlankToolDef = false;
	}

	public ToolRegistry getToolDef() {
		return myRegistry;
	}

	public void setMappingFile(IFile resultFile) {
//		if (myResultFile != null && resultFile != myResultFile) {
//			// perhaps, no reason to allow even 'touch'?
//			throw new IllegalStateException("Did't expect file to be chosen more than once");
//		}
		myResultFile = resultFile;
	}

	public IFile getMappingFile() {
		return myResultFile;
	}

	public Mapping getMapping() {
		if (mapInstance == null) {
			mapInstance = GMFMapFactory.eINSTANCE.createMapping();
			URI res = URI.createPlatformResourceURI(getMappingFile().getFullPath().toString());
			getResourceSet().createResource(res).getContents().add(mapInstance);
		}
		return mapInstance;
	}

	/**
	 * @return status with code field set to constant from IMessageProvider
	 */
	public IStatus isReady2Go() {
		if (myDomainModel != null && myCanvas != null && myRegistry != null) {
			return Status.OK_STATUS;
		}
		if (myDomainModel == null) {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedDomain, null);
		}
		if (myCanvas == null) {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedCanvas, null);
		} else {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedToolDef, null);
		}
	}

	private void checkUnload(EObject eobj) {
		if (eobj == null) {
			return;
		}
		if (eobj.eResource().getResourceSet() == getResourceSet() && eobj.eResource().isLoaded()) {
			eobj.eResource().unload();
		}
	}
	public List/*<EClass>*/ getCanvasElementCandidates() {
		UniqueEList rv = new UniqueEList();
		for (Iterator it = myDomainModel.getEClassifiers().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				EClass eClass = (EClass) next;
				if (!eClass.isAbstract() && !eClass.isInterface() && !eClass.getEAllContainments().isEmpty()) {
					rv.add(eClass);
				}
			}
		}
		return rv;
	}

	public void selectCanvasElement(EClass eClass) {
		assert eClass.getEPackage() == myDomainModel;
		CanvasMapping cm;
		if (getMapping().getDiagram() == null) {
			cm =  GMFMapFactory.eINSTANCE.createCanvasMapping();
			cm.setDiagramCanvas(myCanvas);
			// +palette/gmfgraph.canvas
		} else {
			cm = getMapping().getDiagram();
		}
		cm.setDomainMetaElement(eClass);
		cm.setDomainModel(eClass.getEPackage());
		getMapping().setDiagram(cm);
	}

	public void feedDefaultMapping() {
		myFeeder = new MapDefFeeder(this, createToolDefSupplier());
		myFeeder.feedDefaultMapping();
	}

	private ToolDefSupplier createToolDefSupplier() {
		if (isNewBlankToolDef()) {
			return new CreateToolDef(getToolDef());
		} else {
			return new ToolDefLookup(getToolDef());
		}
	}

	public NodeReference[] nodeCandidates() {
		return myFeeder.getInitialNodes();
	}

	public LinkMapping[] linkCandidates() {
		return myFeeder.getInitialLinks();
	}
	
	public String getInitialECoreFile() {
		return initialECoreFile;
	}

	public void setInitialECoreFile(String initialECoreFile) {
		this.initialECoreFile = initialECoreFile;
	}

	public String getInitialGraphFile() {
		return initialGraphFile;
	}

	public void setInitialGraphFile(String initialGraphFile) {
		this.initialGraphFile = initialGraphFile;
	}

	public String getInitialToolFile() {
		return initialToolFile;
	}

	public void setInitialToolFile(String initialToolFile) {
		this.initialToolFile = initialToolFile;
	}
}
