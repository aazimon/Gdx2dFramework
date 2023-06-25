/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.movement;

/**
 * Title: Movement
 *
 * <p>
 * Description: This interface is for implementing a movement control system, either through the Keyboard, mouse or
 * other device.</p>
 *
 * Copyright (c) Jun 22, 2023
 * @author Gary Deken
 * @version 0.7
 */
public interface Movement {

   /**
    * returns the direction of the movement in degrees (0 to 360)
    * @return
    */
   float getDirection();

   /**
    * This returns the amount of the X movement for a given update.
    * @return double
    */
   float getXUpdate();

   /**
    * This returns the amount of the Y movement for a given update.
    * @return double
    */
   float getYUpdate();

   /**
    * This method takes the delta time, since the last update, and determines the movement since. The amount of the
    * movement is returned through the getXUpdate() and getYUpdate().
    * @param deltaTime float
    */
   void update(float deltaTime);

   /**
    * Set the speed, as in pixels per second.
    * @param speed
    */
   void setSpeed(float speed);

}