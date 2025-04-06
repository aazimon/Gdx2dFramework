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

import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: BaseMouseMovement
 *
 * <p>
 * Description: The BaseMouseMovement has common attributes related to Mouse movements, including the button ID, if the
 * Movement is button activated, the movement is "active", the user is clicking the button, and X and Y click offsets to
 * keep the Sprite in line with the mouse cursor. This includes a method to determine if mouse click is on the Sprite,
 * and setting Button Activated.</p>
 *
 * Copyright (c) Feb 28, 2025
 * @author Gary Deken
 * @version 0.17
 */
public abstract class BaseMouseMovement extends BaseMovement {
   protected boolean active = false;
   protected boolean buttonActivated = false;
   protected int buttonID;
   protected int xClickOffSet = 0;
   protected int yClickOffSet = 0;
   protected int xUpdateLoc;
   protected int yUpdateLoc;

   /**
    * Create the MouseMovement for the specified Button ID. The speed is set to 1 by default, to indicate the Movement
    * is moving.
    * @param buttonID
    */
   public BaseMouseMovement(int buttonID) {
      this.buttonID = buttonID;
      speed = 1;
   }

   /**
    * Set the MouseMovement as being button activated or not to move the sprite.
    * @param buttonActivate
    */
   public void setButtonActivated(boolean buttonActivate) {
      this.buttonActivated = buttonActivate;
   }

   /**
    * Checks if the X and Y locations are over/on the Sprite.
    * @param x
    * @param y
    * @param spriteUpdate
    * @return boolean
    */
   protected boolean isOverActor(int x, int y, SpriteUpdate spriteUpdate) {
      return spriteUpdate.contains(x, y, spriteUpdate.getLayer());
   }

}
