package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class StructuralFeaturesParserGenerator
{
  protected static String nl;
  public static synchronized StructuralFeaturesParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    StructuralFeaturesParserGenerator result = new StructuralFeaturesParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.text.FieldPosition;" + NL + "import java.text.MessageFormat;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.emf.transaction.util.TransactionUtil;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate List features;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "(List features) {" + NL + "\t\tthis.features = features;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tList values = new ArrayList(features.size());" + NL + "\t\tfor (Iterator it = features.iterator(); it.hasNext();) {" + NL + "\t\t\tEStructuralFeature feature = (EStructuralFeature) it.next();" + NL + "\t\t\tObject value = element.eGet(feature);" + NL + "\t\t\tvalue = getValidValue(feature, value);" + NL + "\t\t\tvalues.add(value);" + NL + "\t\t}" + NL + "\t\treturn processor.format(values.toArray(new Object[values.size()]), new StringBuffer(), new FieldPosition(0)).toString();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParserEditStatus validateValues(Object[] values) {" + NL + "\t\tif (values.length != features.size()) {" + NL + "\t\t\treturn ParserEditStatus.UNEDITABLE_STATUS;" + NL + "\t\t}" + NL + "\t\tfor (int i = 0; i < values.length; i++) {" + NL + "\t\t\tObject value = getValidNewValue((EStructuralFeature) features.get(i), values[i]);" + NL + "\t\t\tif (value instanceof InvalidValue) {" + NL + "\t\t\t\treturn new ParserEditStatus(";
  protected final String TEXT_9 = ".ID," + NL + "\t\t\t\t\tIParserEditStatus.UNEDITABLE, value.toString());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, Object[] values) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tTransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);" + NL + "\t\tif (editingDomain == null) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tCompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, \"Set Values\"); //$NON-NLS-1$" + NL + "\t\tfor (int i = 0; i < values.length; i++) {" + NL + "\t\t\tEStructuralFeature feature = (EStructuralFeature) features.get(i);" + NL + "\t\t\tcommand.compose(getModificationCommand(element, feature, values[i]));" + NL + "\t\t}" + NL + "\t\treturn command;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isAffectingEvent(Object event, int flags) {" + NL + "\t\tif (event instanceof Notification) {" + NL + "\t\t\tObject feature = ((Notification) event).getFeature();" + NL + "\t\t\tif (features.contains(feature)) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getStructuralFeaturesParserClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getStructuralFeaturesParserClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
