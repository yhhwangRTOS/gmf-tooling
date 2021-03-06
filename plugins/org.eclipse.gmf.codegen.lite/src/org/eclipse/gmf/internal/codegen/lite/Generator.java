/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.lite;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPropertyTab;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenPropertyTab;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;
import org.eclipse.gmf.internal.common.codegen.TextMerger;

/**
 * Invokes templates to populate diagram editor project.
 * TODO reuse fullRT.Generator as much as possible
 * @author artem
 */
public class Generator extends GeneratorBase implements Runnable {

	private final GenEditorGenerator myEditorGen; 

	private final GenDiagram myDiagram;

	private final CodegenEmitters myEmitters;

	public Generator(GenEditorGenerator genModel) {
		this(genModel, Activator.getInstance().getEmitters(genModel));
	}

	public Generator(GenEditorGenerator genModel, CodegenEmitters emitters) {
		assert genModel != null && emitters != null;
		myDiagram = genModel.getDiagram();
		myEditorGen = genModel;
		myEmitters = emitters;
	}

	@Override
	protected TextMerger createMergeService() {
		return myEmitters.createMergeService();
	}

	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		final Path pluginDirectory = new Path(myEditorGen.getPluginDirectory());
		final Path examplaryLocation = new Path(myEditorGen.getDomainGenModel().getModelDirectory());
		initializeEditorProject(pluginDirectory, guessNewProjectLocation(examplaryLocation, pluginDirectory.segment(0)), Collections.<IProject>emptyList());

		doGenerateFile(myEmitters.getManifestGenerator(), new Path("META-INF/MANIFEST.MF"), new Object[] { myEditorGen.getPlugin() });
		doGenerateFile(myEmitters.getBuildPropertiesGenerator(), new Path("build.properties"), new Object[] { myEditorGen.getPlugin() });
		doGenerateFile(myEmitters.getPluginXML(), new Path("plugin.xml"), new Object[] { myEditorGen.getPlugin() });
		doGenerateFile(myEmitters.getPluginPropertiesGenerator(), new Path("plugin.properties"), new Object[] { myEditorGen.getPlugin() });

		internalGenerateJavaClass(myEmitters.getCreationWizardGenerator(), myDiagram.getCreationWizardQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getCreationWizardPageGenerator(), myDiagram.getCreationWizardPageQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getPluginGenerator(), myEditorGen.getPlugin().getActivatorQualifiedClassName(), myEditorGen.getPlugin());
		internalGenerateJavaClass(myEmitters.getInitDiagramFileActionGenerator(), myDiagram.getInitDiagramFileActionQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getModelElementSelectionPageEmitter(), myEmitters.getModelElementSelectionPageQualifiedNameEmitter(), myDiagram);
		internalGenerateJavaClass(myEmitters.getNewDiagramFileWizardGenerator(), myDiagram.getNewDiagramFileWizardQualifiedClassName(), myDiagram);
		if (myEditorGen.getApplication() != null) {
			internalGenerateJavaClass(myEmitters.getURISelectorPageGenerator(), myEmitters.getURISelectorPageQualifiedClassNameGenerator(), myDiagram);
		}
		if (myDiagram.generateCreateShortcutAction()) {
			internalGenerateJavaClass(myEmitters.getCreateShortcutActionEmitter(), myDiagram.getCreateShortcutActionQualifiedClassName(), myDiagram);
			if (myEditorGen.getApplication() != null) {
				internalGenerateJavaClass(myEmitters.getShortcutCreationWizardEmitter(), myEmitters.getShortcutCreationWizardQualifiedClassNameEmitter(), myDiagram);
			} else {
				internalGenerateJavaClass(myEmitters.getElementChooserEmitter(), myDiagram.getElementChooserQualifiedClassName(), myDiagram);
			}
		}
		if (myDiagram.generateShortcutIcon()) {
			internalGenerateJavaClass(myEmitters.getShortcutProviderEmitter(), myEmitters.getShortcutProviderQualifiedClassNameEmitter(), myDiagram);
			internalGenerateJavaClass(myEmitters.getCreateShortcutNodeCommandEmitter(), myEmitters.getCreateShortcutNodeCommandQualifiedClassNameEmitter(), myDiagram);
			internalGenerateJavaClass(myEmitters.getCreateShortcutEdgeCommandEmitter(), myEmitters.getCreateShortcutEdgeCommandQualifiedClassNameEmitter(), myDiagram);
			generateShortcutIcon();
			if (myEditorGen.getApplication() == null) {
				internalGenerateJavaClass(myEmitters.getShortcutPropertyTesterEmitter(), myDiagram.getShortcutPropertyTesterQualifiedClassName(), myDiagram);
			}
		}
		internalGenerateJavaClass(myEmitters.getLoadResourceActionGenerator(), myDiagram.getLoadResourceActionQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getElementTypesGenerator(), myDiagram.getElementTypesQualifiedClassName(), myDiagram);

