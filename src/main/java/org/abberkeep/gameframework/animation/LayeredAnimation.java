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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: LayeredAnimation
 *
 * <p>
 * Description: A multi layered Animation, that contains one or more Animations. The first Animation added will be on
 * the bottom and additional Animations will render on top of it.</p>
 *
 * Copyright (c) Jun 9, 2023
 * @author Gary Deken
 * @version 0.6
 */
public class LayeredAnimation extends BaseAnimation {
   private List<Animation> animations = new ArrayList<>();

   public LayeredAnimation(Animation animation) {
      animations.add(animation);
   }

   public void addAnimation(Animation animation) {
      animations.add(animation);
   }

   public Animation getAnimation(int index) {
      return animations.get(index);
   }

   @Override
   public void setColor(Color color) {
      animations.forEach(animation -> animation.setColor(color));
   }

   @Override
   public void setColor(float red, float green, float blue) {
      super.setColor(red, green, blue);
      animations.forEach(animation -> animation.setColor(color));
   }

   @Override
   public void setColor(int red, int green, int blue) {
      super.setColor(red, green, blue);
      animations.forEach(animation -> animation.setColor(color));
   }

   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      animations.forEach(animation -> animation.draw(batch, x + xOffset, y + yOffset));
   }

   @Override
   protected void updateChild(float deltaTime) {
      animations.forEach(animation -> animation.update(deltaTime));
   }

}
