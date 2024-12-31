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
import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: Background
 *
 * <p>
 * Description: Interface for describing the backgrounds rendering process, if it is static, scrolling, parallax or
 * something else.</p>
 *
 * Copyright (c) Sep 21, 2024
 * @author Gary Deken
 * @version 0.16
 */
public interface Background extends Updatable {

   /**
    * Add the Background's Animation.
    * @param animation
    */
   void addAnimation(Animation animation);

   /**
    * Draws the Background on the Screen based on the ViewPort of the Screen and type of Background. Location of the
    * Background is held internal to the Background class, and those values are passed down to the Animation class. Each
    * child class must implement this method for how the child should be drawn.
    * @param batch
    */
   void draw(SpriteBatch batch);

   /**
    * Set the Screen origin, so the Background can be adjusted accordingly.
    * @param x
    * @param y
    */
   void setScreenOrigin(int x, int y);

   /**
    * Set the Screen size, so the Background can be adjusted accordingly.
    * @param width
    * @param height
    */
   void setScreenSize(int width, int height);
}
