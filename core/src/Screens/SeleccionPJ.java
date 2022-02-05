package Screens;
 
 
 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import Entradas.Direcciones;
import Entradas.Entradas;
import Online.cliente;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.*;
 

public class SeleccionPJ  implements Screen,TieneFondo,InputEvent {
    private Imagen fondoImagen;
   
	private SpriteBatch b;
    private Imagen flecha[]= new Imagen[4];
    private Imagen flecha2[]= new Imagen[4];
	private Imagen[][] portrait= new Imagen[4][2]; // 0 es astolfo, 1 mordred, 2 jeanne, 3 atalante
    private Imagen[] portraitEnemigo=new Imagen[4];
    private personajePrefab jugador;
    private personajePrefab jugador2;
    private int opc,opc2=0,opcOFF=0;
  
   
    boolean npc=false;
    cliente cl;
    private Entradas entradas= new Entradas();
    AtlasRegion[] a;
   
    @Override
    public void show() { 
        Config.addListInput(this);
        Gdx.input.setInputProcessor(entradas);
         setFondo();
		b = Render.batch;
        mostrarRetrato(); 
        listapj();
         
        
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
            flecha2[j].setPosition(posx+Config.SacarPorcentaje(5, Config.WIDTH), posy+Config.SacarPorcentaje(31,Config.HEIGHT));  
        }
  
        }
 
    
    
    public void mostrarRetrato( ){


        
    for (int i = 0; i < Retratos.values().length; i++) {
        flecha[i] = new Imagen(Recursos.FLECHA);
        flecha[i].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(10, Config.HEIGHT));
        flecha2[i] = new Imagen(Recursos.FLECHA);
        flecha2[i].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(10, Config.HEIGHT));
        flecha2[i].getS().setColor(80,2,2,0.2f);
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
    
       Render.cleaner();
         
        
       b.begin();
        
     
        Accionar();
    
      
     for (int i = 0; i < portrait.length; i++) {
            portrait[i][0].dibujar();
        }
       fondoImagen.dibujar();
        if (Config.ONLINE) {
            portrait[opc][1].dibujar();
            portraitEnemigo[opc2].dibujar();
              flecha[opc].dibujar();
              flecha2[opc2].dibujar();
        }
        else{
            flecha[opcOFF].dibujar();
        }
       b.end();
    
    }
     
     private void Accionar() {
           try {
                synchronized(entradas){
                    entradas.wait(140);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        if (Config.ONLINE) { 
             
            if (entradas.isLeft()) {
             
                cliente.getHiloC().enviarMensaje(Direcciones.IZQUIERDA.getString());
            } 
            if (entradas.isRight()) {
                 
                cliente.getHiloC().enviarMensaje(Direcciones.DERECHA.getString());
            } 
            if (entradas.isEnter()) {
               
                cliente.getHiloC().enviarMensaje(Direcciones.ENTER.getString());
            }
        }
        else{
            

           
             
         if (npc) {
             portraitEnemigo[inputOffline()].dibujar();

             if (entradas.isEnter()) {
              jugador2= Retratos.values()[inputOffline()].getClase(); 
              Render.app.setScreen(new SeleccionEscenarios(jugador, jugador2));
         }
         }
         else{portrait[inputOffline()][1].dibujar();
             if(entradas.isEnter()) {
            npc =true;
            jugador= Retratos.values()[inputOffline()].getClase();
              }
         }

        
        
        }

        

        }
    


    public int inputQueLlega() {
        boolean enter=false;
        if (cliente.getHiloC().MiPropioMensaje()) {
         
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
                  enter=true;
                   // entradas.stopInput();
                    break;
                default:
                    break;
            }
             
        }
     
        else{
          
             switch (cliente.getHiloC().getDir()) {
           case IZQUIERDA:
                
               if (opc2==0) {
                 
                opc2=3;
                 
            }
            else{
                opc2--;
                 
            }
               break;

               case DERECHA:
           
                  if(opc2==3){
                opc2=0;
               }
               else{
                   opc2++;
                  
               }
               
               break;
               case ENTER:
               jugador2=new Astolfo();
                System.out.println(jugador2);
               //    jugador2=Retratos.values()[opc].getClase();
                
               break;
           default:
               break;
       }
        
       
        }

 
        return 0;
}

     

    public int inputOffline() {

       
        

              if (entradas.isLeft()) {
              
                if (opcOFF==0) {
                     
                    opcOFF=3;
                     
                }
                else{
                    opcOFF--;
                    
                }
                
            }
            if (entradas.isRight()) {
                if(opcOFF==3){
                 opcOFF=0;
                }
                else{
                    opcOFF++;
                   
                }
                
            }
          
           
            return opcOFF;
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
        
         inputQueLlega();
        cliente.getHiloC().getDir().dontActive();
         
        
    }
 
  
 
}
   
 