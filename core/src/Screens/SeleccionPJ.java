package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.*;
 

public class SeleccionPJ implements Screen {
    private Imagen fondoImagen;

	private SpriteBatch b;
	 
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
        // TODO Auto-generated method stub
        
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
