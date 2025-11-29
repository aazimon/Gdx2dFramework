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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.background.Background;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: GameMap
 *
 * <p>
 * Description: This is the base GameMap that will be the parent of all other GameMaps. It will be added to the
 * BaseScreen, which will call the GameMap's renderCycle() method for the GameMap to render the sprites on the
 * screen.</p>
 *
 * Copyright (c) Mar 2, 2025
 * @author Gary Deken
 * @version 0.17
 */
public abstract class GameMap {
   private Viewport viewport;
   protected boolean renderCycle = false;
   protected Background background;
   protected List<Sprite> toBeAdded = new ArrayList<>();
   protected List<Updatable> updatables = new ArrayList<>();

   /**
    * Adds an Actor to this GameMap.
    * @param actor
    */
   public abstract void addActor(Actor actor);

   /**
    * Adds a Decor to this GameMap.
    * @param decor
    */
   public abstract void addDecor(Decor decor);

   /**
    * Adds a Sprite to this GameMap.
    * @param sprite
    */
   public abstract void addSprite(Sprite sprite);

   public void addUpdatable(Updatable updatable) {
      this.updatables.add(updatable);
   }

   /**
    * This renders the GameMap, by setting the renderCycle, updating the Sprites and then drawing the Sprites. Then it
    * will add any Sprites added during the render cycle to the GameMap.
    * @param deltaTime
    * @param batch
    */
   public void renderCycle(float deltaTime, SpriteBatch batch) {
      renderCycle = true;
      if (background != null) {
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
         background.update(deltaTime);
         background.draw(batch);
      }
      updatables.forEach(update -> update.update(deltaTime));;
      updateSprites(deltaTime);
      drawSprites(batch);
      renderCycle = false;
      addOffCycle();
   }

   /**
    * This sets the GameMap's width and height and updates the Background if that is set.
    * @param width
    * @param height
    */
   public void resize(int width, int height) {
      if (background != null) {
         background.setScreenSize(width, height);
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
      }
   }

   /**
    * Set the Background object for this Screen.
    * @param background
    */
   public void setBackground(Background background) {
      this.background = background;
      if (viewport != null) {
         background.setScreenSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
      }
   }

   /**
    * Called when calling BaseScreen setGameMap, to set up Background object. There is no need to call this manually.
    * @param viewport
    * @param screenWidth
    * @param screenHeight
    */
   public void setUp(Viewport viewport, int screenWidth, int screenHeight) {
      this.viewport = viewport;
      if (background != null) {
         background.setScreenSize(screenWidth, screenHeight);
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
      }
   }

   protected abstract void addOffCycle();

   protected abstract void drawSprites(SpriteBatch batch);

   protected abstract void updateSprites(float deltaTime);

}
