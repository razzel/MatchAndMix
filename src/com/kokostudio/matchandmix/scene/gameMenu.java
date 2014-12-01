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


public class gameMenu extends BaseScene {
	
	private HUD mainMenuHUD;
	
	private ButtonSprite back;
	private ButtonSprite pause;
	private ButtonSprite about;
	private ButtonSprite gameGuessTheMissingLetter;
	private ButtonSprite matchitTextureRegion;
	private ButtonSprite solveitTextureRegion;
	private ButtonSprite CountitTextureRegion;
	private ButtonSprite games;
	private ButtonSprite progress;
	private ButtonSprite option;
	private ButtonSprite next;
	private ButtonSprite prev;
	
	
	private Sprite menuheader;
	
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
		return SceneType.SCENE_gameMenu;
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

			}
	
}




