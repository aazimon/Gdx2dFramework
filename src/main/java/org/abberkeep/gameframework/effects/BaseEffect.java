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

/**
 * Title: BaseEffect
 *
 * <p>
 * Description: BaseEffect holds attributes used by all Effects, including the currentTime, currentDuration,
 * currentIndex and list of durations. The size of the durations should match the size of the effects, as the duration
 * is used to check if the effect is done.</p>
 *
 * Copyright (c) Jan 6, 2024
 * @author Gary Deken
 * @version 0.15
 */
public abstract class BaseEffect implements Effects {
   protected List<Float> durations = new ArrayList<>();
   protected float currentDuration;
   protected int currentIndex;
   protected float currentTime;

   @Override
   public boolean isDone() {
      return currentIndex >= durations.size();
   }

   protected void baseReset() {
      currentDuration = durations.get(0);
      currentIndex = 0;
      currentTime = 0;
   }

}
