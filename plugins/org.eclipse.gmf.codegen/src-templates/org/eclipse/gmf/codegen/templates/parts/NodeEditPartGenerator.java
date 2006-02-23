package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NodeEditPartGenerator {
 
  protected static String nl;
  public static synchronized NodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGenerator result = new NodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.BorderLayout;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.StackLayout;" + NL + "import org.eclipse.gef.EditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ShapeNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {";
  protected final String TEXT_7 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, null);";
  protected final String TEXT_8 = NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_9 = "());" + NL + "\t\tinstallEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new ";
  protected final String TEXT_12 = "() {" + NL + "" + NL + "\t\t\tpublic ";
  protected final String TEXT_13 = " getCommand(";
  protected final String TEXT_14 = " request) {" + NL + "\t\t\t\tif (understandsRequest(request)) {" + NL + "\t\t\t\t\tif (request instanceof ";
  protected final String TEXT_15 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_16 = " adapter = ((";
  protected final String TEXT_17 = ") request).getViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = " type = (";
  protected final String TEXT_19 = ") adapter.getAdapter(";
  protected final String TEXT_20 = ".class);";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tif (type == ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ") {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_24 = " compartmentEditPart = getChildBySemanticHint(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "Compartments.";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t\t\treturn compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.getCommand(request);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_29 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_30 = "());";
  protected final String TEXT_31 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_32 = "());";
  protected final String TEXT_33 = NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new ";
  protected final String TEXT_34 = "() {" + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_35 = " child) {" + NL + "\t\t\t\tEditPolicy result = super.createChildEditPolicy(child);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_36 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_37 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createNodeShape() {";
  protected final String TEXT_38 = NL + "\t\treturn new ";
  protected final String TEXT_39 = "()";
  protected final String TEXT_40 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t\treturn ";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL + " \t\treturn new ";
  protected final String TEXT_45 = "();";
  protected final String TEXT_46 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodePlate() {";
  protected final String TEXT_47 = NL + "\t\treturn new DefaultSizeNodeFigure(getMapMode().DPtoLP(";
  protected final String TEXT_48 = "), getMapMode().DPtoLP(";
  protected final String TEXT_49 = "));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {" + NL + "\t\tNodeFigure figure = createNodePlate();" + NL + "\t\tfigure.setLayoutManager(new StackLayout());" + NL + "\t\tIFigure shape = createNodeShape();" + NL + "\t\tfigure.add(shape);" + NL + "\t\tif (shape.getLayoutManager() == null){" + NL + "\t\t\tshape.setLayoutManager(new StackLayout());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tIFigure shapeContents = new Figure();" + NL + "\t\tshape.add(shapeContents);" + NL + "\t\tshapeContents.setLayoutManager(new BorderLayout());" + NL + "\t\taddContentPane(shapeContents);" + NL + "\t\tdecorateShape(shapeContents);" + NL + "" + NL + "\t\treturn figure;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void decorateShape(IFigure shapeContents) {" + NL + "\t\tView view = (View) getModel();" + NL + "\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcutted\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFigure decorationPane = new Figure();" + NL + "\t\tdecorationPane.setLayoutManager(new BorderLayout());" + NL + "\t\tshapeContents.add(decorationPane, BorderLayout.BOTTOM);" + NL + "\t\t" + NL + "\t\tImageFigureEx imageFigure = new ImageFigureEx(";
  protected final String TEXT_50 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"));" + NL + "\t\tdecorationPane.add(imageFigure, BorderLayout.RIGHT);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addContentPane(IFigure shape) {" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_51 = "();" + NL + "\t\tshape.add(contentPane, BorderLayout.CENTER);";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = " layout = new ";
  protected final String TEXT_54 = "();" + NL + "\t\tlayout.setSpacing(getMapMode().DPtoLP(5));" + NL + "\t\tcontentPane.setLayoutManager(layout);";
  protected final String TEXT_55 = NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_56 = "() {" + NL + "\t\t\tpublic Object getConstraint(IFigure figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_57 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_58 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_59 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_60 = " getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = "Labels.";
  protected final String TEXT_63 = ");" + NL + "\t}";
  protected final String TEXT_64 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_65 = " childEditPart, int index) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_66 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_67 = " childEditPart) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_68 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_69 = " childEditPart) {";
  protected final String TEXT_70 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_71 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_72 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_73 = " root = (";
  protected final String TEXT_74 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_75 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + "}";
  protected final String TEXT_78 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = genNode.getDiagram();
boolean useFlowLayout = !genNode.isListLayout();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    if (!genNode.getChildNodes().isEmpty()) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genNode.getGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
boolean hasActualChildren = !genNode.getChildNodes().isEmpty();
for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();) {
	GenCompartment compartment = (GenCompartment) compartments.next();
	hasActualChildren |= compartment.isListLayout() && !compartment.getChildNodes().isEmpty();
}
if (hasActualChildren) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_20);
    
	for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();) {
		GenCompartment compartment = (GenCompartment) compartments.next();
		if (compartment.isListLayout() && !compartment.getChildNodes().isEmpty()) {
			for (Iterator children = compartment.getChildNodes().iterator(); children.hasNext(); ) {
				GenNode child = (GenNode) children.next();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(child.getUniqueIdentifier());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(compartment.getSemanticHintFieldName());
    stringBuffer.append(TEXT_27);
    
			}
		}
	}

    stringBuffer.append(TEXT_28);
    
}
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy"));
    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genNode.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
if (useFlowLayout) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy"));
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassName = null;
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_39);
    if (useFlowLayout) {
    stringBuffer.append(TEXT_40);
    } // use flow layout
    stringBuffer.append(TEXT_41);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_43);
    } // instanceof SnippetViewmap 
 else if (viewmap instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((InnerClassViewmap) viewmap).getClassName());
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
int width = 40;
int height = 40;
DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) genNode.getViewmap().find(DefaultSizeAttributes.class);
if (defSizeAttrs != null) {
	width = defSizeAttrs.getWidth();
	height = defSizeAttrs.getHeight();
}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(height);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_51);
    
if (!useFlowLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout");

    stringBuffer.append(TEXT_52);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_54);
    
} else {
// Flow layout

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_57);
    
}

    stringBuffer.append(TEXT_58);
    
if (!genNode.getLabels().isEmpty()) {
	GenNodeLabel primaryLabel = (GenNodeLabel) genNode.getLabels().get(0);
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
	String labelName = primaryLabel.getSemanticHintFieldName();
	if (primaryLabel instanceof GenExternalNodeLabel) {
		labelName = ((GenExternalNodeLabel) primaryLabel).getSemanticHintLabelFieldName();
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(labelName);
    stringBuffer.append(TEXT_63);
    
}
boolean hasExternalLabels = false;
for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
	GenNodeLabel label = (GenNodeLabel) labels.next();
	if (label instanceof ExternalLabel) {
		hasExternalLabels = true;
		break;
	}
}
if (hasExternalLabels) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_69);
    
	for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
		GenNodeLabel label = (GenNodeLabel) labels.next();
		if (label instanceof ExternalLabel) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    
		}
	}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    
}
if (genNode.getViewmap() instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(((InnerClassViewmap) genNode.getViewmap()).getClassBody());
    }
    stringBuffer.append(TEXT_77);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}