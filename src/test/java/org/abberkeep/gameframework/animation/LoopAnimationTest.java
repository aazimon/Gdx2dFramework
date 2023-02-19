/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.gameframework.animation;

import static org.easymock.EasyMock.*;

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

   @Before
   public void setUp() {
      TextureRegion texture = mock(TextureRegion.class);
      region = new TextureRegion[4];
      region[0] = texture;
      expect(region[0].getRegionWidth()).andReturn(32);
      expect(region[0].getRegionHeight()).andReturn(32);
   }

   @Test
   public void testUpdateLoop2() {
      replayAll();

      underTest = new LoopAnimation(.2f, region, 2);
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
