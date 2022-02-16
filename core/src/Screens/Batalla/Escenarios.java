package Screens.Batalla;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;

import Entradas.Entradas;
import Online.server;
import Screens.Hud;
import Screens.HudBarra;
import Screens.TieneFondo;
import personajes.personajePrefab;
import personajes.personajePrefab.Estado;
import utiles.Config;
import utiles.Imagen;
import utiles.InputEvent;
import utiles.Render;
public class Escenarios implements Screen,TieneFondo,InputEvent{
  private SpriteBatch b;
   private ShapeRenderer sr;
    private float tamanioenx,tamanioenx2;
   protected Imagen fightstage;
  protected Hud hud;
  protected HudBarra hb;
 private String parte1,parte2;
 
  private float   ts;
 
   boolean a1, a2, a3, leftW = false;
   Entradas entradas = new Entradas(this);
   private String e;
   private int opc;
   float velocidad = 0f,velocidad2=0f;
   float  gravedad = 5f;
    private   personajePrefab p1;
    private  personajePrefab p2;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    this.p1=p1;
    this.p2=p2;
   
    Config.addListInput(this);
    setFondo();
    p1.setX(450);
    p1.setY(Config.HEIGHT/2);
    p2.setX(700);
    p2.setY(Config.HEIGHT/2);
    sr = new ShapeRenderer();

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
        



        ts+=delta;
        Render.cleaner();
       b.begin();
       fightstage.dibujar();
      // b.draw(new Texture((int)p1.getCollide().width,(int)p1.getCollide().height,Pixmap.Format.RGB565), p1.getCollide().getX(), p1.getCollide().getY());
       b.draw(new Texture((int)p2.getCollide().width,(int)p2.getCollide().height,Pixmap.Format.RGB565), p2.getCollide().getX(), p2.getCollide().getY());
        if (ts>.101f ) {
         
            hitbox();
            colision();

            ts=0;
                }
                sr.setProjectionMatrix(Config.getCamara().combined);
                sr.begin(ShapeRenderer.ShapeType.Filled);

                sr.setColor(Color.BLUE);
                sr.rect(p1.getX(), p1.getY(), p1.getCollide().getWidth(), p1.getCollide().getHeight());
                sr.setColor(Color.RED);
                sr.rect(p1.getHitbox().getX(), p1.getHitbox().getY(),p1.getHitbox().getWidth(), p1.getHitbox().getHeight());
                sr.setColor(Color.WHITE);
                sr.rect(p2.getX(), p2.getY(), p2.getCollide().getWidth(), p2.getCollide().getHeight());

