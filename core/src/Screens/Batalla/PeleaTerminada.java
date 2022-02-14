package Screens.Batalla;

 

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.Hud;
import Screens.HudBarra;
import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
 
import utiles.Render;

public class PeleaTerminada  extends Escenarios {
    SpriteBatch b;
    public PeleaTerminada(Imagen e, personajePrefab p1, personajePrefab p2){
        super(e,p1,p2);
        fightstage=e;
        b= Render.batch;
          super.hud = new Hud(b);
          hb= new HudBarra();
          Config.addListInput(this);
    
    
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
        
        hb.dibujar();
     b.end();
        super.hud.mostrarHud();
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
