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

   public MockAnimation() {
      height = 10;
      width = 12;
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      // do nothing
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
   public void setColor(Color color) {
      // do nothing.
   }

   @Override
   public void setColor(float red, float green, float blue) {
      // do nothing.
   }

   @Override
   public void setColor(int red, int green, int blue) {
      // do nothing.
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
      // do nothing.
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
      // do nothing.
   }

}
