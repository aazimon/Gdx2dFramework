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
 * Title: BaseAnimation
 *
 * <p>
 * Description: An abstract Animation class that has height and width of the all Animations.</p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version 1
 * @since 0.4
 */
public abstract class BaseAnimation implements Animation {
   protected int width;
   protected int height;
   protected float originX;
   protected float originY;
   protected float rotation;
   protected Color color;
   protected float translucency = 1f;
   protected int xOffset;
   protected int yOffset;
   protected float stateTime;
   protected Sound sound;
   protected List<Effects> effects;

   @Override
   public void addEffects(Effects effect) {
      if (effects == null) {
         effects = new ArrayList<>();
      }
      effects.add(effect);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      if (color != null) {
         batch.setColor(color);
         drawChild(batch, x, y);
         batch.setColor(Color.WHITE);
      } else {
         drawChild(batch, x, y);
      }
   }

   @Override
   public int getHeight() {
      return height;
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
      this.color = new Color(color.r, color.g, color.b, translucency);
   }

   @Override
   public void setColor(float red, float green, float blue) {
      color = new Color(red, green, blue, translucency);
   }

   @Override
   public void setColor(int red, int green, int blue) {
      color = new Color(red / 255.0f, green / 255.0f, blue / 255.0f, translucency);
   }

   /**
    * Rotates the Animation based on the center of the image. As the image rotates the corners will break the boundaries
    * of the original Texture,
    * @param rotation
    */
   public void setRotation(float rotation) {
      this.rotation = rotation;
   }

   @Override
   public void setSize(int width, int height) {
      this.width = width;
      this.height = height;
      this.originX = width / 2.0f;
      this.originY = height / 2.0f;
   }

   @Override
   public void setSound(Sound sound) {
      this.sound = sound;
   }

   @Override
   public void setTranslucency(float percent) {
      if (translucency != percent) {
         if (percent > 1f) {
            percent = 1f;
         } else if (percent < 0f) {
            percent = 0f;
         }
         translucency = percent;
         if (color == null) {
            setColor(Color.WHITE);
         } else {
            setColor(color);
         }
      }
   }

   @Override
   public void setXOffSet(int xOffset) {
      this.xOffset = xOffset;
   }

   @Override
   public void setYOffset(int yOffset) {
      this.yOffset = yOffset;
   }

   @Override
   public void update(float deltaTime) {
      if (effects != null) {
         effects.forEach(effect -> {
            effect.update(deltaTime);
            effect.updateAnimation(this);
         });
      }
      updateChild(deltaTime);
   }

   /**
    * Child class implementation of the draw method.
    * @param batch
    * @param x
    * @param y
    */
   protected abstract void drawChild(SpriteBatch batch, float x, float y);

   /**
    * Child class implementation of the update method.
    * @param deltaTime
    */
   protected abstract void updateChild(float deltaTime);

}
