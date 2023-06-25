/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.screen;

import com.badlogic.gdx.Gdx;

/**
 * Title: ScreenInput
 *
 * <p>
 * Description: A wrapper around the Gdx.input static class. This class takes in account the Screen size and adjusts the
 * Vertical position for zero being on the bottom of the screen.</p>
 *
 * Copyright (c) Jun 10, 2023
 * @author Gary Deken
 * @version 0.7
 */
public class ScreenInput {
   private static int width;
   private static int height;

   public static final int getDeltaX() {
      return Gdx.input.getDeltaX();
   }

   public static final int getDeltaY() {
      return -Gdx.input.getDeltaY();
   }

   public static final int getX() {
      return Gdx.input.getX();
   }

   public static final int getY() {
      return ScreenInput.height - Gdx.input.getY();
   }

   public static final void setScreenSize(int screenWidth, int screenHeight) {
      ScreenInput.width = screenWidth;
      ScreenInput.height = screenHeight;
   }

}
