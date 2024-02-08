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
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.effects.Effects;

/**
 * Title: MockAnimation
 *
 * <p>
 * Description:
 *
 * Copyright (c) Sep 21, 2023
 *
 * @author Gary Deken
 * @version
 */
public class MockAnimation implements Animation {
   private int height;
   private int width;
   private Color color;
   private float translucency = 1f;
   private List<Effects> effects;

   public MockAnimation() {
      height = 10;
      width = 12;
      color = new Color(1, 1, 1, 1);
   }

   @Override
   public void addEffects(Effects effect) {
      if (effects == null) {
         effects = new ArrayList<>();
      }
      effects.add(effect);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      // do nothing
   }

   public Color getColor() {
      return color;
   }

   @Override
   public int getHeight() {
      return height;
   }

   public float getTranslucency() {
      return translucency;
   }

   @Override
   public int getWidth() {
      return width;
   }

   @Override
   public void reset() {
      if (effects != null) {
         effects.forEach(Effects::reset);
      }
   }

   @Override
   public void setColor(Color color) {
      this.color = color;
   }

   @Override
   public void setColor(float red, float green, float blue) {
      this.color.r = red;
      this.color.g = green;
      this.color.b = blue;
   }

   @Override
   public void setColor(int red, int green, int blue) {
      color = new Color(red / 255.0f, green / 255.0f, blue / 255.0f, 1f);
   }

   @Override
   public void setSize(int width, int height) {
      this.height = height;
      this.width = width;
   }

   @Override
   public void setSound(Sound sound) {
      // do nothing.
   }

   @Override
   public void setTranslucency(float percent) {
      this.translucency = percent;
   }

   @Override
   public void setXOffSet(int xOffset) {
      // do nothing.
   }

   @Override
   public void setYOffset(int yOffset) {
      // do nothing.
   }

   @Override
   public void update(float deltaTime) {
      if (effects != null) {
         effects.forEach(effect -> {
            effect.update(deltaTime);
            effect.updateAnimation(this);
         });
      }
   }

}
