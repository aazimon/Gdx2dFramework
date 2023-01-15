/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation.imagefx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: ScaleImage
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 14, 2023
 * @author Gary Deken
 * @version
 */
public class ScaleEffect implements ImageEffect {
   private float width;
   private float height;

   public ScaleEffect(float width, float height) {
      this.width = width;
      this.height = height;
   }

   @Override
   public void draw(SpriteBatch batch, Texture texture, float x, float y) {
      batch.draw(texture, x, y, width, height);
   }

   @Override
   public void initialize(Animation animation) {
      this.width = animation.getWidth();
      this.height = animation.getHeight();
   }

}
