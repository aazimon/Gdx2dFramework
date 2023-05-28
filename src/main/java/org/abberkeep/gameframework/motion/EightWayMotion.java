/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.motion;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.movement.Direction;

/**
 * Title: EightWayMotion
 *
 * <p>
 * Description: Controls the Animations in eight Cardinal directions. The direction is North (or up), North East, East
 * (or right), South East, South (or down), South West, West (or left) and North West. The direction is simplified to
 * the eight Cardinal directions.</p>
 *
 * Copyright (c) May 18, 2023
 * @author Gary Deken
 * @version
 */
public class EightWayMotion implements Motion {
   private final static int NORTH = 0;
   private final static int NORTH_EAST = 1;
   private final static int EAST = 2;
   private final static int SOUTH_EAST = 3;
   private final static int SOUTH = 4;
   private final static int SOUTH_WEST = 5;
   private final static int WEST = 6;
   private final static int NORTH_WEST = 7;
   private Animation[] animations = new Animation[8];
   private int index;

   /**
    * Creates a FourWayMotion to control the animation. The animation changes as the direction changes.
    * @param north
    * @param northEast
    * @param east
    * @param southEast
    * @param south
    * @param southWest
    * @param west
    * @param northWest
    */
   public EightWayMotion(Animation north, Animation northEast, Animation east, Animation southEast, Animation south,
      Animation southWest, Animation west, Animation northWest) {
      animations[NORTH] = north;
      animations[NORTH_EAST] = northEast;
      animations[EAST] = east;
      animations[SOUTH_EAST] = southEast;
      animations[SOUTH] = south;
      animations[SOUTH_WEST] = southWest;
      animations[WEST] = west;
      animations[NORTH_WEST] = northWest;
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into a LoopAnimation, where the elements in the array are expected to be
    * arranged where the first row is the character moving North (or up), second is North East, the third is East (or
    * right), the fourth is South East, fifth is South (or down), the sixth is South West, the seventh is West (or left)
    * and the eight is North West.
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    */
   public EightWayMotion(Texture texture, int tileWidth, int tileHeight, float duration) {
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[NORTH] = new LoopAnimation(duration, textureRegions[0]);
      animations[NORTH_EAST] = new LoopAnimation(duration, textureRegions[1]);
      animations[EAST] = new LoopAnimation(duration, textureRegions[2]);
      animations[SOUTH_EAST] = new LoopAnimation(duration, textureRegions[3]);
      animations[SOUTH] = new LoopAnimation(duration, textureRegions[4]);
      animations[SOUTH_WEST] = new LoopAnimation(duration, textureRegions[5]);
      animations[WEST] = new LoopAnimation(duration, textureRegions[6]);
      animations[NORTH_WEST] = new LoopAnimation(duration, textureRegions[7]);
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into a LoopAnimation, where the elements are arranged where the north index is
    * the character moving North (or up), northEast index is North East, the east index is East (or right), the
    * southEast index is South East, south index is South (or down), the southWest index is South West, the west index
    * is West (or left) and the eight is North West.
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    * @param north
    * @param northEast
    * @param east
    * @param southEast
    * @param south
    * @param southWest
    * @param west
    * @param northWest
    */
   public EightWayMotion(Texture texture, int tileWidth, int tileHeight, float duration, int north, int northEast,
      int east, int southEast, int south, int southWest, int west, int northWest) {
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[NORTH] = new LoopAnimation(duration, textureRegions[north]);
      animations[NORTH_EAST] = new LoopAnimation(duration, textureRegions[northEast]);
      animations[EAST] = new LoopAnimation(duration, textureRegions[east]);
      animations[SOUTH_EAST] = new LoopAnimation(duration, textureRegions[southEast]);
      animations[SOUTH] = new LoopAnimation(duration, textureRegions[south]);
      animations[SOUTH_WEST] = new LoopAnimation(duration, textureRegions[southWest]);
      animations[WEST] = new LoopAnimation(duration, textureRegions[west]);
      animations[NORTH_WEST] = new LoopAnimation(duration, textureRegions[northWest]);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animations[index].draw(batch, x, y);
   }

   @Override
   public void update(float deltaTime, float direction) {
      direction = Direction.nearest8thDirection(direction);
      if (direction == Direction.NORTH) {
         index = NORTH;
      } else if (direction == Direction.NORTH_EAST) {
         index = NORTH_EAST;
      } else if (direction == Direction.EAST) {
         index = EAST;
      } else if (direction == Direction.SOUTH_EAST) {
         index = SOUTH_EAST;
      } else if (direction == Direction.SOUTH) {
         index = SOUTH;
      } else if (direction == Direction.SOUTH_WEST) {
         index = SOUTH_WEST;
      } else if (direction == Direction.WEST) {
         index = WEST;
      } else {
         index = NORTH_WEST;
      }
      animations[index].update(deltaTime);
   }

}
