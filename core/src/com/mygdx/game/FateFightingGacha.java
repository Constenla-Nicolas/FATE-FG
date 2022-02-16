package com.mygdx.game;

import com.badlogic.gdx.Game;
  
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Online.cliente;
import Screens.*;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
 
import utiles.Render;
public class FateFightingGacha extends Game {
	 
 
	int x,y;
	 
	  
	@Override
	public void create () {
 
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
		//Render.app.setScreen(new Escenarios(Background.values()[0].getRoot(), p1, p2));
		
		Render.app.setScreen(new pantallaCarga());
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		if (Config.ONLINE) {
			cliente.dispose();
				}
		super.dispose();
		Render.batch.dispose();
	}
}
