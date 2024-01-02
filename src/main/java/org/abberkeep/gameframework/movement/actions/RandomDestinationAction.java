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
package org.abberkeep.gameframework.movement.actions;

import java.util.function.Supplier;

/**
 * Title: RandomDestinationAction
 *
 * <p>
 * Description: A ScriptAction that move the Actor from its current location to the random goal location. The goal is
 * randomized each time this action is started. The goals can be a range, but passing in a Supplier<Integer>.</p>
 *
 * Copyright (c) Dec 13, 2023
 * @author Gary Deken
 * @version 0.14
 */
public class RandomDestinationAction extends AbstractDestinationAction<Supplier<Integer>> {

   /**
    * Creates a RandomDestinationAction with a given Supplier that would be used to set the goalX and goalY on setup.
    * This will set the goals each time this ScriptAction is restarted. If one of the two goal suppliers, X or Y, is
    * null, this will throw a NullPointerException.
    * @param supplerX
    * @param supplerY
    * @param speed
    */
   public RandomDestinationAction(Supplier<Integer> supplerX, Supplier<Integer> supplerY, float speed) {
      if (supplerX == null || supplerY == null) {
         throw new NullPointerException("Both supplerX and supplerY are required.");
      }
      goalXs.add(supplerX);
      goalYs.add(supplerY);
      this.speed = speed;
   }

   @Override
   public void addGoal(Supplier<Integer> x, Supplier<Integer> y) {
      if (x == null || y == null) {
         throw new NullPointerException("Both X and Y are required.");
      }
      goalXs.add(x);
      goalYs.add(y);
   }

   @Override
   protected int getNextX() {
      return goalXs.get(currentIndex).get();
   }

   @Override
   protected int getNextY() {
      return goalYs.get(currentIndex).get();
   }

}
