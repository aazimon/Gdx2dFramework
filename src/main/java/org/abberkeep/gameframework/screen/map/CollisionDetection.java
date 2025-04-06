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
package org.abberkeep.gameframework.screen.map;

import java.util.Collection;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: CollisionDetection
 *
 * <p>
 * Description: The CollisionDetection is a static method for looping through the Sprite list to find if the sprite has
 * collided with another one.</p>
 *
 * Copyright (c) Mar 2, 2025
 * @author Gary Deken
 * @version 0.17
 */
public class CollisionDetection {

   public static void detectCollision(Sprite sprite, Collection<Sprite> sprites) {
      for (Sprite collideSprite : sprites) {
         if (sprite != collideSprite && sprite.contains(collideSprite)) {
            sprite.handleCollision(collideSprite);
         }
      }
   }
}
