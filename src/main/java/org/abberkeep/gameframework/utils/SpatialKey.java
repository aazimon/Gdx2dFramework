/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.utils;

/**
 * Title: SpatialKey
 *
 * <p>
 * Description: The SpatialKey used in the SpatialTree for setting X and Y
 * values within the TreeMap.
 *
 * Copyright (c) Sep 21, 2023
 *
 * @author Gary Deken
 * @version 0.10
 */
public class SpatialKey implements Comparable<SpatialKey> {
   private int x;
   private int y;
   private float xf;
   private float key;

   public SpatialKey(int x, int y, float xf) {
      this.x = x;
      this.y = y;
      this.xf = xf;
      key = (y * SpatialTree.FACTORAL) + xf;
   }

   @Override
   public int compareTo(SpatialKey other) {
      return Float.compare(key, other.getKey());
   }

   @Override
   public boolean equals(Object obj) {
      SpatialKey ok = (SpatialKey) obj;
      return key == ok.key;
   }

   public float getKey() {
      return key;
   }

   public int getX() {
      return (int) x;
   }

   public float getXf() {
      return xf;
   }

   public int getY() {
      return y;
   }

   @Override
   public int hashCode() {
      return Float.hashCode(key);
   }

   public void increaseX() {
      xf += SpatialTree.OFFSET;
      key = (y * SpatialTree.FACTORAL) + xf;
   }

   public void setX(int x) {
      this.x = x;
   }

   public void setXf(float xf) {
      this.xf = xf;
   }

   public void setY(int y) {
      this.y = y;
   }

}
