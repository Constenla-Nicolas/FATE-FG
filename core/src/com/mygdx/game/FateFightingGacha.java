package com.mygdx.game;

import com.badlogic.gdx.Game;
  
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Online.HiloServidor;
import Online.server;
import Screens.*;
 
import utiles.Config;
 
import utiles.Render;
public class FateFightingGacha extends Game {
	 
	 
	int x,y;
	 private server  sv;
	  
	@Override
	public void create () {
		 
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
		sv = new server();
	 
		//Render.app.setScreen(new Escenarios(Background.values()[0].getRoot(), p1, p2));
		Render.app.setScreen(new SeleccionPJ());
		
	}
	 
	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		 if (Config.ONLINE) {
			 
	 sv.dispose();
	 
		 }
		 
		super.dispose();
	}
}