		internalGenerateJavaClass(myEmitters.getActionBarContributorGenerator(), myEditorGen.getEditor().getActionBarContributorQualifiedClassName(), myEditorGen.getEditor());
		internalGenerateJavaClass(myEmitters.getDiagramEditorUtilGenerator(), myDiagram.getDiagramEditorUtilQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getEditorGenerator(), myEditorGen.getEditor().getQualifiedClassName(), myEditorGen.getEditor());
		if (myEditorGen.getEditor().isEclipseEditor()) {
			internalGenerateJavaClass(myEmitters.getMatchingStrategyEmitter(), myDiagram.getMatchingStrategyQualifiedClassName(), myDiagram);
		}
		if (myEditorGen.getApplication() == null && !myEditorGen.getEditor().isEclipseEditor()) {
			internalGenerateJavaClass(myEmitters.getOpenDiagramInViewActionGenerator(), myEmitters.getOpenDiagramInViewActionQualifiedClassNameGenerator(), myEditorGen.getEditor());
		}
		if (myDiagram.getPalette() != null) {
			internalGenerateJavaClass(myEmitters.getPaletteFactoryGenerator(), myDiagram.getPalette().getFactoryQualifiedClassName(), myDiagram.getPalette());
		}
		internalGenerateJavaClass(myEmitters.getEditPartFactoryGenerator(), myDiagram.getEditPartFactoryQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getDiagramEditPartGenerator(), myDiagram.getEditPartQualifiedClassName(), myDiagram);
		HashSet<OpenDiagramBehaviour> openDiagramBehaviors = new HashSet<OpenDiagramBehaviour>();
		generateBehaviors(myDiagram, openDiagramBehaviors);
		generateLayoutEditPolicy(myDiagram);

		if (myDiagram.isValidationEnabled() || myEditorGen.hasAudits()) {
			generateValidationProvider();
			if (myDiagram.getEditorGen().getApplication() == null) {
				//Strictly non-RCP stuff
				generateMarkerNavigationProvider();
			}
		}
		if (myDiagram.getEditorGen().getMetrics() != null) {
			generateMetricProvider();
		}

