/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.movement;

import com.badlogic.gdx.Gdx;

/**
 * Title: TwoKeyMovement
 *
 * <p>
 * Description: Encapsulates getting the input from two keys and determines the direction and the amount of movement for
 * the update. This works either in a horizontal or horizontal direction.</p>
 *
 * Copyright (c) Jun 22, 2023
 * @author Gary Deken
 * @version 0.7
 */
public class TwoKeyMovement extends BaseMovement {
   private int[] keyIds = new int[2];
   private boolean horizontal = true;

   /**
    * Constructs a TwoKeyMovement, with the key IDs. If the direction is vertical (keyId1 is up, keyId2 is down) or
    * horizontal (keyId1 is right, keyId2 is left).
    * @param keyId1
    * @param keyId2
    * @param horizontal
    */
   public TwoKeyMovement(int keyId1, int keyId2, boolean horizontal) {
      keyIds[0] = keyId1;
      keyIds[1] = keyId2;
      this.horizontal = horizontal;
   }

   @Override
   public void update(float deltaTime) {
      if (Gdx.input.isKeyPressed(keyIds[0])) {
         // up or right
         if (horizontal) {
            xUpdate = speed;
            direction = Direction.EAST;
         } else {
            yUpdate = speed;
            direction = Direction.NORTH;
         }
      } else if (Gdx.input.isKeyPressed(keyIds[1])) {
         // down or left
         if (horizontal) {
            xUpdate = -speed;
            direction = Direction.WEST;
         } else {
            yUpdate = -speed;
            direction = Direction.SOUTH;
         }
      } else {
         xUpdate = 0;
         yUpdate = 0;
      }
   }

}
