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

import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.motion.Motion;

/**
 * Title: Effect
 *
 * <p>
 * Description: An Effects to be applied to a Motion and Animation.</p>
 *
 * Copyright (c) Dec 31, 2023
 * @author Gary Deken
 * @version 0.15
 */
public interface Effects extends Updatable {

   /**
    * Returns true when this Effects has completed.
    * @return
    */
   boolean isDone();

   /**
    * Resets the Color to the initial setting.
    */
   void reset();

   /**
    * This is called from the BaseAnimation to update it with the given effects.
    * @param animation
    */
   void updateAnimation(Animation animation);

   /**
    * This is called from the BaseMotion to update it with the given effects.
    * @param motion
    */
   void updateMotion(Motion motion);
}
