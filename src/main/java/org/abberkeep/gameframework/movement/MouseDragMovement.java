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

import com.badlogic.gdx.Gdx;
import org.abberkeep.gameframework.screen.ScreenInput;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: MouseDragMovement
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Sep 22, 2024
 * @author Gary Deken
 * @version
 */
public class MouseDragMovement extends BaseMovement {
   private boolean active = false;
   private boolean buttonActivated = false;
   private int buttonID;
   private int xClickOffSet = 0;
   private int yClickOffSet = 0;
   private int xUpdateLoc;
   private int yUpdateLoc;

   /**
    * Creates a MouseDragMovement that will move the Sprite with the Mouse cursor when the Mouse button is clicked on it
    * and held.
    * @param buttonID
    */
   public MouseDragMovement(int buttonID) {
      this.buttonID = buttonID;
      speed = 1;
   }

   /**
    * Creates a MouseDragMovement that must be "activated" by clicking on the sprite first, before it will move around
    * with the mouse.
    * @param buttonID
    * @param buttonActivated
    */
   public MouseDragMovement(int buttonID, boolean buttonActivated) {
      this.buttonID = buttonID;
      this.buttonActivated = buttonActivated;
      speed = 1;
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

   public void setButtonActivated(boolean buttonActivate) {
      this.buttonActivated = buttonActivate;
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
      xUpdateLoc = ScreenInput.getX();
      yUpdateLoc = ScreenInput.getY();
      // Need to check if in a state that the Actor should be moved.
      // first check if mouse is over the Actor.
      if (isOverActor(ScreenInput.getX(), ScreenInput.getY(), spriteUpdate)) {
         if (Gdx.input.isButtonJustPressed(buttonID)) {
            xClickOffSet = (int) spriteUpdate.getX() - ScreenInput.getX();
            yClickOffSet = (int) spriteUpdate.getY() - ScreenInput.getY();
            // If the button activation set, the Mouse click will activate or deactivate for moving.
            if (buttonActivated) {
               // Activate or deactivate
               active = !active;
            } else {
               active = true;
            }
         }
         // If Movement is not button activated, the mouse just needs to be pressed to move.
         if (!buttonActivated && active) {
            active = Gdx.input.isButtonPressed(buttonID);
         }
      }
      if (active) {
         // set update location for reverting back movement
         xUpdate = spriteUpdate.getX();
         yUpdate = spriteUpdate.getY();
         // Drag the Actor
         spriteUpdate.setLocation(xUpdateLoc + xClickOffSet, yUpdateLoc + yClickOffSet);
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

   private boolean isOverActor(int x, int y, SpriteUpdate spriteUpdate) {
      return spriteUpdate.contains(x, y);
   }
}
