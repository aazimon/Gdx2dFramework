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
package org.abberkeep.gameframework.screen.bsp;

/**
 * Title: BSPLine
 *
 * <p>
 * Description: A dividing Line for a BSP Tree structure. The has the coordinates of the division.</p>
 *
 * Copyright (c) Dec 10, 2023
 * @author Gary Deken
 * @version 0.14
 */
public class BSPLine {
   private int x1;
   private int y1;
   private int x2;
   private int y2;
   private int nx;
   private int ny;

   /**
    * Create a new BSPLine from x1, y1 to x2, y2.
    * @param x1
    * @param y1
    * @param x2
    * @param y2
    */
   public BSPLine(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      nx = y2 - y1;
      ny = x1 - x2;
   }

   /**
    * Determine the side of the line the location is on. If negative it is the back, if positive it is the front.
    * @param x
    * @param y
    * @return
    */
   public int getSide(float x, float y) {
      float side = (x - x1) * nx + (y - y1) * ny;
      if (side < 0) {
         return -1;
      }
      if (side > 0) {
         return 1;
      }
      return 0;
   }

}
