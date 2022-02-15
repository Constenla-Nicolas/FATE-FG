package Screens.Batalla;


import java.security.Key;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Rectangle;

import Entradas.Direcciones;
import Entradas.Entradas;
import Online.cliente;
import Screens.Hud;
import Screens.HudBarra;
import Screens.TieneFondo;
import personajes.Astolfo;
import personajes.Mordred;
import personajes.personajePrefab;
import personajes.personajePrefab.Estado;
import utiles.Config;
import utiles.Imagen;
import utiles.InputEvent;
import utiles.Render;
public class Escenarios implements Screen,TieneFondo,InputEvent{
   SpriteBatch b;
   float velocidad = 0f,velocidad2=0f;
   float  gravedad = 5f;
   protected Imagen fightstage;
   Hud hud;
   HudBarra hb;
   boolean animacion;
   float time, ts;
   float period= 0.9f;
   Mordred mordred;
   Astolfo astolfo;
   
   Entradas entradas = new Entradas();
  private String e;
  private int opc;
  private   personajePrefab p1;
  private  personajePrefab p2;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    this.p1=p1;
    this.p2=p2;
      if (cliente.getHiloC().getIdcliente()==0) {
        System.out.println("soy el cliente 0");
       cliente.enviarMensaje("escenarios");
       p1.setX(450);
       p1.setY(Config.HEIGHT/2);
       p2.setX(700);
       p2.setY(Config.HEIGHT/2);
       
    }
    else{
        p1.setX(700);
        p1.setY(Config.HEIGHT/2);
        p2.setX(450);
        p2.setY(Config.HEIGHT/2);
    }


    p1.setAnims();
    p2.setAnims();
    p1.setEstado(Estado.STANCE);
    p2.setEstado(Estado.STANCE);
    setFondo();
    Config.addListInput(this);


 }
    protected Escenarios(Imagen e2, personajePrefab p12, personajePrefab p22) {
    }
    @Override
    public void show() {

        b= Render.batch;
        hud= new Hud(b);
        hb= new HudBarra();
        p1.currentFrame = p1.stance.getKeyFrame(1);

        p2.currentFrame = p2.stance.getKeyFrame(1);


        Gdx.input.setInputProcessor(entradas);

    }
