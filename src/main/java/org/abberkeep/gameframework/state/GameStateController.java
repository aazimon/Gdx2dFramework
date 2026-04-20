/*
 * Copyright (c) 2022-2025 Gary Deken
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
package org.abberkeep.gameframework.state;

import com.badlogic.gdx.Screen;

/**
 * Title: GameStateController
 *
 * <p>
 * Description: Interface for controlling game state. It is used for changing the GameState and GameMap.</p>
 *
 * Copyright (c) Dec 25, 2025
 * @author Gary Deken
 * @version 0.19
 */
public interface GameStateController {

   /**
    * Sets the Screen in the BaseGame.
    * @param screen
    */
   void setScreen(Screen screen);

   /**
    * Sets a new State in the BaseGame.
    * @param state
    */
   void setGameState(GameState state);

}
