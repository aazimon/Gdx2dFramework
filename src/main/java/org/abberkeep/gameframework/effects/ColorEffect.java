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
import org.abberkeep.gameframework.Updatable;

/**
 * Title: Effect
 *
 * <p>
 * Description: An ColorEffect to be applied to a Motion and Animation.</p>
 *
 * Copyright (c) Dec 31, 2023
 * @author Gary Deken
 * @version 0.14
 */
public interface ColorEffect extends Updatable {

   /**
    * Gets the current Color of this Effect.
    * @return
    */
   Color getColor();

   /**
    * Returns true when this ColorEffect has completed.
    * @return
    */
   boolean isDone();

   /**
    * Resets the Color to the initial setting.
    */
   void reset();

}
