/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.gameframework.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.abberkeep.gameframework.animation.MockAnimation;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Title: SpatialTreeTest
 *
 * Copyright (c) Sept 20, 2023
 *
 * @author Gary Deken
 * @version 0.10
 */
public class SpatialTreeTest {
   private SpatialTree underTest;

   @Before
   public void setUp() {
      underTest = new SpatialTree();
   }

   @After
   public void tearDown() {
   }

   @Test
   public void testEntrySet() {
      Decor d1 = new Decor(new MockAnimation());
      d1.setLocation(14, 21);
      Decor d2 = new Decor(new MockAnimation());
      d2.setLocation(19, 26);
      Decor d3 = new Decor(new MockAnimation());
      d3.setLocation(9, 16);

      underTest.put(d1);
      underTest.put(d2);
      underTest.put(d3);

      Set<Map.Entry<SpatialKey, Sprite>> expResult = null;
      Set<Map.Entry<SpatialKey, Sprite>> result = underTest.entrySet();
      Iterator<Map.Entry<SpatialKey, Sprite>> iter = result.iterator();

      assertEquals(3, result.size());

      Map.Entry<SpatialKey, Sprite> entry = iter.next();

      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   @Test
   public void testGetPut() {
      Decor d = new Decor(new MockAnimation());
      d.setLocation(14, 21);

      SpatialKey key = new SpatialKey(14, 21, 14f);
      underTest.put(d);

      Sprite result = underTest.get(key);
      assertEquals(d, result);
   }

   /**
    * Test of iterator method, of class SpatialTree.
    */
   @Test
   public void testIterator() {
      System.out.println("iterator");
      SpatialTree instance = new SpatialTree();
      Iterator<SpatialKey> expResult = null;
      Iterator<SpatialKey> result = instance.iterator();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
