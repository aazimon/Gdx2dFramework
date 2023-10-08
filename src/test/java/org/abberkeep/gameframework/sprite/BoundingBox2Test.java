/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.abberkeep.gameframework.sprite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gary
 */
public class BoundingBox2Test {
   private BoundingBox underTest;
   private int x1 = 5;
   private int x2 = 15;
   private int x3 = 25;
   private int y1 = 5;
   private int y2 = 15;
   private int y3 = 25;

   @Before
   public void setUp() {
      underTest = new BoundingBox(10, 10, 20, 20);
      //10,30   30,30
      //10,10   30,10
   }

   @Test
   public void testContains1() {
      BoundingBox other = new BoundingBox(x1, y3, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains2() {
      BoundingBox other = new BoundingBox(x2, y3, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains3() {
      BoundingBox other = new BoundingBox(x3, y3, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains4() {
      BoundingBox other = new BoundingBox(x1, y2, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains5() {
      BoundingBox other = new BoundingBox(x2, y2, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains6() {
      BoundingBox other = new BoundingBox(x3, y2, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains7() {
      BoundingBox other = new BoundingBox(x1, y1, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains8() {
      BoundingBox other = new BoundingBox(x2, y1, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContains9() {
      BoundingBox other = new BoundingBox(x3, y1, 10, 10);

      assertTrue(other.contains(underTest));
   }

   @Test
   public void testContainsNo() {
      BoundingBox other = new BoundingBox(35, 35, 10, 10);

      assertFalse(other.contains(underTest));
   }

}
