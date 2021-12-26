package Screens;

 

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

 
import utiles.Config;
import utiles.Imagen;
import utiles.Render;
 
 

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Label cuentaAtras;
    private Label tiempotexto;
    Imagen contorno;
    private int sec=99;
    public Hud(SpriteBatch batch){
        contorno = new Imagen("pngs/life_bar.png");
        startTimer(); 
        viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,batch);
        table();
      
    }
    public void contornoBarra(){
        contorno.setSize(Config.tamanioDeAlgo(25, Config.WIDTH), Config.tamanioDeAlgo(10, Config.HEIGHT));
        Render.batch.begin();
        contorno.dibujar();
        Render.batch.end();
    }

       private Timer.Task TimerSegundos = new Timer.Task() {
        
          @Override
          public void run() {
           sec--;
           System.out.println(sec);
          }
      };
        public void startTimer(){
          Timer.schedule(TimerSegundos, 1f, 1f);
          
      }
 
   public void mostrarHud(){
       Render.batch.setProjectionMatrix(stage.getCamera().combined);
       stage.draw();
       contornoBarra();
        
   }
   public void dispose(){
       stage.dispose();
   }
    
   private void table() {
    
       Table table = new Table();
       table.top();
       table.setFillParent(true);
        cuentaAtras = new Label(String.format("%02d", sec),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        tiempotexto= new Label("TIME",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
     
        table.add(tiempotexto).expandX().padTop(10);
        table.row();
        table.add(cuentaAtras).expandX().padTop(10);
        table.row();
     
       stage.addActor(table);
   }
    
    
     
   
   public Label getCuentaAtras() {
       return cuentaAtras;
   }
   public int getSec() {
       return sec;
   }
}
