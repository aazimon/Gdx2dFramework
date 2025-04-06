/*
 * Copyright (c) 2023 Gary Deken
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.background.Background;
import org.abberkeep.gameframework.screen.map.GameMap;

/**
 * Title: BaseScreen
 *
 * <p>
 * Description: The base screen used by all screens.</p>
 *
 * Copyright (c) Dec 9, 2022
 * @author Gary Deken
 * @version 1
 * @since 0.1
 */
public abstract class BaseScreen implements Screen {
   protected Background background;
   protected SpriteBatch batch;
   protected int largestSpriteWidth = 0;
   protected int largestSpriteHeight = 0;
   protected Viewport viewport;
   protected int height;
   protected int width;
   private Color bgColor;
   private Map<String, Texture> textures = new HashMap<>();
   private Map<String, Sound> sounds = new HashMap<>();
   private Map<String, Music> musics = new HashMap<>();
   private List<Updatable> updatables = new ArrayList<>();
   private GameMap gameMap;

   /**
    * Constructor for the BaseScreen. It sets the background color to a default Black.
    */
   protected BaseScreen() {
      bgColor = new Color();
   }

   /**
    * Adds an Updatable object to this Screen. Updatable objects are not drawn on the screen but are only updated each
    * cycle. Updatables are used for functionalities that require events to happen at any given iteration of the Game.
    * @param updatable
    */
   public void addUpdatable(Updatable updatable) {
      updatables.add(updatable);
   }

   @Override
   public void dispose() {
      for (Texture texture : textures.values()) {
         texture.dispose();
      }
      for (Sound sound : sounds.values()) {
         sound.dispose();
      }
      for (Music music : musics.values()) {
         music.dispose();
      }
      textures.clear();
      sounds.clear();
      musics.clear();
   }

   /**
    * Method to get Musics and storing them at the Screen level for disposal when the screen disposes.
    * @param fileName
    * @return
    */
   public Music getMusic(String fileName) {
      return musics.computeIfAbsent(fileName, fn -> Gdx.audio.newMusic(Gdx.files.internal(fn)));
   }

   /**
    * Method to get Sounds and storing them at the Screen level for disposal when the screen disposes.
    * @param fileName
    * @return
    */
   public Sound getSound(String fileName) {
      return sounds.computeIfAbsent(fileName, fn -> Gdx.audio.newSound(Gdx.files.internal(fn)));
   }

   /**
    * Method to get Textures and storing them at the Screen level for disposal when the screen disposes.
    * @param fileName
    * @return
    */
   public Texture getTexture(String fileName) {
      return textures.computeIfAbsent(fileName, Texture::new);
   }

   @Override
   public void hide() {
      //
   }

   @Override
   public void pause() {
      //
   }

   /**
    * Renders the images to the screen and setting up basic setup for all Screens. This updates any Updatables, then
    * updates and renders the Background if it is set, and then it calls the renderChild method that child Screens will
    * implement and render for the specific Screen.
    * @param deltaTime
    */
   @Override
   public void render(float deltaTime) {
      Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
      Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
      viewport.getCamera().update();
      batch.setProjectionMatrix(viewport.getCamera().combined);
      batch.begin();
      updatables.forEach(up -> up.update(deltaTime));
      if (background != null) {
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
         background.update(deltaTime);
         background.draw(batch);
      }
      gameMap.renderCycle(deltaTime, batch);
      batch.end();
      ScreenInput.inputLocks.clear();
   }

   /**
    * This sets the Screen's width and height and updates the Background if that is set.
    * @param width
    * @param height
    */
   @Override
   public void resize(int width, int height) {
      this.width = width;
      this.height = height;
      if (background != null) {
         background.setScreenSize(width, height);
         background.setScreenOrigin(viewport.getScreenX(), viewport.getScreenY());
      }
   }

   @Override
   public void resume() {
      //
   }

   /**
    * Used within the BaseGame when calling setScreen. The setScreen will call this method to inject the SpriteBatch and
    * Viewport objects.
    * @param batch
    * @param viewport
    */
   public void setupScreen(SpriteBatch batch, Viewport viewport) {
      this.batch = batch;
      this.viewport = viewport;
      height = Gdx.graphics.getHeight();
      width = Gdx.graphics.getWidth();
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
   }

   public void setGameMap(GameMap gameMap) {
      this.gameMap = gameMap;
   }

}
