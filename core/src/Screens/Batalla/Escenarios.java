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
   float  gravedad = 10f;
   protected Imagen fightstage;
   Hud hud;
   HudBarra hb;
   boolean animacion;
   float time, ts;
   float period= 0.9f;
   Mordred mordred;
   Astolfo astolfo;
   boolean a1, a2, a3, leftW = false;
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
       cliente.getHiloC().enviarMensaje(Direcciones.ESCENARIOS.getString());
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


        Render.cleaner();
       b.begin();
        fightstage.dibujar();


      b.draw(p1.currentFrame, p1.getX(), p1.getY());
      b.draw(p2.currentFrame, p2.getX(), p2.getY());
        // System.out.println(p1.getX());
        // System.out.println(p2.getX());

     movement();

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

        p1.setY(p1.getY() + (velocidad -= gravedad));

        if(p1.getY() < Config.HEIGHT/2){
            p1.setY(Config.HEIGHT/2);
            p1.setEstado(Estado.STANCE);
        }

        p2.setY(p2.getY() + (velocidad2 -= gravedad));

        if(p2.getY() <= Config.HEIGHT/2){
            p2.setY(Config.HEIGHT/2);
            p2.setEstado(Estado.STANCE);
        }
        if((entradas.isUp() && p1.getEstado() == Estado.STANCE) || ((entradas.isUp() && entradas.isRight()) && p1.getEstado() == Estado.CORRER) ){
            if(p1.getEstado() == Estado.CORRERL){
            }
            p1.setEstado(Estado.SALTO);
            velocidad = 50;
            entradas.mandarOnline(19);
        }
        else if(entradas.isDown()){
            p1.setEstado(Estado.AGACHADO);
            entradas.mandarOnline(20);

        }
        else if(entradas.isA() && (!a2 && !a3) || (!p1.ataque1.isAnimationFinished(time) && a1) ){
            a1 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO1 ){
                p1.setEstado(Estado.AEREO1);
                if(p1.getX() < p2.getX()){
                if(entradas.isRight()){
                    p1.setX(p1.getX() + 20);

                }
                if(entradas.isLeft()){
                    p1.setX(p1.getX() - 10);

                }
            }
            else{
                if(entradas.isRight()){
                    p1.setX(p1.getX() + 10);

                }
                if(entradas.isLeft()){
                    p1.setX(p1.getX() - 20);

                }

            }

                }
                else{
                    p1.setEstado(Estado.ATAQUED);

                }
                
                

        }
        else if(entradas.isS() && (!a1 && !a3) || (!p1.ataque2.isAnimationFinished(time) && a2) ){
            a2 = true;
            if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO2 ){
                p1.setEstado(Estado.AEREO2);
                if(p1.getX() < p2.getX()){
                    if(entradas.isRight()){
                        p1.setX(p1.getX() + 15);

                    }
                    if(entradas.isLeft()){
                        p1.setX(p1.getX() - 8);

                    }
                }
                else{
                    if(entradas.isRight()){
                        p1.setX(p1.getX() + 8);

                    }
                    if(entradas.isLeft()){
                        p1.setX(p1.getX() - 15);

                    }

                }
            }
                else{
                    p1.setEstado(Estado.ATAQUEM);
                }
            }
            else if(entradas.isD() || (!p1.ataque4.isAnimationFinished(time) && a3) && (!a1 && !a2)){
                a3 = true;

                if(p1.getEstado() == Estado.SALTO || p1.getEstado() == Estado.AEREO3 ){
                    p1.setEstado(Estado.AEREO3);
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
                    }
                }
        else if(entradas.isRight() && (!a2 && !a3 && !a1)){
            if(p1.getEstado() != Estado.SALTO){
            p1.setEstado(Estado.CORRER);
            }
            if(p1.currentFrame.isFlipX()){

                p1.currentFrame.flip(true, false);

            }
           // p1.setX(p1.getX() + 20);
            entradas.mandarOnline(22);

        }
        else if(entradas.isLeft()){
            if(p1.getEstado() != Estado.SALTO){
                p1.setEstado(Estado.CORRERL);
                }

            //    p1.setX(p1.getX() - 20);
                entradas.mandarOnline(21);
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
            
            a2 = false;
            a3 = false;
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
            a1 = false;
            a3 = false;
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
            a1 = false;
            a2 = false;
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
            
            a2 = false;
            a3 = false;
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
            
            a1 = false;
            a3 = false;
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
            a1 = false;
            a2 = false;
            
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
            a1 = false;
            a2 = false;
            a3 = false;
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
      inputQueLlega();
       cliente.getHiloC().getDir().dontActive();
    }



    @Override
    public int inputQueLlega() {


        if (cliente.getHiloC().MiPropioMensaje()) {

            switch (cliente.getHiloC().getDir()) {
                case POSX:


                p1.setX(p1.getX() + cliente.getHiloC().darmayonesa());
                    p1.setEstado(Estado.CORRER);
                    break;

                case POSY:
                p1.setY(p1.getY() + cliente.getHiloC().darmayonesa()); //Envia a mi propio cliente

                break;
                
                   
                case HP:

                p1.setVidaActual(p1.getVidaActual()-Integer.parseInt(cliente.getHiloC().getDir().getString()) );
                break;
                default:
               
         
                    break;


            }

        }

        else if(!cliente.getHiloC().MiPropioMensaje()) {

             switch (cliente.getHiloC().getDir()) {

                case POSX:

                p2.setX(p2.getX() + cliente.getHiloC().darmayonesa());
                    break;
                case POSY:
                p2.setY(p2.getY() + cliente.getHiloC().darmayonesa());

                break;
           
                
                case HP:
                p2.setVidaActual(p2.getVidaActual()-Integer.parseInt(cliente.getHiloC().getDir().getString()) );
                break;
                default:
                    break;
       }


        }




        return 0;
    }

}
