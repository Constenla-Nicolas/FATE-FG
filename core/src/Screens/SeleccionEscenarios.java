package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Entradas.Entradas;
import utiles.Config;
import personajes.personajePrefab;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;

public class SeleccionEscenarios implements Screen {
    private Entradas input = new Entradas(this);
   
    personajePrefab j1;
    personajePrefab j2;
    Imagen Escena[]=new Imagen[Background.values().length];
    Imagen portrait[]=new Imagen[Background.values().length];
    SpriteBatch b;
    Imagen flecha[]= new Imagen[4];
    int opc=0;
    public SeleccionEscenarios(personajePrefab jugador1,personajePrefab jugador2){
        
        b= Render.batch;
       
         this.j1=jugador1;
         this.j2=jugador2;
         mostrarRetrato();

         

    }

    private void mostrarRetrato() {
        for (int i = 0; i < Escena.length; i++) {
            portrait[i]=new Imagen(Background.values()[i].getRoot2());
            portrait[i].setSize(Config.tamanioDeAlgo(50, Config.WIDTH), Config.tamanioDeAlgo(50, Config.HEIGHT));
            flecha[i] = new Imagen(Recursos.FLECHA);
            flecha[i].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(15, Config.HEIGHT));
          
        }
        // int[] posEspecif={0,5,5,8};
        
        // float posx =Config.centrado(Config.HEIGHT+Config.SacarPorcentaje(65, Config.HEIGHT));
       
        //  for (int j = 0; j < Background.values().length; j++) {
        //     float posy =Config.centrado(Config.WIDTH-Config.SacarPorcentaje(28, Config.WIDTH));
        //     posx=posx+Config.SacarPorcentaje(posEspecif[j], Config.WIDTH);
        //     if(j==3){posy=posy-Config.SacarPorcentaje(3, Config.HEIGHT);}
        //     portrait[j].setPosition(posx, posy);
        //     flecha[j].setPosition(posx+Config.SacarPorcentaje(5, Config.WIDTH), posy+Config.SacarPorcentaje(31,Config.HEIGHT)); 
        // }
       int posx=0;
            for (int i = 0; i < Background.values().length; i++) {
                portrait[i].setPosition(Config.centrado(Config.WIDTH) - Config.SacarPorcentaje(posx, Config.WIDTH) , Config.centrado(Config.HEIGHT));
                flecha[i].setPosition(Config.SacarPorcentaje(8, Config.WIDTH) + Config.SacarPorcentaje(posx, Config.WIDTH), Config.centrado(Config.HEIGHT)+ Config.SacarPorcentaje(40, Config.HEIGHT));
                posx+=16;
            }
         
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
       for (int i = 0; i < Escena.length; i++) {
            Escena[i]=new Imagen(Background.values()[i].getRoot());
            Escena[i].setSize(Config.WIDTH,Config.HEIGHT);
       }

    }

    @Override
    public void render(float delta) {
        Render.cleaner();
       b.begin();
       Escena[inputSelec()].dibujar();
       Seleccionar();
      for (int i = 0; i < portrait.length; i++) {
        portrait[i].dibujar();
      }
       
       flecha[opc].dibujar();
       b.end();

      

    }





    private void Seleccionar() {
        
        if (input.isEnter()) {
        Render.app.setScreen(new Escenarios(Background.values()[opc].getRoot(),j1,j2));
        }
    }

    public int inputSelec() {
        try {
            synchronized(input){
                  input.wait(90);
 
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
          
            return opc;
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
