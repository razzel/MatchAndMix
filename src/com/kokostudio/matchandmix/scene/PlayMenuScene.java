package com.kokostudio.matchandmix.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.SceneManager;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class PlayMenuScene extends BaseScene {
	
	private TiledSprite play;
	
	@Override
	public void createScene() {
		this.setTouchAreaBindingOnActionDownEnabled(true);
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
	
	// =================================================================================
	// CLASS LOGIC
	// =================================================================================
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
		play = new TiledSprite(400, 180, resourcesManager.playTiledTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					play.setCurrentTileIndex(1);
					play.setScale(0.9f);
					break;
				case TouchEvent.ACTION_UP:
					SceneManager.getInstance().loadMainMenuScene();
					play.setCurrentTileIndex(0);
					play.setScale(1.0f);
					break;
				}
				return true;
			}	
		};
		registerTouchArea(play);
		attachChild(play);
	}	
}
