package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Render {


	public static SpriteBatch bacth;
	
	
	public static void Cleaner() {
		Gdx.gl.glClearColor(1, 0, 0, 1);	/*limpieza de pantalla*/
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
