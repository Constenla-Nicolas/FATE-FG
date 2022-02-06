package Screens.Batalla;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Rectangle;

import Entradas.Entradas;
import Screens.Hud;
import Screens.HudBarra;
import Screens.TieneFondo;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import personajes.personajePrefab.Estado;
import utiles.Config;
import utiles.Imagen;
 
import utiles.Render;
public class Escenarios implements Screen,TieneFondo{
   SpriteBatch b;
   Estado asd;
   float velocidad = 0f; 
   float  gravedad = 10f;
   Rectangle player1Box, player2Box;
   protected Imagen fightstage;
   Hud hud;
   HudBarra hb;
   boolean animacion;
   float time, ts;
   float period= 0.9f;
   Mordred mordred;
   Astolfo astolfo;
   boolean a1, a2, a3 = false;
   Entradas entradas = new Entradas(this);
  private String e;
  private int opc;
  private   personajePrefab p1;
  private  personajePrefab p2;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    this.p1=p1;
    this.p2=p2;
 
    setFondo();
    
 }
    protected Escenarios(Imagen e2, personajePrefab p12, personajePrefab p22) {
    }
    @Override
    public void show() {
        
        b= Render.batch;
        hud= new Hud(b);
        hb= new HudBarra();
        
        mordred = new Mordred();   
        astolfo = new Astolfo();                                  
        Gdx.input.setInputProcessor(entradas);
        player2Box = new Rectangle(astolfo.img.getX(), astolfo.img.getY(), astolfo.img.getWidth(), astolfo.img.getHeight());
        p1.setY(Gdx.graphics.getHeight()/2);
        p1.setX(Gdx.graphics.getWidth()/4);
        p1.setEstado(Estado.STANCE);
        
       
    }
