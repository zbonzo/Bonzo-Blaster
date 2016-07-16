package com.zac.bonzoblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//public class BonzoBlaster extends ApplicationAdapter {
public class BonzoBlaster extends Game {
	SpriteBatch batch;
	public BitmapFont font;
	Texture img;

	//This is the start

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {

		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
