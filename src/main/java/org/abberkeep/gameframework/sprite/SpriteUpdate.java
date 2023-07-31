/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework.sprite;

/**
 * Title: SpriteUpdate
 *
 * <p>
 * Description: Interface for handling updates to the Sprite class. This is used in the Movement interface, exposing the
 * methods needed to allow the Movement classes to change the Sprite's location.</p>
 *
 * Copyright (c) Jul 1, 2023
 * @author Gary Deken
 * @version 0.8
 */
public interface SpriteUpdate {

   /**
    * Returns the Sprite's X location.
    * @return
    */
   float getX();

   /**
    * Returns the Sprite's Y location.
    * @return
    */
   float getY();

   /**
    * Sets the Sprite's X location.
    * @param x
    */
   void setX(float x);

   /**
    * Sets the Sprite's Y location.
    * @param y
    */
   void setY(float y);

}
