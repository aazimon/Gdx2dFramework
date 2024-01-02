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
package org.abberkeep.gameframework.screen.bsp;

import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: Node
 *
 * <p>
 * Description: A Node for a BSP Tree structure. The Node has Front (positive) and Back (negative) sides. and a list of
 * Sprites on each side.</p>
 *
 * Copyright (c) Dec 10, 2023
 * @author Gary Deken
 * @version 0.14
 */
public class Node {
   private Node front;
   private Node back;
   private BSPLine partition;
   private List<Decor> decors = new ArrayList<>();
   private List<Actor> actors = new ArrayList<>();

   /**
    * Creates a Node with the given partition.
    * @param partition
    */
   public Node(BSPLine partition) {
      this.partition = partition;
   }

}
