package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class CompartmentViewFactoryGenerator
{
  protected static String nl;
  public static synchronized CompartmentViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CompartmentViewFactoryGenerator result = new CompartmentViewFactoryGenerator();
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
  protected final String TEXT_10 = ".VISUAL_ID));" + NL + "\t\t";
  protected final String TEXT_11 = " drawerStyle = ";
  protected final String TEXT_12 = ".eINSTANCE.createDrawerStyle();" + NL + "\t\tview.getStyles().add(drawerStyle);" + NL + "\t\t//XXX: init styles from attributes!!!" + NL + "\t\t";
  protected final String TEXT_13 = " titleStyle = ";
  protected final String TEXT_14 = ".eINSTANCE.createTitleStyle();" + NL + "\t\tview.getStyles().add(titleStyle);" + NL + "\t}" + NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenCompartment genElement = (GenCompartment) ((Object[]) argument)[0];
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.TitleStyle"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
