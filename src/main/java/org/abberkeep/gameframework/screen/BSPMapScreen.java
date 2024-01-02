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
package org.abberkeep.gameframework.screen;

import org.abberkeep.gameframework.screen.bsp.BSPLine;
import org.abberkeep.gameframework.screen.bsp.Node;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: BSPMapScreen
 *
 * <p>
 * Description: A BSPMapScreen, where the objects within the Screen are divided in the BSP Tree based on their location,
 * and collision is done by section in the BSP Tree.</p>
 *
 * Copyright (c) Dec 10, 2023
 * @author Gary Deken
 * @version 0.14
 */
public class BSPMapScreen extends BaseScreen {
   private int mapHeight;
   private int mapWidth;
   private Node root;

   /**
    * Creates a BSPMapScreen with the given mapHeight and mapWidth. The mapHeight and mapWidth should be the same size
    * as the screen or larger.
    * @param mapHeight
    * @param mapWidth
    */
   public BSPMapScreen(int mapHeight, int mapWidth) {
      this.mapHeight = mapHeight;
      this.mapWidth = mapWidth;
      root = constructNodes(0, 0, mapHeight, mapWidth);
   }

   @Override
   public void addActor(Actor actor) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void addDecor(Decor decor) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void show() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   protected void renderChild(float deltaTime) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   private Node constructNodes(int xStart, int yStart, int height, int width) {
      if (height < 100 || width < 100) {
         // if the section is too small don't divide.
         return null;
      }
      // find the center.
      int x = height / 2;
      int y = width / 2;
      BSPLine line;
      if (height > width) {
         // map is tall
         line = new BSPLine(xStart, y, xStart + width, y);
      } else {
         // map is wide
         line = new BSPLine(x, yStart, x, yStart + height);
      }
      return null;
   }

}
