package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.*;
import com.mygdx.game.FateFightingGacha;

public class MenuPrincipal implements Screen {
	private Imagen fondoImagen;
	private int a =0;
	private SpriteBatch b;
	public float tiempo;

	public MenuPrincipal(){}
	@Override
	public void show() {
		fondoImagen=new Imagen("badlogic.jpg");
		Render.bacth= new SpriteBatch();
		b = Render.bacth;
	}

	@Override
	public void render(float delta) {
		b.begin();
		fondoImagen.dibujar();
		b.end();
		
		
	 
	}


	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
