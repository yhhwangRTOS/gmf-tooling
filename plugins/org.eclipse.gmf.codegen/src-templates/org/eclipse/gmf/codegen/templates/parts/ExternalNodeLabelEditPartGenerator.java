package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ExternalNodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized ExternalNodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ExternalNodeLabelEditPartGenerator result = new ExternalNodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.draw2d.Label;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gef.EditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;" + NL + "//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;" + NL + "import ";
  protected final String TEXT_7 = ".LabelDirectEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_8 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = " implements ITextAwareEditPart {";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String VISUAL_ID = \"";
  protected final String TEXT_13 = "\";";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_16 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_17 = " parser;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_18 = " parserElements;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic {" + NL + "\t\tregisterSnapBackPosition(";
  protected final String TEXT_19 = ".VISUAL_ID, new Point(0, 0));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_20 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());" + NL + "\t}";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_23 = " getLabel() {" + NL + "\t\treturn (";
  protected final String TEXT_24 = ") getFigure();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setLabel(";
  protected final String TEXT_25 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);" + NL + "\t\tdefaultText = figure.getText();" + NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setLabelText(String text) {" + NL + "\t\tgetLabel().setText(text);" + NL + "\t\tObject pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);" + NL + "\t\tif (pdEditPolicy instanceof ";
  protected final String TEXT_26 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_27 = ") pdEditPolicy).refreshFeedback();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshUnderline() {" + NL + "\t\t";
  protected final String TEXT_28 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_29 = ") getPrimaryView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_30 = ".eINSTANCE.getFontStyle());" + NL + "\t\tif (style != null) {" + NL + "\t\t\t//getLabel().setTextUnderline(style.isUnderline());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshStrikeThrough() {" + NL + "\t\t";
  protected final String TEXT_31 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_32 = ") getPrimaryView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_33 = ".eINSTANCE.getFontStyle());" + NL + "\t\tif (style != null) {" + NL + "\t\t\t//getLabel().setTextStrikeThrough(style.isStrikeThrough());" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_36 = " getLabelIcon() {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_39 = " getModelChildren() {" + NL + "\t\treturn ";
  protected final String TEXT_40 = ".EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_41 = " getChildBySemanticHint(String semanticHint) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_42 = " element = resolveSemanticElement();" + NL + "\t\tString text = null;" + NL + "\t\tif (element != null && getParser() != null) {" + NL + "\t\t\ttext = getParser().getPrintString(new ";
  protected final String TEXT_43 = "(element)," + NL + "\t\t\t\tgetParserOptions().intValue());" + NL + "\t\t}" + NL + "\t\tif (text == null || text.length() == 0) {" + NL + "\t\t\ttext = defaultText;" + NL + "\t\t}" + NL + "\t\treturn text;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditText() {" + NL + "\t\t";
  protected final String TEXT_44 = " element = resolveSemanticElement();" + NL + "\t\tif (element == null || getParser() == null) {" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL + "\t\treturn getParser().getEditString(new ";
  protected final String TEXT_45 = "(element)," + NL + "\t\t\tgetParserOptions().intValue());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = " element = resolveSemanticElement();" + NL + "\t\tif (element != null && getEditText() != null) {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_48 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_49 = " getEditTextValidator() {" + NL + "\t\treturn new ";
  protected final String TEXT_50 = "() {" + NL + "" + NL + "\t\t\tpublic String isValid(final Object value) {" + NL + "\t\t\t\tif (value instanceof String) {" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_51 = " element = resolveSemanticElement();" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_52 = " parser = getParser();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_53 = " valid =" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_54 = ") getEditingDomain().runExclusive(" + NL + "\t\t\t\t\t\t\t\tnew ";
  protected final String TEXT_55 = ".Impl() {" + NL + "" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tsetResult(parser.isValidEditString(" + NL + "\t\t\t\t\t\t\t\t\tnew ";
  protected final String TEXT_56 = "(element), (String) value));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\treturn valid.getCode() == ";
  protected final String TEXT_57 = ".EDITABLE ?" + NL + "\t\t\t\t\t\t\tnull : valid.getMessage();" + NL + "\t\t\t\t\t} catch (InterruptedException ie) {" + NL + "\t\t\t\t\t\tie.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t// shouldn't get here" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_58 = " getCompletionProcessor() {" + NL + "\t\t";
  protected final String TEXT_59 = " element = resolveSemanticElement();" + NL + "\t\tif (element == null || getParser() == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getParser().getCompletionProcessor(new ";
  protected final String TEXT_60 = "(element));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_61 = " getParserOptions() {" + NL + "\t\treturn ";
  protected final String TEXT_62 = ".NONE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_63 = " getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tString parserHint = ((";
  protected final String TEXT_64 = ") getModel()).getType();" + NL + "\t\t\t";
  protected final String TEXT_65 = " element = resolveSemanticElement();" + NL + "\t\t\tif (element != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_66 = " hintAdapter =" + NL + "\t\t\t\t\tnew ";
  protected final String TEXT_67 = "(element, parserHint) {" + NL + "" + NL + "\t\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_68 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getAdapter(adapter);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tparser = ";
  protected final String TEXT_71 = ".getInstance().getParser(hintAdapter);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_72 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tsetManager(new ";
  protected final String TEXT_73 = "(this));" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setManager(";
  protected final String TEXT_74 = " manager) {" + NL + "\t\tthis.manager = manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit(";
  protected final String TEXT_75 = " eventLocation) {" + NL + "\t\tif (getManager().getClass() == ";
  protected final String TEXT_76 = ".class) {" + NL + "\t\t\t((";
  protected final String TEXT_77 = ") getManager()).show(eventLocation.getSWTPoint());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void performDirectEdit(char initialCharacter) {" + NL + "\t\tif (getManager() instanceof ";
  protected final String TEXT_78 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_79 = ") getManager()).show(initialCharacter);" + NL + "\t\t} else {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEditRequest(";
  protected final String TEXT_80 = " request) {" + NL + "\t\tfinal ";
  protected final String TEXT_81 = " theRequest = request;" + NL + "\t\ttry {" + NL + "\t\t\tgetEditingDomain().runExclusive(new Runnable() {" + NL + "" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\tif (isActive() && isEditable()) {" + NL + "\t\t\t\t\t\tif (theRequest instanceof ";
  protected final String TEXT_82 = ") {" + NL + "\t\t\t\t\t\t\tchar c = ((";
  protected final String TEXT_83 = ") theRequest).getInitialCharacter();" + NL + "\t\t\t\t\t\t\tperformDirectEdit(c);" + NL + "\t\t\t\t\t\t} else if ((theRequest instanceof ";
  protected final String TEXT_84 = ") && (getEditText().equals(getLabelText()))) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_85 = " editRequest =" + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_86 = ") theRequest;" + NL + "\t\t\t\t\t\t\tperformDirectEdit(editRequest.getLocation());" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tperformDirectEdit();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t\trefreshUnderline();" + NL + "\t\trefreshStrikeThrough();";
  protected final String TEXT_87 = NL + "\t\trefreshBounds();";
  protected final String TEXT_88 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t\tObject pdEditPolicy = getEditPolicy(";
  protected final String TEXT_89 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (pdEditPolicy instanceof ";
  protected final String TEXT_90 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_91 = ") pdEditPolicy).refreshFeedback();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {" + NL + "\t\t";
  protected final String TEXT_92 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_93 = ") getPrimaryView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_94 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_95 = " fontData;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tfontData = new ";
  protected final String TEXT_96 = "(" + NL + "\t\t\t\tstyle.getFontName(), style.getFontHeight()," + NL + "\t\t\t\t(style.isBold() ? ";
  protected final String TEXT_97 = ".BOLD : ";
  protected final String TEXT_98 = ".NORMAL) |" + NL + "\t\t\t\t(style.isItalic() ? ";
  protected final String TEXT_99 = ".ITALIC : ";
  protected final String TEXT_100 = ".NORMAL));" + NL + "\t\t} else {" + NL + "\t\t\t// initialize font to defaults" + NL + "\t\t\tfontData = ";
  protected final String TEXT_101 = ".getFontData(" + NL + "\t\t\t\t(";
  protected final String TEXT_102 = ") getDiagramPreferencesHint().getPreferenceStore()," + NL + "\t\t\t\t";
  protected final String TEXT_103 = ".PREF_DEFAULT_FONT);" + NL + "\t\t}" + NL + "\t\tsetFont(fontData);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFontColor(";
  protected final String TEXT_104 = " color) {" + NL + "\t\tgetLabel().setForegroundColor(color);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addSemanticListeners() {" + NL + "\t\tif (getParser() instanceof ";
  protected final String TEXT_105 = ") {" + NL + "\t\t\t";
  protected final String TEXT_106 = " element = resolveSemanticElement();" + NL + "\t\t\tparserElements = ((";
  protected final String TEXT_107 = ") getParser()).getSemanticElementsBeingParsed(element);" + NL + "\t\t\tfor (int i = 0; i < parserElements.size(); i++) {" + NL + "\t\t\t\taddListenerFilter(\"SemanticModel\" + i, this, (";
  protected final String TEXT_108 = ") parserElements.get(i)); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tsuper.addSemanticListeners();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeSemanticListeners() {" + NL + "\t\tif (parserElements != null) {" + NL + "\t\t\tfor (int i = 0; i < parserElements.size(); i++) {" + NL + "\t\t\t\tremoveListenerFilter(\"SemanticModel\" + i); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tsuper.removeSemanticListeners();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_109 = " getAccessibleEditPart() {" + NL + "\t\tif (accessibleEP == null) {" + NL + "\t\t\taccessibleEP = new AccessibleGraphicalEditPart() {" + NL + "" + NL + "\t\t\t\tpublic void getName(";
  protected final String TEXT_110 = " e) {" + NL + "\t\t\t\t\te.result = getLabel().getText();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn accessibleEP;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_111 = " event) {" + NL + "\t\tObject feature = event.getFeature();";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = "\t\tif (";
  protected final String TEXT_114 = ".eINSTANCE.getFontStyle_FontColor().equals(feature)) {" + NL + "\t\t\tInteger c = (Integer) event.getNewValue();" + NL + "\t\t\tsetFontColor(";
  protected final String TEXT_115 = ".getInstance().getColor(c));" + NL + "\t\t} else if (";
  protected final String TEXT_116 = ".eINSTANCE.getFontStyle_Underline().equals(feature)) {" + NL + "\t\t\trefreshUnderline();" + NL + "\t\t} else if (";
  protected final String TEXT_117 = ".eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {" + NL + "\t\t\trefreshStrikeThrough();" + NL + "\t\t} else if (";
  protected final String TEXT_118 = ".eINSTANCE.getFontStyle_FontHeight().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_119 = ".eINSTANCE.getFontStyle_FontName().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_120 = ".eINSTANCE.getFontStyle_Bold().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_121 = ".eINSTANCE.getFontStyle_Italic().equals(feature)) {" + NL + "\t\t\trefreshFont();" + NL + "\t\t} else {" + NL + "\t\t\tif (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {" + NL + "\t\t\t\trefreshLabel();" + NL + "\t\t\t}" + NL + "\t\t\tif (getParser() instanceof ISemanticParser) {" + NL + "\t\t\t\t";
  protected final String TEXT_122 = " modelParser =" + NL + "\t\t\t\t\t(";
  protected final String TEXT_123 = ") getParser();" + NL + "\t\t\t\tif (modelParser.areSemanticElementsAffected(null, event)) {" + NL + "\t\t\t\t\tremoveSemanticListeners();" + NL + "\t\t\t\t\tif (resolveSemanticElement() != null) {" + NL + "\t\t\t\t\t\taddSemanticListeners();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trefreshLabel();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.handleNotificationEvent(event);" + NL + "\t}";
  protected final String TEXT_124 = NL;
  protected final String TEXT_125 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_126 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_127 = " label = createLabel();" + NL + "\t\tdefaultText = label.getText();" + NL + "\t\treturn label;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_128 = " createLabel() {";
  protected final String TEXT_129 = NL + "\t\treturn new ";
  protected final String TEXT_130 = "();";
  protected final String TEXT_131 = NL + "\t\treturn ";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = NL + "\t\treturn new ";
  protected final String TEXT_134 = "();";
  protected final String TEXT_135 = NL + "\t}" + NL;
  protected final String TEXT_136 = NL;
  protected final String TEXT_137 = NL + "}";
  protected final String TEXT_138 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenExternalNodeLabel genLabel = (GenExternalNodeLabel) ((Object[]) argument)[0];
GenCommonBase genHost = genLabel.getNode();
GenDiagram genDiagram = genLabel.getDiagram();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_7);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_10);
    {
GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_20);
    final boolean needsRefreshBounds = false;
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_45);
    if (!genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ICellEditorValidator"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ICellEditorValidator"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.RunnableWithResult"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.text.contentassist.IContentAssistProcessor"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genHost.getUniqueIdentifier());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserService"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.internal.requests.DirectEditRequestWrapper"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.internal.requests.DirectEditRequestWrapper"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_86);
    if (needsRefreshBounds) {
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.PreferenceConverter"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.AccessibleEditPart"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.accessibility.AccessibleEvent"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_128);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genLabel.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.Label";
	}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_130);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_132);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_133);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    if (genLabel.getViewmap() instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(((InnerClassViewmap) genLabel.getViewmap()).getClassBody());
    }
    stringBuffer.append(TEXT_137);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_138);
    return stringBuffer.toString();
  }
}
