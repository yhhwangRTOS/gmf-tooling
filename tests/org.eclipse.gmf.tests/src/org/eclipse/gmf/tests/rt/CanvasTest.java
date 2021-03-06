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
package org.eclipse.gmf.tests.rt;

import junit.framework.TestCase;

/**
 * @author artem
 */
public class CanvasTest extends TestCase {

	/**
	 * Constructor for CanvasTest.
	 * @param name
	 */
	public CanvasTest(String name) {
		super(name);
	}

	public void testUinAssignment() {
		fail("Revisit");
//		Diagram dc = NotationFactory.eINSTANCE.createDiagram();
//		int[] assigned = new int[20];
//		for (int i = 0; i < assigned.length; i++) {
//			assigned[i] = dc.nextAvailableUin();
//			View de = null;
//			if (i % 3 == 0) {
//				dc.getPersistedChildren().add(de = NotationFactory.eINSTANCE.createNode());
//			} else {
//				dc.getPersistedEdges().add(de = NotationFactory.eINSTANCE.createEdge());
//			}
//			de.setUin(assigned[i]);
//		}
//		Arrays.sort(assigned);
//		for (int i = 2; i < assigned.length; i++) {
//			assertTrue("There should be no same uins", assigned[i-1] != assigned[i]);
//		}
//		// choose arbitrary uin as last assigned
//		dc.setLastAssignedUin(assigned[assigned.length/2]);
//		// make sure newest uins do not contradict existing uins
//		for (int i = 0; i < 5; i++) {
//			assertTrue("Newly generated uin matches existing one after change of lastAssignedUin", Arrays.binarySearch(assigned, dc.nextAvailableUin()) < 0);
//		}
	}
}
