/*
 * Copyright (c) 2023 Gary Deken
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
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: SingleMotion
 *
 * <p>
 * Description: SingleMotion is a simple motion that has the same Animation for all directions of a Sprite.</p>
 *
 * Copyright (c) May 18, 2023
 * @author Gary Deken
 * @version 0.6
 */
public class SingleMotion extends BaseMotion {

   /**
    * Creates a SingleMotion with the given Animation.
    * @param animation
    */
   public SingleMotion(Animation animation) {
      animations = new Animation[1];
      animations[0] = animation;
   }

   /**
    * Draws the single Animation to the screen.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animations[0].draw(batch, x, y);
   }

   @Override
   public void setDirection(float direction) {
      // This does nothing, as there is no direction for this Motion.
   }

   /**
    * Updates the SingleMotion for the deltaTime and direction.
    * @param deltaTime
    * @param direction
    */
   @Override
   public void update(float deltaTime, float direction) {
      animations[0].update(deltaTime);
   }

}
