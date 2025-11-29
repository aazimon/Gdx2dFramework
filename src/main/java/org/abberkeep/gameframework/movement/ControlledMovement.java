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

import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: ControlledMovement
 *
 * <p>
 * Description: This Movement is similar to the SingleMovement, but exposes a setter to the Direction, allowing another
 * process to control the Speed and Direction.</p>
 *
 * Copyright (c) Nov 14, 2025
 * @author Gary Deken
 * @version
 */
public class ControlledMovement extends BaseMovement {

   public ControlledMovement() {
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      // stop moving
      spriteUpdate.setLocation(spriteUpdate.getX() - xUpdate, spriteUpdate.getY() - yUpdate);
   }

   public void setDirection(float direction) {
      this.direction = direction;
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
      calculateMagnitudesByDirection(direction, speed);
      spriteUpdate.setLocation(spriteUpdate.getX() + xUpdate, spriteUpdate.getY() + yUpdate);
   }

}
