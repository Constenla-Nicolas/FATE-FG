package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FateFightingGacha;

public class Render {


	public static SpriteBatch batch;
	
	public static FateFightingGacha app;
	public static void cleaner() {
		Gdx.gl.glClearColor(0, 0, 0, 1);	/*limpieza de pantalla*/
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	
}
