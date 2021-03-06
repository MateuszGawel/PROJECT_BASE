package com.apptogo.PROJECT_NAME.main;



import com.apptogo.PROJECT_NAME.callback.GameCallback;
import com.apptogo.PROJECT_NAME.manager.CustomActionManager;
import com.apptogo.PROJECT_NAME.manager.ResourcesManager;
import com.apptogo.PROJECT_NAME.screen.BasicScreen;
import com.apptogo.PROJECT_NAME.screen.SplashScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Main class of the game. All constants can be defined here.	
 */
public class Main extends Game {
	// 20x40 in box2d units
	public static final float SCREEN_WIDTH = 1280f, SCREEN_HEIGHT = 800f;

	public static GameCallback gameCallback;

	public static Main getInstance() {
		return (Main) Gdx.app.getApplicationListener();
	}

	public Main(GameCallback gameCallback) {
		super();
		Main.gameCallback = gameCallback;
	}

	public BasicScreen getCurrentScreen() {
		return (BasicScreen) getScreen();
	}

	@Override
	public void setScreen(Screen screen) {
		//        if (this.screen != null && this.screen instanceof BasicScreen) {
		//        	((BasicScreen)this.screen).fadeOut(screen);
		//    	}
		//        else
		doSetScreen(screen);
	}

	public void doSetScreen(Screen screen) {
		if (this.screen != null) {
			this.screen.dispose();
		}
		super.setScreen(screen);
	}

	@Override
	public void create() {
		//use this to define log level. It overrides local settings
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		//set handle back button
		Gdx.input.setCatchBackKey(true);

		ResourcesManager.create();
		CustomActionManager.create();
		ResourcesManager.getInstance().loadResources();
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		ResourcesManager.destroy();
		CustomActionManager.destroy();
	}
}
