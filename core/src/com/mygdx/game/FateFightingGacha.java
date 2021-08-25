package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.PantallaCarga;
import Screens.ScreenManager;
import utiles.Render;
public class FateFightingGacha extends Game {
	SpriteBatch b;
	Texture img;
	int x,y;
	 
	@Override
	public void create () {
		Render.batch=new SpriteBatch();
		this.setScreen(new PantallaCarga());
	

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		b.dispose();
		super.dispose();
	}
}
