package Screens;

 

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    ProgressBar hp;
    private Label tiempotexto;
    Imagen contorno;
    Imagen contorno2;
    Pixmap pixmap;
    private int sec=99;
    ProgressBarStyle progressBarStyle;
    TextureRegionDrawable drawable;
    public Hud(SpriteBatch batch){
        contorno = new Imagen("pngs/life_bar.png");
        contorno2= new Imagen("pngs/life_bar.png");
        contorno2.darVuelta(true, false);
        startTimer();
        barradvida();
        viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,batch);
        table();
         
    }


    public void barradvida(){
    pixmap = new Pixmap(100, 20, Format.RGBA8888);
    pixmap.setColor(Color.RED);
    pixmap.fill();
    drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
     progressBarStyle = new ProgressBarStyle();
    progressBarStyle.background = drawable;
    pixmap = new Pixmap(0, 20, Format.RGBA8888);
    pixmap.setColor(Color.GREEN);
    pixmap.fill();
    drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
     
    progressBarStyle.knob = drawable;
     
    Pixmap pixmap = new Pixmap(100, 20, Format.RGBA8888);
    pixmap.setColor(Color.GREEN);
    pixmap.fill();
    drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
    pixmap.dispose();
     
    progressBarStyle.knobBefore = drawable;
    }

    public void contornoBarra(){
        contorno.setSize(Config.tamanioDeAlgo(48, Config.WIDTH), Config.tamanioDeAlgo(6, Config.HEIGHT));
        contorno.setPosition(Config.centrado(Config.WIDTH)- Config.SacarPorcentaje(47, Config.WIDTH), Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(45, Config.HEIGHT));
        contorno2.setSize(Config.tamanioDeAlgo(48, Config.WIDTH), Config.tamanioDeAlgo(6, Config.HEIGHT));
        contorno2.setPosition(Config.centrado(Config.WIDTH)+ Config.SacarPorcentaje(5, Config.WIDTH), Config.centrado(Config.HEIGHT)+Config.SacarPorcentaje(45, Config.HEIGHT));
        
        
        Render.batch.begin();
        contorno.dibujar();
        contorno2.dibujar();


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
       pixmap.dispose();
   }
    
   private void table() {
    
       Table table = new Table();
       table.top();
       table.setFillParent(true);
        cuentaAtras = new Label(String.format("%02d", sec),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        tiempotexto= new Label("TIME",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
       hp = new ProgressBar(0.0f, 1.0f, 0.01f, false, progressBarStyle);
        hp.setValue(1.0f);
        hp.setAnimateDuration(0.25f);
        hp.setBounds(10, 10, 100, 20);
         
        stage.addActor(hp);
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
