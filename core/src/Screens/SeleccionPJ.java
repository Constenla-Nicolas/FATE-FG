package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import personajes.Mordred;
import utiles.*;
 

public class SeleccionPJ implements Screen {
    private Imagen fondoImagen;
    private Mordred m;
	private SpriteBatch b;
	private Imagen portrait;
    private Imagen portraitEnemigo;
    AtlasRegion[] a;
    @Override
    public void show() { 
        fondoImagen=new Imagen(Recursos.SELECCPJ);
		fondoImagen.setSize(Config.WIDTH, Config.HEIGHT);
        
		b = Render.batch; 
        mostrarRetrato(1, false);
        mostrarRetrato(0,true);
       
    }
    public void mostrarRetrato(int opc,boolean p1){  // opc va a ser igual al personaje que el usuario elija
        if(p1==true){
            portrait = new Imagen(Retratos.values()[opc].getRuta());
            portrait.setSize(Config.tamanioDeAlgo(35, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
            portrait.setPosition(Config.centrado(Config.WIDTH)-((18.3f*Config.WIDTH)/100),Config.centrado(Config.HEIGHT)+((10.42f*Config.HEIGHT)/100));  

        }
        if(p1==false){
            
            portraitEnemigo = new Imagen(Retratos.values()[opc].getRuta());
            System.out.println(Retratos.values()[opc].getRuta());
           portraitEnemigo.setSize(Config.tamanioDeAlgo(40, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
        
             portraitEnemigo.setPosition(Config.centrado(Config.WIDTH)+((46.6f*Config.WIDTH)/100),Config.centrado(Config.HEIGHT)+((10.42f*Config.HEIGHT)/100));  
        }
}

    @Override
    public void render(float delta) {

       Render.cleaner();
        
       b.begin();
       portraitEnemigo.dibujar();
       portrait.dibujar();
       
       
       fondoImagen.dibujar();
     
       
       b.end();
        
    }

    @Override
    public void resize(int width, int height) {
        Config.getViewport().update(width, height);
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
       b.dispose();
       portrait.dispose();
       portraitEnemigo.dispose();
    }
    
}
