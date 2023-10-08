/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @version 0.10
 */
public class BoundingBox {
   private int x;
   private int y;
   private int width;
   private int height;

   public BoundingBox(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }

   public boolean contains(BoundingBox other) {
      return (checkX(other) && checkY(other));
   }

   public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
   }

   private boolean checkX(BoundingBox other) {
      // x <= oX <= x+w
      // ox <= x <= ox+ow
      return (x <= other.x && other.x <= x + width)
            || (other.x <= x && x <= other.x + other.width);
   }

   private boolean checkY(BoundingBox other) {
      // y <= oy <= y+h
      // oy <= y <= oy+oh
      return (y <= other.y && other.y <= y + height)
            || (other.y <= y && y <= other.y + other.height);
   }

}
