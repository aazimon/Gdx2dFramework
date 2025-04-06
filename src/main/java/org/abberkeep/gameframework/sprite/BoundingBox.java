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

/**
 * Title: BoundingBox
 *
 * <p>
 * Description: The bounds of a Sprite.</p>
 *
 * Copyright (c) Sept 17, 2023
 *
 * @author Gary Deken
 * @version 0.11
 */
public class BoundingBox implements Bounds {
   private int x;
   private int xInset = 0;
   private int y;
   private int yInset = 0;
   private int layer = 0;
   private int width;
   private int height;

   public BoundingBox(int x, int y, int layer, int width, int height) {
      this.x = x;
      this.y = y;
      this.layer = layer;
      this.width = width;
      this.height = height;
   }

   /**
    * Check if this BoundingBox contains the other BoundingBox. This checks if the layers match first, then if the
    * BoundingBox has points withing each other.
    * @param other
    * @return
    */
   public boolean contains(BoundingBox other) {
      return this.layer == other.layer && (checkX(other) && checkY(other));
   }

   /**
    * Check if the X and Y and Layer are all withing this BoundingBox. This checks if the layers match first, then if
    * the BoundingBox contains the X and Y locations.
    * @param x
    * @param y
    * @param layer
    * @return
    */
   public boolean contains(int x, int y, int layer) {
      return this.layer == layer && checkX(x) && checkY(y);
   }

   @Override
   public void setHeight(int height) {
      this.height = height;
   }

   @Override
   public void setLayer(int layer) {
      this.layer = layer;
   }

   public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public void setSize(int width, int height) {
      this.width = width;
      this.height = height;
   }

   public int getLayer() {
      return layer;
   }

   @Override
   public void setWidth(int width) {
      this.width = width;
   }

   @Override
   public void setXInset(int xInset) {
      this.xInset = xInset;
   }

   @Override
   public void setYInset(int yInset) {
      this.yInset = yInset;
   }

   /**
    * Returns the x location (left) plus the xInset to return the x edge.
    * @return int
    */
   int getXEdge() {
      return x + xInset;
   }

   /**
    * Returns the y location (bottom) minus the yInset to return the y edge.
    * @return int
    */
   int getYEdge() {
      return y + yInset;
   }

   private boolean checkX(int x) {
      // x <= oX < x+w
      return getXEdge() <= x && x < getXEdge() + width;
   }

   private boolean checkX(BoundingBox other) {
      // x <= oX < x+w
      // ox <= x < ox+ow
      return (getXEdge() <= other.getXEdge() && other.getXEdge() < getXEdge() + width)
         || (other.getXEdge() <= getXEdge() && getXEdge() < other.getXEdge() + other.width);
   }

   private boolean checkY(int y) {
      // y <= oy < y+h
      return getYEdge() <= y && y < getYEdge() + height;
   }

   private boolean checkY(BoundingBox other) {
      // y <= oy < y+h
      // oy <= y < oy+oh
      return (getYEdge() <= other.getYEdge() && other.getYEdge() < getYEdge() + height)
         || (other.getYEdge() <= getYEdge() && getYEdge() < other.getYEdge() + other.height);
   }

}
