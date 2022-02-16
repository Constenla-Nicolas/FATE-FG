package Screens.Batalla;

 

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import Online.cliente;
import Screens.Hud;
import Screens.HudBarra;
import Screens.MenuPrincipal;
import Screens.SeleccionPJ;
import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
import com.badlogic.gdx.utils.viewport.FitViewport;
import utiles.Render;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
public class PeleaTerminada  extends Escenarios {
   private SpriteBatch b;
   private boolean fadeInTerminado = false, termina = false;
   private float a = 0;
   private Stage stage;
   private Label label;
   private Viewport viewport;
    private  String ganador;
    private float countTime = 0, waitTime = 5;
   private float countTimerEnd = 0, timeEnde = 5;
   private String winner;
   private Imagen endstage;
    public PeleaTerminada(String e,String ganador){

        super(e,cliente.getJ1(),cliente.getJ1());
        this.ganador=ganador;  
        System.out.println(ganador);
        if (ganador.contains("mordred")) {
            endstage= new Imagen( "Endings/fate-s-saber-of-red.jpg");
        }
  
       else if (ganador.contains("astolfo")) {
        endstage=new Imagen("Endings/fate-gran-orden-astolfo.jpg" );
       }
       if (cliente.getJ1().getVidaActual()>cliente.getJ2().getVidaActual()) {
           winner="gano el cliente 1";
       }
       else{
           winner ="gano el cliente 2";
       }
        b= Render.batch;
        viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,b);
        Table table = new Table();
       table.center();
       table.setFillParent(true);
        label = new Label(winner ,new Label.LabelStyle(new BitmapFont(),Color.GOLD));
        table.add(label).expandX().padTop(10);
        table.row();
        table.setScale(200f, 200f);
       stage.addActor(table);
       endstage.setSize(Config.WIDTH,Config.HEIGHT);
       
    }   
     
   
 
 


    @Override
    public void show() {
     //   fightstage.setTransparencia(1f);
         setFondo();
        
    }

    @Override
    public void render(float delta) {
     Render.cleaner();
   procesarFade();
     b.begin();
        endstage.dibujar();
        
         
     b.end();
        stage.draw();
    }
    
	private void procesarFade() {
		fightstage.setTransparencia(a);
		if (!fadeInTerminado) {
			a += 0.01f;
		if (a > 1) {
			a = 1;
			fadeInTerminado = true;
		}
		}else {
			countTime+=0.07f;
			if(countTime > waitTime) {
				a -= 0.01f;
				if (a < 0) {
					a = 0;
					termina = true;
				
				}
			}
		}
		fightstage.setTransparencia(a);
		if(termina){
			countTimerEnd+=0.1f;
			if(countTimerEnd>timeEnde){
                Config.ONLINE=false;
				Render.app.setScreen(new MenuPrincipal());
                cliente.enviarMensaje("cerrar");
                cliente.getHiloC().interrupt();
                
			}

		}
    }
    @Override
    public void resize(int width, int height) {
       
        
    }

    @Override
    public void pause() {
      
        
    }

    @Override
    public void resume() {
        
        
    }
    

    @Override
    public void hide() {
         
        
    }

    @Override
    public void dispose() {
         
        b.dispose();
        fightstage.dispose();
        endstage.dispose();
        stage.dispose();
    }

     
    
}
