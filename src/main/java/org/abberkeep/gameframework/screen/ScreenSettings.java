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
package org.abberkeep.gameframework.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.abberkeep.gameframework.state.GameState;

/**
 * Title: ScreenSettings
 *
 * <p>
 * Description: Used for getting elements that are need to set up a BaseScreen.</p>
 *
 * Copyright (c) Dec 25, 2025
 * @author Gary Deken
 * @version 0.19
 */
public interface ScreenSettings {

   /**
    * Gets the GameState. This is used to call the update with the deltaTime.
    * @return
    */
   GameState getGameState();

   /**
    * Gets the SpriteBatch. This is used for rendering the game.
    * @return
    */
   SpriteBatch getSpriteBatch();

   /**
    * Gets the Viewport. This is used for rendering the game.
    * @return
    */
   Viewport getViewport();

}
