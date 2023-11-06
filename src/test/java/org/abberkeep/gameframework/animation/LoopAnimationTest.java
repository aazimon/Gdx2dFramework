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
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: LoopAnimationTest</p>
 *
 * <p>
 * Description: This tests the methods of the LoopAnimationTest class.</p>
 *
 * Copyright: Copyright (c) Feb 17, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class LoopAnimationTest extends EasyMockSupport {
   private LoopAnimation underTest;
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
   public void testUpdateLoop2() {
      expect(sound.play()).andReturn(1l).times(2);
      replayAll();

      underTest = new LoopAnimation(.2f, region, 2);
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