float a;
    @Override
    public void render(float delta) {
        inputSelec();
        mordred.setInput(opc);
        mordred.update(delta);
        time += delta;
        
        
        
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
       
    

        hb.dibujar();
       
        a=a+0.1f;
       movement();
       
         b.end();
         
        ActualizarBarras();
       
       
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());
        player2Box.setPosition(astolfo.img.getX(), astolfo.img.getY());

    //    // if (hud.getSec()<=95) {
    //         hud.terminarTimer();
    //         Render.app.setScreen(new PeleaTerminada(this.fightstage,this.p1,this.p2));
    // }
         
     }

    private void movement(){
        p1.setY(p1.getY() + (velocidad -= gravedad));
        
        if(p1.getY() < Gdx.graphics.getHeight()/2){
            p1.setY(Gdx.graphics.getHeight()/2);
            p1.setEstado(Estado.STANCE);
        }
        
        if((entradas.isUp() && p1.getEstado() == Estado.STANCE) || ((entradas.isUp() && entradas.isRight()) && p1.getEstado() == Estado.CORRER) ){
            p1.setEstado(Estado.SALTO);
            velocidad = 50;

        }
        else if(entradas.isDown()){
            p1.setEstado(Estado.AGACHADO);


        }
        else if(entradas.isA() && (!a2 && !a3) || (!p1.ataque1.isAnimationFinished(time) && a1) ){
            a1 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO1){
                p1.setEstado(Estado.AEREO1);
                
                }
                else{
                    p1.setEstado(Estado.ATAQUE1);
                    
                }
                

        }
        else if(entradas.isS() || (!p1.ataque2.isAnimationFinished(time) && a2) && (!a1 && !a3)){
            a2 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO2){
                p1.setEstado(Estado.AEREO2);
                }
                else{
                    p1.setEstado(Estado.ATAQUE2);
                } 
            }
            else if(entradas.isD() || (!p1.ataque4.isAnimationFinished(time) && a3) && (!a1 && !a2)){
                a3 = true;
                
                if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO3){
                    p1.setEstado(Estado.AEREO3);
                    }
                    else{
                        p1.setEstado(Estado.ATAQUE3);
                    } 
                }
        else if(entradas.isRight()){
            if(p1.getEstado() != Estado.SALTO){
            p1.setEstado(Estado.CORRER);
            }
            p1.setX(p1.getX() + 20);

        }      
        else if(entradas.isLeft()){
            if(p1.getEstado() != Estado.SALTO){
                p1.setEstado(Estado.CORRER);
                
                }
                p1.setX(p1.getX() - 20);
               }
       
        asd = p1.getEstado();
        
        System.out.println(p1.getEstado());
        switch(asd){
            case SALTO:
            b.draw(p1.jump.getKeyFrame(time), p1.getX(), p1.getY());
            
            break;
            case CORRER:
            b.draw(p1.walk.getKeyFrame(time, true), p1.getX()+100, p1.getY(), -200, 200);
            break;
            case AGACHADO:
            b.draw(p1.crouch.getKeyFrame(time), p1.getX(), p1.getY());
            break;
            case ATAQUE1:
            p1.air1.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air1.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air1.isAnimationFinished(time)){
                time = 0;
            }
            
            a2 = false;
            a3 = false;
            break;
            case ATAQUE2:
            p1.ataque2.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air2.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air2.isAnimationFinished(time)){
                time = 0;
            }
            a1 = false;
            a3 = false;
            break;
            case ATAQUE3:
            p1.ataque4.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air4.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air4.isAnimationFinished(time)){
                time = 0;
            }
            a1 = false;
            a2 = false;
            break;
            case AEREO1:
            p1.air1.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air1.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air1.isAnimationFinished(time)){
                time = 0;
            }
            
            a1 = false;
            a2 = false;
            a3 = false;
            break;
            
            case AEREO2:
            p1.air2.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air2.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air2.isAnimationFinished(time)){
                time = 0;
            }
            
            a1 = false;
            a2 = false;
            a3 = false;
            break;
            case AEREO3:
            p1.air3.setPlayMode(PlayMode.NORMAL);
            b.draw(p1.air3.getKeyFrame(time), p1.getX(), p1.getY());
            if(p1.air3.isAnimationFinished(time)){
                time = 0;
                
            a1 = false;
            a2 = false;
            a3 = false;
            }
            break;
            default:
            a1 = false;
            a2 = false;
            a3 = false;
            b.draw(p1.stance.getKeyFrame(time, true), p1.getX(), p1.getY(), 200, 200);
                break;

        }






        //  if(entradas.isLeft()){ 
        //     p1.setEstado(Estado.CORRER);
        //     p1.setX(p1.getX() - 6);
        //     b.draw(p1.walk.getKeyFrame(time, true), p1.getX(), p1.getY());	
            
        //     p1.walk.setPlayMode(PlayMode.LOOP_REVERSED);
		// }

        // else if(entradas.isDown()){
            
        //     b.draw(p1.crouch.getKeyFrame(time), p1.getX(), p1.getY());
        // }
		// else if(entradas.isRight()){
        //     p1.setEstado(Estado.CORRER);
        //     p1.setX(p1.getX() + 10);
        //     b.draw(p1.walk.getKeyFrame(time, true), p1.getX(), p1.getY());	
            
        //     p1.walk.setPlayMode(PlayMode.LOOP);
            
		// }
        // else if(entradas.isUp() && p1.getEstado() == Estado.STANCE){
           
        //     p1.setEstado(Estado.SALTO);
        //     velocidad = 50;
            
            
        //     b.draw(p1.jump.getKeyFrame(time, true), p1.getX(), p1.getY());

            
        // }
        // else if(entradas.isA()){
        //     if(p1.getEstado() == Estado.SALTO){
        //         b.draw(p1.air1.getKeyFrame(time, true), p1.getX(), p1.getY());
                

        //     }
        //     else{
        //         p1.ataque1.setPlayMode(PlayMode.LOOP);
        //     b.draw(p1.ataque1.getKeyFrame(time, true), p1.getX(), p1.getY());
        //     System.out.println(p1.ataque1.getKeyFrameIndex(time));
            
        //     }
        // }
        // else if(entradas.isS()){
        //     p1.ataque4.setPlayMode(PlayMode.LOOP);
        //     b.draw(p1.ataque4.getKeyFrame(time), p1.getX(), p1.getY());
        //     System.out.println(p1.ataque4.getKeyFrameIndex(time));
            
        // }
        // else if(entradas.isD() || animacion){
        //     if(time > 1){
        //         time = 0;
        //     }
        //     time += 0.1f;
        //     animacion = true;
        //     if(animacion){
        //     p1.ataque4.setPlayMode(PlayMode.LOOP);
        //     for (int i = 0; i < p1.ataque4.getFrameDuration(); i++) {
        //         b.draw(p1.ataque4.getKeyFrame(time), p1.getX(), p1.getY());
                
        //     }
        //     }
        //     animacion = false;

        // }

        // else if(p1.getY() == Gdx.graphics.getHeight()/2){

        //     p1.setEstado(Estado.STANCE);
        //     b.draw(p1.jump.getKeyFrame(time, true), p1.getX(), p1.getY());
            
        // }
        // else {
        //     b.draw(p1.jump.getKeyFrame(time, true), p1.getX(), p1.getY());
            
        // }

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
        //  
        
    }

    @Override
    public void pause() {
        //  
        
    }

    @Override
    public void resume() {
        //  
        
    }

    @Override
    public void hide() {
        //  
        
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
