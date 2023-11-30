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

/**
 * Title: MockSpriteUpdate
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 5, 2023
 * @author Gary Deken
 * @version
 */
public class MockSpriteUpdate implements SpriteUpdate {
   private float x;
   private float y;
   private BoundingBox bounds;
   private boolean remove;

   public MockSpriteUpdate(int width, int height) {
      bounds = new BoundingBox(0, 0, width, height);
   }

   @Override
   public boolean contains(BoundingBox other) {
      return bounds.contains(other);
   }

   @Override
   public float getX() {
      return x;
   }

   @Override
   public float getY() {
      return y;
   }

   @Override
   public void setLocation(float x, float y) {
      this.x = x;
      this.y = y;
      bounds.setLocation((int) x, (int) y);
      System.out.println("SpriteUpdate X: " + x + " Y: " + y);
   }

   @Override
   public void setRemove(boolean remove) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setX(float x) {
      this.x = x;
      bounds.setLocation((int) x, (int) y);
      System.out.println("SpriteUpdate X: " + x);
   }

   @Override
   public void setY(float y) {
      this.y = y;
      bounds.setLocation((int) x, (int) y);
      System.out.println("SpriteUpdate Y: " + y);
   }

}
