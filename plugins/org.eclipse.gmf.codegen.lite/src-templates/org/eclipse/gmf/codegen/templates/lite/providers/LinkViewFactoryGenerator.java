package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class LinkViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LinkViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkViewFactoryGenerator result = new LinkViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void decorateView(";
  protected final String TEXT_6 = " view) {";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "view.setType(";
  protected final String TEXT_9 = ".getType(";
  protected final String TEXT_10 = ".VISUAL_ID));" + NL + "\t\t//XXX: init styles from attributes!!!";
  protected final String TEXT_11 = NL + "\t\tcreate";
  protected final String TEXT_12 = "Label(view);";
  protected final String TEXT_13 = NL + "\t}" + NL;
  protected final String TEXT_14 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void create";
  protected final String TEXT_15 = "Label(";
  protected final String TEXT_16 = " view) {" + NL + "\t\t";
  protected final String TEXT_17 = " label = ";
  protected final String TEXT_18 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(label);" + NL + "\t\tlabel.setElement(null);" + NL + "\t\t";
  protected final String TEXT_19 = ".decorateView(label);" + NL + "\t}";
  protected final String TEXT_20 = NL + "}";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenLink genElement = (GenLink) ((Object[]) argument)[0];
GenDiagram genDiagram = genElement.getDiagram();
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genElement.getDiagram().getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genElement.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel label = (GenLinkLabel) it.next();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_12);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_13);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel label = (GenLinkLabel) it.next();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_20);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
