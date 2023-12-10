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

import org.abberkeep.gameframework.movement.actions.ChangeSpeedAction;
import org.abberkeep.gameframework.movement.actions.DestinationAction;
import org.abberkeep.gameframework.movement.actions.EasingAction;
import org.abberkeep.gameframework.movement.actions.GoToAction;
import org.abberkeep.gameframework.movement.actions.MoveAction;
import org.abberkeep.gameframework.movement.actions.TimeMoveAction;
import org.abberkeep.gameframework.movement.actions.WaitAction;
import org.abberkeep.gameframework.sprite.MockSpriteUpdate;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: ScriptMovementTest</p>
 *
 * <p>
 * Description: This tests the methods of the ScriptMovementTest class.</p>
 *
 * Copyright: Copyright (c) Nov 16, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class ScriptMovementTest {
   private ScriptMovement underTest;
   private MockSpriteUpdate spriteUpdate;

   @Before
   public void setup() {
      spriteUpdate = new MockSpriteUpdate(10, 10);
      spriteUpdate.setLocation(20, 20);
   }

   @Test
   public void testChangeSpeedAction() {
      ChangeSpeedAction action = new ChangeSpeedAction(4f, 2f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertEquals(4f, action.getSpeed(), 0.01f);
      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
   }

   @Test
   public void testChangeSpeedActionDirection() {
      ChangeSpeedAction action = new ChangeSpeedAction(4f, 45f, 2f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertEquals(4f, action.getSpeed(), 0.01f);
      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
   }

   @Test
   public void testChangeSpeedActionNegative() {
      ChangeSpeedAction action = new ChangeSpeedAction(1f, 2f);
      underTest = new ScriptMovement(action);
      underTest.setSpeed(5f);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertEquals(1f, action.getSpeed(), 0.01f);
      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
   }

   @Test
   public void testDestinationAction() {
      DestinationAction action = new DestinationAction(17, 17, 1f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);

      assertTrue(action.isDone());
      assertTrue(underTest.isDone());

   }

   @Test
   public void testDestinationAction2() {
      DestinationAction action = new DestinationAction(15, 12, 1f, true);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      assertEquals(19.549, spriteUpdate.getX(), 0.001f);
      assertEquals(19.108, spriteUpdate.getY(), 0.001f);
      underTest.update(.2f, spriteUpdate);
      assertEquals(19.087, spriteUpdate.getX(), 0.001f);
      assertEquals(18.22, spriteUpdate.getY(), 0.001f);
      underTest.update(.2f, spriteUpdate);
      assertEquals(18.616, spriteUpdate.getX(), 0.001f);
      assertEquals(17.339, spriteUpdate.getY(), 0.001f);
      underTest.update(.2f, spriteUpdate);
      assertEquals(18.13, spriteUpdate.getX(), 0.001f);
      assertEquals(16.464, spriteUpdate.getY(), 0.001f);
      underTest.update(.2f, spriteUpdate);
      assertEquals(17.63, spriteUpdate.getX(), 0.001f);
      assertEquals(15.598, spriteUpdate.getY(), 0.001f);
   }

   @Test
   public void testDestinationTimeMoveActions() {
      DestinationAction action = new DestinationAction(40, 40, 1f);
      TimeMoveAction action2 = new TimeMoveAction(Direction.NORTH_EAST, 1f, 2f);
      MockSpriteUpdate spriteUpdate2 = new MockSpriteUpdate(10, 10);
      spriteUpdate2.setLocation(20, 20);
      ScriptMovement underTest2 = new ScriptMovement(action2);
      underTest = new ScriptMovement(action);

      assertEquals(spriteUpdate.getX(), spriteUpdate2.getX(), 0f);
      assertEquals(spriteUpdate.getY(), spriteUpdate2.getY(), 0f);

      underTest.update(.2f, spriteUpdate);
      underTest2.update(.2f, spriteUpdate2);
      assertEquals(spriteUpdate.getX(), spriteUpdate2.getX(), 0f);
      assertEquals(spriteUpdate.getY(), spriteUpdate2.getY(), 0f);
      underTest.update(.2f, spriteUpdate);
      underTest2.update(.2f, spriteUpdate2);
      assertEquals(spriteUpdate.getX(), spriteUpdate2.getX(), 0f);
      assertEquals(spriteUpdate.getY(), spriteUpdate2.getY(), 0f);
      underTest.update(.2f, spriteUpdate);
      underTest2.update(.2f, spriteUpdate2);
      assertEquals(spriteUpdate.getX(), spriteUpdate2.getX(), 0f);
      assertEquals(spriteUpdate.getY(), spriteUpdate2.getY(), 0f);
      underTest.update(.2f, spriteUpdate);
      underTest2.update(.2f, spriteUpdate2);
      assertEquals(spriteUpdate.getX(), spriteUpdate2.getX(), 0f);
      assertEquals(spriteUpdate.getY(), spriteUpdate2.getY(), 0f);

//      assertTrue(action.isDone());
//      assertTrue(underTest.isDone());
   }

   @Test
   public void testEasingTimeActionIn() {
      EasingAction action = new EasingAction(2f, 0f, 2f, EasingAction.EASING_POWER.BI);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
      assertEquals(2f, action.getSpeed(), 0.001f);
   }

   @Test
   public void testEasingTimeActionOut() {
      EasingAction action = new EasingAction(2f, EasingAction.EASING_POWER.BI);
      underTest = new ScriptMovement(action);
      underTest.setSpeed(2f);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
      assertEquals(0f, action.getSpeed(), 0.01f);
   }

   @Test
   public void testGoToAction() {
      TimeMoveAction action = new TimeMoveAction(Direction.EAST, .8f, 1f);
      underTest = new ScriptMovement(action);
      GoToAction action1 = new GoToAction(underTest, 0);
      underTest.addAction(action1);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      assertTrue(action.isDone());
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      assertTrue(action.isDone());
      underTest.update(.2f, spriteUpdate);

      assertFalse(underTest.isDone());
   }

   @Test
   public void testGoToActionRepeat() {
      TimeMoveAction action = new TimeMoveAction(Direction.EAST, .8f, 1f);
      underTest = new ScriptMovement(action);
      GoToAction action1 = new GoToAction(underTest, 0, 1);
      underTest.addAction(action1);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      assertTrue(action.isDone());
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      assertTrue(action.isDone());
      underTest.update(.2f, spriteUpdate);

      assertTrue(underTest.isDone());
   }

   @Test
   public void testMoveAction() {
      MoveAction action = new MoveAction(90f, 1f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds
      underTest.update(.2f, spriteUpdate);

      assertFalse(action.isDone());
      assertFalse(underTest.isDone());
      assertEquals(1f, action.getSpeed(), 0.0f);
   }

   @Test
   public void testTimeMoveAction() {
      TimeMoveAction action = new TimeMoveAction(180f, 1f, 2f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
      assertEquals(1f, action.getSpeed(), 0.0f);
   }

   @Test
   public void testWaitAction() {
      WaitAction action = new WaitAction(2f);
      underTest = new ScriptMovement(action);

      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds

      assertTrue(action.isDone());
      assertTrue(underTest.isDone());
      assertEquals(0f, action.getSpeed(), 0.0f);
   }

   @Test
   public void testScript() {
      EasingAction action1 = new EasingAction(2f, 180f, 2f, EasingAction.EASING_POWER.BI);
      TimeMoveAction action2 = new TimeMoveAction(180f, 1f, 2f);
      WaitAction action3 = new WaitAction(2f);
      DestinationAction action4 = new DestinationAction(17, 17, 3f);
      EasingAction action5 = new EasingAction(2f, EasingAction.EASING_POWER.BI);
      underTest = new ScriptMovement(action1);
      underTest.addAction(action2);
      underTest.addAction(action3);
      underTest.addAction(action4);
      underTest.addAction(action5);

      // ease in
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds
      assertTrue(action1.isDone());
      assertEquals(2f, action1.getSpeed(), 0.001f);

      // time move
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds
      assertTrue(action2.isDone());
      assertEquals(1f, action2.getSpeed(), 0.001f);

      // wait
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds
      assertTrue(action3.isDone());
      assertEquals(0f, action3.getSpeed(), 0.001f);

      // destination
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      assertTrue(action4.isDone());
      assertEquals(3f, action4.getSpeed(), 0.001f);

      // ease out
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 1 second
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      underTest.update(.2f, spriteUpdate);
      // 2 seconds
      assertTrue(action5.isDone());
      assertEquals(0f, action5.getSpeed(), 0.001f);
      // done
      assertTrue(underTest.isDone());
   }

   @Test
   public void testChangeInDirectionBelow180() {
      TestAction action = new TestAction(23f, 2f, 2f, true);

      action.setup(95f, 2f);
      assertEquals(87.8f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(80.6f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(73.4f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(66.2f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(59.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(51.8f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(44.6f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(37.4f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(30.2f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(23.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionAbove180() {
      TestAction action = new TestAction(275f, 2f, 2f, true);

      action.setup(195f, 2f);
      assertEquals(203.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(211.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(219.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(227.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(235.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(243.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(251.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(259.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(267.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(275.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionAbove90() {
      TestAction action = new TestAction(230f, 2f, 2f, true);

      action.setup(95f, 2f);
      assertEquals(108.5f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(122.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(135.5f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(149.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(162.5f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(176.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(189.5f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(203.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(216.5f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(230.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionLess90() {
      TestAction action = new TestAction(292f, 2f, 2f, true);

      action.setup(75f, 2f);
      assertEquals(60.7f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(46.4f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(32.1f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(17.8f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(3.5f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(349.2f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(334.9f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(320.6f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(306.3f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(292.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionLess902() {
      TestAction action = new TestAction(75f, 2f, 2f, true);

      action.setup(292f, 2f);
      assertEquals(306.3f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(320.6f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(334.9f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(349.2f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(3.5f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(17.8f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(32.1f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(46.4f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(60.7f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(75.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionGreater() {
      TestAction action = new TestAction(260f, 2f, 2f, true);

      action.setup(10f, 2f);
      assertEquals(359.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(348.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(337.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(326.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(315.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(304.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(293.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(282.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(271.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(260.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionGreater2() {
      TestAction action = new TestAction(0f, 2f, 2f, true);

      action.setup(270f, 2f);
      assertEquals(279.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(288.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(297.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(306.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(315.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(324.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(333.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(342.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(351.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(360.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionGreater3() {
      TestAction action = new TestAction(10f, 2f, 2f, true);

      action.setup(200f, 2f);
      // 190 to 10 = -90
      // 180 to 10 = -85
      // 200 tp 10 = -95
      assertEquals(217.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(234.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(251.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(268.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(285.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(302.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(319.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(336.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(353.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(10.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   @Test
   public void testChangeInDirectionGreater4() {
      TestAction action = new TestAction(200f, 2f, 2f, true);

      action.setup(10f, 2f);
      // 180 to 10 = -85
      // 190 to 10 = -90
      // 200 tp 10 = -95
      assertEquals(353.0f, action.getUpdatedDirection(.2f), 0f);
      assertEquals(336.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(319.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(302.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(285.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 1 second
      assertEquals(268.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(251.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(234.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(217.0f, action.getUpdatedDirection(.2f), 0.001f);
      assertEquals(200.0f, action.getUpdatedDirection(.2f), 0.001f);
      // 2 seconds
   }

   private class TestAction extends TimeMoveAction {
      public TestAction(float direction, float speed, float time) {
         super(direction, speed, time);
      }

      public TestAction(float direction, float speed, float time, boolean changeGradually) {
         super(direction, speed, time, changeGradually);
      }

      public float getUpdatedDirection(float deltaTime) {
         return super.getUpdatedDirection(deltaTime);
      }

   }

}