float a;
    @Override
    public void render(float delta) {

        
        inputSelec();
         time += delta;
         ts+=delta;
        if (ts>.03f ) {
            movement();
            ts=0;
                }
        Render.cleaner();
       b.begin();
        fightstage.dibujar();


      b.draw(p1.currentFrame, p1.getX(), p1.getY());
      b.draw(p2.currentFrame, p2.getX(), p2.getY());
 

 
        a=a+0.1f;

         b.end();

        b.begin();
        hb.dibujar();
        b.end();


        ActualizarBarras();

        hud.mostrarHud();
        hud.getCuentaAtras().setText(hud.getSec());
        // p1.box1.setPosition(p1.getX(), p1.getY());

        // p2.box1.setPosition(p2.getX(), p2.getY());

    //    if (hud.getSec()<=95) {
    //        // hud.terminarTimer();
    //         Render.app.setScreen(new PeleaTerminada(this.fightstage,this.p1,this.p2));
    // }
       



     }




    private void movement(){

         
        System.out.println(p1.getEstado());
        
        System.out.println(p2.getEstado());
        p1.setY(p1.getY() + (velocidad -= gravedad));

        if(p1.getY() <= Config.HEIGHT/2){
            p1.setY(Config.HEIGHT/2);
            p1.setEstado(Estado.STANCE);
        }

        p2.setY(p2.getY() + (velocidad2 -= gravedad));

        if(p2.getY() <= Config.HEIGHT/2){
            p2.setY(Config.HEIGHT/2);
            cliente.enviarMensaje("stance");

        }

        if((entradas.isUp() && p1.getEstado() == Estado.STANCE) || ((entradas.isUp() && entradas.isRight()) && p1.getEstado() == Estado.CORRER) ){
            if(p1.getEstado() == Estado.CORRERL){
            }
            p1.setEstado(Estado.SALTO);
            velocidad = 50;
            cliente.enviarMensaje("arriba"); 
        }
        else if(entradas.isDown()){
            p1.setEstado(Estado.AGACHADO);
            cliente.enviarMensaje("abajo");

        }
        else if(entradas.isA() && (!p1.a2 && !p1.a3) || (!p1.ataque1.isAnimationFinished(time) && p1.a1) ){
             
            p1.a1 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO1 ){
                p1.setEstado(Estado.AEREO1);
                cliente.enviarMensaje("aereo1");

                }
                else{
                    p1.setEstado(Estado.ATAQUED);
                    cliente.enviarMensaje("ataqued");
                }
                
                

        }
        else if(entradas.isS() && (!p1.a1 && !p1.a3) || (!p1.ataque2.isAnimationFinished(time) && p1.a2) ){
            p1.a2 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO2 ){
                p1.setEstado(Estado.AEREO2);
                cliente.enviarMensaje("aereo2");
                
            cliente.getHiloC().enviarMensaje(Direcciones.AEREO2.getString());
             
            }
                else{
                    p1.setEstado(Estado.ATAQUEM);
                    
                    cliente.enviarMensaje("ataquem");
                }
            }
        else if(entradas.isD() || (!p1.ataque4.isAnimationFinished(time) && p1.a3) && (!p1.a1 && !p1.a2)){
                p1.a3 = true;

                if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO3 ){
                    p1.setEstado(Estado.AEREO3);
                    
                    cliente.enviarMensaje("aereo3");
                    
            cliente.getHiloC().enviarMensaje(Direcciones.AEREO3.getString());
                    if(p1.getX() < p2.getX()){
                        if(entradas.isRight()){
                            p1.setX(p1.getX() + 10);

                        }
                        if(entradas.isLeft()){
                            p1.setX(p1.getX() - 5);

                        }
                    }
                    else{
                        if(entradas.isRight()){
                            p1.setX(p1.getX() + 5);

                        }
                        if(entradas.isLeft()){
                            p1.setX(p1.getX() - 10);

                        }

                    }
                    }
                    else{
                        p1.setEstado(Estado.ATAQUEF);
                        cliente.enviarMensaje("ataquef");
                    }
            }
        else if(entradas.isRight() && (!p1.a2 && !p1.a3 && !p1.a1)){
            if(p1.getEstado() != Estado.SALTO){
            p1.setEstado(Estado.CORRER);
            }
            
           // p1.setX(p1.getX() + 20);
           cliente.enviarMensaje("derecha");

        }
        else if(entradas.isLeft() && (!p1.a2 && !p1.a3 && !p1.a1)){
            if(p1.getEstado() != Estado.SALTO){
                p1.setEstado(Estado.CORRERL);
                }

            //    p1.setX(p1.getX() - 20);
             cliente.enviarMensaje("izquierda");
            }
           
        else{
           // cliente.enviarMensaje("quietecito");
        }
        p1.setEstadoAnterior(p1.getEstado());


        switch(p1.getEstado()){
            case SALTO:
            p1.currentFrame = p1.jump.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.jump.isAnimationFinished(time)){
                time = 0;
            }
            break;
            
            case AGACHADO:
            
            p1.currentFrame = p1.crouch.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            
            break;

            case ATAQUED:
            p1.currentFrame = p1.ataque4.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.ataque4.isAnimationFinished(time)){
                time = 0;
            }
            
            p1.a2 = false;
            p1.a3 = false;
            break;

            case ATAQUEM:
            p1.currentFrame = p1.ataque2.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.ataque2.isAnimationFinished(time)){
                time = 0;
            }
            p1.a1 = false;
            p1.a3 = false;
            break;

            case ATAQUEF:
            p1.currentFrame = p1.ataque3.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.ataque3.isAnimationFinished(time)){
                time = 0;
            }
            p1.a1 = false;
            p1.a2 = false;
            break;

            case AEREO1:
            p1.air1.setPlayMode(PlayMode.NORMAL);
            p1.currentFrame = p1.air1.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.air1.isAnimationFinished(time)){
                time = 0;
            }
            
            p1.a2 = false;
            p1.a3 = false;
            break;
            
            case AEREO2:
            p1.currentFrame = p1.air2.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.air2.isAnimationFinished(time)){
                time = 0;
            }
            
            p1.a1 = false;
            p1.a3 = false;
            break;
            case AEREO3:
            
            p1.currentFrame = p1.air3.getKeyFrame(time);
            if(p1.getX() > p2.getX() && !p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
            p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.air3.isAnimationFinished(time)){
                time = 0;
            }
            p1.a1 = false;
            p1.a2 = false;
            
            break;
            case CORRER:
            p1.currentFrame = p1.walk.getKeyFrame(time);
            if(p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.walk.isAnimationFinished(time)){
                time = 0;
            }
            
            break;
            case CORRERL:
            p1.currentFrame = p1.walk.getKeyFrame(time);
            if(!p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
            
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            if(p1.walk.isAnimationFinished(time)){
                time = 0;
            }
            
            break;
            default:
            p1.a1 = false;
            p1.a2 = false;
            p1.a3 = false;
            p1.currentFrame = p1.stance.getKeyFrame(time,true);
            if (p1.getX() > p2.getX() && !p1.currentFrame.isFlipX())  {
                p1.currentFrame.flip(true, false);
            }
            else if(p1.getX() < p2.getX() && p1.currentFrame.isFlipX()){
                p1.currentFrame.flip(true, false);
            }
           //b.draw(p1.currentFrame, p1.getX(), p1.getY());
            
           
                break;

                
        }
        
