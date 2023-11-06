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
package org.abberkeep.gameframework.utils;

import com.badlogic.gdx.AbstractInput;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import org.abberkeep.gameframework.screen.ScreenInput;

/**
 * Title: TestInput
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 5, 2023
 * @author Gary Deken
 * @version
 */
public class MockInput extends AbstractInput {
   private int keyPressed1;
   private int keyPressed2;
   private int buttonPressed1;
   private int x;
   private int y;

   public MockInput() {
      Camera camera = new MockCamera(500, 500);
      ScreenInput.setScreenSize(1000, 1000, camera);
   }

   @Override
   public void cancelVibrate() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getAccelerometerX() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getAccelerometerY() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getAccelerometerZ() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getAzimuth() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long getCurrentEventTime() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getGyroscopeX() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getGyroscopeY() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getGyroscopeZ() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getDeltaX() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getDeltaX(int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getDeltaY() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getDeltaY(int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public InputProcessor getInputProcessor() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getMaxPointers() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Orientation getNativeOrientation() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getPitch() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getPressure() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getPressure(int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public float getRoll() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getRotation() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void getRotationMatrix(float[] floats) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void getTextInput(TextInputListener tl, String string, String string1, String string2) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void getTextInput(TextInputListener tl, String string, String string1, String string2,
      OnscreenKeyboardType okt) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int getX() {
      return x;
   }

   @Override
   public int getX(int i) {
      return x;
   }

   @Override
   public int getY() {
      return 1000 - y;
   }

   @Override
   public int getY(int i) {
      return 1000 - y;
   }

   @Override
   public boolean isButtonPressed(int button) {
      return button == buttonPressed1;
   }

   @Override
   public boolean isButtonJustPressed(int button) {
      return isButtonPressed(button);
   }

   @Override
   public boolean isCursorCatched() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean isKeyPressed(int key) {
      return key == keyPressed1 || key == keyPressed2;
   }

   @Override
   public boolean isPeripheralAvailable(Peripheral prphrl) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean isTouched() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean isTouched(int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public boolean justTouched() {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   public void setButtonPressed1(int buttonPressed1) {
      this.buttonPressed1 = buttonPressed1;
   }

   @Override
   public void setCursorCatched(boolean bln) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setCursorPosition(int i, int i1) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setInputProcessor(InputProcessor ip) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   public void setKeyPressed1(int keyPressed1) {
      this.keyPressed1 = keyPressed1;
   }

   public void setKeyPressed2(int keyPressed2) {
      this.keyPressed2 = keyPressed2;
   }

   @Override
   public void setOnscreenKeyboardVisible(boolean bln) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setOnscreenKeyboardVisible(boolean bln, OnscreenKeyboardType okt) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   public void setX(int x) {
      this.x = x;
   }

   public void setY(int y) {
      this.y = y;
   }

   @Override
   public void vibrate(int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void vibrate(long[] longs, int i) {
      // TODO Implement method
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
