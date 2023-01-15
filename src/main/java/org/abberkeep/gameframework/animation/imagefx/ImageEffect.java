/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.animation.imagefx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.Animation;

/**
 * Title: RenderAnimation
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version
 */
public interface ImageEffect {

   /**
    * Draws the Animation to the screen.
    * @param batch
    * @param x
    * @param y
    */
   void draw(SpriteBatch batch, Texture texture, float x, float y);

   void initialize(Animation animation);

}