p2.setEstadoAnterior(p2.getEstado());


switch(p2.getEstado()){
    
  
    
    case AGACHADO:
    
    System.out.println("aaaaaaaaa");
    p2.currentFrame = p2.crouch.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
    
    break;
    case SALTO:
    
        p2.currentFrame = p2.jump.getKeyFrame(time);
        if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
            p2.currentFrame.flip(true, false);
        }
        else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
        }
       //b.draw(p2.currentFrame, p2.getX(), p2.getY());
        if(p2.jump.isAnimationFinished(time)){
            time = 0;
        }
        break;

    case ATAQUED:
    p2.currentFrame = p2.ataque4.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.ataque4.isAnimationFinished(time)){
        time = 0;
    }
    
    p2.a2 = false;
    p2.a3 = false;
    break;

    case ATAQUEM:
    p2.currentFrame = p2.ataque2.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.ataque2.isAnimationFinished(time)){
        time = 0;
    }
    p2.a1 = false;
    p2.a3 = false;
    break;

    case ATAQUEF:
    p2.currentFrame = p2.ataque3.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.ataque3.isAnimationFinished(time)){
        time = 0;
    }
    p2.a1 = false;
    p2.a2 = false;
    break;

    case AEREO1:
    p2.air1.setPlayMode(PlayMode.NORMAL);
    p2.currentFrame = p2.air1.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.air1.isAnimationFinished(time)){
        time = 0;
    }
    
    p2.a2 = false;
    p2.a3 = false;
    break;
    
    case AEREO2:
    p2.currentFrame = p2.air2.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.air2.isAnimationFinished(time)){
        time = 0;
    }
    
    p2.a1 = false;
    p2.a3 = false;
    break;
    case AEREO3:
    
    p2.currentFrame = p2.air3.getKeyFrame(time);
    if(p2.getX() > p1.getX() && !p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
    p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.air3.isAnimationFinished(time)){
        time = 0;
    }
    p2.a1 = false;
    p2.a2 = false;
    
    break;
    case CORRER:
    p2.currentFrame = p2.walk.getKeyFrame(time);
    if(p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.walk.isAnimationFinished(time)){
        time = 0;
    }
    
    break;
    case CORRERL:
    p2.currentFrame = p2.walk.getKeyFrame(time);
    if(!p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
    
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    if(p2.walk.isAnimationFinished(time)){
        time = 0;
    }
    
    break;
    default:
    p2.a1 = false;
    p2.a2 = false;
    p2.a3 = false;
    p2.currentFrame = p2.stance.getKeyFrame(time,true);
    if (p2.getX() > p1.getX() && !p2.currentFrame.isFlipX())  {
        p2.currentFrame.flip(true, false);
    }
    else if(p2.getX() < p1.getX() && p2.currentFrame.isFlipX()){
        p2.currentFrame.flip(true, false);
    }
   //b.draw(p2.currentFrame, p2.getX(), p2.getY());
    
   
        break;

        
}








    }

     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void ActualizarBarras() {
    if (p1.getVidaActual()!=p1.getVidamax()) {
           hb.Restarvida1(p1.getVidaActual());
        }
    if (p1.getVidaActual()!=p1.getVidamax()) {
        hb.Restarvida2(p1.getVidaActual());
    }
    if (p2.getCargasuper()!=0) {
        hb.Actualizarsuper1(p2.getCargasuper());
    }
    if (p1.getCargasuper()!=0) {
        hb.Actualizarsuper2(p1.getCargasuper());
    }

    }


