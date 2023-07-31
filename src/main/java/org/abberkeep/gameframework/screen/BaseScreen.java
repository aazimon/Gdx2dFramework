/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.HashMap;
import java.util.Map;

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
   protected SpriteBatch batch;
   protected Viewport viewport;
   private Color bgColor;
   private Map<String, Texture> textures = new HashMap<>();

   /**
    * Constructor for the BaseScreen. It sets the background color to a default Black.
    */
   protected BaseScreen() {
      bgColor = new Color();
   }

   @Override
   public void dispose() {
      for (Texture texture : textures.values()) {
         texture.dispose();
      }
      textures.clear();
   }

   /**
    * Method to get Textures and storing them at the Screen level for disposal when the screen disposes.
    * @param fileName
    * @return
    */
   public Texture getTexture(String fileName) {
      return textures.computeIfAbsent(fileName, fn -> new Texture(fn));
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
    * Renders the images to the screen and setting up basic setup for all Screens. This calls the renderChild method
    * that child Screens will implement and render for the specific Screen.
    * @param deltaTime
    */
   @Override
   public void render(float deltaTime) {
      Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
      Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
      viewport.getCamera().update();
      batch.setProjectionMatrix(viewport.getCamera().combined);
      batch.begin();
      renderChild(deltaTime);
      batch.end();
   }

   /**
    * ChildScreens must implement this for the Screen's specific implementation.
    * @param deltaTime
    */
   protected abstract void renderChild(float deltaTime);

   @Override
   public void resize(int width, int height) {
      //
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
   }

   /**
    * Set the background color for the Screen. The default is 0, 0, 0, or black.
    * @param color
    */
   public void setBackgroundColor(Color color) {
      bgColor = color;
   }

   /**
    * Set the background color for the Screen. The default is 0, 0, 0, or black.
    * @param red
    * @param green
    * @param blue
    */
   public void setBackgroundColor(float red, float green, float blue) {
      bgColor = new Color(red, green, blue, 0f);
   }

   /**
    * Set the background color for the Screen from RGB 0-255 range. The range is converted to decimal 0.0 to 1.0..
    * @param red
    * @param green
    * @param blue
    */
   public void setBackgroundColor(int red, int green, int blue) {
      bgColor = new Color(red / 255.0f, green / 255.0f, blue / 255.0f, 0f);
   }

}
