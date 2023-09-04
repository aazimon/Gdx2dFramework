/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import static org.easymock.EasyMock.expect;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.easymock.EasyMockSupport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: BounceAnimationTest</p>
 *
 * <p>
 * Description: This tests the methods of the BounceAnimationTest class.</p>
 *
 * Copyright: Copyright (c) Feb 18, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class BounceAnimationTest extends EasyMockSupport {
   private BounceAnimation underTest;
   private TextureRegion[] region;
   private Sound sound;

   @Before
   public void setUp() {
      TextureRegion tr = mock(TextureRegion.class);
      region = new TextureRegion[4];
      region[0] = tr;
      expect(region[0].getRegionWidth()).andReturn(32);
      expect(region[0].getRegionHeight()).andReturn(32);
      sound = mock(Sound.class);
   }

   @Test
   public void testUpdate() {
      expect(sound.play()).andReturn(1l).times(5);
      replayAll();

      underTest = new BounceAnimation(.2f, region);
      underTest.setSound(sound);
      float delta = 0.1f;

      test(delta, 0);
      test(delta, 1);
      test(delta, 1);
      test(delta, 2);
      test(delta, 2);
      test(delta, 3);
      test(delta, 3);
      test(delta, 2);
      // 1
      test(delta, 2);
      test(delta, 1);
      test(delta, 1);
      test(delta, 0);
      // 2
      test(delta, 0);
      test(delta, 1);
      test(delta, 1);
      test(delta, 2);
      test(delta, 2);
      test(delta, 3);
      // 3
      test(delta, 3);
      test(delta, 2);
      test(delta, 2);
      test(delta, 1);
      test(delta, 1);
      test(delta, 1);
      test(delta, 0);
      // 4
   }

   @Test
   public void testUpdateNumberOfLoops1() {
      expect(sound.play()).andReturn(1l);
      replayAll();

      underTest = new BounceAnimation(.2f, region, 1);
      float delta = 0.1f;

      test(delta, 0);
      test(delta, 1);
      test(delta, 1);
      test(delta, 2);
      test(delta, 2);
      test(delta, 3);
      // 1
      test(delta, 3);
      test(delta, 3);
      test(delta, 3);
      test(delta, 3);
      test(delta, 3);
      test(delta, 3);
      test(delta, 3);
   }

   @Test
   public void testUpdateNumberOfLoops2() {
      expect(sound.play()).andReturn(1l).times(3);
      replayAll();

      underTest = new BounceAnimation(.2f, region, 2);
      underTest.setSound(sound);
      float delta = 0.1f;

      test(delta, 0);
      test(delta, 1);
      test(delta, 1);
      test(delta, 2);
      test(delta, 2);
      test(delta, 3);
      // 1
      test(delta, 3);
      test(delta, 2);
      test(delta, 2);
      test(delta, 1);
      test(delta, 1);
      test(delta, 0);
      // 2
      test(delta, 0);
      test(delta, 0);
      test(delta, 0);
      test(delta, 0);
//      test(delta, 1);
//      test(delta, 1);
//      test(delta, 2);
//      test(delta, 2);
//      test(delta, 3);
//      test(delta, 3);
//      test(delta, 4);
//      // 1
//      test(delta, 4);
//      test(delta, 3);
//      test(delta, 3);
//      test(delta, 2);
//      test(delta, 2);
//      test(delta, 1);
//      test(delta, 1);
//      test(delta, 0);
      // 4
   }

   private int getCurrentIndex() {
      try {
         return (int) FieldUtils.readField(underTest, "currentIndex", true);
      } catch (IllegalAccessException ex) {
         //
      }
      return -1;
   }

   private void test(float delta, int index) {
      underTest.update(delta);
      Assert.assertEquals(index, getCurrentIndex());
   }

}
