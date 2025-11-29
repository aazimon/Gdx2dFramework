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

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;
import org.abberkeep.gameframework.utils.FastMath;

/**
 * Title: GameStickMovement
 *
 * <p>
 * Description: Encapsulates getting the input from a sensitive game stick and determines the direct and the amount of
 * movement for the update. The speed is determined base on the amount the stick is movement in a given direct. This
 * uses the four cardinal directions (North, South, East and West).</p>
 *
 * Copyright (c) Nov 28, 2025
 * @author Gary Deken
 * @version 0.18
 */
public class GameStickMovement extends BaseMovement {
   private int axisHorizontalId = 0;
   private int axisVerticalId = 0;
   private Controller controller;
   private float maxSpeed;

   /**
    * Constructs a GameStickMovement, with the axis IDs and the masSpeed for the current Controller. The axis IDs are
    * used to move in that direction. The Game Stick can only move in a single direction.
    *
    * @param verticalAxisId
    * @param horizontalAxisId
    * @param maxSpeed
    */
   public GameStickMovement(int verticalAxisId, int horizontalAxisId, float maxSpeed) {
      this(verticalAxisId, horizontalAxisId, maxSpeed, Controllers.getCurrent());
   }

   /**
    * Constructs a GameStickMovement, with the axis IDs and the masSpeed for the Controller passed in. The axis IDs are
    * used to move in that direction. The Game Stick can only move in a single direction.
    *
    * @param verticalAxisId
    * @param horizontalAxisId
    * @param maxSpeed
    * @param controller
    */
   public GameStickMovement(int verticalAxisId, int horizontalAxisId, float maxSpeed, Controller controller) {
      axisVerticalId = verticalAxisId;
      axisHorizontalId = horizontalAxisId;
      this.maxSpeed = maxSpeed;
      this.controller = controller;
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      // determine which direct was the collision
      // check if reverting X update there is no collision
      spriteUpdate.setX(spriteUpdate.getX() - xUpdate);
      if (spriteUpdate.contains(other)) {
         // Still collision, so collided on Y axis. Set X back and revert Y update.
         spriteUpdate.setX(spriteUpdate.getX() + xUpdate);
         spriteUpdate.setY(spriteUpdate.getY() - yUpdate);
      }
      // otherwise collision is on the X axis, leave reverted.
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
      float yMove = -controller.getAxis(axisVerticalId);
      float xMove = controller.getAxis(axisHorizontalId);
      if (yMove != 0 && xMove != 0) {
         // calculate the x & y distance based on the direction and speed.
         float radians = FastMath.atan2Lookup(yMove, xMove);

         yUpdate = (float) (FastMath.fastSin(radians) * (maxSpeed * Math.abs(yMove)));
         xUpdate = (float) (FastMath.fastCos(radians) * (maxSpeed * Math.abs(xMove)));

         spriteUpdate.setLocation(spriteUpdate.getX() + xUpdate, spriteUpdate.getY() + yUpdate);
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
