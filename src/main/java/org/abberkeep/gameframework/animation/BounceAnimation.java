/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: BounceAnimation
 *
 * <p>
 * Description: An Animation that bounces back and forth through the images, either with no end are a set number of
 * bounces.</p>
 *
 * Copyright (c) Apr 15, 2023
 * @author Gary Deken
 * @version
 */
public class BounceAnimation extends BaseAnimation {
   private TextureRegion[] frames;
   private float animationDuration;
   private float stateTime;
   private int currentIndex = 0;
   private Updatable bounceUpdate;

   /**
    * Creates a BounceAnimation that bounces continuously.
    * @param frameDuration
    * @param region
    */
   public BounceAnimation(float frameDuration, TextureRegion[] region) {
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      bounceUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         currentIndex = (int) (stateTime / frameDuration);
         currentIndex = currentIndex % ((frames.length * 2) - 2);
         if (currentIndex >= frames.length) {
            currentIndex = frames.length - 2 - (currentIndex - frames.length);
         }
      };
   }

   /**
    * Creates a BounceAnimation that bounces for a set number of times. The number of bounces must be positive
    * @param frameDuration
    * @param region
    * @param numberOfBounces
    * @throws IllegalArgumentException when the numberOfBounces is zero or negative.
    */
   public BounceAnimation(float frameDuration, TextureRegion[] region, int numberOfBounces) {
      if (numberOfBounces < 1) {
         throw new IllegalArgumentException("The numberOfBounces must be one or greater.");
      }
      frames = region;
      animationDuration = frameDuration * frames.length;
      width = region[0].getRegionWidth();
      height = region[0].getRegionHeight();
      originX = width / 2;
      originY = height / 2;
      bounceUpdate = (deltaTime) -> {
         stateTime += deltaTime;
         int bounceNumber = (int) ((stateTime - frameDuration) / (animationDuration - frameDuration));
         if (bounceNumber < numberOfBounces) {
            currentIndex = (int) (stateTime / frameDuration);
            currentIndex = currentIndex % ((frames.length * 2) - 2);
            if (currentIndex >= frames.length) {
               currentIndex = frames.length - 2 - (currentIndex - frames.length);
            }
         }
      };
   }

   /**
    * Renders the TextureRegion to the screen based on the location provided and the parameters set by other methods.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      batch.draw(frames[currentIndex], x, y, originX, originY, width, height, 1, 1, rotation);
   }

   /**
    * Updates the sequence of the images to be displayed to the screen.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      bounceUpdate.update(deltaTime);
   }

}
