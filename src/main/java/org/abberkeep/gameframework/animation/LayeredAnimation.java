/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: LayeredAnimation
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jun 9, 2023
 * @author Gary Deken
 * @version
 */
public class LayeredAnimation extends BaseAnimation {
   private List<Animation> animations = new ArrayList<>();

   public LayeredAnimation(Animation animation) {
      animations.add(animation);
   }

   public void addAnimation(Animation animation) {
      animations.add(animation);
   }

   public Animation getAnimation(int index) {
      return animations.get(index);
   }

   @Override
   public void update(float deltaTime) {
      animations.forEach(animation -> animation.update(deltaTime));
   }

   @Override
   protected void drawChild(SpriteBatch batch, float x, float y) {
      animations.forEach(animation -> animation.draw(batch, x, y));
   }

}
