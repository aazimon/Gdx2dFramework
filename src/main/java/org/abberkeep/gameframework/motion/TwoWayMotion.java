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
 * Title: TwoWayMotion
 *
 * <p>
 * Description: Controls the Animations in two directions. The direction must be opposite of each other, and either
 * vertical or horizontal.</p>
 *
 * Copyright (c) May 18, 2023
 * @author Gary Deken
 * @version 0.6
 */
public class TwoWayMotion extends BaseMotion {
   private boolean horizontal = true;

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. If the direction
    * is vertical (directionOne is up, directionTwo is down) or horizontal (directionOne is right, directionTwo is
    * left).
    *
    * @param directionOne
    * @param directionTwo
    */
   public TwoWayMotion(Animation directionOne, Animation directionTwo) {
      animations = new Animation[2];
      animations[0] = directionOne;
      animations[1] = directionTwo;
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into LoopAnimations where the first TextureRegion array is Right or Up, and
    * the second TextureRegion array is Left or Down.
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    */
   public TwoWayMotion(Texture texture, int tileWidth, int tileHeight, float duration) {
      animations = new Animation[2];
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[0] = new LoopAnimation(duration, textureRegions[0]);
      animations[1] = new LoopAnimation(duration, textureRegions[1]);
   }

   /**
    * Creates a TwoWayMotion to control the animation. The animation changes as the direction changes. The Texture is
    * split into a TextureRegion and made into a LoopAnimation where the direction0 of the TextureRegion array is Right
    * or Up, and the direction1 of the TextureRegion array is Left or Down.
    * @param texture
    * @param tileWidth
    * @param tileHeight
    * @param duration
    * @param direction0
    * @param direction1
    */
   public TwoWayMotion(Texture texture, int tileWidth, int tileHeight, float duration, int direction0, int direction1) {
      animations = new Animation[2];
      TextureRegion[][] textureRegions = TextureRegion.split(texture, tileWidth, tileHeight);
      animations[0] = new LoopAnimation(duration, textureRegions[direction0]);
      animations[1] = new LoopAnimation(duration, textureRegions[direction1]);
   }

   /**
    * Draws the Animation based on the direction determined by the update method.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      animations[currentIndex].draw(batch, x, y);
   }

   /**
    * Set the direction of this Motion to be horizontal (East and West) or vertical (North and South).
    * @param horizontal
    */
   public void setHorizontal(boolean horizontal) {
      this.horizontal = horizontal;
   }

   @Override
   public void setDirection(float direction) {
      setDirectionIndex(direction);
   }

   /**
    * Updates the Animation based on the direction passed in. It will check if the Motion is vertical or horizontal.
    * @param deltaTime
    * @param direction
    */
   @Override
   public void update(float deltaTime, float direction) {
      setDirectionIndex(Direction.convertTo360Degrees(direction));
      animations[currentIndex].update(deltaTime);
   }

   private void setDirectionIndex(float direction) {
      currentIndex = 1;
      if (horizontal) {
         if (direction <= Direction.NORTH || direction > Direction.SOUTH) {
            currentIndex = 0;
         }
      } else {
         if (direction >= Direction.EAST && direction < Direction.WEST) {
            currentIndex = 0;
         }
      }
   }

}
