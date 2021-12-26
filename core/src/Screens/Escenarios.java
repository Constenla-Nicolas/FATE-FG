package Screens;

import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Config;
import utiles.Imagen;
import utiles.Render;
public class Escenarios implements Screen{
   SpriteBatch b;
   private Imagen fightstage;
   Hud hud;
    public Escenarios(){

 }
    @Override
    public void show() {
        fightstage= new Imagen(Background.ESCENARIO1.getRoot());
        fightstage.setSize(Config.tamanioDeAlgo(100, Config.WIDTH),Config.tamanioDeAlgo(100, Config.HEIGHT));
        fightstage.setPosition(Config.centrado(Config.WIDTH), Config.centrado(Config.HEIGHT));
        b= Render.batch;
        hud= new Hud(b);
       
    
    }

    @Override
    public void render(float delta) {
         
        Render.cleaner();
        
       b.begin();
        fightstage.dibujar();
       b.end(); 
       hud.mostrarHud(); 
       
     hud.getCuentaAtras().setText(hud.getSec());
      
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
    
    Render.batch.dispose();
    hud.dispose();
    }
    
}
