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
 * Title: FourWayMotion
 *
 * <p>
 * Description: Controls the Animations in four Cardinal directions. The direction is North (or up), East (or right),
 * South (or down) and West (or left). The direction is simplified to the four Cardinal directions.</p>
 *
 * Copyright (c) May 18, 2023
 * @author Gary Deken
 * @version 0.6
 */
public class FourWayMotion extends BaseMotion {
   private static final int NORTH = 0;
   private static final int EAST = 1;
   private static final int SOUTH = 2;
   private static final int WEST = 3;

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes.
    * @param north
    * @param east
    * @param south
    * @param west
    */
   public FourWayMotion(Animation north, Animation east, Animation south, Animation west) {
      animations = new Animation[4];
      animations[NORTH] = north;
      animations[EAST] = east;
      animations[SOUTH] = south;
      animations[WEST] = west;
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into a LoopAnimation, where the elements are expected to be arranged where the
    * first row is the character moving North (or up), second is East (or right), third is South (or down) and the
    * fourth is West (or left).
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    */
   public FourWayMotion(Texture texture, int tileWidth, int tileHeight, float duration) {
      animations = new Animation[4];
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[NORTH] = new LoopAnimation(duration, textureRegions[0]);
      animations[EAST] = new LoopAnimation(duration, textureRegions[1]);
      animations[SOUTH] = new LoopAnimation(duration, textureRegions[2]);
      animations[WEST] = new LoopAnimation(duration, textureRegions[3]);
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into a LoopAnimation, where the elements are arranged where the north row is
    * the character moving North (or up), east row is East (or right), the south row is South (or down) and the west row
    * is West (or left).
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    * @param north
    * @param east
    * @param south
    * @param west
    */
   public FourWayMotion(Texture texture, int tileWidth, int tileHeight, float duration, int north, int east, int south,
      int west) {
      animations = new Animation[4];
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[NORTH] = new LoopAnimation(duration, textureRegions[north]);
      animations[EAST] = new LoopAnimation(duration, textureRegions[east]);
      animations[SOUTH] = new LoopAnimation(duration, textureRegions[south]);
      animations[WEST] = new LoopAnimation(duration, textureRegions[west]);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animations[currentIndex].draw(batch, x, y);
   }

   @Override
   public void setDirection(float direction) {
      setIndex(direction);
   }

   @Override
   public void update(float deltaTime, float direction) {
      direction = Direction.nearest4thDirection(direction);
      setIndex(direction);
      animations[currentIndex].update(deltaTime);
   }

   private void setIndex(float direction) {
      if (direction == Direction.NORTH) {
         currentIndex = NORTH;
      } else if (direction == Direction.EAST) {
         currentIndex = EAST;
      } else if (direction == Direction.SOUTH) {
         currentIndex = SOUTH;
      } else {
         currentIndex = WEST;
      }
   }

}
