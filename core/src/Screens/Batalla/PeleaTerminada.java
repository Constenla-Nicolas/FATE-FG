package Screens.Batalla;

 

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Online.cliente;
import Screens.Hud;
import Screens.HudBarra;
import Screens.MenuPrincipal;
import Screens.SeleccionPJ;
import personajes.personajePrefab;
import utiles.Imagen;
 
import utiles.Render;

public class PeleaTerminada  extends Escenarios {
   private SpriteBatch b;
   private boolean fadeInTerminado = false, termina = false;
   private float a = 0;
    private  personajePrefab ganador;
    private float countTime = 0, waitTime = 5;
   private float countTimerEnd = 0, timeEnde = 5;
    public PeleaTerminada(String e,personajePrefab ganador){

        super(e,cliente.getJ1(),cliente.getJ1());
        this.ganador=ganador;  
        System.out.println(ganador);
        if (ganador.getNombre().equals("mordred")) {
             fightstage= new Imagen( "Endings/fate-s-saber-of-red.jpg");
       }
       else if (ganador.getNombre().equals("astolfo")) {
          fightstage=new Imagen("Endings/fate-gran-orden-astolfo.jpg" );
       }
       
        b= Render.batch;
     
        
    
    
    }
     
 
 


    @Override
    public void show() {
        fightstage.setTransparencia(1f);
         setFondo();
        
    }

    @Override
    public void render(float delta) {
     Render.cleaner();
    procesarFade();
     b.begin();
      //  fightstage.dibujar();
        
         
     b.end();
    
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
			countTime+=0.01f;
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
				Render.app.setScreen(new SeleccionPJ());
                cliente.enviarMensaje("seleccionpj");
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
        ganador.dispose();
        b.dispose();
        fightstage.dispose();
        
    }

     
    
}
