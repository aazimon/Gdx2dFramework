/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Color;
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

   int getHeight();

   int getWidth();

   /**
    * Set the color for the Animation, by the LibGdx Color object. The default is White.
    * @param color
    */
   void setColor(Color color);

   /**
    * Set the color for the Animation by percentage (0.0 to 1.0). The default is 1, 1, 1, or white.
    * @param red
    * @param green
    * @param blue
    */
   void setColor(float red, float green, float blue);

   /**
    * Set the color for the Animation from RGB 0-255 range. The range is converted to a decimal 0.0 to 1.0.
    * @param red
    * @param green
    * @param blue
    */
   void setColor(int red, int green, int blue);

   /**
    * Sets the size of the Animation to the size that it will be drawn, resizing the image. This will also set the
    * rotation origin to the center of the image.
    * @param width
    * @param height
    */
   void setSize(int width, int height);

   /**
    * Sets the translucency of the Animation. This is the percentage that you can see through the image. 1 is normal, no
    * translucency. 0 is fully transparent.
    * @param percent
    */
   void setTranslucency(float percent);

   /**
    * Sets an X offset in pixel to render this Animation image.
    * @param xOffset
    */
   void setXOffSet(int xOffset);

   /**
    * Sets an Y offset in pixel to render this Animation image.
    * @param yOffset
    */
   public void setYOffset(int yOffset);

   /**
    * Updates the animation.
    * @param deltaTime
    */
   @Override
   void update(float deltaTime);
}
