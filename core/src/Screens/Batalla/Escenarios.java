package Screens.Batalla;


import java.security.Key;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Rectangle;

import Entradas.Entradas;
import Entradas.direcciones;
import Online.server;
import Screens.Hud;
import Screens.HudBarra;
import Screens.TieneFondo;
import personajes.Astolfo;
import personajes.Atalante;
import personajes.Jeanne;
import personajes.Mordred;
import personajes.personajePrefab;
import personajes.personajePrefab.Estado;
import utiles.Config;
import utiles.Imagen;
import utiles.InputEvent;
import utiles.Render;
public class Escenarios implements Screen,TieneFondo,InputEvent{
   SpriteBatch b;
   int velocidad = 0; 
   int  gravedad = 10;
   protected Imagen fightstage;
   Hud hud;
   HudBarra hb;
   boolean animacion;
   int cont, cont2;
   float time, ts;
   float period= 0.9f;
   Mordred mordred;
   Astolfo astolfo;
   boolean a1, a2, a3, leftW = false;
   Entradas entradas = new Entradas(this);
  private String e;
  private int opc;
  private   personajePrefab p1;
  private  personajePrefab p2;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    this.p1=p1;
    this.p2=p2;
    Config.addListInput(this);
    setFondo();
    
 }
    
    protected Escenarios(Imagen e2, personajePrefab p12, personajePrefab p22) {
    }
    @Override
    public void show() {
        
        b= Render.batch;
        hud= new Hud(b);
        hb= new HudBarra();
         
        Gdx.input.setInputProcessor(entradas);
        
       
    }
