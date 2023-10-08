/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: MockAnimation
 *
 * <p>
 * Description:
 *
 * Copyright (c) Sep 21, 2023
 *
 * @author Gary Deken
 * @version
 */
public class MockAnimation implements Animation {
   private int height;
   private int width;

   public MockAnimation() {
      height = 10;
      width = 12;
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      // do nothing
   }

   @Override
   public int getHeight() {
      return height;
   }

   @Override
   public int getWidth() {
      return width;
   }

   @Override
   public void setColor(Color color) {
      // do nothing.
   }

   @Override
   public void setColor(float red, float green, float blue) {
      // do nothing.
   }

   @Override
   public void setColor(int red, int green, int blue) {
      // do nothing.
   }

   @Override
   public void setSize(int width, int height) {
      this.height = height;
      this.width = width;
   }

   @Override
   public void setSound(Sound sound) {
      // do nothing.
   }

   @Override
   public void setTranslucency(float percent) {
      // do nothing.
   }

   @Override
   public void setXOffSet(int xOffset) {
      // do nothing.
   }

   @Override
   public void setYOffset(int yOffset) {
      // do nothing.
   }

   @Override
   public void update(float deltaTime) {
      // do nothing.
   }

}
