/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.gameframework.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: SpatialTree
 *
 * <p>
 * Description: Encapsulates a TreeMap, that creates a key based on the Sprites
 * Spatial location. It multiples the Y coordinate by 10,000 then adds the x
 * location. If the space is already occupied, it adds 0.01 to the x to generate
 * a new key.</p>
 *
 * Copyright (c) Sept 20, 2023
 *
 * @author Gary Deken
 * @version 0.10
 */
public class SpatialTree {
   public static final int FACTORAL = 10000;
   public static final float OFFSET = 0.01f;
   private TreeMap<SpatialKey, Sprite> map = new TreeMap<>(Collections.reverseOrder());

   public Set<Map.Entry<SpatialKey, Sprite>> entrySet() {
      return map.entrySet();
   }

   public Sprite get(SpatialKey key) {
      return map.get(key);
   }

   public Iterator<SpatialKey> iterator() {
      return map.keySet().iterator();
   }

   public void put(Sprite sprite) {
      SpatialKey key = new SpatialKey((int) sprite.getX(), (int) sprite.getY(), (int) sprite.getX());
      if (map.containsKey(key)) {
         key.increaseX();
         put(key, sprite);
      }
      map.put(key, sprite);
   }

   private void put(SpatialKey key, Sprite sprite) {
      if (map.containsKey(key)) {
         key.increaseX();
         put(key, sprite);
      }
      map.put(key, sprite);
   }

}
