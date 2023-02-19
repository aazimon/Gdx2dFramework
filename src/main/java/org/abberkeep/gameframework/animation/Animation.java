/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: Animation
 *
 * <p>
 * Description: An Interface for abstracting out the still images and animated images.</p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version 1
 * @since 0.4
 */
public interface Animation extends Updatable {

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
   @Override
   void update(float deltaTime);
}
