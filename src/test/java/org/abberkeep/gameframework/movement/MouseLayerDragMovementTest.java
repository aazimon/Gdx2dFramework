/*
 * Copyright (c) 2022-2025 Gary Deken
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.abberkeep.gameframework.screen.ScreenInput;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.MockSpriteUpdate;
import org.abberkeep.gameframework.sprite.SpriteUpdate;
import org.abberkeep.gameframework.utils.MockInput;
import org.abberkeep.gameframework.utils.MockSprite;
import org.abberkeep.gameframework.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: MouseLayerDragMovementTest</p>
 *
 * <p>
 * Description: This tests the methods of the MouseLayerDragMovementTest class.</p>
 *
 * Copyright: Copyright (c) Feb 28, 2025
 *
 * @author Gary Deken
 * @version 1.0
 */
public class MouseLayerDragMovementTest {
   private MouseLayerDragMovement underTest;
   private MockInput mockInput;
   private SpriteUpdate mockSpriteUpdate;
   private float xLoc = 10;
   private float yLoc = 10;
   private int clickX = 25;
   private int clickY = 25;

   @Before
   public void setUp() {
      underTest = new MouseLayerDragMovement(Input.Buttons.LEFT, Direction.LAYER.UP);
      underTest.setParent(new MockSprite(20, 20));
      mockInput = new MockInput();
      Gdx.input = mockInput;
      mockSpriteUpdate = new MockSpriteUpdate(20, 20);
      mockSpriteUpdate.setLocation(xLoc, yLoc);
      ScreenInput.inputLocks.removeAll();
      ScreenInput.inputLocks.clear();
   }

   @Test
   public void testHandleCollision() {
   }

   @Test
   public void testButtonActivated() {
      underTest = new MouseLayerDragMovement(Input.Buttons.LEFT, Direction.LAYER.UP, true);
      underTest.setParent(new MockSprite(20, 20));
      BoundingBox bb = new BoundingBox((int) xLoc, 30, 0, 20, 20);

      runJustClicked(clickX, clickY, bb);

      assertTrue(ScreenInput.inputLocks.isLocked(Input.Buttons.LEFT));
      assertTrue(ScreenInput.inputLocks.isLockedOn(Input.Buttons.LEFT, underTest.parent));
      assertEquals(1, mockSpriteUpdate.getLayer());

      mockInput.setY(clickY - 1);
      underTest.update(.02f, mockSpriteUpdate);
      assertEquals(1, mockSpriteUpdate.getLayer());

      runJustClicked(clickX, clickY, bb);
      ScreenInput.inputLocks.clear();

      assertFalse(ScreenInput.inputLocks.isLocked(Input.Buttons.LEFT));
      assertFalse(ScreenInput.inputLocks.isLockedOn(Input.Buttons.LEFT, underTest.parent));
      assertEquals(0, mockSpriteUpdate.getLayer());
   }

   @Test
   public void testButtonActivatedCollision() {
      underTest = new MouseLayerDragMovement(Input.Buttons.LEFT, Direction.LAYER.UP, true);
      underTest.setParent(new MockSprite(20, 20));
      BoundingBox bb = new BoundingBox((int) xLoc, -10, 1, 20, 20);

      runJustClicked(clickX, clickY, bb);

      assertTrue(ScreenInput.inputLocks.isLocked(Input.Buttons.LEFT));
      assertTrue(ScreenInput.inputLocks.isLockedOn(Input.Buttons.LEFT, underTest.parent));
      assertEquals(1, mockSpriteUpdate.getLayer());

      mockInput.setY(clickY - 1);
      underTest.update(.02f, mockSpriteUpdate);
      assertEquals(1, mockSpriteUpdate.getLayer());
      assertTrue(mockSpriteUpdate.contains(bb));
      mockInput.setJustPressed(true);
      mockInput.setX(clickX);
      mockInput.setY(clickY);
      underTest.update(.02f, mockSpriteUpdate);
      assertEquals(0, mockSpriteUpdate.getLayer());
      mockInput.setJustPressed(false);
      assertFalse(mockSpriteUpdate.contains(bb));
      underTest.handleCollision(mockSpriteUpdate, bb);

      assertEquals(10f, underTest.xUpdate, 0.0f);
      assertEquals(9f, underTest.yUpdate, 0.0f);
      int xClick = (int) TestUtils.getObject(underTest, "xClickOffSet");
      int yClick = (int) TestUtils.getObject(underTest, "yClickOffSet");
      assertEquals(-15, xClick);
      assertEquals(-15, yClick);
      assertEquals(xLoc, mockSpriteUpdate.getX(), 0.0f);
      assertEquals(9f, mockSpriteUpdate.getY(), 0.0f);
   }

   private void runJustClicked(int clickX, int clickY, BoundingBox bb) {
      mockInput.setJustPressed(true);
      mockInput.setX(clickX);
      mockInput.setY(clickY);
      underTest.update(.02f, mockSpriteUpdate);
      mockInput.setJustPressed(false);
      assertFalse(mockSpriteUpdate.contains(bb));
   }

}
