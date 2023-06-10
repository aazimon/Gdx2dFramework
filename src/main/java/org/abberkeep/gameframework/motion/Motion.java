/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: Motion
 *
 * <p>
 * Description: This interface encapsulates the Animations based on the direction of the Sprite. These classes will
 * maintain the Animation objects that the motion uses, updating the correct one and return the current image to be
 * displayed based on the direction of the sprite. There will be an Animation for each direction that the Game Piece
 * will need motion for.</p>
 *
 * Copyright (c) May 14, 2023
 * @author Gary Deken
 * @version 0.6
 */
public interface Motion {

   /**
    * Draws the Motion on the Screen, based on the underlining Animation class.
    * @param batch
    * @param x
    * @param y
    */
   void draw(SpriteBatch batch, float x, float y);

   /**
    * Updates the Motion, where the implementing class will determine the Animation to update based on the Direction
    * passed in.
    * @param deltaTime
    * @param direction
    */
   void update(float deltaTime, float direction);
}
