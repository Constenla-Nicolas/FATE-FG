package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import personajes.Mordred;
import utiles.*;
 

public class SeleccionPJ implements Screen {
    private Imagen fondoImagen;
    private Mordred m;
	private SpriteBatch b;
	 
    @Override
    public void show() { 
        fondoImagen=new Imagen(Recursos.SELECCPJ);
		fondoImagen.setSize(Config.WIDTH,Config.HEIGHT);
        fondoImagen.setPosition(0,0);
        Render.batch= new SpriteBatch();
		b = Render.batch;
        
        
    }

    @Override
    public void render(float delta) {

       Render.cleaner();
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
