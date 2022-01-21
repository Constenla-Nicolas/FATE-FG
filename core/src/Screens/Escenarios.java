package Screens;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import Entradas.Entradas;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
 
import utiles.Render;
public class Escenarios implements Screen,TieneFondo{
   SpriteBatch b;
   Rectangle player1Box;
   Rectangle player2Box;
   private Imagen fightstage;
   Hud hud;
   HudBarra hb;
   float ts;
   float period= 0.9f;
   Mordred mordred;
   Astolfo astolfo;
   Entradas entradas = new Entradas(this);
  private String e;
  private int opc;
 private   personajePrefab p1;
  private  personajePrefab p2;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    this.p1=p1;
    this.p2=p2;
    System.out.println(p1);
    setFondo();
    
 }
    @Override
    public void show() {
        
        b= Render.batch;
        hud= new Hud(b);
        hb= new HudBarra();
        p1.mordredAnims();
        mordred = new Mordred();   
        astolfo = new Astolfo();                                  
        Gdx.input.setInputProcessor(entradas);
        player2Box = new Rectangle(astolfo.img.getX(), astolfo.img.getY(), astolfo.img.getWidth(), astolfo.img.getHeight());
       
    }
float a;
    @Override
    public void render(float delta) {
        inputSelec();
        mordred.setInput(opc);
        mordred.update(delta);
        
       // mordred.elapsedTime += delta;
        
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
       astolfo.img.dibujar();
       
      // b.draw(p1.intro.getKeyFrame(mordred.elapsedTime, true), 500, 500, 75, 100);
     
        hb.dibujar();
        movimiento();
        a=a+0.1f;
       
       
        
         b.end();
        ActualizarBarras();
       
       
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());
        player2Box.setPosition(astolfo.img.getX(), astolfo.img.getY());

       
    }



     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    private void ActualizarBarras() {
    if (p1.getVidaActual()!=p1.getVidamax()) {
           hb.Restarvida1(p1.getVidaActual());
        }
    if (p2.getVidaActual()!=p2.getVidamax()) {
        hb.Restarvida2(p2.getVidaActual());
    }
    if (p2.getCargasuper()!=0) {
        hb.Actualizarsuper1(p2.getCargasuper());
    }
    if (p1.getCargasuper()!=0) {
        hb.Actualizarsuper2(p1.getCargasuper());
    }

    }
    public void movimiento(){
        		
		if(entradas.isLeft()){ 	//entradas = input entrys
   
            
			}
		if(entradas.isRight()){
        
		
            
 
    }
 }

     
public int inputSelec() {
    try {
        synchronized(entradas){
              entradas.wait(90);

        }
        
      } catch (InterruptedException e) {
       
          e.printStackTrace();
      }
    
        
        if (entradas.isDown()) {
          
            if (opc==0) {
                 
                opc=3;
               
            }
            else{
                opc--;
              
            }
        }
        if (entradas.isUp()) {
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
     @Override
    public void setFondo() {
        fightstage= new Imagen(e);
        fightstage.setSize(Config.tamanioDeAlgo(100, Config.WIDTH),Config.tamanioDeAlgo(100, Config.HEIGHT));
        fightstage.setPosition(Config.centrado(Config.WIDTH), Config.centrado(Config.HEIGHT));
    }
    
}
