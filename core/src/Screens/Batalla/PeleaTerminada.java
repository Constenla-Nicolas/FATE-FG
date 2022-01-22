package Screens.Batalla;

 

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.Hud;
import personajes.personajePrefab;
 
import utiles.Render;

public class PeleaTerminada  extends Escenarios implements Screen {
    SpriteBatch b;
    public PeleaTerminada(String escenario,personajePrefab p1, personajePrefab p2) {
          super( escenario, p1, p2);



          b= Render.batch;
          super.hud = new Hud(b);
    }

    @Override
    public void show() {
         
         setFondo();
        
    }

    @Override
    public void render(float delta) {
     Render.cleaner();
    
     b.begin();
        super.fightstage.dibujar();
        
        super.hb.dibujar();
     b.end();
        super.hud.mostrarHud();
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
