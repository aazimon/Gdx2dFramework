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
public class BoundingBox2Test {
   private BoundingBox underTest;

   @Before
   public void setUp() {
      underTest = new BoundingBox(40, 40, 20, 20);
      underTest.setXInset(3);
      underTest.setYInset(3);
      underTest.setHeight(14);
      underTest.setWidth(14);
      //43,57   57,57
      //43,43   57,43
   }

   @Test
   public void testContainsNot1() {
      BoundingBox other = new BoundingBox(32, 40, 10, 10);

      assertFalse(other.contains(underTest));
   }

   @Test
   public void testContainsNot2() {
      BoundingBox other = new BoundingBox(58, 40, 10, 10);

      assertFalse(other.contains(underTest));
   }

   @Test
   public void testContainsNot3() {
      BoundingBox other = new BoundingBox(40, 32, 10, 10);

      assertFalse(other.contains(underTest));
   }

   @Test
   public void testContainsNot4() {
      BoundingBox other = new BoundingBox(40, 58, 10, 10);

      assertFalse(other.contains(underTest));
   }

   @Test
   public void testContains1() {
      BoundingBox other = new BoundingBox(34, 40, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains2() {
      BoundingBox other = new BoundingBox(56, 40, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains3() {
      BoundingBox other = new BoundingBox(40, 34, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains4() {
      BoundingBox other = new BoundingBox(40, 56, 10, 10);

      assertTrue(other.contains(underTest));
   }

}
