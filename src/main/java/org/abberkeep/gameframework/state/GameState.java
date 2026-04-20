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

import org.abberkeep.gameframework.Updatable;

/**
 * Title: GameState
 *
 * <p>
 * Description: GameState is used for providing an over arching state of the game. The GameState is used to monitor at a
 * high level the status of the game and change it's state: In the update method you define what conditions that the
 * game status will change and what state it will change to. The BaseGame has the current GameState and is responsible
 * for executing the update method. For example: For the main playing state, the player wins the game or the player
 * loses the game. The GameState will change the current state accordingly.</p>
 *
 * Copyright (c) Dec 25, 2025
 * @author Gary Deken
 * @version 0.19
 */
public abstract class GameState implements Updatable {
   protected GameStateController controller;

   /**
    * Activates this state, to setup any needed features for this state. This makes the GameState active. This is called
    * from the BaseGame's setGameState().
    */
   public abstract void activateState();

   /**
    * This method is called to change the game's state, by passing in the new state.
    *
    * @param newGameState
    */
   public final void changeState(GameState newGameState) {
      deactivateState();
      controller.setGameState(newGameState);
   }

   /**
    * This is called on when the changeState is called. It is for any clean up of this state, including resetting this
    * state to be activated later.
    */
   public abstract void deactivateState();

   public void setGameStateController(GameStateController controller) {
      this.controller = controller;
   }

   /**
    * This is called in the BaseGame's render phase. It is used to check the user defined conditions and determine if
    * the state should change.
    *
    * @param deltaTime
    */
   @Override
   public abstract void update(float deltaTime);

}
