/*
 * Copyright 2022-2026 GaryDeken.
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

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author GaryDeken
 */
public class ChainEffectTest {
   private ChainEffect underTest;

   @Before
   public void setUp() {
      underTest = new ChainEffect(new NoEffect(.2f), new NoEffect(.2f));
      underTest.addEffect(new NoEffect(.2f));
   }

   /**
    * Test of reset method, of class ChainEffect.
    */
   @Test
   public void testReset() {
      for (int i = 0; i < 6; i++) {
         underTest.update(.1f);
      }
      assertTrue(underTest.isDone());
      underTest.reset();
      assertFalse(underTest.isDone());
   }

   /**
    * Test of update method, of class ChainEffect.
    */
   @Test
   public void testUpdate() {
      for (int i = 0; i < 8; i++) {
         underTest.update(.1f);
      }
      assertTrue(underTest.isDone());
   }

}
