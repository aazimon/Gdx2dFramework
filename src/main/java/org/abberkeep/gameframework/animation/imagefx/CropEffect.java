/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation.imagefx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: CropImage
 *
 * <p>
 * Description: Crops the image, thus making it smaller. If the crop value is outside the original image size, the edge
 * pixels are repeated. A cropped</p>
 *
 * Copyright (c) Jan 14, 2023
 * @author Gary Deken
 * @version
 */
public class CropEffect implements ImageEffect {
   private int xStart;
   private int xEnd;
   private int yStart;
   private int yEnd;

   public CropEffect(int xStart, int yStart, int xEnd, int yEnd) {
      this.xStart = xStart;
      this.yStart = yStart;
      this.xEnd = xEnd;
      this.yEnd = yEnd;
   }

   @Override
   public void draw(SpriteBatch batch, Texture texture, float x, float y) {
      batch.draw(texture, x, y, xStart, yStart, xEnd, yEnd);
   }

   @Override
   public void initialize(Animation animation) {
      // Do nothing
   }

}
