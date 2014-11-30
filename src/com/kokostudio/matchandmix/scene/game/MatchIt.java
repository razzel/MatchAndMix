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

public class MatchIt extends BaseScene {
	
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
		return SceneType.SCENE_MATCHIT;
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
					SceneManager.getInstance().loadMatchItPanelScene();
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
					////SceneManager.getInstance().loadGTMLScene();
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
							////SceneManager.getInstance().loadGTMLScene();
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
							////SceneManager.getInstance().loadGTMLScene();
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
							////SceneManager.getInstance().loadGTMLScene();
							questionFrame5.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame5);
				attachChild(questionFrame5);
				
				// frame 2
				questionFrame6 = new ButtonSprite(600, 330, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame6.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							////SceneManager.getInstance().loadGTMLScene();
							questionFrame6.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame6);
				attachChild(questionFrame6);
				
				// frame 7
				questionFrame7 = new ButtonSprite(700, 330, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame7.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							////SceneManager.getInstance().loadGTMLScene();
							questionFrame7.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame7);
				attachChild(questionFrame7);
				
			// 2nd line
				
				//frame 8
				questionFrame8 = new ButtonSprite(100, 230, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame8.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							////SceneManager.getInstance().loadGTMLScene();
							questionFrame8.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame8);
				attachChild(questionFrame8);
				
				// frame 9
				questionFrame9 = new ButtonSprite(200, 230, resourcesManager.frameTextureRegion, vbom) {
					@Override
					public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
						switch(pSceneTouchEvent.getAction()) {
						case TouchEvent.ACTION_DOWN:
							questionFrame9.setScale(1.3f);
							break;
						case TouchEvent.ACTION_UP:
							// load guess the missing letter scene
							// and dispose the main menu scene
							//SceneManager.getInstance().loadGTMLScene();
							questionFrame9.setScale(1.f);
							break;
						}
						
						return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
					}
					
				};
				registerTouchArea(questionFrame9);
				attachChild(questionFrame9);

				// frame 10
						questionFrame10 = new ButtonSprite(300, 230, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame10.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame10.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame10);
						attachChild(questionFrame10);
						
						// frame 11
						questionFrame11 = new ButtonSprite(400, 230, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame11.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame11.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame11);
						attachChild(questionFrame11);
				
						// frame 5
						questionFrame12 = new ButtonSprite(500, 230, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame12.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame12.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame12);
						attachChild(questionFrame12);
						
						// frame 13
						questionFrame13 = new ButtonSprite(600, 230, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame13.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame13.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame13);
						attachChild(questionFrame13);
						
						// frame 14
						questionFrame14 = new ButtonSprite(700, 230, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame14.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame14.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame14);
						attachChild(questionFrame14);
				
						
						//3rd line
						
						//frame 15
						questionFrame15 = new ButtonSprite(100, 130, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame15.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame15.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame15);
						attachChild(questionFrame15);
						
						// frame 16
						questionFrame16 = new ButtonSprite(200, 130, resourcesManager.frameTextureRegion, vbom) {
							@Override
							public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
								switch(pSceneTouchEvent.getAction()) {
								case TouchEvent.ACTION_DOWN:
									questionFrame16.setScale(1.3f);
									break;
								case TouchEvent.ACTION_UP:
									// load guess the missing letter scene
									// and dispose the main menu scene
									//SceneManager.getInstance().loadGTMLScene();
									questionFrame16.setScale(1.f);
									break;
								}
								
								return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
							}
							
						};
						registerTouchArea(questionFrame16);
						attachChild(questionFrame16);

						// frame 17
								questionFrame17 = new ButtonSprite(300, 130, resourcesManager.frameTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											questionFrame17.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											// load guess the missing letter scene
											// and dispose the main menu scene
											//SceneManager.getInstance().loadGTMLScene();
											questionFrame17.setScale(1.f);
											break;
										}
										
										return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
									}
									
								};
								registerTouchArea(questionFrame17);
								attachChild(questionFrame17);
								
								// frame 18
								questionFrame18 = new ButtonSprite(400, 130, resourcesManager.frameTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											questionFrame18.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											// load guess the missing letter scene
											// and dispose the main menu scene
											//SceneManager.getInstance().loadGTMLScene();
											questionFrame18.setScale(1.f);
											break;
										}
										
										return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
									}
									
								};
								registerTouchArea(questionFrame18);
								attachChild(questionFrame18);
						
								// frame 19
								questionFrame19 = new ButtonSprite(500, 130, resourcesManager.frameTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											questionFrame19.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											// load guess the missing letter scene
											// and dispose the main menu scene
											//SceneManager.getInstance().loadGTMLScene();
											questionFrame19.setScale(1.f);
											break;
										}
										
										return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
									}
									
								};
								registerTouchArea(questionFrame19);
								attachChild(questionFrame19);
								
								// frame 20
								questionFrame20 = new ButtonSprite(600, 130, resourcesManager.frameTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											questionFrame20.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											// load guess the missing letter scene
											// and dispose the main menu scene
											//SceneManager.getInstance().loadGTMLScene();
											questionFrame20.setScale(1.f);
											break;
										}
										
										return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
									}
									
								};
								registerTouchArea(questionFrame20);
								attachChild(questionFrame20);
								
								// frame 21
								questionFrame21 = new ButtonSprite(700, 130, resourcesManager.frameTextureRegion, vbom) {
									@Override
									public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
										switch(pSceneTouchEvent.getAction()) {
										case TouchEvent.ACTION_DOWN:
											questionFrame21.setScale(1.3f);
											break;
										case TouchEvent.ACTION_UP:
											// load guess the missing letter scene
											// and dispose the main menu scene
											//SceneManager.getInstance().loadGTMLScene();
											questionFrame21.setScale(1.f);
											break;
										}
										
										return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
									}
									
								};
								registerTouchArea(questionFrame21);
								attachChild(questionFrame21);
		// QUESTION HEADER
		qheader = new Sprite(400, 430, resourcesManager.qHeaderTextureRegion, vbom);
		attachChild(qheader);
		
		// BACK BUTTON
	
	/*back = new ButtonSprite(740, 60, resourcesManager.backTextureRegion, vbom) {
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
		*/
		camera.setHUD(mainMenuHUD);
	
	}
	
	
}
