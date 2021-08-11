package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.MenuPrincipal;
 
import utiles.Render;
import Screens.*;
import com.badlogic.gdx.Game;
public class FateFightingGacha extends Game {
	SpriteBatch b;
	Texture img;
	int x,y;
	 
	@Override
	public void create () {
		
	//	this.setScreen(new MenuPrincipal());

		Render.bacth=new SpriteBatch();
		b=Render.bacth;
		 
		
	}

	@Override
	public void render () {
		super.render();
		b.begin();
	 	 
		b.end(); 
	}
	
	@Override
	public void dispose () {
		b.dispose();
		img.dispose();
	}
}
