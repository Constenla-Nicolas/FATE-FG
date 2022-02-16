package Screens;
 
 
 

import java.time.Year;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import Entradas.direcciones;
 
import Online.server;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.*;
 

public class SeleccionPJ  implements Screen,TieneFondo, InputEvent {
    private Imagen fondoImagen;
    
	private SpriteBatch b;
    private Imagen flecha[]= new Imagen[4];
    int listo=0;
    public personajePrefab p;
	private Imagen[][] portrait= new Imagen[4][2]; // 0 es astolfo, 1 mordred, 2 jeanne, 3 atalante
    private Imagen[] portraitEnemigo=new Imagen[4];
    private boolean uno,dos;
    int opc =0;
    int cont;
     float ts, period;
    boolean npc=false;


    AtlasRegion[] a;
    @Override
    public void show() { 
       
        Config.addListInput(this);
        p = new Mordred();
         setFondo();
		b = Render.batch;
        mostrarRetrato(); 
        listapj();
    
        b.begin();
        
        b.end();
    }

    

    private void listapj(){
        
        int[] posEspecif={0,10,20,8};

        for (int i = 0; i < Retratos.values().length; i++) {
            portrait[i][0]= new Imagen(Retratos.values()[i].getRoot2());
            portrait[i][0].setSize(Config.tamanioDeAlgo(15, Config.WIDTH),Config.tamanioDeAlgo(30, Config.HEIGHT));
           
        }
        float posx =Config.centrado(Config.HEIGHT+Config.SacarPorcentaje(65, Config.HEIGHT));
       
         for (int j = 0; j < Retratos.values().length; j++) {
            float posy =Config.centrado(Config.WIDTH-Config.SacarPorcentaje(28, Config.WIDTH));
            posx=posx+Config.SacarPorcentaje(posEspecif[j], Config.HEIGHT);
            if(j==3){posy=posy-Config.SacarPorcentaje(3, Config.HEIGHT);}
            portrait[j][0].setPosition(posx, posy);
            flecha[j].setPosition(posx+Config.SacarPorcentaje(5, Config.WIDTH), posy+Config.SacarPorcentaje(31,Config.HEIGHT));
           
        }
  
        }
 
    
    
    public void mostrarRetrato(){


        
    for (int i = 0; i < Retratos.values().length; i++) {
        flecha[i] = new Imagen(Recursos.FLECHA);
        flecha[i].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(10, Config.HEIGHT));
        
        portrait[i][1] = new Imagen(Retratos.values()[i].getRoot());
        portrait[i][1].setSize(Config.tamanioDeAlgo(35, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
        portrait[i][1].setPosition(Config.centrado(Config.WIDTH)- Config.SacarPorcentaje(18.3f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));  
        
    }
      for (int i = 0; i < Retratos.values().length; i++) {
    portraitEnemigo[i] = new Imagen(Retratos.values()[i].getRoot());
    portraitEnemigo[i].setSize(Config.tamanioDeAlgo(40, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
    portraitEnemigo[i].setPosition(Config.centrado(Config.WIDTH)+ Config.SacarPorcentaje(50.6f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));

          
      }
    

        
   }

    @Override
    public void render(float delta) {
        // if (Config.ONLINE==true) { }
           
        // else{}
       Render.cleaner();
         

// if (direcciones.ARRIBA.isActive()) {
//     //server.getUsuario().y++;
// }

        
       b.begin();




 
       
     ts +=Gdx.graphics.getRawDeltaTime();
     if(ts > period){
         ts-=period; 
         
    
     }
     for (int i = 0; i < portrait.length; i++) {
            portrait[i][0].dibujar();
        }
       fondoImagen.dibujar();
       
       b.end();
        
    }

   
    @Override
    public void resize(int width, int height) {
        Config.getViewport().update(width, height);
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
       b.dispose();
        for (int i = 0; i < portrait.length; i++) {
            for (int j = 0; j < portrait[0].length; j++) {
                portrait[i][j].dispose();
            }
        }
        for (int i = 0; i < portraitEnemigo.length; i++) {
            portraitEnemigo[i].dispose();
        }
       fondoImagen.dispose();
    }
    @Override
    public void setFondo() {
      
        fondoImagen=new Imagen(Recursos.SELECCPJ);
		fondoImagen.setSize(Config.WIDTH, Config.HEIGHT);
    }



    @Override
    public void handleInput() {
        System.out.println(server.getMsg());
                server.enviarAtodos(server.getMsg());
               if (server.getMsg().equals("enter")) {
                    
                cont++;
             
               }
               if (cont==2) {
                   server.enviarAtodos("seleccionescenario");
                   cont=0;
               }
             
              
          
         
        
 
    }
 
  
 
}
   
 