		for (GenNode next : (List<? extends GenNode>) myDiagram.getAllNodes()) {
			if (!(next instanceof GenChildLabelNode)) {
				internalGenerateJavaClass(myEmitters.getNodeEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
				generateGraphicalEditPolicy(next);
				for (GenNodeLabel label : next.getLabels()) {
					internalGenerateJavaClass(myEmitters.getNodeLabelEditPartGenerator(), label.getEditPartQualifiedClassName(), label);
					internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), label.getNotationViewFactoryQualifiedClassName(), label);
				}
			} else {
				internalGenerateJavaClass(myEmitters.getChildNodeEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
			}
			internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
			generateBehaviors(next, openDiagramBehaviors);
			generateCommands(next);
			generateComponentEditPolicy(next);
			boolean shouldGenerateLayoutEditPolicy = false;
			boolean shouldGenerateSideAffixedLayoutEditPolicy = false;
			for (GenNode nextChild : next.getChildNodes()) {
				if (nextChild instanceof GenChildSideAffixedNode) {
					shouldGenerateSideAffixedLayoutEditPolicy = true;
				} else {
					shouldGenerateLayoutEditPolicy = true;
				}
			}
			if (shouldGenerateLayoutEditPolicy) {
				generateLayoutEditPolicy(next);
			}
			if (shouldGenerateSideAffixedLayoutEditPolicy) {
				generateSideAffixedLayoutEditPolicy(next);
			}
		}
		for (GenLink next : (List<? extends GenLink>) myDiagram.getLinks()) {
			internalGenerateJavaClass(myEmitters.getLinkEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
			generateGraphicalEditPolicy(next);
			if (next.getLabels().size() > 0) {
				generateConnectionEndpointEditPolicy(next);
			}
			for (GenLinkLabel label : (List<? extends GenLinkLabel>) next.getLabels()) {
				internalGenerateJavaClass(myEmitters.getLinkLabelEditPartGenerator(), label.getEditPartQualifiedClassName(), label);
				internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), label.getNotationViewFactoryQualifiedClassName(), label);
			}
			internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
			generateBehaviors(next, openDiagramBehaviors);
			generateCommands(next);
			generateComponentEditPolicy(next);
		}
		for (GenCompartment next : myDiagram.getCompartments()) {
			internalGenerateJavaClass(myEmitters.getCompartmentEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
			internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
			generateLayoutEditPolicy(next);
		}
		internalGenerateJavaClass(myEmitters.getViewFactoryGenerator(), myDiagram.getNotationViewFactoryQualifiedClassName(), myDiagram);
		internalGenerateJavaClass(myEmitters.getDomainElementInitializerGenerator(), myEmitters.getDomainElementInitializerQualifiedNameGenerator(), myDiagram);
		internalGenerateJavaClass(myEmitters.getVisualIDRegistryGenerator(), myDiagram.getVisualIDRegistryQualifiedClassName(), myDiagram);
		if(myDiagram.getEditorGen().getExpressionProviders() != null) {
			generateExpressionProviders();
		}
		if (isPathInsideGenerationTarget(myDiagram.getCreationWizardIconPathX())) {
			// at the moment this may produce path that reference generated icon file, thus
			// skip generation if the path is relative
			generateDiagramIcon(myDiagram.getCreationWizardIconPathX());
		}
		if (isPathInsideGenerationTarget(myEditorGen.getEditor().getIconPathX())) {
			// at the moment this may produce path that reference generated icon file, thus
			// skip generation if the path is relative
			generateDiagramIcon(myEditorGen.getEditor().getIconPathX());
		}
		generateWizardBanner();
		if (myEditorGen.getApplication() == null && myEditorGen.getNavigator() != null) {
			generateNavigatorContentProvider();
			generateNavigatorLabelProvider();
			generateNavigatorLinkHelper();
			generateNavigatorSorter();
			generateNavigatorActionProvider();
			generateAbstractNavigatorItem();
			generateNavigatorGroup();
			generateNavigatorItem();
			generateNavigatorGroupIcons();
			if (myEditorGen.getDomainGenModel() != null && myEditorGen.getNavigator().isGenerateDomainModelNavigator()) {
				generateDomainNavigatorContentProvider();
				generateDomainNavigatorLabelProvider();
				generateDomainNavigatorItem();
				generateURIEditorInputTester();
			}
		}
		if (myEditorGen.getPropertySheet() != null) {
			generatePropertySheetSections();
		}
		generateApplication();
		generatePreferences();
		generateExternalizationSupport();
	}

	private static boolean isPathInsideGenerationTarget(String path) {
		assert path != null;
		Path p = new Path(path);
		return !p.isAbsolute() && !p.segment(0).equals(".."); //$NON-NLS-1$
	}

	private void generateExpressionProviders() throws UnexpectedBehaviourException, InterruptedException {
		GenExpressionProviderContainer providerContainer = myEditorGen.getExpressionProviders();
		internalGenerateJavaClass(
			myEmitters.getAbstractExpressionEmitter(),
			providerContainer.getExpressionsPackageName(), 
			providerContainer.getAbstractExpressionClassName(),
			myDiagram
		);

		for (GenExpressionProviderBase nextProvider : (List<? extends GenExpressionProviderBase>) providerContainer.getProviders()) {
			if(nextProvider instanceof GenExpressionInterpreter) {
				TextEmitter providerEmitter = null;
				if(GenLanguage.OCL_LITERAL.equals(nextProvider.getLanguage())) {
					providerEmitter = myEmitters.getOCLExpressionFactoryEmitter();
				} else if(GenLanguage.REGEXP_LITERAL.equals(nextProvider.getLanguage()) || GenLanguage.NREGEXP_LITERAL.equals(nextProvider.getLanguage())) {
					providerEmitter = myEmitters.getRegexpExpressionFactoryEmitter();
				}
				GenExpressionInterpreter interpreter = (GenExpressionInterpreter)nextProvider;
				if(providerEmitter != null) {
					internalGenerateJavaClass(
							providerEmitter,
							providerContainer.getExpressionsPackageName(),
							interpreter.getClassName(),
							interpreter);
				}
			}
		}
	}

	private void generateShortcutIcon() throws UnexpectedBehaviourException, InterruptedException {
		doGenerateBinaryFile(myEmitters.getShortcutImageEmitter(), new Path("icons/shortcut.gif"), null); //$NON-NLS-1$
	}
	
	private void generateDiagramIcon(String path) throws UnexpectedBehaviourException, InterruptedException {
		// use genModel.prefix if available to match colors of model icons and diagram icons
		// @see GenPackageImpl#generateEditor - it passes prefix to ModelGIFEmitter 
		Object[] args = new Object[] {myDiagram.getDomainDiagramElement() == null ? myEditorGen.getDiagramFileExtension() : myDiagram.getDomainDiagramElement().getGenPackage().getPrefix() };
		doGenerateBinaryFile(myEmitters.getDiagramIconEmitter(), new Path(path), args);
	}

	private void generateWizardBanner() throws UnexpectedBehaviourException, InterruptedException {
		// @see GenPackageImpl#generateEditor - it passes prefix to ModelWizardGIFEmitter
		try {
			Object[] args = new Object[] {myEmitters.getWizardBannerStemEmitter().generate(new NullProgressMonitor(), new Object[] {myDiagram}) };
			String path = myEmitters.getWizardBannerLocationEmitter().generate(new NullProgressMonitor(), new Object[] {myDiagram});
			doGenerateBinaryFile(myEmitters.getWizardBannerImageEmitter(), new Path(path), args);
		} catch (InvocationTargetException e) {
			handleException(e);
		}
	}

	private void generateBehaviors(GenCommonBase element, HashSet<OpenDiagramBehaviour> generatedBehaviors) throws UnexpectedBehaviourException, InterruptedException {
		for (OpenDiagramBehaviour behaviour : element.getBehaviour(OpenDiagramBehaviour.class)) {
			if (!generatedBehaviors.contains(behaviour)) {
				generatedBehaviors.add(behaviour);
				generateOpenDiagramEditPolicy(behaviour);
			}
		}
	}

	private void generateValidationProvider() throws UnexpectedBehaviourException, InterruptedException {
		internalGenerateJavaClass(
			myEmitters.getValidationProviderGenerator(),
			myDiagram.getProvidersPackageName(),
			myDiagram.getValidationProviderClassName(),
			myDiagram);
		internalGenerateJavaClass(myEmitters.getValidateActionGenerator(), myEmitters.getValidateActionQualifiedNameGenerator(), myDiagram);
	}

	private void generateMarkerNavigationProvider() throws UnexpectedBehaviourException, InterruptedException {
		internalGenerateJavaClass(
			myEmitters.getMarkerNavigationProviderEmitter(), 
			myDiagram.getProvidersPackageName(), 
			myDiagram.getMarkerNavigationProviderClassName(), 
			myDiagram);
	}

	private void generateMetricProvider() throws UnexpectedBehaviourException, InterruptedException {
		internalGenerateJavaClass(
			myEmitters.getMetricProviderEmitter(),
			myDiagram.getProvidersPackageName(),
			myDiagram.getMetricProviderClassName(),
			myDiagram);
		internalGenerateJavaClass(myEmitters.getMetricsActionEmitter(), myEmitters.getMetricsActionQualifiedNameEmitter(), myDiagram);
	}	

	private void generateOpenDiagramEditPolicy(OpenDiagramBehaviour behaviour) throws UnexpectedBehaviourException, InterruptedException {
		internalGenerateJavaClass(myEmitters.getOpenDiagramEditPolicyEmitter(), behaviour.getEditPolicyQualifiedClassName(), behaviour);
	}

	private void generateCommands(GenNode genNode) throws UnexpectedBehaviourException, InterruptedException {
		if (!genNode.getDomainMetaClass().isAbstract()) {
			internalGenerateJavaClass(myEmitters.getCreateNodeCommandEmitter(), myEmitters.getCreateNodeCommandQualifiedClassNameEmitter(), genNode);
		}
		internalGenerateJavaClass(myEmitters.getAddNodeCommandEmitter(), myEmitters.getAddNodeCommandQualifiedClassNameEmitter(), genNode);
		internalGenerateJavaClass(myEmitters.getCloneNodeCommandEmitter(), myEmitters.getCloneNodeCommandQualifiedClassNameEmitter(), genNode);
	}

	private void generateCommands(GenLink genLink) throws UnexpectedBehaviourException, InterruptedException {
		if (!genLink.isViewDirectionAlignedWithModel()) {
			return;
		}
		internalGenerateJavaClass(myEmitters.getCreateLinkStartCommandEmitter(), myEmitters.getCreateLinkStartCommandQualifiedClassNameEmitter(), genLink);
		internalGenerateJavaClass(myEmitters.getCreateLinkCompleteCommandEmitter(), myEmitters.getCreateLinkCompleteCommandQualifiedClassNameEmitter(), genLink);
		internalGenerateJavaClass(myEmitters.getReconnectLinkSourceCommandEmitter(), myEmitters.getReconnectLinkSourceCommandQualifiedClassNameEmitter(), genLink);
		internalGenerateJavaClass(myEmitters.getReconnectLinkTargetCommandEmitter(), myEmitters.getReconnectLinkTargetCommandQualifiedClassNameEmitter(), genLink);
	}

	private void generateLayoutEditPolicy(GenContainerBase containerBase) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getLayoutEditPolicyEmitter(), myEmitters.getLayoutEditPolicyQualifiedClassNameEmitter(), containerBase);
	}

	private void generateSideAffixedLayoutEditPolicy(GenNode node) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getSideAffixedLayoutEditPolicyEmitter(), myEmitters.getSideAffixedLayoutEditPolicyQualifiedClassNameEmitter(), node);
	}

	private void generateGraphicalEditPolicy(GenNode genNode) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getGraphicalEditPolicyEmitter(), genNode.getGraphicalNodeEditPolicyQualifiedClassName(), genNode);
	}

	private void generateGraphicalEditPolicy(GenLink genLink) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getGraphicalEditPolicyEmitter(), myEmitters.getGraphicalEditPolicyQualifiedClassNameEmitter(), genLink);
	}

	private void generateComponentEditPolicy(GenCommonBase genElement) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getComponentEditPolicyEmitter(), myEmitters.getComponentEditPolicyQualifiedClassNameEmitter(), genElement);
	}

	private void generateConnectionEndpointEditPolicy(GenLink genLink) throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(myEmitters.getConnectionEndpointEditPolicyEmitter(), myEmitters.getConnectionEndpointEditPolicyQualifiedClassNameEmitter(), genLink);
	}

	private void generateNavigatorContentProvider() throws InterruptedException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorContentProviderEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getContentProviderClassName(),
				myEditorGen.getNavigator()
			);
	}

	private void generateDomainNavigatorContentProvider() throws InterruptedException {
		doGenerateJavaClass(myEmitters.getDomainNavigatorContentProviderEmitter(), myEditorGen.getNavigator().getDomainContentProviderQualifiedClassName(), myEditorGen.getNavigator());
	}
	
	private void generateDomainNavigatorLabelProvider() throws InterruptedException {
		doGenerateJavaClass(myEmitters.getDomainNavigatorLabelProviderEmitter(), myEditorGen.getNavigator().getDomainLabelProviderQualifiedClassName(), myEditorGen.getNavigator());
	}
	
	private void generateDomainNavigatorItem() throws InterruptedException {
		doGenerateJavaClass(myEmitters.getDomainNavigatorItemEmitter(), myEditorGen.getNavigator().getDomainNavigatorItemQualifiedClassName(), myEditorGen.getNavigator());
	}
	
	private void generateURIEditorInputTester() throws InterruptedException {
		doGenerateJavaClass(myEmitters.getURIEditorInputTesterEmitter(), myEditorGen.getNavigator().getUriInputTesterQualifiedClassName(), myEditorGen.getNavigator());
	}

	private void generateNavigatorLabelProvider() throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorLabelProviderEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getLabelProviderClassName(),
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorLinkHelper() throws InterruptedException {
		if (!myEditorGen.getEditor().isEclipseEditor()) {
			return;
		}
		internalGenerateJavaClass(
				myEmitters.getNavigatorLinkHelperEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getLinkHelperClassName(), 
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorSorter() throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorSorterEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getSorterClassName(), 
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorActionProvider() throws InterruptedException, UnexpectedBehaviourException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorActionProviderEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getActionProviderClassName(), 
				myEditorGen.getNavigator()
			);
	}
	
	private void generateAbstractNavigatorItem() throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(
				myEmitters.getAbstractNavigatorItemEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getAbstractNavigatorItemClassName(),
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorGroup() throws InterruptedException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorGroupEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getNavigatorGroupClassName(),
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorItem() throws InterruptedException {
		internalGenerateJavaClass(
				myEmitters.getNavigatorItemEmitter(),
				myEditorGen.getNavigator().getPackageName(),
				myEditorGen.getNavigator().getNavigatorItemClassName(),
				myEditorGen.getNavigator()
			);
	}
	
	private void generateNavigatorGroupIcons() throws InterruptedException, UnexpectedBehaviourException {
		Set<String> groupIcons = new HashSet<String>();
		for (GenNavigatorChildReference nextReference : (List<? extends GenNavigatorChildReference>) myEditorGen.getNavigator().getChildReferences()) {
			if (nextReference.getGroupIcon() != null && nextReference.getGroupIcon().length() > 0) {
				groupIcons.add(nextReference.getGroupIcon());
			}
		}
		for (String iconPath : groupIcons) {
			generateGroupIcon(new Path(iconPath));
		}
	}
	
	private void generateGroupIcon(Path groupIconPath) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateBinaryFile(myEmitters.getGroupIconEmitter(), groupIconPath, null);	
	}

	protected void generatePropertySheetSections() throws UnexpectedBehaviourException, InterruptedException {
		if (myEditorGen.getPropertySheet().isNeedsCaption()) {
			doGenerateJavaClass(
				myEmitters.getPropertySheetLabelProviderEmitter(), 
				myEditorGen.getPropertySheet().getLabelProviderQualifiedClassName(), 
				myEditorGen.getPropertySheet());
		}
		for (GenPropertyTab tab : (List<? extends GenPropertyTab>) myEditorGen.getPropertySheet().getTabs()) {
			if (tab instanceof GenCustomPropertyTab) {
				doGenerateJavaClass(
					myEmitters.getPropertySectionEmitter(),
					((GenCustomPropertyTab) tab).getQualifiedClassName(),
					tab);
			}
		}
	}

	private void generateApplication() throws UnexpectedBehaviourException, InterruptedException {
		GenApplication application = myEditorGen.getApplication();
		if (application != null) {
			doGenerateJavaClass(myEmitters.getApplicationEmitter(), application.getQualifiedClassName(), application);
			doGenerateJavaClass(myEmitters.getActionBarAdvisorEmitter(), application.getActionBarAdvisorQualifiedClassName(), application);
			doGenerateJavaClass(myEmitters.getPerspectiveEmitter(), application.getPerspectiveQualifiedClassName(), application);
			doGenerateJavaClass(myEmitters.getWorkbenchAdvisorEmitter(), application.getWorkbenchAdvisorQualifiedClassName(), application);
			doGenerateJavaClass(myEmitters.getWorkbenchWindowAdvisorEmitter(), application.getWorkbenchWindowAdvisorQualifiedClassName(), application);
		}
	}

	private void generatePreferences() throws UnexpectedBehaviourException, InterruptedException {
		generatePreferences(myDiagram.getPreferencePages());
	}

	private void generatePreferences(EList<GenPreferencePage> pages) throws UnexpectedBehaviourException, InterruptedException {
		for (GenPreferencePage preferencePage : pages) {
			if (preferencePage instanceof GenStandardPreferencePage) {
				generatePreferencePage((GenStandardPreferencePage) preferencePage);
			}
			generatePreferences(preferencePage.getChildren());
		}
	}

	private void generatePreferencePage(GenStandardPreferencePage preferencePage) throws UnexpectedBehaviourException, InterruptedException {
		switch (preferencePage.getKind()) {
		case APPEARANCE_LITERAL:
			internalGenerateJavaClass(myEmitters.getAppearancePreferencePageEmitter(), myEmitters.getAppearancePreferencePageQualifiedClassNameEmitter(), myDiagram);
			break;
		case GENERAL_LITERAL:
			internalGenerateJavaClass(myEmitters.getGeneralPreferencePageEmitter(), myEmitters.getGeneralPreferencePageQualifiedClassNameEmitter(), myDiagram);
			break;
		//TODO support more standard preference pages.
		}
	}

	private void generateExternalizationSupport() throws UnexpectedBehaviourException, InterruptedException {
        String packageName = myEditorGen.getEditor().getPackageName();
        String messagesClassName = "Messages";
        doGenerateJavaClass(myEmitters.getExternalizeEmitter(), packageName, messagesClassName, new Object[] { myEditorGen });
        doGenerateFile(myEmitters.getMessagesEmitter(), new Path(messagesClassName.toLowerCase()+".properties"), new Object[] { myEditorGen });
    }

	private void internalGenerateJavaClass(TextEmitter emitter, String qualifiedClassName, Object argument) throws InterruptedException {
		internalGenerateJavaClass(emitter, CodeGenUtil.getPackageName(qualifiedClassName), CodeGenUtil.getSimpleClassName(qualifiedClassName), argument);
	}

	private void internalGenerateJavaClass(TextEmitter emitter, TextEmitter qualifiedClassNameEmitter, Object argument) throws InterruptedException {
		String qualifiedClassName = null;
		try {
			qualifiedClassName = qualifiedClassNameEmitter.generate(new NullProgressMonitor(), new Object[] {argument});
		} catch (InvocationTargetException e) {
			handleException(e);
		} catch (UnexpectedBehaviourException e) {
			handleException(e);
		}
		internalGenerateJavaClass(emitter, qualifiedClassName, argument);
	}

	/**
	 * Passes initialized ImportManager as second template argument
	 */
	private void internalGenerateJavaClass(TextEmitter emitter, String packageName, String className, Object argument) throws InterruptedException {
		ImportAssistant importUtil = createImportAssistant(packageName, className);
		doGenerateJavaClass(emitter, packageName, className, argument, importUtil);
	}

	protected void setupProgressMonitor() {
		Counter c = new Counter();
		c.registerFactor(GMFGenPackage.eINSTANCE.getGenNode(), 2);
		c.registerFactor(GMFGenPackage.eINSTANCE.getGenCompartment(), 2);
		c.registerFactor(GMFGenPackage.eINSTANCE.getGenLink(), 2);
		c.registerFactor(GMFGenPackage.eINSTANCE.getGenNodeLabel(), 2);
		c.registerFactor(GMFGenPackage.eINSTANCE.getGenLinkLabel(), 2);
		int total = c.getTotal(myDiagram);
		total++; // init
		total += 4; // text files
		total += 15; // out-of-cycle doGenerateJava... <- genDiagram + genEditor
		setupProgressMonitor(null, total);
	}
}
