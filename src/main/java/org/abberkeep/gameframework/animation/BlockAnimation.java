/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: BlockAnimation
 *
 * <p>
 * Description: Creates a rectangle block, from a single pixel white image, Animation. The pixel image (a static
 * Texture) can be resized and colorized. It can also be rotated.</p>
 *
 * Copyright (c) Jun 10, 2023
 * @author Gary Deken
 * @version 0.7
 */
public class BlockAnimation extends BaseAnimation {
   private static Texture texture;

   /**
    * Creates a BlockAnimation with the given width and height.
    * @param width
    * @param height
    */
   public BlockAnimation(int width, int height) {
      if (texture == null) {
         texture = new Texture("blank.png");
      }
      color = Color.WHITE;
      this.width = width;
      this.height = height;
   }

   @Override
   public void update(float deltaTime) {
      // do nothing
   }

   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      batch.draw(texture, x + xOffset, y + yOffset, width, height);
   }

}
