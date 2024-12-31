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
package org.abberkeep.gameframework.sprite;

import java.util.LinkedList;
import java.util.Queue;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: ActorFactory
 *
 * <p>
 * Description: The ActorFactory will create new Actor of the defined type. Each Actor will have same type of Movement
 * and Motions created.</p>
 *
 * @param <T>
 *
 * Copyright (c) Nov 9, 2023
 * @author Gary Deken
 * @version 0.13
 */
public abstract class ActorFactory<T extends ForgedActor> {
   protected BaseScreen baseScreen;
   protected Queue<T> queue = new LinkedList<>();
   protected int queueSize = 5;

   /**
    * Creates a SpriteFactory taking in the BaseScreen where the Actors will be added. The queue will only be populated
    * when the setupQueue() method is called and not before. At that time, the queue will default to five entries.
    * @param baseScreen
    */
   protected ActorFactory(BaseScreen baseScreen) {
      this.baseScreen = baseScreen;
   }

   /**
    * Creates a SpriteFactory taking in the BaseScreen where the Actors will be added. The queue will only be populated
    * when the setupQueue() method is called and not before. At that time, the queue will be populated with the
    * queueSize number of entries.
    * @param baseScreen
    * @param queueSize
    */
   protected ActorFactory(BaseScreen baseScreen, int queueSize) {
      this.baseScreen = baseScreen;
      this.queueSize = queueSize;
   }

   /**
    * Retrieve a Sprite from the queue or Create a New Sprite of the defined type and add it to the BaseScreen at the X
    * and Y location passed in. This method uses the build method to create the Movement and Motions in the Actor. If
    * the Sprite is pulled from the queue, it's remove flag is set to false.
    * @param x
    * @param y
    */
   public void createNewActor(float x, float y) {
      T t;
      if (queue.isEmpty()) {
         t = construct(buildMovement(), buildMoveMotions(), buildStillMotions());
         t.setActorFactory(this);
      } else {
         t = queue.poll();
         t.reset();
      }
      t.setLocation(x, y);

      baseScreen.addActor(t);
   }

   /**
    * This will set up the queue with the queueSize number of Actors. This should be called before the Actors are
    * needed, otherwise the queue will be empty and the Actor will be created as needed.
    */
   public void setupQueue() {
      for (int i = 0; i < queueSize; i++) {
         T t = construct(buildMovement(), buildMoveMotions(), buildStillMotions());
         t.setActorFactory(this);
         queue.add(t);
      }
   }

   /**
    * This gets called when an Actor is removed, and this adds that Actor back into the Queue. The remove flag is not
    * set to false at this point, so that the Screen can still see it needs to be removed.
    * @param actor
    */
   public void actorRemoved(ForgedActor actor) {
      T t = (T) actor;
      queue.add(t);
   }

   /**
    * Child classes need to implement this method and define how the Movement is to be created and passed into the
    * Actor.
    * @return
    */
   protected abstract Movement buildMovement();

   /**
    * Child classes need to implement this method and define how the Move Motion is to be created and passed into the
    * Actor.
    * @return
    */
   protected abstract Motion[] buildMoveMotions();

   /**
    * Child classes need to implement this method and define how the Still Motion is to be created and passed into the
    * Actor.
    * @return
    */
   protected abstract Motion[] buildStillMotions();

   /**
    * Child classes need to implement this method and define how the type Actor is to be created, including any
    * additional attributes that need to be set.
    * @param buildMovement
    * @param buildMoveMotions
    * @param buildStillMotions
    * @return
    */
   protected abstract T construct(Movement buildMovement, Motion[] buildMoveMotions, Motion[] buildStillMotions);

}
