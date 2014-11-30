package com.kokostudio.matchandmix.scene.game.panel;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kokostudio.matchandmix.base.BaseScene; 

import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class MatchItPanel extends BaseScene{
	
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createEntities();
		
	}

	private void createEntities() {
		// TODO Auto-generated method stub
		
		
	}

	private void createBackground() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MATCHIT;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	

}
