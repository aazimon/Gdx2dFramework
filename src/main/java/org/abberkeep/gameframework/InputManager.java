/*
 * Copyright (c) 2022-2026 Gary Deken
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
package org.abberkeep.gameframework;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: InputManager
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2026
 * @author Gary Deken
 * @version 0.21
 */
public class InputManager implements InputProcessor {
   private static List<InputListener> listeners = new ArrayList<>();
   private static InputEvent inputEvent = new InputEvent();

   public static void addInputListener(InputListener inputerListener) {
      listeners.add(inputerListener);
   }

   @Override
   public boolean keyDown(int keycode) {
      for (InputListener listener : listeners) {
         listener.keyDown(inputEvent, keycode);
      }
      //System.out.println("Key Down: " + keycode);
      return inputEvent.isHandled();
   }

   @Override
   public boolean keyUp(int keycode) {
      for (InputListener listener : listeners) {
         listener.keyUp(inputEvent, keycode);
      }
      //System.out.println("Key Up: " + keycode);

      return inputEvent.isHandled();
   }

   @Override
   public boolean keyTyped(char character) {
      for (InputListener listener : listeners) {
         listener.keyTyped(inputEvent, character);
      }
      //System.out.println("Key Typed: " + character);
      return inputEvent.isHandled();
   }

   @Override
   public boolean touchDown(int screenX, int screenY, int pointer, int button) {
      for (InputListener listener : listeners) {
         listener.touchDown(inputEvent, screenX, screenY, pointer, button);
      }
      //System.out.println("Touch Down: X: " + screenX + " Y: " + screenY + " pointer: " + pointer + " button: " + button);
      return inputEvent.isHandled();
   }

   @Override
   public boolean touchUp(int screenX, int screenY, int pointer, int button) {
      for (InputListener listener : listeners) {
         listener.touchUp(inputEvent, screenX, screenY, pointer, button);
      }
      //System.out.println("Touch Up: X: " + screenX + " Y: " + screenY + " pointer: " + pointer + " button: " + button);
      return inputEvent.isHandled();
   }

   @Override
   public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
      //System.out.println(
      //   "Touch Cancelled: X: " + screenX + " Y: " + screenY + " pointer: " + pointer + " button: " + button);
      return inputEvent.isHandled();
   }

   @Override
   public boolean touchDragged(int screenX, int screenY, int pointer) {
      for (InputListener listener : listeners) {
         listener.touchDragged(inputEvent, screenX, screenY, pointer);
      }
      //System.out.println("Touch Dragged: X: " + screenX + " Y: " + screenY + " pointer: " + pointer);
      return inputEvent.isHandled();
   }

   @Override
   public boolean mouseMoved(int screenX, int screenY) {
      for (InputListener listener : listeners) {
         listener.mouseMoved(inputEvent, screenX, screenY);
      }
      //System.out.println("Mouse Moved: X: " + screenX + " Y: " + screenY);
      return inputEvent.isHandled();
   }

   @Override
   public boolean scrolled(float amountX, float amountY) {
      for (InputListener listener : listeners) {
         listener.scrolled(inputEvent, 0, 0, amountX, amountY);
      }
      //System.out.println("Scrolled: X: " + amountX + " Y: " + amountY);
      return inputEvent.isHandled();
   }

}
