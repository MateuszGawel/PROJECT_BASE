package com.apptogo.PROJECT_NAME.screen;

import com.apptogo.PROJECT_NAME.main.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class BasicScreen implements Screen {
	//main instance of game
	protected Main game;

	protected Stage backStage;
	protected FillViewport backViewport;

	protected FitViewport frontViewport;
	protected Stage frontStage;

	public BasicScreen(Main game) {
		this.game = game;
	}

	@Override
	public void show() {

		this.backViewport = new FillViewport(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		this.backStage = new Stage(this.backViewport);
		((OrthographicCamera) backStage.getCamera()).position.set(0f, 0f, 0f);

		this.frontViewport = new FitViewport(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		this.frontStage = new Stage(this.frontViewport);
		((OrthographicCamera) frontStage.getCamera()).position.set(0f, 0f, 0f);

		Gdx.input.setInputProcessor(frontStage);

		prepare();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.backViewport.apply();
		this.backStage.act(delta);
		this.backStage.draw();

		step(delta);

		this.frontViewport.apply();
		this.frontStage.act(delta);
		this.frontStage.draw();

		handleInput();
	}

	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.BACK) || Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {

		}
	}
	
	@Override
	public void resize(int width, int height) {
		this.backStage.getViewport().update(width, height);
		this.frontStage.getViewport().update(width, height);
	}

	abstract protected void prepare();

	abstract protected void step(float delta);
	
	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

	public Stage getFrontStage() {
		return frontStage;
	}

	public Stage getBackStage() {
		return backStage;
	}
}
