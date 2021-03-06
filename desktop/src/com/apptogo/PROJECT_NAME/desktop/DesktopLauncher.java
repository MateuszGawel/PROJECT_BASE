package com.apptogo.PROJECT_NAME.desktop;

import com.apptogo.PROJECT_NAME.callback.GameCallback;
import com.apptogo.PROJECT_NAME.main.Main;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		GameCallback gameCallback = new GameCallbackImpl();

		new LwjglApplication(new Main(gameCallback), config);
	}
}
