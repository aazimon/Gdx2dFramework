/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: BaseAnimation
 *
 * <p>
 * Description: An abstract Animation class that has height and width of the all Animations.</p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version 1
 * @since 0.4
 */
public abstract class BaseAnimation implements Animation {
   protected float width;
   protected float height;
   protected float originX;
   protected float originY;
   protected float rotation;
   protected Color color;
   protected float translucency = 1f;

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      if (color != null) {
         batch.setColor(color);
         drawChild(batch, x, y);
         batch.setColor(Color.WHITE);
      } else {
         drawChild(batch, x, y);
      }
   }

   protected abstract void drawChild(SpriteBatch batch, float x, float y);

   @Override
   public float getHeight() {
      return height;
   }

   @Override
   public float getWidth() {
      return width;
   }

   @Override
   public void setColor(Color color) {
      this.color = new Color(color.r, color.g, color.b, translucency);
   }

   @Override
   public void setColor(float red, float green, float blue) {
      color = new Color(red, green, blue, translucency);
   }

   @Override
   public void setColor(int red, int green, int blue) {
      color = new Color(red / 255.0f, green / 255.0f, blue / 255.0f, translucency);
   }

   /**
    * Rotates the Animation based on the center of the image. As the image rotates the corners will break the boundaries
    * of the original Texture,
    * @param rotation
    */
   public void setRotation(float rotation) {
      this.rotation = rotation;
   }

   @Override
   public void setSize(float width, float height) {
      this.width = width;
      this.height = height;
      this.originX = width / 2;
      this.originY = height / 2;
   }

   @Override
   public void setTranslucency(float percent) {
      if (translucency != percent) {
         if (percent > 1f) {
            percent = 1f;
         } else if (percent < 0f) {
            percent = 0f;
         }
         translucency = percent;
         if (color == null) {
            setColor(Color.WHITE);
         } else {
            setColor(color);
         }
      }
   }

}
