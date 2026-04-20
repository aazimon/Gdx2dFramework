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

import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.motion.Motion;

/**
 * Title: NoEffect
 *
 * <p>
 * Description: The NoEffect does nothing but run for the specified time. This is useful for ChainEffect.</p>
 *
 * Copyright (c) Apr 12, 2026
 * @author GaryDeken
 * @version 0.19
 */
public class NoEffect implements Effects {
   private float time = 0;
   private float duration;

   /**
    * Creates a NoEffect that will run for the specified duration.
    * @param duration
    */
   public NoEffect(float duration) {
      this.duration = duration;
   }

   @Override
   public boolean isDone() {
      return time >= duration;
   }

   @Override
   public void reset() {
      time = 0;
   }

   @Override
   public void updateAnimation(Animation animation) {
      // no action taken.
   }

   @Override
   public void updateMotion(Motion motion) {
      // no action taken.
   }

   @Override
   public void update(float deltaTime) {
      time += deltaTime;
   }

}
