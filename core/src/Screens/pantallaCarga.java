package Screens;
 
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Imagen;
import utiles.Render;

public class pantallaCarga implements Screen{
   Imagen fondo;
   SpriteBatch b=Render.bacth;
    @Override
    public void show() {
       fondo= new Imagen("astolfo ending.jpg");
        
    }

    @Override
    public void render(float delta) {
      
        b.begin();

       

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
