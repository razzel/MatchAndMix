package com.kokostudio.matchandmix.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.kokostudio.matchandmix.GameActivity;

public class ResourcesManager {
	
	//-----------------------------
	// VARIABLES
	//-----------------------------
	private final static ResourcesManager INSTANCE = new ResourcesManager();
	
	public Engine engine;
	public GameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;
	
	//-----------------------------
	// TEXTURES & TEXTURE REGIONS
	//-----------------------------
	
	// BACKGROUND TEXTURE ****************************************
	public BitmapTextureAtlas bgTextureAtlas;
	public ITextureRegion bgTextureRegion;
	
	// ENTITIES *****************************************************
	public BuildableBitmapTextureAtlas entitiesTextureAtlas;
	public ITextureRegion frameTextureRegion;
	public ITextureRegion qHeaderTextureRegion;
	public ITextureRegion backTexture;
	
	// PLAY MENU TEXTURES **********************************************
	public BuildableBitmapTextureAtlas playMenuTextureAtlas;
	public ITextureRegion playMenuBackgroundTexture;
	public ITextureRegion playTextureRegion;
	
	// MAIN MENU TEXTURES **********************************************
	public BuildableBitmapTextureAtlas mainMenuTextureAtlas;
	public ITextureRegion pauseTextureRegion;
	public ITextureRegion aboutTextureRegion;
	public ITextureRegion gameGuessTextureRegion;
	public ITextureRegion matchitTextureRegion;
	public ITextureRegion SolveitTextureRegion;
	public ITextureRegion CountitTextureRegion;
	public ITextureRegion backTextureRegion;
	
	//-----------------------------
	// CLASS LOGIC
	//-----------------------------
	
	// CREATE GENERAL BACKGROUND AND ENTITIES
	public void createGeneralBackground() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		bgTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 896, 512);
		bgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bgTextureAtlas, activity, "background.png", 10, 10);
		bgTextureAtlas.load();
	}
	
	public void unloadBackground() {
		bgTextureAtlas.unload();
	}
	
	public void createQuestionEntities() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		entitiesTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 512);
		frameTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(entitiesTextureAtlas, activity, "question_frame.png");
		qHeaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(entitiesTextureAtlas, activity, "question_header.png");
		backTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(entitiesTextureAtlas, activity, "back.png");
		
		try {
			this.entitiesTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.entitiesTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	
	public void unloadQuestionFrame() {
		entitiesTextureAtlas.unload();
	}
	
	//// SPLASH SCENE////
	public void loadSplashScene() {
		
	}
	
	public void unloadSplashScene() {
		
	}
	
	//// PLAY MENU SCENE ////
	public void loadPlayMenuResources() {
		loadPlayMenuGraphics();
		loadPlayMenuAudio();
	}
	
	public void loadPlayMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		playMenuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		playMenuBackgroundTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(playMenuTextureAtlas, activity, "playmenu_background.png");
		playTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(playMenuTextureAtlas, activity, "play.png");
		
		try {
			this.playMenuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.playMenuTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	
	public void loadPlayMenuAudio() {
		
	}
	
	public void loadPlayMenuTextures() {
		playMenuTextureAtlas.load();
	}
	// UNLOAD
	public void unloadPlayMenuTextures() {
		playMenuTextureAtlas.unload();
	}
	
	
	//// MAIN MENU SCENE ////
	public void loadMainMenuResources() {
		loadMainMenuGraphics();
		loadMainMenuAudio();
		createGeneralBackground();
	}
	
	public void loadMainMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu_main/");
		mainMenuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		pauseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "pause.png");
		backTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "back.png");
		//aboutTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "about.png");
		gameGuessTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "guess_the_missing_letter.png");
		matchitTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "ci_btn.png");
		CountitTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "si_btn.png");
		try {
			this.mainMenuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.mainMenuTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	
	public void unloadMainMenuTextures() {
		mainMenuTextureAtlas.unload();
	}
	
	public void loadMainMenuAudio() {
		
	}
	
	// UNLOAD
	
	// PROGRESS SCENE
	
	// OPTION SCENE
	
	// ABOUT SCENE
	
	//------------------------------------------------------------------------
	// GAMES LOADING TEXTURE AREA
	//------------------------------------------------------------------------
	
	public void loadGameResources() {
		
	}
	
	//// MATCH IT !!!! ////
	public void loadMatchItResources() {
		loadMatchItGraphics();
		loadMatchItAudio();
	}
	
	public void loadMatchItGraphics() {
		
	}
	
	public void loadMatchItAudio() {
		
	}
	
	// UNLOAD

	///// GUESS THE MISSING LETTER !!!! ////
	public void loadGTMLResources() {
		createQuestionEntities();
		createGeneralBackground();
		loadGTMLGraphics();
		loadGTMLAudio();
	}
	
	public void loadGTMLGraphics() {
		
	}
	
	public void loadGTMLAudio() {
		
	}
	
	// UNLOAD
	
	//// COUNT IT !!!!  ////
	public void loadCountItResources() {
		loadCountItGraphics();
		loadCountItAudio();
	}
	
	public void loadCountItGraphics() {
		
	}
	
	public void loadCountItAudio() {
		
	}
	
	// UNLOAD
	
	//// SOLVE IT !!!!  ////
	public void loadSolveItResources() {
		loadSolveItGraphics();
		loadSolveItAudio();
	}
	
	public void loadSolveItGraphics() {
		
	}
	
	public void loadSolveItAudio() {
		
	}
	
	// UNLOAD
	
	//// THAT COLOR IS ???? ////
	public void loadThatColorIsResources() {
		loadThatColorIsGraphics();
		loadThatColorIsAudio();
	}
	
	public void loadThatColorIsGraphics() {
		
	}
	
	public void loadThatColorIsAudio() {
		
	}
	
	// UNLOAD
	
	//----------------------------------------------------------
	// SETTERS & GETTERS
	//----------------------------------------------------------
	
	public static void prepareManager(Engine eng, GameActivity act, Camera cam, VertexBufferObjectManager vbom) { // should be static
		getInstance().engine = eng;
		getInstance().activity = act;
		getInstance().camera = cam;
		getInstance().vbom = vbom;
	}
	
	public static ResourcesManager getInstance() {
		return INSTANCE;
	}
	
}
