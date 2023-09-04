/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: RandomAnimation
 *
 * <p>
 * Description: An Animation that renders random frames, either with no end are a set number of cycles for the total
 * duration.</p>
 *
 * Copyright (c) Apr 15, 2023
 * @author Gary Deken
 * @version 0.5
 */
public class RandomAnimation extends BaseAnimation {
   private TextureRegion[] frames;
   private float animationDuration;
   private int currentIndex = 0;
   private Updatable randomUpdate;
   private int lastFrameIndex;
   private float lastStateTime;
   private boolean playSound = true;
   private int countIndex = 0;

   /**
    * Creates a RandomAnimation that randomly renders frames continuously.
    * @param frameDuration
    * @param region
    */
   public RandomAnimation(float frameDuration, TextureRegion[] region) {
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      randomUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         currentIndex = (int) (stateTime / frameDuration);
         int lastFrame = (int) ((lastStateTime) / frameDuration);
         if (lastFrame != currentIndex) {
            currentIndex = MathUtils.random(frames.length - 1);
            countIndex++;
         } else {
            currentIndex = lastFrameIndex;
         }
         lastFrameIndex = currentIndex;
         lastStateTime = stateTime;
         if (sound != null) {
            updateSound();
         }
      };
   }

   public RandomAnimation(float frameDuration, TextureRegion[] region, int numberOfCycles) {
      if (numberOfCycles < 1) {
         throw new IllegalArgumentException("The numberOfCycles must be one or greater.");
      }
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      randomUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         currentIndex = (int) (stateTime / frameDuration);
         int cycleNumber = (int) (stateTime / animationDuration);
         if (cycleNumber < numberOfCycles) {
            int lastFrame = (int) ((lastStateTime) / frameDuration);
            if (lastFrame != currentIndex) {
               currentIndex = MathUtils.random(frames.length - 1);
               countIndex++;
            } else {
               currentIndex = lastFrameIndex;
            }
            lastFrameIndex = currentIndex;
            lastStateTime = stateTime;
         } else {
            currentIndex = lastFrameIndex;
         }
         if (sound != null) {
            updateSound();
         }
      };

   }

   /**
    * Updates the sequence of the images to be displayed to the screen.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      randomUpdate.update(deltaTime);
   }

   /**
    * Renders the TextureRegion to the screen based on the location provided and the parameters set by other methods.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      batch.draw(frames[currentIndex], x + xOffset, y + yOffset, originX, originY, width, height, 1, 1, rotation);
   }

   private void updateSound() {
      if (countIndex >= frames.length) {
         countIndex = 0;
      }
      if (playSound && countIndex == 0) {
         sound.play();
         playSound = false;
      } else if (countIndex > 0) {
         playSound = true;
      }
   }

}
