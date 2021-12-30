package com.mygdx.game;

import com.badlogic.gdx.Game;
 
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Online.Cliente;
import Screens.*;
import utiles.Config;
 
import utiles.Render;
public class FateFightingGacha extends Game {
	 
	Texture img;
	int x,y;
	 
	  
	@Override
	public void create () {
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
	      Render.app.setScreen(new SeleccionPJ());
	//	Render.app.setScreen(new Escenarios(Background.values()[0].getRoot()));
		

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		 
		super.dispose();
	}
}
