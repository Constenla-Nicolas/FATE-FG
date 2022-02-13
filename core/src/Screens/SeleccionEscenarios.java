package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Entradas.Direcciones;
import Entradas.Entradas;
import Online.cliente;
import Screens.Batalla.Escenarios;
import utiles.Config;
import personajes.personajePrefab;
import utiles.Imagen;
import utiles.InputEvent;
import utiles.Recursos;
import utiles.Render;

public class SeleccionEscenarios implements Screen,InputEvent {
    //private Entradas input = new Entradas(this);
   
   private personajePrefab j1;
   private personajePrefab j2;
    Imagen Escena[]=new Imagen[Background.values().length];
    Imagen portrait[]=new Imagen[Background.values().length];
    SpriteBatch b;
    Imagen flecha[]= new Imagen[4];
    static int opc=0;
    private Entradas entradas= new Entradas();
     
    public SeleccionEscenarios(personajePrefab j1, personajePrefab j2){
        b= Render.batch;
      Config.addListInput(this);
      if (cliente.getHiloC().getIdcliente()==0) {
          
          cliente.getHiloC().enviarMensaje(Direcciones.SELECCIONESCENARIOS.getString());
          System.out.println("soy el cliente 0");
      }else if (cliente.getHiloC().getIdcliente()==1) {
          entradas.stopInput();
      }
    
         this.j1=j1;
    this.j2=j2;
    Gdx.input.setInputProcessor(entradas);
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
        mostrarRetrato();
        
       for (int i = 0; i < Escena.length; i++) {
            Escena[i]=new Imagen(Background.values()[i].getRoot());
            Escena[i].setSize(Config.WIDTH,Config.HEIGHT);
       }

    }

    @Override
    public void render(float delta) {
        Render.cleaner();
       b.begin();
       



       if (Config.ONLINE) {
        if (entradas.isLeft()) {
            entradas.mandarOnline(21);
         }
         if (entradas.isRight()) {
            entradas.mandarOnline(22);
         }
         if(entradas.isEnter()){
            entradas.mandarOnline(66);
         }
           Escena[opc].dibujar();
       }
       else{
          Escena[inputOffline()].dibujar(); 
       }
       

      
      for (int i = 0; i < portrait.length; i++) {
        portrait[i].dibujar();
      }
       
       flecha[opc].dibujar();
       b.end();

      

    }





    
    
    public int inputOffline() {
        try {
            synchronized(entradas){
                 entradas.wait(90);
 
            }
            
          } catch (InterruptedException e) {
           
              e.printStackTrace();
          }
        
            
            if (entradas.isLeft()) {
              
                if (opc==0) {
                     
                    opc=3;
                   
                }
                else{
                    opc--;
                  
                }
            }
            if (entradas.isRight()) {
                if(opc==3){
                 opc=0;
                }
                else{
                    opc++;
                   
                }
            }
            if (entradas.isEnter()) {
                Render.app.setScreen(new Escenarios(Background.values()[opc].getRoot(),j1,j2));
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
        for (int i = 0; i < portrait.length; i++) {
            portrait[i].dispose();
            Escena[i].dispose();
        }
         for (int i = 0; i < Escena.length; i++) {
            flecha[i].dispose();
         }
        
    }
   
    @Override
    public void handleInput() {
         System.out.println("handle input de selesc");
       
        

         inputQueLlega();
       cliente.getHiloC().getDir().dontActive();
        
    }
    @Override
    public int inputQueLlega() {
            System.out.println("que esta entrando al switch"+cliente.getHiloC().getDir());
        switch (cliente.getHiloC().getDir()) {
            case IZQUIERDA:
                 
                if (opc==0) {
                  
                 opc=3;
                  
             }
             else{
                 opc--;
                  
             }
                break;
 
                case DERECHA:
                if(opc==3){
                 opc=0;
                }
                else{
                    opc++;
                   
                }
                
                break;
                case ENTER:
                entradas.stopInput();
                
                System.out.println("llego un enter");
                break;

         
                
            default:
                break;
        }
        return 0;
    }

    public static int getOpc() {
        return opc;
    }

   
   
    
}
