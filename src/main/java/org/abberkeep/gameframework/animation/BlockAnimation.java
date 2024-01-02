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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.BaseGame;

/**
 * Title: BlockAnimation
 *
 * <p>
 * Description: Creates a rectangle block, from a single pixel white image, Animation. The pixel image (a static
 * Texture) can be resized and colorized. It can also be rotated.</p>
 *
 * Copyright (c) Jun 10, 2023
 * @author Gary Deken
 * @version 0.7
 */
public class BlockAnimation extends BaseAnimation {
   private static Texture texture;

   /**
    * Creates a BlockAnimation with the given width and height.
    * @param width
    * @param height
    */
   public BlockAnimation(int width, int height) {
      if (texture == null) {
         texture = BaseGame.getGlobalTexture("blank.png");
      }
      color = Color.WHITE;
      this.width = width;
      this.height = height;
   }

   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      batch.draw(texture, x + xOffset, y + yOffset, width, height);
   }

   @Override
   protected void updateChild(float deltaTime) {
      if (stateTime == 0.0f && sound != null) {
         sound.play();
         stateTime = 1f;
      }
   }

}
