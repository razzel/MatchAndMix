package com.kokostudio.matchandmix.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.color.Color;
import org.andengine.engine.camera.Camera;
import com.kokostudio.matchandmix.base.BaseScene;
import com.kokostudio.matchandmix.manager.SceneManager.SceneType;

public class SplashScene extends BaseScene {
	
	private Sprite splash;

	@Override
	public void createScene() {
		setBackground(new Background(Color.YELLOW));
		/*splash = new Sprite(400, 240, resourcesManager.SplashTextureRegion, vbom);
		attachChild(splash);
		
		splash = new Sprite(0, 0, resourcesManager.SplashTextureRegion, vbom)
		{
		  @Override
		   protected void preDraw(GLState pGLState, Camera pCamera) 
		   {
		      super.preDraw(pGLState, pCamera);
		      pGLState.enableDither();
		    }
		};
		        
		splash.setScale(1.5f);
		splash.setPosition(400, 240);
		attachChild(splash);
*/
	}

	@Override
	public void onBackKeyPressed() {
		
	}

	@Override
	public SceneType getSceneType() {	
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		//splash.detachSelf();
		//splash.dispose();
		this.detachSelf();
		this.dispose();
	}
	
}
