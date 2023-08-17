/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: Sprite
 *
 * <p>
 * Description: The base Sprite class for all game items. This base class holds attributes that are common to all
 * displayed elements within the game.</p>
 *
 * Copyright (c) Aug 5, 2023
 * @author Gary Deken
 * @version 0.9
 */
public abstract class Sprite implements Updatable, SpriteUpdate {
   protected float x;
   protected float y;
   protected int height = 1;
   protected int width = 1;

   public Sprite(int width, int height) {
      this.width = width;
      this.height = height;
   }

   /**
    * Draws the Sprite on the Screen. Location of the Sprite is held internal to the Sprite class, and those values are
    * passed down to the Animation class. Each child class must implement this method for how the child should be drawn.
    * @param batch
    */
   public abstract void draw(SpriteBatch batch);

   @Override
   public abstract void update(float deltaTime);

   /**
    * Returns the height of this Sprite in pixels.
    * @return float
    */
   public int getHeight() {
      return height;
   }

   /**
    * Returns the width of this Sprite in pixels.
    * @return int
    */
   public int getWidth() {
      return width;
   }

   /**
    * Returns the X location of this sprite
    * @return float
    */
   @Override
   public float getX() {
      return x;
   }

   /**
    * Returns the Y location of this sprite
    * @return float
    */
   @Override
   public float getY() {
      return y;
   }

   /**
    * Sets the height of this Sprite in pixels.
    * @param height
    */
   public void setHeight(int height) {
      this.height = height;
   }

   @Override
   public void setLocation(float x, float y) {
      this.x = x;
      this.y = y;
   }

   /**
    * Sets the width and height of this Sprite in pixels.
    * @param width
    * @param height
    */
   public void setSize(int width, int height) {
      this.width = width;
      this.height = height;
   }

   /**
    * Sets the width of this Sprite in pixels.
    * @param width
    */
   public void setWidth(int width) {
      this.width = width;
   }

   /**
    * Sets the X location of this Sprite.
    * @param x
    */
   @Override
   public void setX(float x) {
      this.x = x;
   }

   /**
    * Sets the Y location of this Sprite.
    * @param y
    */
   @Override
   public void setY(float y) {
      this.y = y;
   }

}
