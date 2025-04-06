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
package org.abberkeep.gameframework.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: MockSprite
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Feb 2, 2025
 * @author Gary Deken
 * @version
 */
public class MockSprite extends Sprite {

   public MockSprite(int width, int height) {
      super(width, height);
   }

   @Override
   public void draw(SpriteBatch batch) {
      //
   }

   @Override
   public void update(float deltaTime) {
      //
   }

   @Override
   public boolean doesImpact() {
      return false;
   }

}
