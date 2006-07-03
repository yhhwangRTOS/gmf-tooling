package org.eclipse.gmf.codegen.templates.lite.commands;

import org.eclipse.gmf.common.codegen.*;

public class ReconnectNotationalEdgeTargetCommandGenerator
{
  protected static String nl;
  public static synchronized ReconnectNotationalEdgeTargetCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ReconnectNotationalEdgeTargetCommandGenerator result = new ReconnectNotationalEdgeTargetCommandGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ReconnectNotationalEdgeTargetCommand extends ";
  protected final String TEXT_4 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_5 = " edge;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_6 = " newTarget;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " oldTarget;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ReconnectNotationalEdgeTargetCommand(";
  protected final String TEXT_8 = " edge, ";
  protected final String TEXT_9 = " newTarget) {" + NL + "\t\tthis.edge = edge;" + NL + "\t\tthis.newTarget = newTarget;" + NL + "\t}" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canExecute() {" + NL + "\t\treturn newTarget != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canUndo() {" + NL + "\t\treturn oldTarget != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void execute() {" + NL + "\t\toldTarget = edge.getTarget();" + NL + "\t\tedge.setTarget(newTarget);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void redo() {" + NL + "\t\texecute();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void undo() {" + NL + "\t\tedge.setTarget(oldTarget);" + NL + "\t\toldTarget = null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_2);
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
