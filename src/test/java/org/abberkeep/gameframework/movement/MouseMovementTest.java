/*
 * Copyright (c) 2022-2023 Gary Deken
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.MockSpriteUpdate;
import org.abberkeep.gameframework.sprite.SpriteUpdate;
import org.abberkeep.gameframework.utils.MockInput;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: MouseMovementTest</p>
 *
 * <p>
 * Description: This tests the methods of the MouseMovementTest class.</p>
 *
 * Copyright: Copyright (c) Nov 5, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class MouseMovementTest {
   private MouseMovement underTest;
   private MockInput mockInput;
   private SpriteUpdate mockSpriteUpdate;
   private float xLoc = 10;
   private float yLoc = 10;

   @Before
   public void setUp() {
      underTest = new MouseMovement(Input.Buttons.LEFT, 0.8f);
      mockInput = new MockInput();
      Gdx.input = mockInput;
      mockSpriteUpdate = new MockSpriteUpdate(20, 20);
      mockSpriteUpdate.setLocation(xLoc, yLoc);
   }

   @Test
   public void testHandleCollisionUp() {
      BoundingBox bb = new BoundingBox((int) xLoc, 30, 20, 20);
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setY(yLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionDown() {
      BoundingBox bb = new BoundingBox((int) xLoc, -10, 20, 20);
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionRight() {
      BoundingBox bb = new BoundingBox(31, (int) yLoc, 20, 20);
      underTest.xUpdate = 1f;
      mockSpriteUpdate.setX(xLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionLeft() {
      BoundingBox bb = new BoundingBox(-11, (int) yLoc, 20, 20);
      underTest.xUpdate = -1f;
      mockSpriteUpdate.setX(xLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionUpWithUpRight() {
      BoundingBox bb = new BoundingBox((int) xLoc, 30, 20, 20);
      underTest.xUpdate = 1f;
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setX(xLoc + 1f);
      mockSpriteUpdate.setY(yLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc + 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionUpWithUpLeft() {
      BoundingBox bb = new BoundingBox((int) xLoc, 30, 20, 20);
      underTest.xUpdate = -1f;
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setX(xLoc - 1f);
      mockSpriteUpdate.setY(yLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc - 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionDownWithDownRight() {
      BoundingBox bb = new BoundingBox((int) xLoc, -10, 20, 20);
      underTest.xUpdate = 1f;
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setX(xLoc + 1f);
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc + 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionDownWithDownLeft() {
      BoundingBox bb = new BoundingBox((int) xLoc, -10, 20, 20);
      underTest.xUpdate = -1f;
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setX(xLoc - 1f);
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc - 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionRightWithUpRight() {
      BoundingBox bb = new BoundingBox(31, (int) yLoc, 20, 20);
      underTest.xUpdate = 1f;
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setX(xLoc + 1f);
      mockSpriteUpdate.setY(yLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc + 1, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionRightWithDownRight() {
      BoundingBox bb = new BoundingBox(31, (int) yLoc, 20, 20);
      underTest.xUpdate = 1f;
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setX(xLoc + 1f);
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc - 1, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionLeftWithUpLeft() {
      BoundingBox bb = new BoundingBox(-11, (int) yLoc, 20, 20);
      underTest.xUpdate = -1f;
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setX(xLoc - 1f);
      mockSpriteUpdate.setY(yLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc + 1, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionLeftWithDownLeft() {
      BoundingBox bb = new BoundingBox(-11, (int) yLoc, 20, 20);
      underTest.xUpdate = -1f;
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setX(xLoc - 1f);
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc - 1, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionUpAtGoal() {
      BoundingBox bb = new BoundingBox((int) xLoc, 31, 20, 20);
      mockInput.setButtonPressed1(Input.Buttons.LEFT);
      mockInput.setX((int) xLoc);
      mockInput.setY((int) yLoc + 1);

      underTest.update(20f, mockSpriteUpdate);
      underTest.update(20f, mockSpriteUpdate);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(.8f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionDownAtGoal() {
      BoundingBox bb = new BoundingBox((int) xLoc, -10, 20, 20);
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setY(yLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionRightAtGoal() {
      BoundingBox bb = new BoundingBox(31, (int) yLoc, 20, 20);
      underTest.xUpdate = 1f;
      mockSpriteUpdate.setX(xLoc + 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionLeftAtGoal() {
      BoundingBox bb = new BoundingBox(-11, (int) yLoc, 20, 20);
      underTest.xUpdate = -1f;
      mockSpriteUpdate.setX(xLoc - 1f);

      assertTrue(mockSpriteUpdate.contains(bb));

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateUp() {
      mockInput.setButtonPressed1(Input.Buttons.LEFT);
      mockInput.setX((int) xLoc);
      mockInput.setY((int) yLoc + 1);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.NORTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc + 0.8f, mockSpriteUpdate.getY(), 0.0f);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.NORTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc + 1f, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateDown() {
      mockInput.setButtonPressed1(Input.Buttons.LEFT);
      mockInput.setX((int) xLoc);
      mockInput.setY((int) yLoc - 1);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.SOUTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc - 0.8f, mockSpriteUpdate.getY(), 0.0f);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.SOUTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc - 1f, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateRight() {
      mockInput.setButtonPressed1(Input.Buttons.LEFT);
      mockInput.setX((int) xLoc + 1);
      mockInput.setY((int) yLoc);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.EAST, underTest.direction, 0f);
      assertEquals(xLoc + 0.8f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0.0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.EAST, underTest.direction, 0f);
      assertEquals(xLoc + 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateLeft() {
      mockInput.setButtonPressed1(Input.Buttons.LEFT);
      mockInput.setX((int) xLoc - 1);
      mockInput.setY((int) yLoc);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(-0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.WEST, underTest.direction, 0f);
      assertEquals(xLoc - .8f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(-0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.WEST, underTest.direction, 0f);
      assertEquals(xLoc - 1f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

}
