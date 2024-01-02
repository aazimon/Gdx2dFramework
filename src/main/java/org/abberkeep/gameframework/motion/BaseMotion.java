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
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.effects.ColorEffect;

/**
 * Title: BaseMotion
 *
 * <p>
 * Description: BaseMotion holds all attributes that are common to all Motions.</p>
 *
 * Copyright (c) Dec 31, 2023
 * @author Gary Deken
 * @version 0.14
 */
public abstract class BaseMotion implements Motion {
   protected Animation[] animations;
   protected int currentIndex = 0;

   @Override
   public Animation getAnimation(int index) {
      if (index < 0 || index > animations.length) {
         return null;
      }
      return animations[index];
   }

   @Override
   public int getHeight() {
      return animations[currentIndex].getHeight();
   }

   @Override
   public int getWidth() {
      return animations[currentIndex].getWidth();
   }

   @Override
   public void setColor(Color color) {
      for (Animation animation : animations) {
         animation.setColor(color);
      }
   }

   @Override
   public void setColor(float red, float green, float blue) {
      for (Animation animation : animations) {
         animation.setColor(red, green, blue);
      }
   }

   @Override
   public void setColor(int red, int green, int blue) {
      for (Animation animation : animations) {
         animation.setColor(red, green, blue);
      }
   }

   @Override
   public void setColorEffect(ColorEffect colorEffect) {
      for (Animation animation : animations) {
         animation.setColorEffect(colorEffect);
      }
   }

   @Override
   public void setSize(int width, int height) {
      for (Animation animation : animations) {
         animation.setSize(width, height);
      }
   }

   @Override
   public void setSound(Sound sound) {
      for (Animation animation : animations) {
         animation.setSound(sound);
      }
   }

   @Override
   public void setTranslucency(float percent) {
      for (Animation animation : animations) {
         animation.setTranslucency(percent);
      }
   }

}
