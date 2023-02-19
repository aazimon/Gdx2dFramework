/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.abberkeep.gameframework;

/**
 * Title: Updatable
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Feb 17, 2023
 * @author Gary Deken
 * @version 0.5
 */
public interface Updatable {

   /**
    * This method takes the elapse time between rendered frames.
    *
    * @param deltaTime float
    */
   void update(float deltaTime);
}
