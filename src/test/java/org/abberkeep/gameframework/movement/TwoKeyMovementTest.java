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

import static org.junit.Assert.*;

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
 * Title: TwoKeyMovementTest</p>
 *
 * <p>
 * Description: This tests the methods of the TwoKeyMovementTest class.</p>
 *
 * Copyright: Copyright (c) Nov 5, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class TwoKeyMovementTest {
   private TwoKeyMovement underTest;
   private MockInput mockInput;
   private SpriteUpdate mockSpriteUpdate;
   private float xLoc = 10;
   private float yLoc = 10;

   @Before
   public void setUp() {
      underTest = new TwoKeyMovement(Input.Keys.RIGHT, Input.Keys.LEFT, 0.8f, true);
      mockInput = new MockInput();
      Gdx.input = mockInput;
      mockSpriteUpdate = new MockSpriteUpdate(20, 20);
      mockSpriteUpdate.setLocation(xLoc, yLoc);
   }

   @Test
   public void testHandleCollisionRight() {
      BoundingBox bb = new BoundingBox(10, 10, 0, 20, 20);
      underTest.xUpdate = 1f;
      mockSpriteUpdate.setX(xLoc + 1f);

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(1f, underTest.xUpdate, 0.0f);
      assertEquals(0.0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionLeft() {
      BoundingBox bb = new BoundingBox(10, 10, 0, 20, 20);
      underTest.xUpdate = -1f;
      mockSpriteUpdate.setX(xLoc - 1f);

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(-1f, underTest.xUpdate, 0.0f);
      assertEquals(0.0f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionUp() {
      BoundingBox bb = new BoundingBox(10, 10, 0, 20, 20);
      underTest.yUpdate = 1f;
      mockSpriteUpdate.setY(yLoc + 1f);

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testHandleCollisionDown() {
      BoundingBox bb = new BoundingBox(10, 10, 0, 20, 20);
      underTest.yUpdate = -1f;
      mockSpriteUpdate.setY(yLoc - 1f);

      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-1f, underTest.yUpdate, 0.0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateRight() {
      mockInput.setKeyPressed1(Input.Keys.RIGHT);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0.0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.EAST, underTest.direction, 0f);
      assertEquals(xLoc + 0.8f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateLeft() {
      mockInput.setKeyPressed1(Input.Keys.LEFT);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(-0.8f, underTest.xUpdate, 0.0f);
      assertEquals(0.0f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.WEST, underTest.direction, 0f);
      assertEquals(xLoc - 0.8f, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateUp() {
      underTest = new TwoKeyMovement(Input.Keys.UP, Input.Keys.DOWN, 0.8f, false);
      mockInput.setKeyPressed1(Input.Keys.UP);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.NORTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc + 0.8f, mockSpriteUpdate.getY(), 0.0f);
   }

   @Test
   public void testUpdateDown() {
      underTest = new TwoKeyMovement(Input.Keys.UP, Input.Keys.DOWN, 0.8f, false);
      mockInput.setKeyPressed1(Input.Keys.DOWN);

      underTest.update(20f, mockSpriteUpdate);

      assertEquals(0f, underTest.xUpdate, 0.0f);
      assertEquals(-0.8f, underTest.yUpdate, 0.0f);
      assertEquals(Direction.SOUTH, underTest.direction, 0f);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(yLoc - 0.8f, mockSpriteUpdate.getY(), 0.0f);
   }

}
