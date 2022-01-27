package com.mygdx.game;

import com.badlogic.gdx.Game;
  
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 
import Screens.*;
import Screens.Batalla.Escenarios;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
 
import utiles.Render;
public class FateFightingGacha extends Game {
	 
 
	int x,y;
	 
	  
	@Override
	public void create () {
		personajePrefab p1,p2;
		p1=new Mordred();
		p2=new Mordred();
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
		Render.app.setScreen(new Escenarios(Background.values()[0].getRoot(), p1, p2));
		
		
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
