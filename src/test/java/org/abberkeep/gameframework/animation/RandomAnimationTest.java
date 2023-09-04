/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import static org.easymock.EasyMock.expect;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: RandomAnimationTest</p>
 *
 * <p>
 * Description: This tests the methods of the RandomAnimationTest class.</p>
 *
 * Copyright: Copyright (c) Sep 4, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class RandomAnimationTest extends EasyMockSupport {
   private RandomAnimation underTest;
   private TextureRegion[] region;
   private Sound sound;

   @Before
   public void setUp() {
      TextureRegion texture = mock(TextureRegion.class);
      region = new TextureRegion[4];
      region[0] = texture;
      expect(region[0].getRegionWidth()).andReturn(32);
      expect(region[0].getRegionHeight()).andReturn(32);
      sound = mock(Sound.class);
   }

   @Test
   public void testUpdate() {
      expect(sound.play()).andReturn(1l).times(2);
      replayAll();

      underTest = new RandomAnimation(.2f, region, 2);
      underTest.setSound(sound);
      float delta = 0.1f;

      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
      underTest.update(delta);
   }

}
