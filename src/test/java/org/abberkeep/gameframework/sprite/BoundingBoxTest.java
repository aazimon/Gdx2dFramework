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
package org.abberkeep.gameframework.sprite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author gary
 */
public class BoundingBoxTest {
   private BoundingBox underTest;
   private int x1 = 5;
   private int x2 = 15;
   private int x3 = 25;
   private int y1 = 5;
   private int y2 = 15;
   private int y3 = 25;

   @Before
   public void setUp() {
      underTest = new BoundingBox(10, 10, 20, 20);
      //10,30   30,30
      //10,10   30,10
   }

   @Test
   public void testContains1() {
      BoundingBox other = new BoundingBox(x1, y3, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains2() {
      BoundingBox other = new BoundingBox(x2, y3, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains3() {
      BoundingBox other = new BoundingBox(x3, y3, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains4() {
      BoundingBox other = new BoundingBox(x1, y2, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains5() {
      BoundingBox other = new BoundingBox(x2, y2, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains6() {
      BoundingBox other = new BoundingBox(x3, y2, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains7() {
      BoundingBox other = new BoundingBox(x1, y1, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains8() {
      BoundingBox other = new BoundingBox(x2, y1, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains9() {
      BoundingBox other = new BoundingBox(x3, y1, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContainsNo() {
      BoundingBox other = new BoundingBox(35, 35, 10, 10);

      assertFalse(underTest.contains(other));
   }

}
