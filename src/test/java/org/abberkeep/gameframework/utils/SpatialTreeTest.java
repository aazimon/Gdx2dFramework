/*
 * Copyright (c) 2023 Gary Deken
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.abberkeep.gameframework.utils;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import org.abberkeep.gameframework.animation.MockAnimation;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

      Set<SpatialTree.Node> result = underTest.entrySet();
      Iterator<SpatialTree.Node> iter = result.iterator();

      assertEquals(3, result.size());

//      SpatialTree.Node entry = iter.next();
//      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
//      fail("The test case is a prototype.");
   }

   @Test
   public void testGetPut() {
      // Root
      Decor d = new Decor(new MockAnimation());
      d.setLocation(14, 21);

      underTest.put(d);

      SpatialKey key = new SpatialKey(14, 21, 14f);
      Sprite result = underTest.get(key);
      assertEquals(d, result);

      // Left
      Decor l = new Decor(new MockAnimation());
      l.setLocation(13, 20);

      underTest.put(l);

      key = new SpatialKey(13, 20, 13f);
      result = underTest.get(key);
      assertEquals(l, result);

      // Right
      Decor r = new Decor(new MockAnimation());
      r.setLocation(15, 22);

      underTest.put(r);

      key = new SpatialKey(15, 22, 15f);
      result = underTest.get(key);
      assertEquals(r, result);

      // Same Left
      Decor l2 = new Decor(new MockAnimation());
      l2.setLocation(13, 20);

      underTest.put(l2);

      key = new SpatialKey(13, 20, 13f);
      key.increaseX();
      result = underTest.get(key);
      assertEquals(l2, result);

      // Same Right
      Decor r2 = new Decor(new MockAnimation());
      r2.setLocation(15, 22);

      underTest.put(r2);

      key = new SpatialKey(15, 22, 15f);
      key.increaseX();
      result = underTest.get(key);
      assertEquals(r2, result);

      // Same Root
      Decor d2 = new Decor(new MockAnimation());
      d2.setLocation(14, 21);

      underTest.put(d2);

      key = new SpatialKey(14, 21, 14f);
      key.increaseX();
      result = underTest.get(key);
      assertEquals(d2, result);
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
//      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
//      fail("The test case is a prototype.");
   }

}
