package com.kokostudio.matchandmix.manager;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
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
import org.andengine.opengl.texture.region.TiledTextureRegion;
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
	// QFRAMES
	public BuildableBitmapTextureAtlas qFrameTextureAtlas;
	public ITextureRegion qHeaderTextureRegion;
	public TiledTextureRegion answeredTextureRegion;
	public TiledTextureRegion notAnsweredTextureRegion;
	
	// COMMON BUTTONS
	public BuildableBitmapTextureAtlas commonButtonsTextureAtlas;
	public TiledTextureRegion backTiledTextureRegion;
	public TiledTextureRegion nextTiledTextureRegion;
	public TiledTextureRegion prevTiledTextureRegion;
	
	// Splash Textures ********************************************************
	public BitmapTextureAtlas SplashTextureAtlas;
	public ITextureRegion SplashTextureRegion;
	
	// PLAY MENU TEXTURES **********************************************
	public BuildableBitmapTextureAtlas playMenuTextureAtlas;
	public ITextureRegion playMenuBackgroundTexture;
	public TiledTextureRegion playTiledTextureRegion;
	
	// MAIN MENU TEXTURES **********************************************
	public BuildableBitmapTextureAtlas mainMenuTextureAtlas;
	public ITextureRegion menuHeaderTextureRegion;
	public TiledTextureRegion gamesTiledTextureRegion;
	public TiledTextureRegion progressTiledTextureRegion;
	public TiledTextureRegion howtoTiledTextureRegion;
	public TiledTextureRegion aboutTiledTextureRegion;
	public TiledTextureRegion optionTiledTextureRegion;
	public TiledTextureRegion exitTiledTextureRegion;
	
	// GAME MENU TEXTURES ***************************************************************
	public BuildableBitmapTextureAtlas gameMenuTextureAtlas;
	public TiledTextureRegion guessTextureRegion;
	
	// ABOUT PANELS ***********************************************
	public BuildableBitmapTextureAtlas AboutSceneTextureAtlas;
	public ITextureRegion aboutpanelTextureRegion;
	
	
	//---------------------------------------------------------------------------
	// SFX
	//--------------------------------------------------------------------------
	
	//-----------------------------
	// CLASS LOGIC
	//-----------------------------
	
	// CREATE GENERAL BACKGROUND AND ENTITIES ==========================================================================================
	public void createGeneralBackground() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		bgTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 1024, 1024);
		bgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bgTextureAtlas, activity, "background.png", 10, 10);
		bgTextureAtlas.load();
	}
	public void unloadBackground() {
		bgTextureAtlas.unload();
	}
	// QUESTION FRAMES
	public void createQuestionFrames() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		qFrameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 256);
		qHeaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(qFrameTextureAtlas, activity, "question_header.png");
		answeredTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(qFrameTextureAtlas, activity, "ans.png", 2,1);	
		notAnsweredTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(qFrameTextureAtlas, activity, "not_ans.png", 2,1);
		try {
			this.qFrameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.qFrameTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	public void unloadQuestionFrame() {
		qFrameTextureAtlas.unload();
	}
	
	// COMMON BUTTONS
	public void createCommonButtons() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		commonButtonsTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 300, 300);
		backTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(commonButtonsTextureAtlas, activity, "back_btn.png", 2, 1);
		nextTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(commonButtonsTextureAtlas, activity, "next_btn.png", 2, 1);
		prevTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(commonButtonsTextureAtlas, activity, "prev_btn.png", 2, 1);
		try {
			this.commonButtonsTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.commonButtonsTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	public void unloadCommonButtons() {
		commonButtonsTextureAtlas.unload();
	}
	
	// SPLASH SCENE ==================================================================================================================
	public void loadSplashScene() {
		//BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		//SplashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		//SplashTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(playMenuTextureAtlas, activity, "loading.png");	
	}
	
	public void unloadSplashScene() {
		SplashTextureAtlas.unload();
		SplashTextureRegion = null;
	}
	
	// PLAY MENU SCENE ========================================================================================================================
	public void loadPlayMenuResources() {
		loadPlayMenuGraphics();
		loadPlayMenuAudio();
	}
	
	public void loadPlayMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu_play/");
		playMenuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		playMenuBackgroundTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(playMenuTextureAtlas, activity, "playmenu_background.png");
		playTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(playMenuTextureAtlas, activity, "play_btn.png", 2,1);
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
	
	
	// MAIN MENU SCENE ======================================================================================================================
	public void loadMainMenuResources() {
		createGeneralBackground();
		createCommonButtons();
		loadMainMenuGraphics();
		loadMainMenuAudio();
	}
	
	public void loadMainMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu_main/");
		mainMenuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
		menuHeaderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, activity, "menu_header.png");
		gamesTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "games_btn.png", 2, 1);
		progressTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "prog_btn.png", 2, 1);
		howtoTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "htp_btn.png", 2, 1);
		aboutTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "about_btn.png", 2, 1);
		optionTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "option_btn.png", 2, 1);
		exitTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, activity, "quit_btn.png", 2, 1);
		try {
			this.mainMenuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.mainMenuTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	
	public void loadMainMenuAudio() {
		
	}
	// UNLOAD
	public void unloadMainMenuTextures() {
		unloadBackground();
		mainMenuTextureAtlas.unload();
	}
	
	// GAME MENU SCENE ======================================================================================================================
	public void loadGameMenuResources() {
		createGeneralBackground();
		createCommonButtons();
		loadGameMenuGraphics();
		loadGameMenuAudio();
	}
	
	public void loadGameMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu_games/");
		gameMenuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024);
		guessTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(gameMenuTextureAtlas, activity, "gml_btn.png", 2, 1);
		try {
			this.gameMenuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 1));
			this.gameMenuTextureAtlas.load();
		} catch(final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}
	
	public void loadGameMenuAudio() {
		
	}
	// UNLOAD
	public void unloadGameMenuTexture() {
		unloadBackground();
		gameMenuTextureAtlas.unload();
	}
	
	// PROGRESS SCENE =======================================================================================================================
	
	// OPTION SCENE =========================================================================================================================
	
	// ABOUT SCENE ==========================================================================================================================
	
	//------------------------------------------------------------------------
	// GAMES LOADING TEXTURE AREA
	//------------------------------------------------------------------------
	
	// MATCH IT !!!! ============================================================================================================
	public void loadMatchItResources() {
		createQuestionFrames();
		createGeneralBackground();
		loadMatchItGraphics();
		loadMatchItAudio();
	}
	
	public void loadMatchItGraphics() {
		
	}
	
	public void loadMatchItAudio() {
		
	}
	
	// UNLOAD
	public void unloadMatchItResources() {
		unloadQuestionFrame();
		unloadBackground();
		unloadQuestionFrame();
	}

	// MATCH IT PANEL
	public void loadMatchItPanelResources() {
		createGeneralBackground();
		createQuestionFrames();
		loadMatchItPanelGraphics();
		loadMatchItPanelAudio();
	}
	
	public void loadMatchItPanelGraphics() {
		
	}
	
	public void loadMatchItPanelAudio() {
		
	}

	// GUESS THE MISSING LETTER !!!! =========================================================================================================
	public void loadGTMLResources() {
		createGeneralBackground();
		createQuestionFrames();
		loadGTMLGraphics();
		loadGTMLAudio();
	}
	
	public void loadGTMLGraphics() {
		
	}
	
	public void loadGTMLAudio() {
		
	}
	// GTML PANEL
		public void loadGTMLPanelResources() {
			createGeneralBackground();
			createCommonButtons();
			loadGTMLPanelGrahics();
			loadGTMLPanelAudio();
		}
			
		public void loadGTMLPanelGrahics() {
			
		}
		public void loadGTMLPanelAudio() {
		
		}

	// UNLOAD
	public void unloadGTMLTextures() {
		unloadBackground();
		unloadQuestionFrame();
	}
	
	// COUNT IT !!!! =======================================================================================================================
	public void loadCountItResources() {
		loadCountItGraphics();
		loadCountItAudio();
	}
	
	public void loadCountItGraphics() {
		
	}
	
	public void loadCountItAudio() {
		
	}
	
	// UNLOAD
	
	// SOLVE IT !!!! =======================================================================================================================
	public void loadSolveItResources() {
		loadSolveItGraphics();
		loadSolveItAudio();
	}
	
	public void loadSolveItGraphics() {
		
	}
	
	public void loadSolveItAudio() {
		
	}
	
	// UNLOAD
	
	// THAT COLOR IS ???? ===================================================================================================================
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
