/*
 * Copyright (c) 2022-2025 Gary Deken
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
package org.abberkeep.gameframework.state;

/**
 * Title: NullState
 *
 * <p>
 * Description: An empty state that has no activate actions or deactivation actions.</p>
 *
 * Copyright (c) Dec 25, 2025
 * @author Gary Deken
 * @version 0.19
 */
public class NullState extends GameState {

   @Override
   public void activateState() {
      // Do nothing
   }

   @Override
   public void deactivateState() {
      // Do nothing
   }

   @Override
   public void update(float deltaTime) {
      // Do nothing
   }

}
