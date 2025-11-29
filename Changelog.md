Change log for Gdx2dFramework.

## [0.18]
- add ControlledMovement for Movements that are controlled by a separate object.
- Add GamePadMovement and GameStickMovement, for GamePad controlling.
- add list of updatables in the base GameMap, and updating them in the rendercycle.
- Move BackGround and ViewPort into GameMap.
- add method to get the GameMap from the BaseScreen.
- add method to SpriteUpdate and Sprite setLocation() that takes X, Y and Layer.
- update JavaDocs on FastMath
- make LibGdx and Gdx-Controller provided.

## [0.17]
- Add Layers to framework. Update SpriteUpdate with Layer and implementing classes.
   - Add MouseLayerDragMovement, BaseMouseMovement.
   - Add a parent and changingLayer checks to Movement for layer movement.
   - update BoundingBox with layer and contains() with layer check.
   - update Direction with LAYER enum.
- Add GameMap for handling the layout of the game. Update classes to use GameMap. Update BaseScreen, removing GameMap code and add GameMap.
   - Add SimpleSpriteMap, replacing SimpleScreen.
- Add InputLocks class and update ScreenInput for handling button press for activation and deactivation,
- Add a simple CollisionDetection for checking all sprites.

## [0.16]
- Add MouseDragMovement, Background and FixedBackground, Add Background to the BaseScreen.
- add contains(int x, int y) to SpriteUpdate and add it in implementing classes.
- update BoundingBox to add checks for just X and Y separately.
- Jacoco reporting to project.

## [0.15]
- Change ColorEffect to Effect and have TranslucencyEffect along with ColorCycleEffect.
- Create a BaseEffect for common attributes.
- add reset method in Animation and Motion, used by the Effect code.

## [0.14]
- Add AbstractDestinationAction, with DestinationAction, RandomDestinationAction
- Add BaseMotion to hold common attributes.
- Add ColorEffect and ColorCycleEffect
- Update Animation and Motion to set Color Effect on those classes.

## [0.13]
- Add reset() to Movement.
- add Updatables to BaseScreen and add them to the render cycle.
- correct collision handling for same sprite.

## [0.12]
- Udpate SimpleScreen's render cycle for adding and removing sprites during the game.
- add Sprite removal feature with Collisions.
- implement the height and wide in the BaseScreen.
- Add SingleMovement, ScriptMovement and NoMovement.
- add ScriptAction and actions for the ScriptMovement.

## [0.11]
- Update Sprites and Movements for Collision Detection.
- Add a BoundingBox and Bounds.
- Add SimpleScreen and a SpatialTree (initial work).
- Add RandomSound class.
- Update Copyright docs.

## [0.10]
- Add Sound and Music to the framework, updating Animations to have sound
- Add a getGlobalTexture() method.

## [0.9]
- Add Sprite, Actor and Decor.
- Change SpriteUpdate and Movements to set Location in one method.
- Change Height and Width to be int(s) instead of floats, making the size an exact pixel size.
- Add StaticRegionAnimation.

## [0.8]
- Rework Movements to set values on a SpriteUpdate and have a Speed value.
- Add SpriteUpdate for working with Movement classes.
- Add MouseMovement class.
- Update BaseScreen and BaseGame to change ViewPort when the Camera is moved.
- Update ScreenInput to return values related to Camera position.
- Update Animation to set the Translucency.
- Update Motion to set the Animation's Color, Size and Translucency.

## [0.7]
- Add the Movement interface, BaseMovement, TwoKeyMovement and FourKeyMovement classes.
- Add the ScreenInput utility class.
- Add the BlockAnimation.

## [0.6]
- Add the Motion interface, SingleMotion, TwoWayMotion, FourWayMotion and EightWayMotion classes.
- Add the Direction and FastMath utility classes.

## [0.5]
- Add the LoopAnimation, BounceAnimation and RandomAnimation classes.
- Add Updatable interface.

## [0.4]
- Add Animation interface, a BaseAnimation and StaticAnimation classes.

## [0.3]
- move resize() method into BaseScreen.

## [0.2]
- Add getTexture() to BaseScreen to store images in a cache and disposing of them on exit.

## [0.1]
- Initial development
- BaseGame for setting up OrthographicCamera
- Base Screen for rendering the background.