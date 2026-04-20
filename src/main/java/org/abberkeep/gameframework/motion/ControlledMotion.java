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
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: ControlledMotion
 *
 * <p>
 * Description: This Motion is similar to the SingleMotion, but exposes a setter for the current index of the Animation
 * to use, allowing another process to control which Animation is updated and rendered..</p>
 *
 * Copyright (c) Dec 12, 2025
 * @author Gary Deken
 * @version 0.19
 */
public class ControlledMotion extends BaseMotion {

   public ControlledMotion(Animation... animations) {
      this.animations = animations;
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animations[currentIndex].draw(batch, x, y);
   }

   /**
    * Set the index of the Animation array passed in the constructor, that will be updated and rendered.
    * @param currentIndex
    */
   public void setCurrentIndex(int currentIndex) {
      this.currentIndex = currentIndex;
   }

   /**
    * The ControlledMotion does not set the Animation to used based on the direction. This method does not do anything.
    * @param direction
    */
   @Override
   public void setDirection(float direction) {
      // Does nothing.
   }

   /**
    * The ControlledMotion does not use the direction parameter, instead using the currentIndex set via the
    * setCurrentIndex method.
    * @param deltaTime
    * @param direction
    */
   @Override
   public void update(float deltaTime, float direction) {
      animations[currentIndex].update(deltaTime);
   }

}
