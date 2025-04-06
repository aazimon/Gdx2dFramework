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
package org.abberkeep.gameframework.screen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: InputLocks
 *
 * <p>
 * Description: The InputLocks holds locks on input IDs so that other Sprites do not respond to the inputs incorrectly.
 * Locks are added and the ScreenInput will not report inputs for any Sprite that does not have the lock. Once a Sprite
 * is done with an Input, the lock is marked for removal. At the end of an update cycle, the locks are removed from the
 * ScreenInput.</p>
 *
 * Copyright (c) Feb 2, 2025
 * @author Gary Deken
 * @version 0.17
 */
public class InputLocks {
   private Map<Integer, Sprite> locks = new HashMap<>();
   private Set<Integer> removes = new HashSet<>();

   /**
    * Adds a Lock for the Input ID for this Sprite, so to prevent other Sprites from reacting from an input trigger. If
    * the lock is marked for removal, this will cancel the movement and add this sprite as the holder of the lock. This
    * should not be called to cancel a lock removal, use cancelRemove() instead.
    * @param inputId
    * @param sprite
    */
   public void add(int inputId, Sprite sprite) {
      if (removes.contains(inputId)) {
         removes.remove(inputId);
      }
      locks.put(inputId, sprite);
   }

   /**
    * ClearLocks removes all locks that have been marked for removal. This should be run at the end of the render cycle
    * after all updates are made.
    */
   public void clear() {
      for (Integer remove : removes) {
         locks.remove(remove);
      }
   }

   /**
    * This cancels a removal of a lock. Use this if the same sprite needs to keep the lock.
    * @param inputId
    */
   public void cancelRemove(int inputId) {
      removes.remove(inputId);
   }

   /**
    * This returns if there is a lock on the specified input ID.
    * @param inputId
    * @return
    */
   public boolean isLocked(int inputId) {
      return locks.containsKey(inputId);
   }

   /**
    * This returns if there is a lock on a specified input ID with this Sprite.
    * @param inputId
    * @param sprite
    * @return
    */
   public boolean isLockedOn(int inputId, Sprite sprite) {
      Sprite locked = locks.get(inputId);
      if (locked == null) {
         return false;
      }
      return locked.equals(sprite);
   }

   /**
    * This marks a lock to be removed at the end of the render cycle.
    * @param inputId
    */
   public void remove(int inputId) {
      removes.add(inputId);
   }

   /**
    * This will mark all locks to be removed. To complete the removal, call clear().
    */
   public void removeAll() {
      for (Integer integer : locks.keySet()) {
         removes.add(integer);
      }
   }

}
