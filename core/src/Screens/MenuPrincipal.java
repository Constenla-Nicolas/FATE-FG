package Screens;

import com.badlogic.gdx.Screen;
import utiles.*;
import com.mygdx.game.FateFightingGacha;

public class MenuPrincipal implements Screen {
	private Imagen fondoImagen;
	public int a =0;
	public MenuPrincipal(){
	
	}
	@Override
	public void show() {
		fondoImagen=new Imagen("badlogic.jpg");
		
	}

	@Override
	public void render(float delta) {
		fondoImagen.setTransparencia(a);
		System.out.println("hhh");
		fade();
	}


	public void fade (){
	

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
