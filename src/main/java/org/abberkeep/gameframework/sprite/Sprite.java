/*
 * Copyright (c) 2023 Gary Deken
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
   protected int layer;
   protected int height = 1;
   protected int width = 1;
   protected int depth = 1;
   protected BoundingBox bounds;
   protected boolean remove;

   protected Sprite(int width, int height) {
      this.width = width;
      this.height = height;
      bounds = new BoundingBox(0, 0, 0, width, height);
   }

   /**
    * Returns if this Sprite moves and can impact other Sprites
    * @return
    */
   public abstract boolean doesImpact();

   /**
    * Draws the Sprite on the Screen. Location of the Sprite is held internal to the Sprite class, and those values are
    * passed down to the Animation class. Each child class must implement this method for how the child should be drawn.
    * @param batch
    */
   public abstract void draw(SpriteBatch batch);

   @Override
   public abstract void update(float deltaTime);

   /**
    * Determines if this Sprite contains any points from the other Sprite.
    * @param other
    * @return
    */
   public boolean contains(Sprite other) {
      if (!other.equals(this)) {
         return bounds.contains(other.bounds);
      }
      return false;
   }

   @Override
   public boolean contains(BoundingBox other) {
      return bounds.contains(other);
   }

   /**
    * Returns true if the point is within the bounds of this BoundingBox, otherwise it returns false.
    * @param x
    * @param y
    * @param layer
    * @return
    */
   @Override
   public boolean contains(int x, int y, int layer) {
      return bounds.contains(x, y, layer);
   }

   /**
    * Returns the Bounds (BoundingBox) so that he insets and width/height can be adjusted based on the needs.
    * @return Bounds
    */
   public Bounds getBounds() {
      return bounds;
   }

   /**
    * Returns the depth of this Sprite in Layers. This is the front to back value, as in the number of layers the Sprite
    * is in.
    * @return
    */
   public int getDepth() {
      return depth;
   }

   /**
    * Returns the height of this Sprite in pixels.
    * @return float
    */
   public int getHeight() {
      return height;
   }

   /**
    * Returns the layer location of this Sprite.
    * @return int
    */
   @Override
   public int getLayer() {
      return layer;
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
    * Handle the collision with the other sprite.
    * @param other
    */
   public void handleCollision(Sprite other) {
      // do nothing by default
   }

   /**
    * This returns true if the Sprite is moving from one layer to another. Decor, for example, will not move from one
    * layer to another.
    * @return
    */
   public boolean isChangingLayer() {
      return false;
   }

   /**
    * This tells the Screen if this Sprite should be removed from the Screen.
    * @return boolean
    */
   public boolean isRemove() {
      return remove;
   }

   /**
    * Sets the depth (Number of layers) for this Sprite.
    * @param depth
    */
   public void setDepth(int depth) {
      this.depth = depth;
   }

   /**
    * Sets the height of this Sprite in pixels.
    * @param height
    */
   public void setHeight(int height) {
      this.height = height;
      bounds.setSize(width, height);
   }

   /**
    * Sets the layer location of this Sprite. This does not take into account the actual number of layers in the Screen.
    * @param layer
    */
   @Override
   public void setLayer(int layer) {
      this.layer = layer;
      bounds.setLayer(layer);
   }

   @Override
   public void setLocation(float x, float y) {
      this.x = x;
      this.y = y;
      bounds.setLocation((int) x, (int) y);
   }

   @Override
   public void setLocation(float x, float y, int layer) {
      this.x = x;
      this.y = y;
      this.layer = layer;
      bounds.setLocation((int) x, (int) y);
      bounds.setLayer(layer);
   }

   @Override
   public void setRemove(boolean remove) {
      this.remove = remove;
   }

   /**
    * Sets the width and height of this Sprite in pixels.
    * @param width
    * @param height
    */
   public void setSize(int width, int height) {
      this.width = width;
      this.height = height;
      bounds.setSize(width, height);
   }

   /**
    * Sets the width of this Sprite in pixels.
    * @param width
    */
   public void setWidth(int width) {
      this.width = width;
      bounds.setSize(width, height);
   }

   /**
    * Sets the X location of this Sprite.
    * @param x
    */
   @Override
   public void setX(float x) {
      this.x = x;
      bounds.setLocation((int) x, (int) y);
   }

   /**
    * Sets the Y location of this Sprite.
    * @param y
    */
   @Override
   public void setY(float y) {
      this.y = y;
      bounds.setLocation((int) x, (int) y);
   }

}
