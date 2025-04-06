/*
 * Copyright (c) 2022-2024 Gary Deken
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

import org.abberkeep.gameframework.screen.ScreenInput;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: MouseDragMovement
 *
 * <p>
 * Description: This Movement will "drag" a Sprite with the mouse cursor. It has in option to drag the sprite with
 * pressing the mouse button, or by clicking to trigger the dragging and then clicking to turn off the trigger.</p>
 *
 * Copyright (c) Sep 22, 2024
 * @author Gary Deken
 * @version 0.16
 */
public class MouseDragMovement extends BaseMouseMovement {

   /**
    * Creates a MouseDragMovement that will move the Sprite with the Mouse cursor when the Mouse button is clicked on it
    * and held.
    * @param buttonID
    */
   public MouseDragMovement(int buttonID) {
      super(buttonID);
   }

   /**
    * Creates a MouseDragMovement that must be "activated" by clicking on the sprite first, before it will move around
    * with the mouse.
    * @param buttonID
    * @param buttonActivated
    */
   public MouseDragMovement(int buttonID, boolean buttonActivated) {
      super(buttonID);
      this.buttonActivated = buttonActivated;
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      // revert movement
      spriteUpdate.setLocation(xUpdate, yUpdate);
      // check if Mouse no longer over Sprite
      if (!isOverActor(xUpdateLoc, yUpdateLoc, spriteUpdate) && !buttonActivated) {
         active = false;
         xUpdate = 0;
         yUpdate = 0;
      }
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
      xUpdateLoc = ScreenInput.getX();
      yUpdateLoc = ScreenInput.getY();
      // Need to check if in a state that the Actor should be moved.
      // first check if mouse is over the Actor.
      if (isOverActor(ScreenInput.getX(), ScreenInput.getY(), spriteUpdate)) {
         // if just clicked to set state.
         if (ScreenInput.isButtonJustPressed(buttonID, parent)) {
            xClickOffSet = (int) spriteUpdate.getX() - ScreenInput.getX();
            yClickOffSet = (int) spriteUpdate.getY() - ScreenInput.getY();
            // check for button activated.
            if (buttonActivated) {
               // the Mouse click will either activate or deactivate for moving.
               active = !active;
               if (active) {
                  ScreenInput.inputLocks.add(buttonID, parent);
               } else {
                  ScreenInput.inputLocks.remove(buttonID);
                  // set update location for reverting back movement
                  xUpdate = spriteUpdate.getX();
                  yUpdate = spriteUpdate.getY();
               }
            } else {
               active = true;
            }
         }
         // If Movement is not button activated, the mouse just needs to be pressed to move.
         if (!buttonActivated && active) {
            active = ScreenInput.isButtonPressed(buttonID, parent);
         }
      }
      if (active) {
         // set update location for reverting back movement
         xUpdate = spriteUpdate.getX();
         yUpdate = spriteUpdate.getY();
         // Drag the Actor
         spriteUpdate.setLocation(xUpdateLoc + xClickOffSet, yUpdateLoc + yClickOffSet);
      } else if (!buttonActivated) {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
