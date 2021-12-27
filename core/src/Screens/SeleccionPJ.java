package Screens;
 
 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import Entradas.Entradas;
 
import personajes.personajePrefab;
import utiles.*;
 

public class SeleccionPJ  implements Screen,TieneFondo {
    private Imagen fondoImagen;
    private Entradas input = new Entradas(this);
	private SpriteBatch b;
    private Imagen flecha[]= new Imagen[4];
	private Imagen[][] portrait= new Imagen[4][2]; // 0 es astolfo, 1 mordred, 2 jeanne, 3 atalante
    private Imagen portraitEnemigo;
    private personajePrefab jugador;
    private personajePrefab jugador2;
    int opc =0;
    int cont;
  
    AtlasRegion[] a;
    @Override
    public void show() { 
        Gdx.input.setInputProcessor(input);
         setFondo();
		b = Render.batch;
        mostrarRetrato(); 
        listapj();
        
        
    }
    
    private void seleccionar(){
        try {
            synchronized(input){
                  input.wait(120);
            }
            
          } catch (InterruptedException e) {
           
              e.printStackTrace();
          }
        
            
            if (input.isDown()) {
                if (opc==0) {
                    opc=3;
                }
                else{
                    opc--;
                  
                }
            }
            if (input.isUp()) {
                if(opc==3){
                 opc=0;
                }
                else{
                    opc++;
                   
                }
            }
            System.out.println(jugador);
         
         portrait[opc][1].dibujar();
        

         if (input.isEnter()) {
            jugador= Retratos.values()[opc+8].getClase();
         }
        
        
    }

    private void listapj(){
        
        int[] posEspecif={0,10,20,8};

        for (int i = 0; i < Retratos.values().length/3; i++) {
            portrait[i][0]= new Imagen(Retratos.values()[i].getRoot());
            portrait[i][0].setSize(Config.tamanioDeAlgo(15, Config.WIDTH),Config.tamanioDeAlgo(30, Config.HEIGHT));
           
        }
        float posx =Config.centrado(Config.HEIGHT+Config.SacarPorcentaje(65, Config.HEIGHT));
       
         for (int j = 0; j < Retratos.values().length/3; j++) {
            float posy =Config.centrado(Config.WIDTH-Config.SacarPorcentaje(28, Config.WIDTH));
            posx=posx+Config.SacarPorcentaje(posEspecif[j], Config.HEIGHT);
            if(j==3){posy=posy-Config.SacarPorcentaje(3, Config.HEIGHT);}
            portrait[j][0].setPosition(posx, posy);
            flecha[j].setPosition(posx+Config.SacarPorcentaje(5, Config.WIDTH), posy+Config.SacarPorcentaje(31,Config.HEIGHT)); 
        }
          
                       
        // jugador.setImagen(portrait[0][1]);
        // jugador2.setImagen(portrait[1][1]);

        }

        
        
    
    
    public void mostrarRetrato( ){

if (Config.ONLINE==true) {
           
}
else{
        
    for (int i = 4; i < Retratos.values().length-4; i++) {
        flecha[i-4] = new Imagen(Recursos.FLECHA);
        flecha[i-4].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(10, Config.HEIGHT));
        portrait[i-4][1] = new Imagen(Retratos.values()[i].getRoot());
        portrait[i-4][1].setSize(Config.tamanioDeAlgo(35, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
        portrait[i-4][1].setPosition(Config.centrado(Config.WIDTH)- Config.SacarPorcentaje(18.3f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));  
        ;
    }
      
    // portrait[] = new Imagen(Retratos.values()[4].getRoot());
    // portrait.setSize(Config.tamanioDeAlgo(35, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
    // portrait.setPosition  //  portraitEnemigo = new Imagen(Retratos.values()[5].getRoot());
    // portraitEnemigo.setSize(Config.tamanioDeAlgo(40, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
    // portraitEnemigo.setPosition(Config.centrado(Config.WIDTH)+ Config.SacarPorcentaje(50.6f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));

}
        
   }

    @Override
    public void render(float delta) {

       Render.cleaner();
         
        
       b.begin();
      seleccionar();
     for (int i = 0; i < portrait.length; i++) {
            portrait[i][0].dibujar();
        }
       fondoImagen.dibujar();
       flecha[opc].dibujar();
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
        // TODO  aaaaa
    }

    @Override
    public void dispose() {
       b.dispose();
      
       fondoImagen.dispose();
    }
    @Override
    public void setFondo() {
      
        fondoImagen=new Imagen(Recursos.SELECCPJ);
		fondoImagen.setSize(Config.WIDTH, Config.HEIGHT);
    }
    
}
