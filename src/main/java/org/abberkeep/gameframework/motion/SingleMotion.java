/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: SingleMotion
 *
 * <p>
 * Description: SingleMotion is a simple motion that has the same Animation for all directions of a Sprite.</p>
 *
 * Copyright (c) May 18, 2023
 * @author Gary Deken
 * @version 0.6
 */
public class SingleMotion implements Motion {
   private Animation animation;

   public SingleMotion(Animation animation) {
      this.animation = animation;
   }

   /**
    * Draws the single Animation to the screen.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animation.draw(batch, x, y);
   }

   /**
    * Updates the SingleMotion for the deltaTime and direction.
    * @param deltaTime
    * @param direction
    */
   @Override
   public void update(float deltaTime, float direction) {
      animation.update(deltaTime);
   }

}
