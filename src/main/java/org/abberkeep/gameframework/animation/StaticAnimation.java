/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.animation.imagefx.ImageEffect;
import org.abberkeep.gameframework.animation.imagefx.ScaleEffect;

/**
 * Title: StaticAnimation
 *
 * <p>
 * Description: An Animation for rending a still Texture.</p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version 1
 * @since 0.4
 */
public class StaticAnimation extends BaseAnimation {
   private Texture texture;
   protected ImageEffect imageFX;

   /**
    * Constructs a StaticAnimation based on the images size.
    * @param texture
    */
   public StaticAnimation(Texture texture) {
      this(texture, texture.getWidth(), texture.getHeight());
   }

   /**
    * Constructs a StaticAnimation and resizing it.
    * @param texture
    * @param width
    * @param height
    */
   public StaticAnimation(Texture texture, float width, float height) {
      this.texture = texture;
      this.width = width;
      this.height = height;
      imageFX = new ScaleEffect(width, height);
      imageFX.initialize(this);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      imageFX.draw(batch, texture, x, y);
   }

   /**
    * Sets the how the StaticAnimation renders. The default is a ScaleEffect based on the images size or the values
    * passed into the Constructor.
    * @param imageFX
    */
   public void setImageFX(ImageEffect imageFX) {
      this.imageFX = imageFX;
   }

   /**
    * StaticAnimations have no update.
    * @param deltaTime
    */
   @Override
   public void update(float deltaTime) {
      // no update.
   }

}
