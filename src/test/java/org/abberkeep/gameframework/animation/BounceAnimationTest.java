/*
 * Copyright (c) 2023 Gary Deken
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
