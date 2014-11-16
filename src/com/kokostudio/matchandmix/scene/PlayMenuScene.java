package com.kokostudio.matchandmix.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.ResourcesManager;
import com.kokostudio.matchandmix.manager.SceneManager;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class PlayMenuScene extends BaseScene {
	
	private ButtonSprite play;
	
	private void createBackground() {
		attachChild(new Sprite(400, 240, resourcesManager.playMenuBackgroundTexture, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}
	
	private void createButton() {
		play = new ButtonSprite(400, 180, resourcesManager.playTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					play.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					SceneManager.getInstance().loadMainMenuScene();
					play.setScale(1f);
					break;
				}
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}	
		};
		registerTouchArea(play);
		attachChild(play);
	}
	
	@Override
	public void createScene() {
		createBackground();
		createButton();
	}

	@Override
	public void onBackKeyPressed() {
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_PLAYMENU;
	}

	@Override
	public void disposeScene() {
		play.detachSelf();
		play.dispose();
		this.detachSelf();
		this.dispose();		
	}
	
}
