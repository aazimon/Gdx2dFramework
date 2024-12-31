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
package org.abberkeep.gameframework.background;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: FixedBackground
 *
 * <p>
 * Description: Renders a background Animation that is in a fixed location of 0, 0. It does not move even if the
 * foreground does. If the ScreenSize is set, the background Animation will span the entire Screen.</p>
 *
 * Copyright (c) Sep 21, 2024
 * @author Gary Deken
 * @version 0.16
 */
public class FixedBackground implements Background {
   private Animation animation;
   private boolean stretch = false;
   private int sizeX;
   private int sizeY;
   private int height;
   private int width;
   private int originX;
   private int originY;

   /**
    * Creates a new FixedBackground with the Animation and if it should stretch with the screen size. The original
    * Animation size is stored in width and height.
    * @param animation
    * @param stretch
    */
   public FixedBackground(Animation animation, boolean stretch) {
      this.animation = animation;
      this.stretch = stretch;
      sizeX = animation.getWidth();
      sizeY = animation.getHeight();
   }

   @Override
   public void addAnimation(Animation animation) {
      this.animation = animation;
      sizeX = animation.getWidth();
      sizeY = animation.getHeight();
   }

   @Override
   public void draw(SpriteBatch batch) {
      for (int y = originY; y < originY + height; y = y + sizeY) {
         for (int x = originX; x < originX + width; x = x + sizeX) {
            animation.draw(batch, x, y);
         }
      }
   }

   @Override
   public void setScreenOrigin(int x, int y) {
      originX = x;
      originY = y;
   }

   /**
    * Sets the size of the Screen so that the Background can stretch to match, otherwise if the Background Animation is
    * smaller then the screen size it will tile the Animation to fill in the background.
    * @param width
    * @param height
    */
   @Override
   public void setScreenSize(int width, int height) {
      this.width = width;
      this.height = height;
      if (stretch) {
         animation.setSize(width, height);
         sizeX = width;
         sizeY = height;
      }
   }

   @Override
   public void update(float deltaTime) {
      animation.update(deltaTime);
   }

}
