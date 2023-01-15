/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import org.abberkeep.gameframework.animation.imagefx.ImageEffect;

/**
 * Title: BaseAnimation
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version
 */
public abstract class BaseAnimation implements Animation {
   protected float width;
   protected float height;
   protected ImageEffect imageFX;

   public void setImageFX(ImageEffect imageFX) {
      this.imageFX = imageFX;
   }

   @Override
   public float getHeight() {
      return height;
   }

   @Override
   public float getWidth() {
      return width;
   }

}
