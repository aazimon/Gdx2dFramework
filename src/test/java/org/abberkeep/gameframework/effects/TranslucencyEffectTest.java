/*
 * Copyright (c) 2022-2024 Gary Deken
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

import static org.junit.Assert.*;

import org.abberkeep.gameframework.animation.MockAnimation;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: TranslucencyEffectTest</p>
 *
 * <p>
 * Description: This tests the methods of the TranslucencyEffectTest class.</p>
 *
 * Copyright: Copyright (c) Jan 6, 2024
 *
 * @author Gary Deken
 * @version 1.0
 */
public class TranslucencyEffectTest {
   private TranslucencyEffect underTest;
   private MockAnimation animation;

   @Before
   public void setUp() {
      animation = new MockAnimation();
   }

   @Test
   public void testTranslucency0() {
      underTest = new TranslucencyEffect(1f, 1f);
      animation.addEffects(underTest);

      assertEquals(1f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(1f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(1f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(1f, animation.getTranslucency(), 0.01f);
   }

   @Test
   public void testTranslucency1() {
      underTest = new TranslucencyEffect(.5f, 1f);
      animation.addEffects(underTest);

      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
   }

   @Test
   public void testTranslucency2() {
      underTest = new TranslucencyEffect(.5f, 1f);
      underTest.addTranslucency(.25f, .6f);
      animation.addEffects(underTest);

      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.01f);
   }

   @Test
   public void testTranslucencyReset() {
      underTest = new TranslucencyEffect(.5f, 1f);
      underTest.addTranslucency(.25f, .6f);
      animation.addEffects(underTest);

      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.9f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.8f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.7f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.6f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.001f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.01f);
      // reset
      underTest.reset();
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.9f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.8f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.7f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.6f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.5f, animation.getTranslucency(), 0.01f);
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.001f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.25f, animation.getTranslucency(), 0.001f);
   }

   @Test
   public void testTranslucencyOver() {
      underTest = new TranslucencyEffect(.75f, .5f);
      animation.addEffects(underTest);

      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertFalse(underTest.isDone());
      animation.update(.2f);
      assertEquals(.75f, animation.getTranslucency(), 0.001f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.75f, animation.getTranslucency(), 0.001f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.75f, animation.getTranslucency(), 0.001f);
      animation.update(.2f);
      assertTrue(underTest.isDone());
      assertEquals(.75f, animation.getTranslucency(), 0.001f);
   }

}
