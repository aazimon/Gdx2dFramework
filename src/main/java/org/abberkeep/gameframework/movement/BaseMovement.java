/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.movement;

import org.abberkeep.gameframework.utils.FastMath;

/**
 * Title: BaseMovement
 *
 * <p>
 * Description: This base class holds all the attributes associated with all Movment classes.</p>
 *
 * Copyright (c) Jun 22, 2023
 * @author Gary Deken
 * @version 0.7
 */
public abstract class BaseMovement implements Movement {
   protected float xUpdate;
   protected float yUpdate;
   protected float direction;
   protected float speed;

   @Override
   public float getDirection() {
      return direction;
   }

   @Override
   public float getXUpdate() {
      return xUpdate;
   }

   @Override
   public float getYUpdate() {
      return yUpdate;
   }

   @Override
   public void setSpeed(float speed) {
      this.speed = speed;
   }

   /**
    * Calculates the X and Y update values based on the direction and updateSpeed. The updateSpeed is number of pixels
    * per second. If the updateSpeed is zero it does not calculate magnitudes, setting those to zero.
    *
    * @param direction
    * @param updateSpeed
    */
   protected void calculateMagnitudesByDirection(float direction, float updateSpeed) {
      this.direction = direction;
      if (updateSpeed > 0) {
         // calculate the x & y distance based on the direction and speed.
         double radians = Math.toRadians(direction);
         yUpdate = (float) (FastMath.fastSin(radians) * speed);
         xUpdate = (float) (FastMath.fastCos(radians) * speed);
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
