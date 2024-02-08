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
package org.abberkeep.gameframework.effects;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.motion.Motion;

/**
 * Title: TranslucencyEffect
 *
 * <p>
 * Description: An effect that will cycles through levels of translucency, from one level to another level.</p>
 *
 * Copyright (c) Jan 6, 2024
 * @author Gary Deken
 * @version 0.15
 */
public class TranslucencyEffect extends BaseEffect {
   private List<Float> translucencies = new ArrayList<>();
   private float baseTranslucency = 1f;
   private float currentChange;
   private float currentTranslucency = 1f;
   private float startTranslucency = -1;

   /**
    * Create a Translucency effect, that change from opaque (1) to the passed in value over the duration.
    * @param translucency
    * @param duration
    */
   public TranslucencyEffect(float translucency, float duration) {
      addTranslucency(translucency, duration);
      currentChange = baseTranslucency - translucency;
      currentDuration = duration;
   }

   /**
    * Create a Translucency effect, that change from translucency1 to translucency2 over the duration.
    * @param translucency1
    * @param translucency2
    * @param duration
    */
   public TranslucencyEffect(float translucency1, float translucency2, float duration) {
      baseTranslucency = translucency1;
      startTranslucency = translucency1;
      addTranslucency(translucency2, duration);
      currentChange = baseTranslucency - translucency2;
      currentDuration = duration;
   }

   public void addTranslucency(float translucency, float duration) {
      translucencies.add(translucency);
      durations.add(duration);
   }

   @Override
   public void reset() {
      baseReset();
      baseTranslucency = 1f;
      if (startTranslucency != -1) {
         baseTranslucency = startTranslucency;
      }
      currentChange = baseTranslucency - translucencies.get(0);
      currentTranslucency = 1f;
   }

   @Override
   public void update(float deltaTime) {
      currentTime += deltaTime;
      if (currentTime <= currentDuration) {
         updateTranslucency();
      } else {
         currentIndex++;
         if (currentIndex < translucencies.size()) {
            currentDuration = durations.get(currentIndex);
            baseTranslucency = translucencies.get(currentIndex - 1);
            currentChange = baseTranslucency - translucencies.get(currentIndex);
            currentTime = deltaTime;
            updateTranslucency();
         } else {
            currentTranslucency = translucencies.get(translucencies.size() - 1);
         }
      }
   }

   @Override
   public void updateAnimation(Animation animation) {
      animation.setTranslucency(currentTranslucency);
   }

   @Override
   public void updateMotion(Motion motion) {
      motion.setTranslucency(currentTranslucency);
   }

   private void updateTranslucency() {
      float per = (currentTime / currentDuration);
      currentTranslucency = baseTranslucency - (per * currentChange);
   }

}
