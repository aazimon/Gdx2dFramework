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

/**
 * Title: ColorEffect
 *
 * <p>
 * Description: An effect that cycles through, from one Color to another Color.</p>
 *
 * Copyright (c) Dec 31, 2023
 * @author Gary Deken
 * @version 0.14
 */
public class ColorCycleEffect implements ColorEffect {
   private Color baseColor = Color.WHITE;
   private Color renderColor = new Color(1, 1, 1, 1);
   private List<Color> colors = new ArrayList<>();
   private List<Float> durations = new ArrayList<>();
   private int currentColor = 0;
   private float currentTime;
   private float[] currentChange = new float[4];
   private float currentDuration;

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
   public Color getColor() {
      return renderColor;
   }

   @Override
   public boolean isDone() {
      return currentColor >= colors.size();
   }

   @Override
   public void reset() {
      renderColor = new Color(1, 1, 1, 1);
      currentColor = 0;
   }

   @Override
   public void update(float deltaTime) {
      currentTime += deltaTime;
      if (currentTime <= currentDuration) {
         updateRenderColor();
      } else {
         currentColor++;
         if (currentColor < colors.size()) {
            currentDuration = durations.get(currentColor);
            baseColor = colors.get(currentColor - 1);
            setUpCurrentChange(colors.get(currentColor));
            currentTime = deltaTime;
            updateRenderColor();
         }
      }
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