                sr.end();
                sr.begin(ShapeRenderer.ShapeType.Filled);
                sr.setColor(Color.RED);
                sr.rect(p2.getHitbox().getX(), p2.getHitbox().getY(),p2.getHitbox().getWidth(), p2.getHitbox().getHeight());
                sr.end();
        b.end();


       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());

    //    if (hud.getSec()<=0) {
    //         Render.app.setScreen(new PeleaTerminada(this.fightstage,this.p1,this.p2));
    //         server.getHl().enviarAtodos(direcciones.PELEATERMINADA.getString());
    // }

     }
     public void gestorEstados (){
    
         if (p1.getX()>p2.getX()) {tamanioenx=-80;
        }
         else if(p1.getX()<p2.getX()){tamanioenx=75;}

         if (p2.getX()>p1.getX()) {tamanioenx2=-130;
        }
 
          else if(p2.getX()<p1.getX()){tamanioenx2=80;}
         switch (p1.getEstado()) {

            case ATAQUEF:
            p1.setHitbox(tamanioenx, 30);




            break;

            case ATAQUEM:

            p1.setHitbox(tamanioenx, 60);

            break;
            case ATAQUED:
            p1.setHitbox(tamanioenx, 60);



            break;
            case AEREO1:
            p1.setHitbox(tamanioenx, 60);

            break;
            case AEREO2:
            p1.setHitbox(tamanioenx, 60);
            break;
            case AEREO3:
            p1.setHitbox(tamanioenx, 60);
            break;
            case SALTO:
            System.out.println("estoy saltando");
            p1.setY(p1.getY()+ (velocidad-=gravedad));
            break;
             default:
                 break;

         }

         switch (p2.getEstado()) {

            case ATAQUEF:


            p2.setHitbox(tamanioenx2, 60);
            
            break;
            case ATAQUEM:
            p2.setHitbox(tamanioenx2, 60);
         

            break;
            case ATAQUED:
            p2.setHitbox(tamanioenx2, 60);
           
            break;
            case AEREO1:
            p2.setHitbox(tamanioenx2, 60);
         
            break;
            case AEREO2:
            p2.setHitbox(tamanioenx2, 60);
           
            break;
            case AEREO3:
            p2.setHitbox(tamanioenx2, 60);
           
            break;
            case SALTO:
            
            p2.setY(p2.getY()+ (velocidad-=gravedad));
            p2.setEstado(Estado.SALTO);
            break;
             default:
                 break;
         }

     }

     private void colision() {

        if (Intersector.overlaps(p1.getCollide(), p2.getCollide())) {
            System.out.println("se tocan");
            if (p1.getAnteriorX()<p1.getX()) {
            p1.setX(p1.getAnteriorX()-10);
            server.enviarAtodos("posx,"+p1.getX());
            }
            else if (p1.getAnteriorX()>p1.getX()) {
            p1.setX(p1.getAnteriorX()+10);
            server.enviarAtodos("posx,"+p1.getX());
            }
            if (p2.getAnteriorX()<p2.getX()) {
                p2.setX(p2.getAnteriorX()-10);
                server.enviarAtodos("posx,"+p2.getX());
                }
                else if (p2.getAnteriorX()>p2.getX()) {
                p2.setX(p2.getAnteriorX()+10);
                server.enviarAtodos("posx,"+p2.getX());
                }

        }
        p1.setHitbox(30, 30);
        p2.setHitbox(30, 30);
        p1.setAnteriorX(p1.getX());
        p2.setAnteriorX(p2.getX());
         p1.getCollide().setY(p1.getCollide().getY() + (velocidad -= gravedad));
         p2.getCollide().setY(p2.getCollide().getY() + (velocidad2 -= gravedad));
        if(p1.getCollide().getY() < Config.HEIGHT/2){
            p1.getCollide().setY(Config.HEIGHT/2);
            p1.setEstado(Estado.STANCE);
        }
        if(p2.getCollide().getY() <Config.HEIGHT/2){
            p2.getCollide().setY(Config.HEIGHT/2);
            p2.setEstado(Estado.STANCE);
        }


    }

    public void hitbox() {
            if (p1.getHitbox().overlaps(p2.getCollide())) {
                p2.setVidaActual(p2.getVidaActual()-1);
            server.enviarHP("hp,"+p2.getVidaActual()+"<>1");
            }
            else if(p2.getHitbox().overlaps(p1.getCollide())){
                p1.setVidaActual(p1.getVidaActual()-1);
            server.enviarHP("hp,"+p1.getVidaActual()+"<>0");
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
    fightstage.dispose();
    sr.dispose();
    }
     @Override
    public void setFondo() {
        fightstage= new Imagen(e);
        fightstage.setSize(Config.tamanioDeAlgo(100, Config.WIDTH),Config.tamanioDeAlgo(100, Config.HEIGHT));
        fightstage.setPosition(Config.centrado(Config.WIDTH), Config.centrado(Config.HEIGHT));
    }
public personajePrefab Pjug(){
    if (server.getUsuario()==server.getUsuarios()[0]) {

        return p1;

    }

    else if(server.getUsuario()==server.getUsuarios()[1]){


        return p2;

    }
    return null;
}


    @Override
    public void handleInput() {
            server.enviarAtodos(server.getMsg());


            switch (server.getMsg()) {
                case "izquierda":

                //    server.enviarAtodos("posx,-15");
                //    Pjug().getCollide().setPosition(Pjug().getCollide().x-15, Pjug().getCollide().y);

                    break;
                    case "arriba":
                    Pjug().velocidad = 50;
                    break;
                    case "derecha":

                    // server.enviarAtodos("posx,15");
                    // Pjug().getCollide().setPosition(Pjug().getCollide().x + 15, Pjug().getCollide().y);
                    break;

                    case "abajo":
                    Pjug().setEstado(Estado.AGACHADO);


                    break;
                    case "ataquef":
                    System.out.println("llego un ataque fuerte");
                    Pjug().setEstado(Estado.ATAQUEF);


                    break;
                    case "ataquem":

                    Pjug().setEstado(Estado.ATAQUEM);

                    break;
                    case "ataqued":

                    Pjug().setEstado(Estado.ATAQUED);

                    break;
                    case "aereo1":
                    Pjug().setEstado(Estado.AEREO1);

                    break;
                    case "aereo2":
                    Pjug().setEstado(Estado.AEREO2);
                    break;
                    case "aereo3":
                    Pjug().setEstado(Estado.AEREO3);
                    break;

                default:
                if (server.getMsg().contains("posx")) {
                    String partes[]=server.getMsg().split(",");

                    parte1 = partes[0];
                    parte2=partes[1];
                    Pjug().setX(Float.parseFloat(parte2));
                    server.enviarAtodos("posx,"+parte2);
                }
                else if(server.getMsg().contains("posy")){

                    Pjug().velocidad=50;

                }

                   Pjug().setEstado(Estado.STANCE);
                    break;
            }
            gestorEstados();
            
    }

}
