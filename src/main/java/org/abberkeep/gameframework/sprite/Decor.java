/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: Decor
 *
 * <p>
 * Description: Defines a sprite that does not move on the screen. (Has no movement) The decor is static "image", once
 * placed it doesn't move.</p>
 *
 * Copyright (c) Aug 5, 2023
 * @author Gary Deken
 * @version 0.9
 */
public class Decor extends Sprite {
   protected Animation animation;

   public Decor(Animation animation) {
      super(animation.getWidth(), animation.getHeight());
      this.animation = animation;
   }

   @Override
   public boolean doesImpact() {
      return false;
   }


   @Override
   public void draw(SpriteBatch batch) {
      animation.draw(batch, x, y);
   }

   /**
    * Sets the Animation for this Decor. The Animation must not be null.
    * @param animation
    * @throws IllegalArgumentException
    */
   public void setAnimation(Animation animation) {
      if (animation == null) {
         throw new IllegalArgumentException("Animation must not be null.");
      }
      this.animation = animation;
   }

   @Override
   public void update(float deltaTime) {
      animation.update(deltaTime);
   }

}
