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
package org.abberkeep.gameframework.effects;

import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.motion.Motion;

/**
 * Title: ColorEffect
 *
 * <p>
 * Description: An effect that will cycles through colors, from one Color to another Color.</p>
 *
 * Copyright (c) Dec 31, 2023
 * @author Gary Deken
 * @version 0.15
 */
public class ColorCycleEffect extends BaseEffect {
   private Color baseColor = Color.WHITE;
   private Color renderColor = new Color(1, 1, 1, 1);
   private Color startColor;
   private List<Color> colors = new ArrayList<>();
   private float[] currentChange = new float[4];

   /**
    * Creates a ColorCycleEffect which will change from White to the Color passed in, over the duration.
    * @param color
    * @param duration
    */
   public ColorCycleEffect(Color color, float duration) {
      addColorCycle(color, duration);
      currentDuration = duration;
      setUpCurrentChange(color);
   }

   /**
    * Creates a ColorCycleEffectr which will change from the first Color to the second Color, over the duration.
    * @param color1
    * @param color2
    * @param duration
    */
   public ColorCycleEffect(Color color1, Color color2, float duration) {
      baseColor = color1;
      startColor = color1;
      addColorCycle(color2, duration);
      currentDuration = duration;
      setUpCurrentChange(color2);
   }

   /**
    * Add a new Color to the cycle that will change over the duration.
    * @param color
    * @param duration
    */
   public void addColorCycle(Color color, float duration) {
      colors.add(color);
      durations.add(duration);
   }

   @Override
   public void reset() {
      baseReset();
      renderColor = new Color(1, 1, 1, 1);
      baseColor = Color.WHITE;
      if (startColor != null) {
         baseColor = startColor;
      }
      setUpCurrentChange(colors.get(0));
   }

   @Override
   public void update(float deltaTime) {
      currentTime += deltaTime;
      if (currentTime <= currentDuration) {
         updateRenderColor();
      } else {
         currentIndex++;
         if (currentIndex < colors.size()) {
            currentDuration = durations.get(currentIndex);
            baseColor = colors.get(currentIndex - 1);
            setUpCurrentChange(colors.get(currentIndex));
            currentTime = deltaTime;
            updateRenderColor();
         } else {
            Color c = colors.get(colors.size() - 1);
            renderColor.r = c.r;
            renderColor.g = c.g;
            renderColor.b = c.b;
            renderColor.a = c.a;
         }
      }
   }

   @Override
   public void updateAnimation(Animation animation) {
      animation.setColor(renderColor);
   }

   @Override
   public void updateMotion(Motion motion) {
      motion.setColor(renderColor);
   }

   private void setUpCurrentChange(Color color) {
      currentChange[0] = baseColor.r - color.r;
      currentChange[1] = baseColor.g - color.g;
      currentChange[2] = baseColor.b - color.b;
      currentChange[3] = baseColor.a - color.a;
   }

   private void updateRenderColor() {
      float per = (currentTime / currentDuration);
      renderColor.r = baseColor.r - (per * currentChange[0]);
      renderColor.g = baseColor.g - (per * currentChange[1]);
      renderColor.b = baseColor.b - (per * currentChange[2]);
      renderColor.a = baseColor.a - (per * currentChange[3]);
   }

}
