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
   private int x = 10;
   private int y = 10;

   @Before
   public void setUp() {
      underTest = new BoundingBox(x, y, 0, 20, 20);
      // x 10 width 20. Width is 10 to 29
      // y 10 height 20. height is 10 to 29
      //10,29   29,29
      //10,10   29,10
   }

   @Test
   public void testContains1() {
      BoundingBox other = new BoundingBox(x - 5, y + 15, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains2() {
      BoundingBox other = new BoundingBox(x + 5, y + 15, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains3() {
      BoundingBox other = new BoundingBox(x + 15, y + 15, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains4() {
      BoundingBox other = new BoundingBox(x - 5, y + 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   // x 10 width 20. Width is 10 to 29
   // y 10 height 20. height is 10 to 29
   //10,29   29,29
   //10,10   29,10
   @Test
   public void testContains5() {
      BoundingBox other = new BoundingBox(x + 5, y + 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains6() {
      BoundingBox other = new BoundingBox(x + 15, y + 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains7() {
      BoundingBox other = new BoundingBox(x - 5, y - 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains8() {
      BoundingBox other = new BoundingBox(x + 5, y - 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContains9() {
      BoundingBox other = new BoundingBox(x + 15, y - 5, 0, 10, 10);

      assertTrue(underTest.contains(other));
   }

   @Test
   public void testContainsNo() {
      BoundingBox other = new BoundingBox(35, 35, 0, 10, 10);

      assertFalse(underTest.contains(other));
   }

   // x 10 width 20. Width is 10 to 29
   // y 10 height 20. height is 10 to 29
   //10,29   29,29
   //10,10   29,10
   @Test
   public void testNotContainsUp() {
      BoundingBox other = new BoundingBox(x, y + 20, 0, 10, 10);

      assertFalse(underTest.contains(other));
   }

   @Test
   public void testNotContainsDown() {
      BoundingBox other = new BoundingBox(x, y - 10, 0, 10, 10);

      assertFalse(underTest.contains(other));
   }

   @Test
   public void testNotContainsLeft() {
      BoundingBox other = new BoundingBox(x - 10, y, 0, 10, 10);

      assertFalse(underTest.contains(other));
   }

   @Test
   public void testNotContainsRight() {
      BoundingBox other = new BoundingBox(x + 20, y, 0, 10, 10);

      assertFalse(underTest.contains(other));
   }

   @Test
   public void testNotContainsLayer() {
      BoundingBox other = new BoundingBox(x + 15, y - 5, 1, 10, 10);

      assertFalse(underTest.contains(other));
   }

}
