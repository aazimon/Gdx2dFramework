/*
 * Copyright (c) 2022-2023 Gary Deken
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
package org.abberkeep.gameframework.effects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.graphics.Color;
import org.junit.Test;

/**
 * <p>
 * Title: ColorCycleEffectsTest</p>
 *
 * <p>
 * Description: This tests the methods of the ColorCycleEffectsTest class.</p>
 *
 * Copyright: Copyright (c) Dec 31, 2023
 *
 * @author Gary Deken
 * @version 1.0
 */
public class ColorCycleEffectsTest {
   private ColorCycleEffect underTest;

   @Test
   public void testColor1() {
      underTest = new ColorCycleEffect(new Color(1, 0, 0, 1), 1f);

      underTest.update(.2f);
      assertFalse(underTest.isDone());
      underTest.update(.2f);
      assertFalse(underTest.isDone());
      underTest.update(.2f);
      assertFalse(underTest.isDone());
      underTest.update(.2f);
      assertFalse(underTest.isDone());
      underTest.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(0f, underTest.getColor().g, 0.1f);
      assertEquals(0f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
      underTest.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(0f, underTest.getColor().g, 0.1f);
      assertEquals(0f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
      underTest.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(0f, underTest.getColor().g, 0.1f);
      assertEquals(0f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
      underTest.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(0f, underTest.getColor().g, 0.1f);
      assertEquals(0f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testColor2() {
      underTest = new ColorCycleEffect(new Color(1, .6f, 1, 1), 1f);

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(.6f, underTest.getColor().g, 0.1f);
      assertEquals(1f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testColor3() {
      underTest = new ColorCycleEffect(new Color(1, .258f, 1, 1), 1f);

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(.258f, underTest.getColor().g, 0.1f);
      assertEquals(1f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testColor4() {
      underTest = new ColorCycleEffect(new Color(1, .258f, 1, 1), Color.WHITE, 1f);

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(1f, underTest.getColor().g, 0.1f);
      assertEquals(1f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testColor5() {
      underTest = new ColorCycleEffect(new Color(1, .258f, 1, 1), new Color(1, .8f, .5f, .6f), 1f);

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(.8f, underTest.getColor().g, 0.1f);
      assertEquals(.5f, underTest.getColor().b, 0.1f);
      assertEquals(.6f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testColor6() {
      underTest = new ColorCycleEffect(new Color(1, .8f, .5f, .6f), new Color(.8f, .5f, .3f, 1f), 1f);

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(.8f, underTest.getColor().r, 0.1f);
      assertEquals(.5f, underTest.getColor().g, 0.1f);
      assertEquals(.3f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

   @Test
   public void testTwoColor1() {
      underTest = new ColorCycleEffect(new Color(1, .258f, 1, 1), new Color(1, .8f, .5f, .6f), 1f);
      // color1 = ff41ffff
      // color 2 = ffcc7f99
      underTest.addColorCycle(new Color(.8f, .5f, .3f, 1f), 1f);
      // 0 = .1999
      // 1 = .3
      // 2 = .1999
      // 3 = -.3999

      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(1f, underTest.getColor().r, 0.1f);
      assertEquals(.8f, underTest.getColor().g, 0.1f);
      assertEquals(.5f, underTest.getColor().b, 0.1f);
      assertEquals(.6f, underTest.getColor().a, 0.1f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      underTest.update(.2f);
      assertEquals(.8f, underTest.getColor().r, 0.1f);
      assertEquals(.5f, underTest.getColor().g, 0.1f);
      assertEquals(.3f, underTest.getColor().b, 0.1f);
      assertEquals(1f, underTest.getColor().a, 0.1f);
   }

}
