package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.*;

public class PantallaCarga implements Screen{
    Imagen fondo;

	SpriteBatch b;
	boolean fadeInTerminado = false, termina = false;
			float a = 0;
			float countTime = 0, waitTime = 5;
			float countTimerEnd = 0, timeEnde = 5;
	@Override
	public void show() {
		fondo = new Imagen(Recursos.FONDOS);
		fondo.setSize(Config.WIDTH, Config.HEIGHT);
		
		b = Render.batch;

		fondo.setTransparencia(1f);
		}

	@Override
	public void render(float delta) {
		
		Render.cleaner();
		procesarFade();
		b.begin();
		fondo.dibujar();
		
		
		b.end();

	}

	private void procesarFade() {
		fondo.setTransparencia(a);
		if (!fadeInTerminado) {
			a += 0.01f;
		if (a > 1) {
			a = 1;
			fadeInTerminado = true;
		}
		}else {
			countTime+=0.1f;
			if(countTime > waitTime) {
				a -= 0.01f;
				if (a < 0) {
					a = 0;
					termina = true;
				
				}
			}
		}
		fondo.setTransparencia(a);
		if(termina){
			countTimerEnd+=0.1f;
			if(countTimerEnd>timeEnde){
				Render.app.setScreen(new MenuPrincipal());
			}
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
