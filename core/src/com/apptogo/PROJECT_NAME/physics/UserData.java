package com.apptogo.PROJECT_NAME.physics;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class UserData {
	//new fields may be added
	public String key; //general unique key of fixture
	public String type; //general type of fixture (can be anything)
	
	//used for body builder and for texture offsets
	public float width;
	public float height;
	
	//flag for ignoring collision check
	public boolean ignoreCollision = false;
	
	public UserData() {
		type = "default";
	}

	public UserData(String key) {
		this();
		this.key = key;
	}

	/**
	 * @param fixture with userData
	 * @return userData of fixture
	 */
	public static UserData get(Fixture fixture) {
		return ((UserData) fixture.getUserData());
	}

	/**
	 * @param body with userData
	 * @return userData of body
	 */
	public static UserData get(Body body) {
		return ((UserData) body.getUserData());
	}
}
