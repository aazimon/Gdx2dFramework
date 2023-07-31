/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.utils;

import java.lang.reflect.Field;
import org.junit.Assert;

/**
 * Title: TestUtils
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jul 29, 2023
 * @author Gary Deken
 * @version
 */
public class TestUtils {

   public static Object getObject(Object object, String fieldName) {
      try {
         return getObject(object, object.getClass(), fieldName);
      } catch (SecurityException ex) {
         Assert.fail("SecurityException");
      } catch (IllegalAccessException ex) {
         Assert.fail("IllegalAccessException");
      }

      return null;
   }

   private static Object getObject(Object object, Class clazz, String fieldName) throws IllegalAccessException {
      try {
         Field field = clazz.getDeclaredField(fieldName);

         field.setAccessible(true);
         return field.get(object);
      } catch (NoSuchFieldException ex) {
         if (!clazz.getSuperclass().equals(Object.class)) {
            return getObject(object, clazz.getSuperclass(), fieldName);
         }
      }
      return null;
   }
}
