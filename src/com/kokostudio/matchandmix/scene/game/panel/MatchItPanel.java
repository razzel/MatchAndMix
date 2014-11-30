package com.kokostudio.matchandmix.scene.game.panel;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kokostudio.matchandmix.base.BaseScene; 

import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class MatchItPanel extends BaseScene {
	
	
	private HUD mainMenuHUD;

	@Override
	public void createScene() {
		createBackground();
		createEntities();	
	}

	private void createEntities() {
		camera.setHUD(mainMenuHUD);	
	}

	private void createBackground() {
		attachChild(new Sprite(400,240, resourcesManager.bgTextureRegion, vbom) {
			@Override
			protected void draw(GLState pGLState, Camera pCamera) {
				super.draw(pGLState, pCamera);
				pGLState.enableDither();
			}	
		});
	}
	

	@Override
	public void onBackKeyPressed() {
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MATCHITPANEL;
	}

	@Override
	public void disposeScene() {
		
	}
	
}
