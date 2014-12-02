package com.kokostudio.matchandmix.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;


import android.content.Intent;
import android.net.Uri;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.SceneManager;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;


public class MainMenuScene extends BaseScene {
	
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
	private ButtonSprite howtoplay;
	private ButtonSprite next;
	private ButtonSprite prev;
	private ButtonSprite exit;
	
	
	private Sprite menuheader;
	
	@Override
	public void createScene() {
		createBackground();
		createMenuSelection();
		createHUD();
		howtoplay.setVisible(false);
		about.setVisible(false);
		exit.setVisible(false);
		prev.setVisible(false);
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
		
	/*	howtoplay.dispose();
		howtoplay.detachSelf();
		about.dispose();
		about.detachSelf();
		exit.dispose();
		exit.detachSelf();
		back.detachSelf();
		back.dispose();
		*/
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
		//games
		resourcesManager.playMenuSound.play();
		resourcesManager.playMenuSound.setLooping(true);

		games = new ButtonSprite(180, 240, resourcesManager.gamesTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					games.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
					resourcesManager.playMenuSound.stop();
				SceneManager.getInstance().loadaboutScene();
					games.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(games);
		attachChild(games);
		
		
		//progress
		progress = new ButtonSprite(400, 240, resourcesManager.ProgressTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					progress.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
				//	SceneManager.getInstance().loadGTMLScene();
					progress.setScale(1.f);
					resourcesManager.playMenuSound.stop();
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
			
		};
		registerTouchArea(progress);
		attachChild(progress);
		
		
		option = new ButtonSprite(620, 240, resourcesManager.OptionTextureRegion, vbom) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					option.setScale(1.3f);
					break;
				case TouchEvent.ACTION_UP:
					// load guess the missing letter scene
					// and dispose the main menu scene
				//	SceneManager.getInstance().loadGTMLScene
					//startActivity(i);
					resourcesManager.playMenuSound.stop();
					next.setVisible(true);
					option.setScale(1.f);
					break;
				}
				
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}

		
			
		};
		registerTouchArea(option);
		attachChild(option);
		
		
		
		
		
	
				
				//how to play
				howtoplay = new ButtonSprite(180, 240, resourcesManager.howtoplayTextureRegion, vbom) {
					
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							howtoplay.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							resourcesManager.playMenuSound.stop();
							howtoplay.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(howtoplay);
				attachChild(howtoplay);
				
				
				//about
						about = new ButtonSprite(400, 240, resourcesManager.aboutTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									about.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									SceneManager.getInstance().loadaboutScene();
									resourcesManager.playMenuSound.stop();
									System.out.print("About MAtch and Mix!");
									about.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(about);
						attachChild(about);
						
						
						exit = new ButtonSprite(620, 240, resourcesManager.exitTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									exit.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
								//	SceneManager.getInstance().loadGTMLScene();
									System.out.print("Thanks For Playing!");
									System.exit(0);
									
									exit.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(exit);
						attachChild(exit);
						
						
						
						//Next
						
						next = new ButtonSprite(760, 220, resourcesManager.nextTextureRegion, vbom) {
							
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								
								case TouchEvent.ACTION_DOWN:
									next.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									
									//next
									howtoplay.setVisible(true);
									about.setVisible(true);
									exit.setVisible(true);
									//prev
									games.setVisible(false);
									progress.setVisible(false);
									option.setVisible(false);
									next.setVisible(false);
									prev.setVisible(true);
									next.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(next);
						attachChild(next);
						
						
						
						//ACTION BUTTONS ******************************************
						//Previous
								prev = new ButtonSprite(40, 220, resourcesManager.PrevTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											prev.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											//next
											howtoplay.setVisible(false);
											about.setVisible(false);
											exit.setVisible(false);
											//prev
											games.setVisible(true);
											progress.setVisible(true);
											option.setVisible(true);
											next.setVisible(true);
											prev.setVisible(false);
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




