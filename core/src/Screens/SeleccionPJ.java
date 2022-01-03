package Screens;
 
 
 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
 
import Entradas.Entradas;
import personajes.personajePrefab;
import utiles.*;
 

public class SeleccionPJ  implements Screen,TieneFondo {
    private Imagen fondoImagen;
    private EntradaSelecc input = new EntradaSelecc(this);
	private SpriteBatch b;
    private Imagen flecha[]= new Imagen[4];
	private Imagen[][] portrait= new Imagen[4][2]; // 0 es astolfo, 1 mordred, 2 jeanne, 3 atalante
    private Imagen[] portraitEnemigo=new Imagen[4];
    private personajePrefab jugador;
    private personajePrefab jugador2;
    int opc =0;
    int cont;
    float ts, period;
    boolean npc=false;


    AtlasRegion[] a;
    @Override
    public void show() { 
       
        Gdx.input.setInputProcessor(input);
         setFondo();
		b = Render.batch;
        mostrarRetrato(); 
        listapj();
        
        
    }

    private void selecEscenario(){

      
        Render.app.setScreen(new Escenarios(Background.values()[opc].getRoot()));

    }

    private int inputSelec() {
        try {
            synchronized(input){
<<<<<<< HEAD
                  input.wait(90);
=======
                  input.wait(140);
                 
>>>>>>> dfe4b7540a258a7588ef62b4df4a365755648ed9
            }
            
          } catch (InterruptedException e) {
           
              e.printStackTrace();
          }
        
            
<<<<<<< HEAD
            if (input.isDown()) {
           
=======
            if (input.isA()) {
               
>>>>>>> dfe4b7540a258a7588ef62b4df4a365755648ed9
                if (opc==0) {
                    opc=3;
                }
                else{
                    opc=1;
                  
                }
            }
<<<<<<< HEAD
            if (input.isUp()) {
=======
            if (input.isD()) {
             
>>>>>>> dfe4b7540a258a7588ef62b4df4a365755648ed9
                if(opc==3){
                 opc=0;
                }
                else{
                    opc=1;
                   
                }
            }
          
            return opc;
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
          
   

        }

        
        
    
    
    public void mostrarRetrato( ){


        
    for (int i = 4; i < Retratos.values().length-4; i++) {
        flecha[i-4] = new Imagen(Recursos.FLECHA);
        flecha[i-4].setSize(Config.tamanioDeAlgo(4, Config.WIDTH),Config.tamanioDeAlgo(10, Config.HEIGHT));
        portrait[i-4][1] = new Imagen(Retratos.values()[i].getRoot());
        portrait[i-4][1].setSize(Config.tamanioDeAlgo(35, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
        portrait[i-4][1].setPosition(Config.centrado(Config.WIDTH)- Config.SacarPorcentaje(18.3f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));  
        
    }
      for (int i = 4; i < Retratos.values().length-4; i++) {
    portraitEnemigo[i-4] = new Imagen(Retratos.values()[i].getRoot());
    portraitEnemigo[i-4].setSize(Config.tamanioDeAlgo(40, Config.WIDTH), Config.tamanioDeAlgo(70, Config.HEIGHT));
    portraitEnemigo[i-4].setPosition(Config.centrado(Config.WIDTH)+ Config.SacarPorcentaje(50.6f, Config.WIDTH),Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(10.42f,  Config.HEIGHT));

          
      }
    

        
   }

    @Override
    public void render(float delta) {
        // if (Config.ONLINE==true) { }
           
        // else{}
       Render.cleaner();
         
        
       b.begin();
 
    
     ts +=Gdx.graphics.getRawDeltaTime();
     if(ts > period){
         ts-=period;
         handleEvent();
     }
     for (int i = 0; i < portrait.length; i++) {
            portrait[i][0].dibujar();
        }
       fondoImagen.dibujar();
       flecha[opc].dibujar();
       b.end();
        
    }

    private void handleEvent() {
  

       portrait[inputSelec()][1].dibujar();
      if (input.isEnter()) {
          
          jugador= Retratos.values()[inputSelec()+8].getClase();
          seleccionarEnemigo();
      } 

         if (!npc) {
              if(input.isEnter()) {
                System.out.println("a");

  
              jugador= Retratos.values()[inputSelec()+8].getClase();
            npc =true;
               System.out.println(jugador);

         }
        } else {
             portraitEnemigo[inputSelec()].dibujar();

             if (input.isEnter()) {
 
             System.out.println(jugador2);
              jugador2= Retratos.values()[inputSelec()+8].getClase();
         }
         }


    private void seleccionarEnemigo() {
        portraitEnemigo[inputSelec()].dibujar();
        if (input.isEnter()) {
          
            jugador2= Retratos.values()[inputSelec()+8].getClase();
            seleccionarEnemigo();
        } 
       
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public class EntradaSelecc extends Entradas{

        public EntradaSelecc(Screen app) {
            super(app);
             
        }
        @Override
        public boolean keyDown(int keycode) {
             
            switch (keycode) {
                case Keys.UP:
                    down=true;
                    return false;
                case Keys.DOWN:
                    up=true;
                    return false;
    
                case Keys.D:
                    d = true;
                    return false;
                
                case Keys.A:
                    a=true;
                    return false;
                case Keys.ENTER:
                    enter=true;
                    return false;
                default:
                    return false;
            }
       
        }

        @Override
        public boolean keyUp(int keycode){
            switch (keycode) {
                case Keys.UP:
                    down=false;
                    return false;
                case Keys.DOWN:
                    up=false;
                    return false;
    
                case Keys.D:
                    d = false;
                    return false;
                
                case Keys.A:
                    a=false;
                    return false;
                case Keys.ENTER:
                    enter=false;
                    return false;
                default:
                    return false;
            }
        }



        
    }
    

    
}
