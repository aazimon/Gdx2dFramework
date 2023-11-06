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
package org.abberkeep.gameframework.movement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: DirectionTest</p>
 *
 * <p>
 * Description: This tests the methods of the DirectionTest class.</p>
 *
 * Copyright: Copyright (c) May 14, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class DirectionTest {

   public DirectionTest() {
   }

   @Before
   public void setUp() {
   }

   @Test
   public void testGetDirection() {
      int x = 100;
      int y = 100;

      float actual = Direction.getDirection(x, y, x + 100, y);
      assertEquals(Direction.EAST, actual, 0.0);
      actual = Direction.getDirection(x, y, x - 100, y);
      assertEquals(Direction.WEST, actual, 0.0);
      actual = Direction.getDirection(x, y, x, y + 100);
      assertEquals(Direction.NORTH, actual, 0.0);
      actual = Direction.getDirection(x, y, x, y - 100);
      assertEquals(Direction.SOUTH, actual, 0.0);
      actual = Direction.getDirection(x, y, x + 100, y + 100);
      assertEquals(Direction.NORTH_EAST, actual, 0.0);
      actual = Direction.getDirection(x, y, x + 100, y - 100);
      assertEquals(Direction.SOUTH_EAST, actual, 0.0);
      actual = Direction.getDirection(x, y, x - 100, y + 100);
      assertEquals(Direction.NORTH_WEST, actual, 0.0);
      actual = Direction.getDirection(x, y, x - 100, y - 100);
      assertEquals(Direction.SOUTH_WEST, actual, 0.0);

   }

   @Test
   public void testNearest4thDegree() {
      assertEquals(Direction.EAST, Direction.nearest4thDirection(-15), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(0), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(15), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(30), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(45), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(60), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(75), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(90), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(105), 0);
      assertEquals(Direction.NORTH, Direction.nearest4thDirection(120), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(135), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(150), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(165), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(180), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(195), 0);
      assertEquals(Direction.WEST, Direction.nearest4thDirection(210), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(225), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(240), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(255), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(270), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(285), 0);
      assertEquals(Direction.SOUTH, Direction.nearest4thDirection(300), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(315), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(330), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(345), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(360), 0);
      assertEquals(Direction.EAST, Direction.nearest4thDirection(375), 0);
   }

   @Test
   public void testNearest8thDegree() {
      assertEquals(Direction.EAST, Direction.nearest8thDirection(-15), 0);
      assertEquals(Direction.EAST, Direction.nearest8thDirection(0), 0);
      assertEquals(Direction.EAST, Direction.nearest8thDirection(15), 0);
      assertEquals(Direction.NORTH_EAST, Direction.nearest8thDirection(30), 0);
      assertEquals(Direction.NORTH_EAST, Direction.nearest8thDirection(45), 0);
      assertEquals(Direction.NORTH_EAST, Direction.nearest8thDirection(60), 0);
      assertEquals(Direction.NORTH, Direction.nearest8thDirection(75), 0);
      assertEquals(Direction.NORTH, Direction.nearest8thDirection(90), 0);
      assertEquals(Direction.NORTH, Direction.nearest8thDirection(105), 0);
      assertEquals(Direction.NORTH_WEST, Direction.nearest8thDirection(120), 0);
      assertEquals(Direction.NORTH_WEST, Direction.nearest8thDirection(135), 0);
      assertEquals(Direction.NORTH_WEST, Direction.nearest8thDirection(150), 0);
      assertEquals(Direction.WEST, Direction.nearest8thDirection(165), 0);
      assertEquals(Direction.WEST, Direction.nearest8thDirection(180), 0);
      assertEquals(Direction.WEST, Direction.nearest8thDirection(195), 0);
      assertEquals(Direction.SOUTH_WEST, Direction.nearest8thDirection(210), 0);
      assertEquals(Direction.SOUTH_WEST, Direction.nearest8thDirection(225), 0);
      assertEquals(Direction.SOUTH_WEST, Direction.nearest8thDirection(240), 0);
      assertEquals(Direction.SOUTH, Direction.nearest8thDirection(255), 0);
      assertEquals(Direction.SOUTH, Direction.nearest8thDirection(270), 0);
      assertEquals(Direction.SOUTH, Direction.nearest8thDirection(285), 0);
      assertEquals(Direction.SOUTH_EAST, Direction.nearest8thDirection(300), 0);
      assertEquals(Direction.SOUTH_EAST, Direction.nearest8thDirection(315), 0);
      assertEquals(Direction.SOUTH_EAST, Direction.nearest8thDirection(330), 0);
      assertEquals(Direction.EAST, Direction.nearest8thDirection(345), 0);
      assertEquals(Direction.EAST, Direction.nearest8thDirection(360), 0);
      assertEquals(Direction.EAST, Direction.nearest8thDirection(375), 0);
   }

}
