/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.screen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;
import org.abberkeep.gameframework.utils.SpatialKey;
import org.abberkeep.gameframework.utils.SpatialTree;

/**
 * Title: FreestyleScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Sept 10, 2023
 *
 * @author Gary Deken
 * @version 0.10
 */
public abstract class StaticScreen extends BaseScreen {
   private SpatialTree sprites = new SpatialTree();
   private List<Sprite> moved = new ArrayList<>();

   @Override
   public void addActor(Actor actor) {
      addSprite(actor);
   }

   @Override
   public void addDecor(Decor decor) {
      addSprite(decor);
   }

   @Override
   protected void renderChild(float deltaTime) {
      Iterator<SpatialKey> iterY = sprites.iterator();
      while (iterY.hasNext()) {
         SpatialKey key = iterY.next();
         Sprite s = sprites.get(key);
         s.update(deltaTime);
         // detect collision
         if (s.doesImpact()) {
            detectCollision(s);
         }
         if (key.getY() != (int) s.getY() && key.getX() != (int) s.getX()) {
            iterY.remove();
            moved.add(s);
         }
         s.draw(batch);
      }
      moved.forEach((s) -> addSprite(s));
      moved.clear();
   }

   private void addSprite(Sprite sprite) {
      sprites.put(sprite);
      if (sprite.getWidth() > largestSpriteWidth) {
         largestSpriteWidth = sprite.getWidth();
      }
      if (sprite.getHeight() > largestSpriteHeight) {
         largestSpriteHeight = sprite.getHeight();
      }
   }

   private void detectCollision(Sprite s) {
      for (Map.Entry<SpatialKey, Sprite> entry : sprites.entrySet()) {
         if ((int) s.getY() + largestSpriteHeight < entry.getKey().getY()
               || (int) s.getY() - largestSpriteHeight > entry.getKey().getY()) {
            if ((int) s.getX() + largestSpriteWidth < entry.getKey().getX()
                  || (int) s.getX() - largestSpriteWidth > entry.getKey().getX()) {
               s.handleCollision(entry.getValue());
            }
         }
      }
   }

}
