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
	private ButtonSprite gameTextureRegion;
	private ButtonSprite matchitTextureRegion;
	private ButtonSprite solveitTextureRegion;
	private ButtonSprite CountitTextureRegion;
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
		camera.setHUD(mainMenuHUD);
	}
	
	private void createMenuSelection() {
		gameTextureRegion = new ButtonSprite(400, 240, resourcesManager.gameTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					gameTextureRegion.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
					SceneManager.getInstance().loadGTMLScene();
					gameTextureRegion.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(gameTextureRegion);
		attachChild(gameTextureRegion);
		
		
		matchitTextureRegion = new ButtonSprite(140, 240, resourcesManager.matchitTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					matchitTextureRegion.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess match it
					// and dispose the main menu scene
					SceneManager.getInstance().loadMatchItScene();
					matchitTextureRegion.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		
		registerTouchArea(matchitTextureRegion);
		attachChild(matchitTextureRegion);
		
		// Count IT
		
		CountitTextureRegion = new ButtonSprite(640, 240, resourcesManager.CountitTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					CountitTextureRegion.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess count it
					// and dispose the main menu scene
					SceneManager.getInstance().loadGTMLScene();
					CountitTextureRegion.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(CountitTextureRegion);
		attachChild(CountitTextureRegion);
	}
	
	
	

}
