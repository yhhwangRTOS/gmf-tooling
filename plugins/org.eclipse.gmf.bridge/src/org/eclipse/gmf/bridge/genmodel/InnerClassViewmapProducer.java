/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.bridge.genmodel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureAccessor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureHandle;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.common.codegen.NullImportAssistant;

/**
 * @author artem
 */
public class InnerClassViewmapProducer extends DefaultViewmapProducer {

	private final FigureGenerator figureGenerator;
	private final FigureQualifiedNameSwitch fqnSwitch;

	public InnerClassViewmapProducer() {
		this(new RuntimeFQNSwitch(), new MapModeCodeGenStrategy.RuntimeUnspecifiedMapMode());
	}

	public InnerClassViewmapProducer(FigureQualifiedNameSwitch figureNameSwitch, MapModeCodeGenStrategy mapModeCodeGenStrategy) {
		assert figureNameSwitch != null;
		fqnSwitch = figureNameSwitch;
		figureGenerator = new FigureGenerator(fqnSwitch, mapModeCodeGenStrategy);
	}

	public Viewmap create(Node node) {
		if (node.getFigure() == null) {
			return super.create(node);
		}
		final Viewmap viewmap = createViewmap(node.getNodeFigure());
		setupResizeConstraints(viewmap, node);
		setupLayoutType(viewmap, node);
		return viewmap;
	}
	
	public Viewmap create(Connection link) {
		if (link.getFigure() == null) {
			return super.create(link);
		}
		return createViewmap(link.getConnectionFigure());
	}

	public Viewmap create(DiagramLabel label) {
		if (label.getFigure() == null) {
			return super.create(label);
		}
		return createViewmap(label.getFigure());
	}
	
	public Viewmap create(Compartment compartment) {
		Viewmap result = super.create(compartment);
		if (compartment.getFigure() instanceof Figure){
			setupPluginDependencies(result, (Figure) compartment.getFigure());
		}
		return result;
	}

	private Viewmap createViewmap(Figure figure) {
		Viewmap result;
		if ((figure instanceof CustomFigure) && isBareInstance(figure)) {
			FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
			v.setFigureQualifiedClassName(fqnSwitch.get(figure));
			result = v;
			// XXX perhaps, create SnippetViewmap when there are no children but some props
		} else {
			InnerClassViewmap v = GMFGenFactory.eINSTANCE.createInnerClassViewmap();
			ImportAssistant importManager = new NullImportAssistant(null, CodeGenUtil.validJavaIdentifier(figure.getName())); 
			v.setClassBody(figureGenerator.go(figure, importManager));
			v.setClassName(importManager.getCompilationUnitName());
			result = v;
		}
		setupPluginDependencies(result, figure);
		return result;
	}

	private Viewmap createViewmap(FigureHandle figure) {
		if (figure instanceof Figure) {
			return createViewmap((Figure) figure);
		} else if (figure instanceof FigureAccessor) {
			final FigureAccessor figureAccess = (FigureAccessor) figure;
			// ParentAccessorViewmap
			SnippetViewmap v = GMFGenFactory.eINSTANCE.createSnippetViewmap();
			v.setBody(figureAccess.getAccessor());
			// if (figureAccess.getTypedFigure() != null) {
			//v.setClassName(figureAccess.getTypedFigure().getQualifiedClassName());
			//}
		}
		throw new IllegalStateException();
	}
	
	private void setupPluginDependencies(Viewmap viewmap, Figure figure){
		FigureGallery gallery = findAncestorFigureGallery(figure);
		if (gallery != null){
			viewmap.getRequiredPluginIDs().addAll(Arrays.asList(fqnSwitch.getDependencies(gallery)));
		}
	}
	
	public static FigureGallery findAncestorFigureGallery(Figure figure){
		EObject current = figure;
		while (true){
			EObject next = current.eContainer();
			if (next instanceof Figure){
				current = next;
			} else if (next instanceof FigureGallery){
				return (FigureGallery)next;
			} else {
				return null;
			}
		}
	}

	private static boolean isBareInstance(Figure figure){
		if (!figure.getChildren().isEmpty()) {
			return false;
		}
		final Collection featuresToCheck = new LinkedList(figure.eClass().getEAllStructuralFeatures());
		featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getIdentity_Name());
		if (figure instanceof CustomFigure) {
			featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getCustomClass_BundleName());
			featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getCustomClass_QualifiedClassName());
		}
		for(Iterator it = featuresToCheck.iterator(); it.hasNext();) {
			if (figure.eIsSet((EStructuralFeature) it.next())) {
				return false;
			}
		}
		return true;
	}
}
