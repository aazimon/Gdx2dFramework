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

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: SimpleSpriteMap
 *
 * <p>
 * Description: This GameMap stores Sprites in a simple array by layer. The number of layers needs to be a positive
 * amount. No layer can be added below zero.</p>
 *
 * Copyright (c) Mar 2, 2025
 * @author Gary Deken
 * @version 0.17
 */
public class SimpleSpriteMap extends GameMap {
   private List<Sprite>[] spriteLayers;
   private transient int modCount = 0;
   private Map<Integer, List<Sprite>> toBeRemoved = new HashMap<>();

   /**
    * Creates a SimpleSpriteMap for the given number of layers. Layers must be a positive non-zero number.
    * @param layers
    */
   public SimpleSpriteMap(int layers) {
      if (layers < 1) {
         throw new IllegalArgumentException("Layers must be positive");
      }
      spriteLayers = new ArrayList[layers];
      for (int i = 0; i < layers; i++) {
         spriteLayers[i] = new ArrayList<>();
         toBeRemoved.put(i, new ArrayList<>());
      }
   }

   @Override
   public void addActor(Actor actor) {
      addSprite(actor);
   }

   @Override
   public void addDecor(Decor decor) {
      addSprite(decor);
   }

   @Override
   public void addSprite(Sprite sprite) {
      if (renderCycle) {
         toBeAdded.add(sprite);
      } else {
         addSpriteToMap(sprite);
      }
   }

   @Override
   protected void addOffCycle() {
      for (int i = 0; i < spriteLayers.length; i++) {
         List<Sprite> sprites = toBeRemoved.get(i);
         for (Sprite sprite : sprites) {
            spriteLayers[i].remove(sprite);
         }
         sprites.clear();
      }
      if (!toBeAdded.isEmpty()) {
         for (Sprite sprite : toBeAdded) {
            addSpriteToMap(sprite);
         }
         toBeAdded.clear();
      }
   }

   @Override
   protected void drawSprites(SpriteBatch batch) {
      Iterator<Sprite> iter = iterator();

      while (iter.hasNext()) {
         Sprite sprite = iter.next();
         if (!sprite.isRemove()) {
            sprite.draw(batch);
         }
      }
   }

   @Override
   protected void updateSprites(float deltaTime) {
      Iter<Sprite> iter = iterator();

      while (iter.hasNext()) {
         Sprite sprite = iter.next();
         sprite.update(deltaTime);
         // detect collision
         detectCollision(sprite);
         if (sprite.isChangingLayer()) {
            toBeRemoved.get(iter.getCurrentLayer()).add(sprite);
            toBeAdded.add(sprite);
         }
         if (sprite.isRemove()) {
            iter.remove();
         }
      }
   }

   private void addSpriteToMap(Sprite sprite) {
      spriteLayers[sprite.getLayer()].add(sprite);
   }

   private void detectCollision(Sprite sprite) {
      int layer = sprite.getLayer();

      for (Sprite sprite1 : spriteLayers[layer]) {
         if (!sprite.equals(sprite1) && sprite.contains(sprite1)) {
            sprite.handleCollision(sprite1);
         }
      }
   }

   private Iter<Sprite> iterator() {
      return new Iter();
   }

   private class Iter<T> implements Iterator<Sprite> {
      int layerCursor;
      int cursor;       // index of next element to return
      int lastRet = -1; // index of last element returned; -1 if no such
      int expectedModCount = modCount;

      public int getCurrentLayer() {
         return layerCursor;
      }

      @Override
      public boolean hasNext() {
         while (cursor == spriteLayers[layerCursor].size()) {
            // end of layer, go to next
            layerCursor++;
            cursor = 0;
            if (layerCursor == spriteLayers.length) {
               return false;
            }
         }

         return layerCursor < spriteLayers.length || (layerCursor == spriteLayers.length && cursor != spriteLayers[layerCursor].size());
      }

      @Override
      public Sprite next() {
         checkForComodification();
         int i = cursor;

         if (layerCursor >= spriteLayers.length) {
            throw new NoSuchElementException();
         }
         List<Sprite> list = spriteLayers[layerCursor];

         cursor = i + 1;

         if (i >= list.size()) {
            throw new NoSuchElementException();
         }

         return list.get(lastRet = i);
      }

      @Override
      public void remove() {
         if (lastRet < 0) {
            throw new IllegalStateException();
         }
         checkForComodification();

         try {
            spriteLayers[layerCursor].remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
         } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
         }
      }

      final void checkForComodification() {
         if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
         }
      }
   }

}
