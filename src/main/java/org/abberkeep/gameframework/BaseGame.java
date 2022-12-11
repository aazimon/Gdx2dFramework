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
 * Description: </p>
 *
 * Copyright (c) Dec 9, 2022
 * @author Gary Deken
 * @version
 */
public class BaseGame extends Game {
   protected SpriteBatch batch;
   protected float height = 600;
   protected float width = 800;
   protected OrthographicCamera camera;

   protected BaseGame() {
   }

   @Override
   public void create() {
      batch = new SpriteBatch();
      camera = new OrthographicCamera();
      camera.setToOrtho(false, width, height);
      camera.position.set(width / 2, height / 2, 0);
      camera.update();
   }

   @Override
   public void dispose() {
      super.dispose();
      batch.dispose();
   }

   @Override
   public void render() {
      ScreenUtils.clear(1, 0, 0, 1);
      batch.setProjectionMatrix(camera.combined);
      super.render();
   }

   @Override
   public void resize(int width, int height) {
      super.resize(width, height);
      camera.setToOrtho(false, width, height);
   }

   @Override
   public void setScreen(Screen screen) {
      ((BaseScreen) screen).setBatch(batch);
      super.setScreen(screen);
   }

}
