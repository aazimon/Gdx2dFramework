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

/**
 * Title: GamePadMovement
 *
 * <p>
 * Description: Encapsulates getting the input from a four directional GamePad and determines the direction and the
 * amount of movement for the update. This uses the four cardinal directions (North, South, East and West).</p>
 *
 * Copyright (c) Nov 27, 2025
 * @author Gary Deken
 * @version 0.18
 */
public class GamePadMovement extends BaseMovement {
   private int[] buttonIds = new int[4];
   private Controller controller;

   /**
    * Constructs a GamePadMovement, with the button IDs and the speed for the current Controller. The button IDs are
    * used to move in that direction. The GamePad allows pressing two non-conflicting buttons at the same time to get a
    * direction.
    *
    * @param buttonUpId
    * @param buttonDownId
    * @param buttonRightId
    * @param buttonLeftId
    * @param speed
    */
   public GamePadMovement(int buttonUpId, int buttonDownId, int buttonRightId, int buttonLeftId, float speed) {
      this(buttonUpId, buttonDownId, buttonRightId, buttonLeftId, speed, Controllers.getCurrent());
   }

   /**
    * Constructs a GamePadMovement, with the button IDs, the speed and the controller passed in. The button IDs are used
    * to move in that direction. The GamePad allows pressing two non-conflicting buttons at the same time to get a
    * direction.
    *
    * @param buttonUpId
    * @param buttonDownId
    * @param buttonRightId
    * @param buttonLeftId
    * @param speed
    * @param controller
    */
   public GamePadMovement(int buttonUpId, int buttonDownId, int buttonRightId, int buttonLeftId, float speed,
      Controller controller) {
      buttonIds[0] = buttonUpId;
      buttonIds[1] = buttonDownId;
      buttonIds[2] = buttonRightId;
      buttonIds[3] = buttonLeftId;
      this.speed = speed;
      this.controller = controller;
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      // determine which direction was the collision
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
      updateDirection();
      spriteUpdate.setLocation(spriteUpdate.getX() + xUpdate, spriteUpdate.getY() + yUpdate);
   }

   private void updateDirection() {
      if (controller.getButton(buttonIds[0])
         && controller.getButton(buttonIds[2])) {
         calculateMagnitudesByDirection(Direction.NORTH_EAST, speed);
      } else if (controller.getButton(buttonIds[0]) && controller.getButton(buttonIds[3])) {
         calculateMagnitudesByDirection(Direction.NORTH_WEST, speed);
      } else if (controller.getButton(buttonIds[0])) {
         yUpdate = speed;
         xUpdate = 0;
         direction = Direction.NORTH;
      } else if (controller.getButton(buttonIds[1]) && controller.getButton(buttonIds[2])) {
         calculateMagnitudesByDirection(Direction.SOUTH_EAST, speed);
      } else if (controller.getButton(buttonIds[1]) && controller.getButton(buttonIds[3])) {
         calculateMagnitudesByDirection(Direction.SOUTH_WEST, speed);
      } else if (controller.getButton(buttonIds[1])) {
         yUpdate = -speed;
         xUpdate = 0;
         direction = Direction.SOUTH;
      } else if (controller.getButton(buttonIds[2])) {
         xUpdate = speed;
         yUpdate = 0;
         direction = Direction.EAST;
      } else if (controller.getButton(buttonIds[3])) {
         xUpdate = -speed;
         yUpdate = 0;
         direction = Direction.WEST;
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
