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

/**
 * Title: DestinationAction
 *
 * <p>
 * Description: A ScriptAction that move the Actor from its current location to the goal location.</p>
 *
 * Copyright (c) Nov 16, 2023
 * @author Gary Deken
 * @version 0.12
 */
public class DestinationAction extends AbstractDestinationAction<Integer> {

   /**
    * This ScriptAction will move the Actor from its current location to the specified goal location.
    * @param goalX
    * @param goalY
    * @param speed
    */
   public DestinationAction(int goalX, int goalY, float speed) {
      goalXs.add(goalX);
      goalYs.add(goalY);
      this.speed = speed;
   }

   @Override
   public void addGoal(Integer x, Integer y) {
      if (x == null || y == null) {
         throw new NullPointerException("Both X and Y are required.");
      }
      goalXs.add(x);
      goalYs.add(y);
   }

   @Override
   protected int getNextX() {
      return goalXs.get(currentIndex);
   }

   @Override
   protected int getNextY() {
      return goalYs.get(currentIndex);
   }

}
