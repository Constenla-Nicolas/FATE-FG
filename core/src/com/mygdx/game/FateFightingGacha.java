package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Screens.Escenarios;
import Screens.MenuPrincipal;
import Screens.PantallaCarga;
 
import Screens.SeleccionPJ;
import utiles.Config;
import utiles.Recursos;
import utiles.Render;
public class FateFightingGacha extends Game {
	SpriteBatch b;
	Texture img;
	int x,y;
	 
	 
	@Override
	public void create () {
		Render.batch=new SpriteBatch();
		Render.app = this;
		Config.initialize();
		
		Render.app.setScreen(new Escenarios());
		

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
