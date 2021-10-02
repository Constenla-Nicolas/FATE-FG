package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config;

import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;
public class Escenarios implements Screen{
   SpriteBatch b;
   private Imagen fightstage;
   Hud hud;

    @Override
    public void show() {
        b= Render.batch;
       fightstage= new Imagen(Recursos.TESTING);
       fightstage.setSize(utiles.Config.WIDTH, utiles.Config.HEIGHT);
       hud= new Hud(b);
       
    
    }

    @Override
    public void render(float delta) {
        
        hud.mostrarHud();
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
