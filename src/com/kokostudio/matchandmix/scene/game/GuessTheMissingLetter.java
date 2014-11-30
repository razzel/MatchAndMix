package com.kokostudio.matchandmix.scene.game;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;

import android.util.Log;

import com.kokostudio.matchandmix.base.BaseScene; 
import com.kokostudio.matchandmix.manager.SceneManager;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class GuessTheMissingLetter extends BaseScene {
	
	private HUD mainMenuHUD;
	private ButtonSprite questionFrame;
	private ButtonSprite questionFrame2;
	private ButtonSprite questionFrame3;
	private ButtonSprite questionFrame4;
	private ButtonSprite questionFrame5;
	private ButtonSprite questionFrame6;
	private ButtonSprite questionFrame7;
	private ButtonSprite questionFrame8;
	private ButtonSprite questionFrame9;
	private ButtonSprite questionFrame10;
	private ButtonSprite questionFrame11;
	private ButtonSprite questionFrame12;
	private ButtonSprite questionFrame13;
	private ButtonSprite questionFrame14;
	private ButtonSprite questionFrame15;
	private ButtonSprite questionFrame16;
	private ButtonSprite questionFrame17;
	private ButtonSprite questionFrame18;
	private ButtonSprite questionFrame19;
	private ButtonSprite questionFrame20;
	private ButtonSprite questionFrame21;
	private ButtonSprite questionFrame22;
	private ButtonSprite questionFrame23;
	private ButtonSprite questionFrame24;
	private ButtonSprite questionFrame25;
	private ButtonSprite back;
	private Sprite qheader;
	
	//private int x, y, rowCounter, i;
	
	@Override
	public void createScene() {
		//i = 0;
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
		/*questionFrame = new ButtonSprite[17];
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
		*/
		//frame 1
		questionFrame = new ButtonSprite(100, 330, resourcesManager.frameTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					questionFrame.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
					SceneManager.getInstance().loadGTMLScene();
					questionFrame.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(questionFrame);
		attachChild(questionFrame);
		
		// frame 2
		questionFrame2 = new ButtonSprite(200, 330, resourcesManager.frameTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					questionFrame2.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
					SceneManager.getInstance().loadGTMLScene();
					questionFrame2.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(questionFrame2);
		attachChild(questionFrame2);

		// frame 3
				questionFrame3 = new ButtonSprite(300, 330, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame3.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							SceneManager.getInstance().loadGTMLScene();
							questionFrame3.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame3);
				attachChild(questionFrame3);
				
				// frame 4
				questionFrame4 = new ButtonSprite(400, 330, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame4.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							SceneManager.getInstance().loadGTMLScene();
							questionFrame4.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame4);
				attachChild(questionFrame4);
		
				// frame 5
				questionFrame5 = new ButtonSprite(500, 330, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame5.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							SceneManager.getInstance().loadGTMLScene();
							questionFrame5.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame5);
				attachChild(questionFrame5);
		
		// QUESTION HEADER
		qheader = new Sprite(400, 430, resourcesManager.qHeaderTextureRegion, vbom);
		attachChild(qheader);
		
		// BACK BUTTON
	
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
				}				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}				
		};
		
		
		registerTouchArea(back);
		
		
		attachChild(back);
		camera.setHUD(mainMenuHUD);
	}
	
}
