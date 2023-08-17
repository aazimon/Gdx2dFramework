/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Title: StaticRegionAnimation
 *
 * <p>
 * Description: An Animation for rending a still TextureRegion.</p>
 *
 * Copyright (c) Aug 7, 2023
 * @author Gary Deken
 * @version 0.9
 */
public class StaticRegionAnimation extends BaseAnimation {
   private TextureRegion region;

   /**
    * Constructs a StaticRegionAnimation based on the TextureRegion's size.
    * @param region
    */
   public StaticRegionAnimation(TextureRegion region) {
      this.region = region;
      this.width = region.getRegionWidth();
      this.height = region.getRegionHeight();
      this.originX = width / 2;
      this.originY = height / 2;
   }

   /**
    * StaticRegionAnimations have no update.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      // no update.
   }

   /**
    * Renders the TextureRegion to the screen based on the location provided and the parameters set by other methods.
    * @param batch
    * @param x
    * @param y
    */
   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      batch.draw(region, x + xOffset, y + yOffset, originX, originY, width, height, 1, 1, rotation);
   }

}
