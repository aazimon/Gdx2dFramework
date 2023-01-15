/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: Animation
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version
 */
public interface Animation {

   /**
    * Draws the Animation to the screen.
    * @param batch
    * @param x
    * @param y
    */
   void draw(SpriteBatch batch, float x, float y);

   float getHeight();

   float getWidth();

   /**
    * Updates the animation.
    * @param deltaTime
    */
   void update(float deltaTime);
}
