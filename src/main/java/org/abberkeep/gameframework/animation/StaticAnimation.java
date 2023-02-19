/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: StaticAnimation
 *
 * <p>
 * Description: An Animation for rending a still Texture.</p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version 1
 * @since 0.4
 */
public class StaticAnimation extends BaseAnimation {
   private Texture texture;
   private int xStart = 0;
   private int xSrcWidth;
   private int yStart = 0;
   private int ySrcHeight;
   private boolean flipHorizontal = false;
   private boolean flipVertical = false;

   /**
    * Constructs a StaticAnimation based on the images size.
    * @param texture
    */
   public StaticAnimation(Texture texture) {
      this.texture = texture;
      xSrcWidth = texture.getWidth();
      ySrcHeight = texture.getHeight();
      width = texture.getWidth();
      height = texture.getHeight();
   }

   /**
    * Constructs a StaticAnimation and resizing it.
    * @param texture
    * @param width
    * @param height
    */
   public StaticAnimation(Texture texture, float width, float height) {
      this.texture = texture;
      xSrcWidth = texture.getWidth();
      ySrcHeight = texture.getHeight();
      this.width = width;
      this.height = height;
   }

   /**
    * Renders the image to the screen based on the location provided and the parameters set by other methods.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      batch.draw(texture, x, y, originX, originY, width, height, 1, 1, rotation, xStart, yStart, xSrcWidth, ySrcHeight,
         flipHorizontal, flipVertical);
   }

   /**
    * StaticAnimations have no update.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      // no update.
   }

   /**
    * Crops the image, with the starting X and Y locations within the image, and Width and Height from the starting to
    * the edge of the images. Any width or Height that goes beyond the original image size, will cause the last pixels
    * to repeat. The image will resize based on the Height and Width set for the Animation.
    * @param xStart
    * @param yStart
    * @param xSrcWidth
    * @param ySrcHeight
    */
   public void setCropping(int xStart, int yStart, int xSrcWidth, int ySrcHeight) {
      this.xStart = xStart;
      this.yStart = yStart;
      this.xSrcWidth = xSrcWidth;
      this.ySrcHeight = ySrcHeight;
      width = xSrcWidth;
      height = ySrcHeight;
      if (rotation != 0) {
         this.originX = width / 2;
         this.originY = height / 2;
      }
   }

   /**
    * Flips the image horizontally, side to side.
    * @param flipHorizontal
    */
   public void setFlipHorizontal(boolean flipHorizontal) {
      this.flipHorizontal = flipHorizontal;
   }

   /**
    * Flips the image vertically, top to bottom.
    * @param flipVertical
    */
   public void setFlipVertical(boolean flipVertical) {
      this.flipVertical = flipVertical;
   }

}
