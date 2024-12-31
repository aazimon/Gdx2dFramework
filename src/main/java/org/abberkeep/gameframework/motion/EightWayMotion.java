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
 * @version 0.6
 */
public class EightWayMotion extends BaseMotion {
   private static final int NORTH = 0;
   private static final int NORTH_EAST = 1;
   private static final int EAST = 2;
   private static final int SOUTH_EAST = 3;
   private static final int SOUTH = 4;
   private static final int SOUTH_WEST = 5;
   private static final int WEST = 6;
   private static final int NORTH_WEST = 7;

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
      animations = new Animation[8];
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
      animations = new Animation[8];
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
      animations = new Animation[8];
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
      animations[currentIndex].draw(batch, x, y);
   }

   @Override
   public void setDirection(float direction) {
      setDirectionIndex(direction);
   }

   @Override
   public void update(float deltaTime, float direction) {
      setDirectionIndex(Direction.nearest8thDirection(direction));
      animations[currentIndex].update(deltaTime);
   }

   private void setDirectionIndex(float direction) {
      if (direction == Direction.NORTH) {
         currentIndex = NORTH;
      } else if (direction == Direction.NORTH_EAST) {
         currentIndex = NORTH_EAST;
      } else if (direction == Direction.EAST) {
         currentIndex = EAST;
      } else if (direction == Direction.SOUTH_EAST) {
         currentIndex = SOUTH_EAST;
      } else if (direction == Direction.SOUTH) {
         currentIndex = SOUTH;
      } else if (direction == Direction.SOUTH_WEST) {
         currentIndex = SOUTH_WEST;
      } else if (direction == Direction.WEST) {
         currentIndex = WEST;
      } else {
         currentIndex = NORTH_WEST;
      }
   }

}
