/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.movement;

import com.badlogic.gdx.Gdx;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: TwoKeyMovement
 *
 * <p>
 * Description: Encapsulates getting the input from two keys and determines the
 * direction and the amount of movement for the update. This works either in a
 * horizontal or horizontal direction.</p>
 *
 * Copyright (c) Jun 22, 2023
 *
 * @author Gary Deken
 * @version 0.7
 */
public class TwoKeyMovement extends BaseMovement {
   private int[] keyIds = new int[2];
   private boolean horizontal = true;

   /**
    * Constructs a TwoKeyMovement, with the key IDs and speed. If the direction
    * is vertical (keyId1 is up, keyId2 is down) or horizontal (keyId1 is right,
    * keyId2 is left). The horizontal flag is for determining if the movement is
    * horizontal or vertical.
    *
    * @param keyId1
    * @param keyId2
    * @param speed
    * @param horizontal
    */
   public TwoKeyMovement(int keyId1, int keyId2, float speed, boolean horizontal) {
      keyIds[0] = keyId1;
      keyIds[1] = keyId2;
      this.speed = speed;
      this.horizontal = horizontal;
   }

   @Override
   public void handleCollision(SpriteUpdate spriteUpdate, BoundingBox other) {
      // Do nothing.
   }

   @Override
   public void update(float deltaTime, SpriteUpdate spriteUpdate) {
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
      spriteUpdate.setLocation(spriteUpdate.getX() + xUpdate, spriteUpdate.getY() + yUpdate);
   }

}
