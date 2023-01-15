/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Title: StaticAnimation
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 12, 2023
 * @author Gary Deken
 * @version
 */
public class StaticAnimation extends BaseAnimation {
   private Texture texture;

   public StaticAnimation(Texture texture) {
      this(texture, texture.getWidth(), texture.getHeight());
   }

   public StaticAnimation(Texture texture, float width, float height) {
      this.texture = texture;
      this.width = width;
      this.height = height;
      imageFX.initialize(this);
   }

   @Override
   public void draw(SpriteBatch batch, float x, float y) {
      imageFX.draw(batch, texture, x, y);
   }

   @Override
   public void update(float deltaTime) {
      // no update.
   }

}
