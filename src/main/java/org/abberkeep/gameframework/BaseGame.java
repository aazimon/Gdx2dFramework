/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: BaseGame
 *
 * <p>
 * Description: Base Game setup for 2D games.</p>
 *
 * Copyright (c) Dec 9, 2022
 * @author Gary Deken
 * @version 1
 * @since 0.1
 */
public class BaseGame extends Game {
   protected SpriteBatch batch;
   protected float height = 600;
   protected float width = 800;
   protected OrthographicCamera camera;

   protected BaseGame() {
   }

   /**
    * Creates the SpriteBatch and OrthographicCamera based on the width and height.
    */
   @Override
   public void create() {
      batch = new SpriteBatch();
      camera = new OrthographicCamera();
      camera.setToOrtho(false, width, height);
      camera.position.set(width / 2, height / 2, 0);
      camera.update();
   }

   /**
    * Disposes of the SpriteBatch.
    */
   @Override
   public void dispose() {
      super.dispose();
      batch.dispose();
   }

   /**
    * Clears the screen and sets the Projection Matrix to the camera's combined.
    */
   @Override
   public void render() {
      ScreenUtils.clear(1, 0, 0, 1);
      batch.setProjectionMatrix(camera.combined);
      super.render();
   }

   /**
    * Resizes the screen and updates the camera.
    * @param width
    * @param height
    */
   @Override
   public void resize(int width, int height) {
      super.resize(width, height);
      camera.setToOrtho(false, width, height);
   }

   /**
    * Sets the Screen for this Game and puts the SpriteBatch in to the BaseScreen passed in. The Screen passed in must
    * inherit from BaseScreen.
    * @param screen
    */
   @Override
   public void setScreen(Screen screen) {
      ((BaseScreen) screen).setBatch(batch);
      super.setScreen(screen);
   }

}
