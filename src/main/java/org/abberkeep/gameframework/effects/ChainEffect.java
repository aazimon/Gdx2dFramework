/*
 * Copyright 2022-2026 GaryDeken.
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
 * Title: ChainEffect
 *
 * <p>
 * Description: ChainEffect takes multiple Effects and plays then in a sequence. Each Effect add is played for the
 * duration. Once one is done, the next Effect in the list will play. When the last Effect is played it will end on that
 * Effect. The size of the durations should match the size of the effects, as the duration is used to check if the
 * effect is done. If an Effect is added that does not have a "done" state, the ChainEffect will not move past that
 * Effect.</p>
 *
 * Copyright (c) April 12, 2026
 * @author Gary Deken
 * @version 0.19
 */
public class ChainEffect extends BaseEffect {
   private List<Effects> effects = new ArrayList();
   private int current = 0;

   /**
    * Creates a ChainEffect adding the Effects array one by one, starting with the first one.
    * @param effects
    */
   public ChainEffect(Effects... effects) {
      for (Effects effect : effects) {
         this.effects.add(effect);
      }
   }

   /**
    * Adds this Effect to the end of the List of Effects.
    * @param effect
    */
   public void addEffect(Effects effect) {
      this.effects.add(effect);
   }

   @Override
   public boolean isDone() {
      return effects.get(current).isDone() && current >= effects.size() - 1;
   }

   @Override
   public void reset() {
      effects.forEach(e -> e.reset());
      current = 0;
   }

   @Override
   public void updateAnimation(Animation animation) {
      effects.get(current).updateAnimation(animation);
   }

   @Override
   public void updateMotion(Motion motion) {
      effects.get(current).updateMotion(motion);
   }

   @Override
   public void update(float deltaTime) {
      Effects currentEffect = effects.get(current);
      if (currentEffect.isDone() && current < effects.size() - 1) {
         current++;
         currentEffect = effects.get(current);
      }
      currentEffect.update(deltaTime);
   }

}