public int inputSelec() {
    if(!Config.ONLINE){

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
    p1.currentFrame.getTexture().dispose();
    p1.currentFrame.getTexture().dispose();
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
        // System.out.println("handle input de escenario");
       

       if (cliente.getHiloC().MiPropioMensaje()) {

        switch (cliente.getMsg()) {
            case "posx":
            p1.setX(p1.getX()+cliente.getCantidad());
            
            break;
            
            case "izquierda":
            
            p1.setEstado(Estado.CORRERL);

            break;
            case "derecha":
            p1.setEstado(Estado.CORRER);
            break;


            case "arriba":
            p1.setEstado(Estado.SALTO);
            break;

            case "abajo":
            p1.setEstado(Estado.AGACHADO);

            break;
            
            case "ataquef":
            System.out.println("llego un ataque fuerte");
            p1.setEstado(Estado.ATAQUEF);
        

            break;
            case "ataquem":

            p1.setEstado(Estado.ATAQUEM);

            break;
            case "ataqued":

            p1.setEstado(Estado.ATAQUED);
            p1.a1 = true;
        
            break;
            case "aereo1":
            p1.setEstado(Estado.AEREO1);

            break;
            case "aereo2":
            p1.setEstado(Estado.AEREO2);
            break;
            case "aereo3":
            p1.setEstado(Estado.AEREO3);
            break;
            
            default:
                break;


        }

    }

    else if(!cliente.getHiloC().MiPropioMensaje()) {

         switch (cliente.getMsg()) {
            case "posx":
            p2.setX(p2.getX()+cliente.getCantidad());

            break;
            case "izquierda":
            // System.out.println("soeaumnaeotutnmaoeumnta");
            p2.setEstado(Estado.CORRERL);

            break;
            case "derecha":
            p2.setEstado(Estado.CORRER);

            break;


            case "arriba":
            velocidad2=50;
            p2.setEstado(Estado.SALTO);
            break;
            case "stance":
p2.setEstado(Estado.STANCE);
            break;

            case "abajo":
            p2.setEstado(Estado.AGACHADO);

            break;
            
            case "ataquef":
            System.out.println("llego un ataque fuerte");
            p2.setEstado(Estado.ATAQUEF);
        

            break;
            case "ataquem":

            p2.setEstado(Estado.ATAQUEM);

            break;
            case "ataqued":

            p2.setEstado(Estado.ATAQUED);
        
            break;
            case "aereo1":
            p2.setEstado(Estado.AEREO1);

            break;
            case "aereo2":
            p2.setEstado(Estado.AEREO2);
            break;
            case "aereo3":
            p2.setEstado(Estado.AEREO3);
            break;
            default:
                break;




   }


    }


     
    }


 

}
