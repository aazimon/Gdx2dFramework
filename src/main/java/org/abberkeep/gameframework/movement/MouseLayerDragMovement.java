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

import org.abberkeep.gameframework.screen.ScreenInput;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: MouseLayerDragMovement
 *
 * <p>
 * Description: The MouseLayerDragMovement is like the MouseDragMovement, adding layer movement to it. The constructor
 * of the MouseLayerDragMovement will take the Direction Layer for the moving up or down a layer. Layer movement in this
 * Framework is done layer by layer, not as a constant movement.</p>
 *
 * Copyright (c) Feb 16, 2025
 * @author Gary Deken
 * @version 0.17
 */
public class MouseLayerDragMovement extends BaseMouseMovement {
   private int layerDirection;
   private boolean triggering = false;
   private float startX;
   private float startY;
   private boolean changingLayer = false;

   /**
    * This builds a Layer Movement class that is activated by a mouse button (Up or Down).
    * @param buttonID
    * @param direction
    */
   public MouseLayerDragMovement(int buttonID, Direction.LAYER direction) {
      super(buttonID);
      this.layerDirection = direction.getDirection();
   }

   /**
    * This builds a Layer Movement class that is activated by a mouse button (Up or Down).
    * @param buttonID
    * @param direction
    * @param buttonActivated
    */
   public MouseLayerDragMovement(int buttonID, Direction.LAYER direction, boolean buttonActivated) {
      super(buttonID);
      this.layerDirection = direction.getDirection();
      this.buttonActivated = buttonActivated;
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      changingLayer = false;
      if (triggering) {
         // reverting layer movement
         if (active) {
            // going from inactive to active
            spriteUpdate.setLayer(spriteUpdate.getLayer() - layerDirection);
            ScreenInput.inputLocks.remove(buttonID);
            active = false;
         } else if (buttonActivated) {
            // going from active to inactive
            spriteUpdate.setLayer(spriteUpdate.getLayer() + layerDirection);
            ScreenInput.inputLocks.cancelRemove(buttonID);
            active = true;
         } else {
            changingLayer = true;
         }
      }
      // revert single layer movement
      if (!active && !buttonActivated) {
         spriteUpdate.setX(startX);
         spriteUpdate.setY(startY);
      } else {
         spriteUpdate.setX(xUpdate);
         spriteUpdate.setY(yUpdate);
      }
      // check if mouse is no longer over sprite
      if (!isOverActor(xUpdateLoc, yUpdateLoc, spriteUpdate)) {
         active = false;
         xUpdate = 0;
         yUpdate = 0;
      }
   }

   public boolean isChangingLayer() {
      return changingLayer;
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
      xUpdateLoc = ScreenInput.getX();
      yUpdateLoc = ScreenInput.getY();
      triggering = false;
      changingLayer = false;
      // need to check if in a state that the Actor should move.
      // first check if mouse is over the Actor
      if (isOverActor(xUpdateLoc, yUpdateLoc, spriteUpdate)) {
         if (ScreenInput.isButtonJustPressed(buttonID, parent)) {
            int layer = spriteUpdate.getLayer();
            triggering = true;
            changingLayer = true;
            if (buttonActivated) {
               // if button activated, the mouse click will activate or deactivate for moving.
               active = !active;
               if (active) {
                  // activate
                  xClickOffSet = (int) spriteUpdate.getX() - xUpdateLoc;
                  yClickOffSet = (int) spriteUpdate.getY() - yUpdateLoc;
                  spriteUpdate.setLayer(layer + layerDirection);
                  ScreenInput.inputLocks.add(buttonID, parent);
               } else {
                  // deactivate
                  spriteUpdate.setLayer(layer - layerDirection);
                  ScreenInput.inputLocks.remove(buttonID);
               }
            } else {
               active = true;
               xClickOffSet = (int) spriteUpdate.getX() - xUpdateLoc;
               yClickOffSet = (int) spriteUpdate.getY() - yUpdateLoc;
               spriteUpdate.setLayer(layer + layerDirection);
               ScreenInput.inputLocks.add(buttonID, parent);
               startX = spriteUpdate.getX();
               startY = spriteUpdate.getY();
            }
         }
      }
      if (active && !buttonActivated) {
         active = ScreenInput.isButtonPressed(buttonID, parent);
         if (!active) {
            triggering = true;
            spriteUpdate.setLayer(spriteUpdate.getLayer() - layerDirection);
            changingLayer = true;
            ScreenInput.inputLocks.remove(buttonID);
         }
      }
      if (active || triggering) {
         // set update location for reverting back movement
         xUpdate = spriteUpdate.getX();
         yUpdate = spriteUpdate.getY();
         // drag the Actor
         spriteUpdate.setLocation(xUpdateLoc + xClickOffSet, yUpdateLoc + yClickOffSet);
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
