/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: LoopAnimation
 *
 * <p>
 * Description: An Animation that loops through the images, either with no end are a set number of loops.</p>
 *
 * Copyright (c) Apr 15, 2023
 * @author Gary Deken
 * @version 0.5
 */
public class LoopAnimation extends BaseAnimation {
   private Updatable loopUpdate;
   private float stateTime;
   private int currentIndex = 0;
   private TextureRegion[] frames;
   private float animationDuration;

   /**
    * Creates a LoopAnimation that loops continuously.
    * @param frameDuration
    * @param region
    */
   public LoopAnimation(float frameDuration, TextureRegion[] region) {
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      loopUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         currentIndex = (int) (stateTime / frameDuration);
         currentIndex = currentIndex % frames.length;
      };
   }

   /**
    * Creates a LoopAnimation that loops for a set number of times. The number of loops must be positive
    * @param frameDuration
    * @param region
    * @param numberOfLoops
    * @throws IllegalArgumentException when the numberOfLoops is zero or negative.
    */
   public LoopAnimation(float frameDuration, TextureRegion[] region, int numberOfLoops) {
      if (numberOfLoops < 1) {
         throw new IllegalArgumentException("The numberOfLoops needs to be one or greater.");
      }
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      loopUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         currentIndex = (int) (stateTime / frameDuration);
         int loopNumber = (int) (stateTime / animationDuration);
         if (loopNumber < numberOfLoops) {
            currentIndex = currentIndex % frames.length;
         } else {
            currentIndex = Math.min(frames.length - 1, currentIndex);
         }
      };
   }

   /**
    * Updates the sequence of the images to be displayed to the screen.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      loopUpdate.update(deltaTime);
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

}
