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


public class GameMenuScene extends BaseScene {
	
	private HUD mainMenuHUD;
	
	private ButtonSprite back;
	private ButtonSprite pause;
	private ButtonSprite about;
	private ButtonSprite gameGuessTheMissingLetter;
	private ButtonSprite matchitTextureRegion;
	private ButtonSprite solveitTextureRegion;
	private ButtonSprite CountitTextureRegion;
	private ButtonSprite howtoplay;
	private ButtonSprite progress;
	private ButtonSprite option;
	private ButtonSprite exit;
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
		return SceneType.SCENE_GAMEMENU;
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
		resourcesManager.playMenuSound.play();
		resourcesManager.playMenuSound.setLooping(true);	
		
		//GuessTheMissingLetter
		gameGuessTheMissingLetter = new ButtonSprite(180, 240, resourcesManager.gameGuessTextureRegion, vbom) {
			
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
		
		
		//Match IT
		matchitTextureRegion = new ButtonSprite(400, 240, resourcesManager.matchitTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							matchitTextureRegion.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							SceneManager.getInstance().loadMatchItScene();
							System.out.print("About MAtch and Mix!");
							matchitTextureRegion.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(matchitTextureRegion);
				attachChild(matchitTextureRegion);
				
				
				CountitTextureRegion = new ButtonSprite(620, 240, resourcesManager.CountitTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							CountitTextureRegion.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
					
							
							CountitTextureRegion.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(CountitTextureRegion);
				attachChild(CountitTextureRegion);
				
				
				
				
				
				//Next
		next = new ButtonSprite(760, 220, resourcesManager.nextTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							next.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							//SceneManager.getInstance().loadnextScene();
							next.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(next);
				attachChild(next);
			
				
				
				
				//Previous
						prev = new ButtonSprite(40, 220, resourcesManager.PrevTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									prev.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									resourcesManager.playMenuSound.stop();
									SceneManager.getInstance().loadMainMenuScene();
									prev.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(prev);
						attachChild(prev);
						menuheader = new Sprite(400, 430, resourcesManager.menuheaderTextureRegion, vbom);
						attachChild(menuheader);
			}
	
}




