package com.apptogo.PROJECT_NAME.plugin;

import com.apptogo.PROJECT_NAME.physics.ContactListener;
import com.apptogo.PROJECT_NAME.physics.UserData;
import com.badlogic.gdx.utils.Logger;

public abstract class SteeringPlugin extends AbstractPlugin {

	private final Logger logger = new Logger(getClass().getName(), Logger.DEBUG);

	private SoundPlugin soundHandler;

	@Override
	public void run() {
		if (ContactListener.SNAPSHOT.collide(UserData.get(actor.getBody()), "ground")) {

		}
	}

	@Override
	public void setUpDependencies() {
		soundHandler = actor.getPlugin(SoundPlugin.class);
	}
}
