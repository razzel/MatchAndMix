package com.kokostudio.matchandmix.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.scene.MainMenuScene;
import com.kokostudio.matchandmix.scene.PlayMenuScene;
import com.kokostudio.matchandmix.scene.SplashScene;
import com.kokostudio.matchandmix.scene.game.GuessTheMissingLetter;
import com.kokostudio.matchandmix.scene.game.MatchIt;

public class SceneManager {
	
	//---------------------------------
	// SCENES
	//---------------------------------
	private BaseScene splashScene;
	private BaseScene playMenuScene;
	private BaseScene mainMenuScene;
	private BaseScene progressScene;
	private BaseScene optionScene;
	private BaseScene aboutScene;
	
	private BaseScene loadingScene;
	
	// GAMES
	private BaseScene MatchItScene;
	private BaseScene GuessTheMissingLetterScene;
	private BaseScene CountItScene;
	private BaseScene SolveItScene;
	private BaseScene ThatColorIsScene;
	//Panel GAME
	private BaseScene MatchItPanel;
	
	//---------------------------------
	// VARIABLES
	//---------------------------------
	private static final SceneManager INSTANCE = new SceneManager();
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	private BaseScene currentScene;
	private Engine engine = ResourcesManager.getInstance().engine;
	
	public enum SceneType {
		SCENE_SPLASH,
		SCENE_PLAYMENU,
		SCENE_MAINMENU,
		SCENE_PROGRESS,
		SCENE_OPTION,
		SCENE_ABOUT,
		SCENE_LOADING,
		//GAME SCENES
		SCENE_MATCHIT,
		SCENE_GTML,
		SCENE_COUNTIT,
		SCENE_SOLVEIT,
		SCENE_THATCOLORIS,	
		//GAME PANEL SCENES
		SCENE_MATCHITPANEL
	}
	
	//----------------------------------
	// CLASS LOGIC
	//----------------------------------
	
	// SPLASH SCENE
	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback) {
		ResourcesManager.getInstance().loadSplashScene();
		splashScene = new SplashScene();
		currentScene = splashScene;
		pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}
	
	public void disposeSplashScene() {
		ResourcesManager.getInstance().unloadSplashScene();
		splashScene.disposeScene();
		splashScene = null;
	}
	
	// PLAY MENU SCENE
	public void createPlayMenuScene() {
		ResourcesManager.getInstance().loadPlayMenuResources();
		playMenuScene = new PlayMenuScene();
		setScene(playMenuScene);
		disposeSplashScene();
	}
	
	public void loadPlayMenuScene() {
		// dispose the entities in the play menu scene
		mainMenuScene.disposeScene();
		ResourcesManager.getInstance().unloadMainMenuTextures();
		ResourcesManager.getInstance().unloadBackground();
		// load the play menu texture
		ResourcesManager.getInstance().loadPlayMenuTextures();
		setScene(playMenuScene);
	}
	
	// MAIN MENU SCENE
	public void loadMainMenuScene() {
		// unload the play menu texture
		ResourcesManager.getInstance().unloadPlayMenuTextures();	
		// load the main menu texture
		ResourcesManager.getInstance().loadMainMenuResources();
		mainMenuScene = new MainMenuScene();
		setScene(mainMenuScene);
	}
	
	// GAMES SCENES MANAGEMENT
	
	// GUESS THE MISSING LETTER SCENE
	public void loadGTMLScene() {
		// unload the main menu textures
		ResourcesManager.getInstance().unloadMainMenuTextures();
		// load the guess the missing letter resources
		ResourcesManager.getInstance().loadGTMLResources();
		GuessTheMissingLetterScene = new GuessTheMissingLetter();
		setScene(GuessTheMissingLetterScene);
		
	}
	
	// MAtch IT SCENE
	public void loadMatchItScene() {
		// unload the main menu textures
		ResourcesManager.getInstance().unloadMainMenuTextures();
		// load the guess the missing letter resources
		ResourcesManager.getInstance().loadMatchItResources();
		MatchItScene = new MatchIt();
		setScene(MatchItScene);
		
		
		
		
	}
	//----------------------------------
	// GETTERS AND SETTERS
	//----------------------------------
	public static SceneManager getInstance() {
		return INSTANCE;
	}
	
	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}
	
	public BaseScene getCurrentScene() {
		return currentScene;
	}	
	
	public void setScene(BaseScene scene) {
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}
	
	public void setSceneType(SceneType sceneType) {
		switch(sceneType) {
		case SCENE_SPLASH:
			setScene(splashScene);
			break;
		case SCENE_PLAYMENU:
			setScene(playMenuScene);
			break;
		case SCENE_MAINMENU:
			setScene(mainMenuScene);
			break;
		case SCENE_PROGRESS:
			setScene(progressScene);
			break;
		case SCENE_OPTION:
			setScene(optionScene);
			break;
		case SCENE_MATCHIT:
			setScene(MatchItScene);
			break;
		case SCENE_MATCHITPANEL:
			setScene(MatchItPanel);
			break;
		//
		default:
			break;
		}
	}

	public void loadMatchItPanelScene() {
		// unload the main menu textures
		ResourcesManager.getInstance().unloadMainMenuTextures();
		// load the guess the missing letter resources
		ResourcesManager.getInstance().loadMatchItResources();
		MatchItPanel = new MatchIt();
		setScene(MatchItPanel);
		
		
		// TODO Auto-generated method stub
		
	}
	
}
