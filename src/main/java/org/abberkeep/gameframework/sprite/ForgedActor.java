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
package org.abberkeep.gameframework.sprite;

import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;

/**
 * Title: ForgedActor
 *
 * <p>
 * Description: The ForgedActor interface is used by the ActorFactory for each Actor built. It has a method for setting
 * the ActorFactory within that class, and it overrides the setRemove, so that it is also removed from the
 * ActorFactory.</p>
 *
 * Copyright (c) Jan 14, 2024
 * @author Gary Deken
 * @version 0.15
 */
public abstract class ForgedActor extends Actor {
   protected ActorFactory factory;

   public ForgedActor(Movement movement, Motion[] moveMotion, Motion[] stillMotion) {
      super(movement, moveMotion, stillMotion);
   }

   public void setActorFactory(ActorFactory factory) {
      this.factory = factory;
   }

   @Override
   public void setRemove(boolean remove) {
      super.setRemove(remove);
      factory.actorRemoved(this);
   }

}
