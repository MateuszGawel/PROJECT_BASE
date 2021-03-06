package com.apptogo.PROJECT_NAME;

import com.apptogo.PROJECT_NAME.callback.GameCallback;
import com.apptogo.PROJECT_NAME.main.Main;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import android.os.Bundle;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		
		GameCallback gameCallback = new GameCallbackImpl();
		
		initialize(new Main(gameCallback), config);
	}
}
