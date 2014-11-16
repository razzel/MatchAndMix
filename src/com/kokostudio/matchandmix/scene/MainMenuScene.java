package com.kokostudio.matchandmix.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.SceneManager;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class MainMenuScene extends BaseScene {
	
	private HUD mainMenuHUD;
	
	private ButtonSprite back;
	private ButtonSprite pause;
	private ButtonSprite about;
	private ButtonSprite gameGuessTheMissingLetter;
	
	@Override
	public void createScene() {
		createBackground();
		createMenuSelection();
		createHUD();
	}

	@Override
	public void onBackKeyPressed() { }

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MAINMENU;
	}

	@Override
	public void disposeScene() {
		camera.setHUD(null);
		camera.setCenter(400, 240);
		pause.detachSelf();
		pause.dispose();
		back.detachSelf();
		back.dispose();
	}
	
	//------------------------------------------------------
	// CLASS LOGIC
	//------------------------------------------------------
	
	private void createBackground() {
		attachChild(new Sprite(400, 240, resourcesManager.bgTextureRegion, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}		
		});	
	}
	
	private void createHUD() {
		mainMenuHUD = new HUD();
		// Create pause and back button
		pause = new ButtonSprite(50, 440, resourcesManager.pauseTextureRegion, vbom){
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					break;
				case TouchEvent.ACTION_UP:
					break;
				}
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}	
		};
		
		back = new ButtonSprite(740, 60, resourcesManager.backTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					back.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					SceneManager.getInstance().loadPlayMenuScene();
					back.setScale(1.0f);
					break;
				}				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}				
		};
		
		registerTouchArea(pause);
		registerTouchArea(back);
		
		attachChild(pause);
		attachChild(back);
		camera.setHUD(mainMenuHUD);
	}
	
	private void createMenuSelection() {
		gameGuessTheMissingLetter = new ButtonSprite(400, 240, resourcesManager.gameGuessTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					gameGuessTheMissingLetter.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
					SceneManager.getInstance().loadGTMLScene();
					gameGuessTheMissingLetter.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(gameGuessTheMissingLetter);
		attachChild(gameGuessTheMissingLetter);
	}
	

}
