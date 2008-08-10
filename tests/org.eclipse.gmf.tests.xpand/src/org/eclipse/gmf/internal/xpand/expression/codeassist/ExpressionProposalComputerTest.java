/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.Variable;

public class ExpressionProposalComputerTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public final void testComputePrefixAndTargetExpression1() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("test");
        assertEquals("test", s[0]);
        assertNull(s[1]);
    }

    public final void testComputePrefixAndTargetExpression2() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("test.th");
        assertEquals("th", s[0]);
        assertEquals("test", s[1]);
    }

    public final void testComputePrefixAndTargetExpression3() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("test.the.computer.now");
        assertEquals("now", s[0]);
        assertEquals("test.the.computer", s[1]);
    }

    public final void testComputePrefixAndTargetExpression4() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("test(true,\nfalse()).next");
        assertEquals("next", s[0]);
        assertEquals("test(true,\nfalse())", s[1]);
    }

    public final void testComputePrefixAndTargetExpression5() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("bdlfsdfows test. bla({}).");
        assertEquals("", s[0]);
        assertEquals("test. bla({})", s[1]);
    }

    public final void testComputePrefixAndTargetExpression6() {
        final String[] s = ExpressionProposalComputer
                .computePrefixAndTargetExpression("test(true, {false, 'hallo',stuff.");
        assertEquals("", s[0]);
        assertEquals("stuff", s[1]);
    }

    public final void testComputePrefixAndTargetExpression7() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("rfq.*test");
        assertEquals("test", s[0]);
        assertEquals(null, s[1]);
    }

    public final void testComputePrefixAndTargetExpression8() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("\\x");
        assertEquals("x", s[0]);
        assertEquals(null, s[1]);
    }

    public final void testComputePrefixAndTargetExpression9() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("FOREACH (Set[EPackage])e.all");
        assertEquals("all", s[0]);
        assertEquals("e", s[1]);
    }

    public final void testComputePrefixAndTargetExpression10() {
        final String[] s = ExpressionProposalComputer.computePrefixAndTargetExpression("TEST ");
        assertEquals("", s[0]);
        assertEquals(null, s[1]);
    }

    public final void testSetInState() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable("v", BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "v.select(e| true";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(2, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable("v").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEString(), ctx.getVariable("e").getValue());
    }

    public final void testSetInState1() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable("v", BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "v.select(e| true)";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(1, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable("v").getValue());
    }

    public final void testSetInState2() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable("v", BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "v.select(e| ((List[Boolean]){true}).collect(e|";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(2, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable("v").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), ctx.getVariable("e").getValue());
    }

    public final void testSetInState3() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable("v", BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "v.select(e| ((List[Boolean]){true}).collect(b|";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(3, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable("v").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEString(), ctx.getVariable("e").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), ctx.getVariable("b").getValue());
    }

    public final void testSetInState4() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "select(e| ((List[Boolean]){true}).collect(b|";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(3, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE)
                .getValue());
        assertEquals(EcorePackage.eINSTANCE.getEString(), ctx.getVariable("e").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), ctx.getVariable("b").getValue());
    }

    public final void testSetInState5() {
        ExecutionContextImpl ctx = new ExecutionContextImpl(new Scope() {});
        ctx = (ExecutionContextImpl) ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString())));
        final String s = "let x = 'test' : select(e| ((List[Boolean]){true}).collect(b|";
        ctx = (ExecutionContextImpl) ExpressionProposalComputer.computeExecutionContext(s, ctx);
        assertEquals(4, ctx.getVisibleVariables().size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE)
                .getValue());
        assertEquals(EcorePackage.eINSTANCE.getEString(), ctx.getVariable("e").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), ctx.getVariable("b").getValue());
        assertEquals(EcorePackage.eINSTANCE.getEString(), ctx.getVariable("x").getValue());
    }
}
