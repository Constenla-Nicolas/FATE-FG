package com.mygdx.game;

import com.badlogic.gdx.Game;
  
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Online.HiloServidor;
import Online.server;
import Screens.*;
import Screens.Batalla.Escenarios;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
 
import utiles.Render;
public class FateFightingGacha extends Game {
	 
	 
	int x,y;
	 private server  sv;
	 personajePrefab p1, p2;
	  
	@Override
	public void create () {
		 
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
		sv = new server();
		p1 = new Mordred();
		p2 = new Astolfo();
		
		Render.app.setScreen(new SeleccionPJ());
		//Render.app.setScreen(new Escenarios(Background.values()[0].getRoot(), p1, p2));
		
		
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
		 Render.batch.dispose();
		super.dispose();
	}
}
