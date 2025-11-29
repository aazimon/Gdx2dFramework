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
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Title: MockTextureRegion
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 23, 2025
 * @author Gary Deken
 * @version
 */
public class MockTextureRegion extends TextureRegion {
   private int height;
   private int width;

   public MockTextureRegion(int height, int width) {
      this.height = height;
      this.width = width;
   }

   @Override
   public int getRegionHeight() {
      return height;
   }

   @Override
   public int getRegionWidth() {
      return width;
   }

}
