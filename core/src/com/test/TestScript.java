package com.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScript extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		GameEngine.instance.init();
		Gdx.input.setInputProcessor(GameEngine.instance.inputManager.getController());
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		GameEngine.instance.update(Gdx.graphics.getDeltaTime());
		GameEngine.instance.render();
	}

	

}
