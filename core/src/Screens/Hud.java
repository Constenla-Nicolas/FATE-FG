package Screens;

 

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
 
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
import utiles.Render;
 
 

public class Hud {
    private Stage stage;
    private Viewport viewport;
    private Label cuentaAtras;
    private ProgressBar hp;
    private Label tiempotexto;
    
    private  Pixmap pixmap;
    private int sec=99;
    private Sprite a;
    
    private Texture drawable;
    public Hud(SpriteBatch batch){
   
         
        startTimer();
        
        viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,batch);
        table();
         
    }
 
       private Timer.Task TimerSegundos = new Timer.Task() {
        
          @Override
          public void run() {
           sec--;
          // System.out.println(sec);
          }
      };
        public void startTimer(){
          Timer.schedule(TimerSegundos, 1f, 1f);
          
      }
 
   public void mostrarHud(){
       Render.batch.setProjectionMatrix(stage.getCamera().combined);
       stage.draw();
      
        
   }
    
    

   public void dispose(){
       stage.dispose();
       pixmap.dispose();
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