float a;
    @Override
    public void render(float delta) {
        time += delta;
        
        
        
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
       
    
         b.end();
         
     
       
       
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());

    //    if (hud.getSec()<=0) {
    //         Render.app.setScreen(new PeleaTerminada(this.fightstage,this.p1,this.p2));
    //         server.getHl().enviarAtodos(direcciones.PELEATERMINADA.getString());
    // }
         
     }

   

    // private void movement(){
        
    //     p1.setY(p1.getY() + (velocidad -= gravedad));
        
    //     if(p1.getY() < Gdx.graphics.getHeight()/2){
    //         p1.setY(Gdx.graphics.getHeight()/2);
    //         p1.setEstado(Estado.STANCE);
    //     }
        
    //     if((entradas.isUp() && p1.getEstado() == Estado.STANCE) || ((entradas.isUp() && entradas.isRight()) && p1.getEstado() == Estado.CORRER) ){
    //         if(p1.getEstado() == Estado.CORRERL){
    //         }
    //         p1.setEstado(Estado.SALTO);
    //         velocidad = 50;

    //     }
    //     else if(entradas.isDown()){
    //         p1.setEstado(Estado.AGACHADO);


    //     }
    //     else if(entradas.isA() && (!a2 && !a3) || (!p1.ataque1.isAnimationFinished(time) && a1) ){
    //         a1 = true;
    //         if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO1 ){
    //             p1.setEstado(Estado.AEREO1);
    //             if(p1.getX() < p2.getX()){
    //             if(entradas.isRight()){
    //                 p1.setX(p1.getX() + 20);

    //             }
    //             if(entradas.isLeft()){
    //                 p1.setX(p1.getX() - 10);

    //             }
    //         }
    //         else{
    //             if(entradas.isRight()){
    //                 p1.setX(p1.getX() + 10);

    //             }
    //             if(entradas.isLeft()){
    //                 p1.setX(p1.getX() - 20);

    //             }

    //         }
                
    //             }
    //             else{
    //                 p1.setEstado(Estado.ATAQUED);
                    
    //             }
                

    //     }
    //     else if(entradas.isS() && (!a1 && !a3) || (!p1.ataque2.isAnimationFinished(time) && a2) ){
    //         a2 = true;
    //         if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO2 ){
    //             p1.setEstado(Estado.AEREO2);
    //             if(p1.getX() < p2.getX()){
    //                 if(entradas.isRight()){
    //                     p1.setX(p1.getX() + 15);
    
    //                 }
    //                 if(entradas.isLeft()){
    //                     p1.setX(p1.getX() - 8);
    
    //                 }
    //             }
    //             else{
    //                 if(entradas.isRight()){
    //                     p1.setX(p1.getX() + 8);
    
    //                 }
    //                 if(entradas.isLeft()){
    //                     p1.setX(p1.getX() - 15);
    
    //                 }
    
    //             }
    //         }
    //             else{
    //                 p1.setEstado(Estado.ATAQUEM);
    //             } 
    //         }
    //         else if(entradas.isD() || (!p1.ataque4.isAnimationFinished(time) && a3) && (!a1 && !a2)){
    //             a3 = true;
                
    //             if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO3 ){
    //                 p1.setEstado(Estado.AEREO3);
    //                 if(p1.getX() < p2.getX()){
    //                     if(entradas.isRight()){
    //                         p1.setX(p1.getX() + 10);
        
    //                     }
    //                     if(entradas.isLeft()){
    //                         p1.setX(p1.getX() - 5);
        
    //                     }
    //                 }
    //                 else{
    //                     if(entradas.isRight()){
    //                         p1.setX(p1.getX() + 5);
        
    //                     }
    //                     if(entradas.isLeft()){
    //                         p1.setX(p1.getX() - 10);
        
    //                     }
        
    //                 }
    //                 }
    //                 else{
    //                     p1.setEstado(Estado.ATAQUEF);
    //                 } 
    //             }
    //     else if(entradas.isRight() && (!a2 && !a3 && !a1)){
    //         if(p1.getEstado() != Estado.SALTO){
    //         p1.setEstado(Estado.CORRER);
    //         }
    //         if(p1.currentFrame.isFlipX()){
                
    //             p1.currentFrame.flip(true, false);
                
    //         }
    //         p1.setX(p1.getX() + 20);
            

    //     }      
    //     else if(entradas.isLeft()){
    //         if(p1.getEstado() != Estado.SALTO){
    //             p1.setEstado(Estado.CORRERL);
    //             }
                
    //             p1.setX(p1.getX() - 20);
    //         }
        
    //     p1.setEstadoAnterior(p1.getEstado());


    //     switch(p1.getEstado()){
    //         case SALTO:
    //         p1.currentFrame = p1.jump.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.jump.isAnimationFinished(time)){
    //             time = 0;
    //         }
    //         break;
            
    //         case AGACHADO:
    //         p1.currentFrame = p1.crouch.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.crouch.isAnimationFinished(time)){
    //             time = 0;
    //         }
    //         break;

    //         case ATAQUED:
    //         p1.currentFrame = p1.ataque4.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.ataque4.isAnimationFinished(time)){
    //             time = 0;
    //         }
            
    //         a2 = false;
    //         a3 = false;
    //         break;

    //         case ATAQUEM:
    //         p1.currentFrame = p1.ataque2.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.ataque2.isAnimationFinished(time)){
    //             time = 0;
    //         }
    //         a1 = false;
    //         a3 = false;
    //         break;

    //         case ATAQUEF:
    //         p1.currentFrame = p1.ataque3.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.ataque3.isAnimationFinished(time)){
    //             time = 0;
    //         }
    //         a1 = false;
    //         a2 = false;
    //         break;

    //         case AEREO1:
    //         p1.air1.setPlayMode(PlayMode.NORMAL);
    //         p1.currentFrame = p1.air1.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.air1.isAnimationFinished(time)){
    //             time = 0;
    //         }
            
    //         a2 = false;
    //         a3 = false;
    //         break;
            
    //         case AEREO2:
    //         p1.currentFrame = p1.air2.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.air2.isAnimationFinished(time)){
    //             time = 0;
    //         }
            
    //         a1 = false;
    //         a3 = false;
    //         break;
    //         case AEREO3:
            
    //         p1.currentFrame = p1.air3.getKeyFrame(time);
    //         if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //         p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.air3.isAnimationFinished(time)){
    //             time = 0;
    //         }
    //         a1 = false;
    //         a2 = false;
            
    //         break;
    //         case CORRER:
    //         p1.currentFrame = p1.walk.getKeyFrame(time);
    //         if(p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.walk.isAnimationFinished(time)){
    //             time = 0;
    //         }
            
    //         break;
    //         case CORRERL:
    //         p1.currentFrame = p1.walk.getKeyFrame(time);
    //         if(!p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
            
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
    //         if(p1.walk.isAnimationFinished(time)){
    //             time = 0;
    //         }
            
    //         break;
    //         default:
    //         a1 = false;
    //         a2 = false;
    //         a3 = false;
    //         p1.currentFrame = p1.stance.getKeyFrame(time,true);
    //         if (p1.getX() > p2.getX() && !p1.currentFrame.isFlipX())  {
    //             p1.currentFrame.flip(true, false);
    //         }
    //         else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
    //             p1.currentFrame.flip(true, false);
    //         }
    //         b.draw(p1.currentFrame, p1.getX(), p1.getY());
            
           
    //             break;

                
    //     }






      

    // }

     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    
     
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

    

    @Override
    public void handleInput() {
       
             
            switch (server.getHl().getDir()) {
                case IZQUIERDA:
                     
                 
                server.getHl().enviarAtodos(direcciones.POSX.getString()+",-15");
                
                    
                    break;
     
                    case DERECHA:
                    server.getHl().enviarAtodos(direcciones.POSX.getString()+",15");
                    
                    break;
                    case ARRIBA:
                    server.getHl().getDir().POSY.setPOSY(50);
                    server.getHl().enviarAtodos(server.getHl().getDir().POSY.getString());
                    server.getHl().getDir().POSY.reposy();

                    break;
                    case ENTER:
                     
                    
                    System.out.println("llego un enter");
                    break;
                default:
                    System.out.println("no me encuentro instruccion");
                    break;
            }
        
        
    }
    
}
