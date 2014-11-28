package com.kokostudio.matchandmix.scene.game;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import android.util.Log;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class MatchIt extends BaseScene {

	private ButtonSprite[] questionFrame;
	private ButtonSprite back;
	private Sprite qheader;
	
	private int x, y, rowCounter, i;
	
	@Override
	public void createScene() {
		i = 0;
		createBackground();
		createEntities();
	}

	@Override
	public void onBackKeyPressed() {

	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_GTML;
	}

	@Override
	public void disposeScene() {
		
	}
	
	//----------------------------------------------------------
	// CLASS LOGIC
	//----------------------------------------------------------

	private void createBackground() {
		attachChild(new Sprite(400,240, resourcesManager.bgTextureRegion, vbom) {
			@Override
			protected void draw(GLState pGLState, Camera pCamera) {
				super.draw(pGLState, pCamera);
				pGLState.enableDither();
			}
			
		});
	}

	private void createEntities() {
		// QUESTION FRAMES
		questionFrame = new ButtonSprite[17];
		x = 200; y = 330; rowCounter = 0;
		for (i = 0 ; i < questionFrame.length; i++) {
			if(rowCounter < 5) {
				// create button sprite
				questionFrame[i] = new ButtonSprite(x, y, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent,float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							this.setScale(1.2f);
							break;
						case TouchEvent.ACTION_UP:
							this.setScale(1.0f);
							break;
						}
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame[i]);
				attachChild(questionFrame[i]);
				x += 100;
				rowCounter++;
			} else if (rowCounter == 5) {
				y -= 100;
				x = 200;
				rowCounter = 0;
			} else if(rowCounter == 10) {
				y -= 200;
				x = 200;
				rowCounter = 0;
			}
		}
		// QUESTION HEADER
		qheader = new Sprite(400, 430, resourcesManager.qHeaderTextureRegion, vbom);
		attachChild(qheader);
		
		// BACK BUTTON
		back = new ButtonSprite(740, 60, resourcesManager.backTexture, vbom);
		attachChild(back);
	}
	
}