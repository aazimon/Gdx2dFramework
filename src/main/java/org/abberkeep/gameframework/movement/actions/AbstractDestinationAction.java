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

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: AbstractDestinationAction
 *
 * <p>
 * Description: A base ScriptAction for various DestinationActions. This has the base updateChild() that will move the
 * Actor to the goal location without going pass it. This allows for multiple goals to be set, and as each goal is
 * reached it will move to the next goal. Once all the goals have been reached, it will set to be "done".</p>
 *
 * Copyright (c) Dec 13, 2023
 * @author Gary Deken
 * @version 0.14
 * @param <T> Type for getting the next goal.
 */
public abstract class AbstractDestinationAction<T> extends ScriptAction {
   protected List<T> goalXs = new ArrayList<>();
   protected List<T> goalYs = new ArrayList<>();
   protected int currentIndex = 0;
   protected int goalX;
   protected int goalY;

   /**
    * Add a new goal to reach. If one of the two goals, X or Y, is null, this will throw a NullPointerException. Both X
    * and Y need to be defined for this ScriptAction to work properly.
    * @param x
    * @param y
    */
   public abstract void addGoal(T x, T y);

   @Override
   public void setup(float direction, float speed) {
      super.setup(direction, speed);
      currentIndex = 0;
      goalX = getNextX();
      goalY = getNextY();
   }

   @Override
   public void updateChild(float deltaTime, SpriteUpdate spriteUpdate) {
      float x = spriteUpdate.getX();
      float y = spriteUpdate.getY();

      direction = Direction.getDirection(x, y, goalX, goalY);
      calculateMagnitudesByDirection(direction, speed);

      boolean xPositive = goalX > x;
      boolean yPositive = goalY > y;
      if (x != goalX || goalY != y) {
         float nx = spriteUpdate.getX() + xUpdate;
         if (xPositive) {
            if (nx > goalX) {
               nx = goalX;
            }
         } else {
            if (nx < goalX) {
               nx = goalX;
            }
         }
         spriteUpdate.setX(nx);
         float ny = spriteUpdate.getY() + yUpdate;
         if (yPositive) {
            if (ny > goalY) {
               ny = goalY;
            }
         } else {
            if (ny < goalY) {
               ny = goalY;
            }
         }
         spriteUpdate.setY(ny);
      } else {
         calculateMagnitudesByDirection(direction, 0f);
      }
      if (spriteUpdate.getX() == goalX && spriteUpdate.getY() == goalY) {
         currentIndex++;
         if (currentIndex < goalXs.size()) {
            goalX = getNextX();
            goalY = getNextY();
         } else {
            done = true;
         }
      }
   }

   /**
    * This method should call the goalXs.get(currentIndex) to return the X goal.
    * @return
    */
   protected abstract int getNextX();

   /**
    * This method should call the goalYs.get(currentIndex) to return the Y goal.
    * @return
    */
   protected abstract int getNextY();

}
