package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Entradas.Entradas;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
 
import utiles.Render;
public class Escenarios implements Screen,TieneFondo{
   SpriteBatch b;
   private Imagen fightstage;
   Hud hud;
//    int i = 0;
//    Mordred mordred;
//    Entradas entradas = new Entradas(this);
//    public float tiempo = 0;
   private String e;
    public Escenarios(String escenario, personajePrefab p1, personajePrefab p2){
    this.e = escenario;
    System.out.println(p1);
    setFondo();
 }
    @Override
    public void show() {
        
        b= Render.batch;
        hud= new Hud(b);
        // mordred = new Mordred();                                     
        // Gdx.input.setInputProcessor(entradas);
       
    }

    @Override
    public void render(float delta) {
         
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
        
        //mordred.anim[i].dibujar();
        
         b.end(); 
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());
   
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //  tiempo+=delta;
     
    //   prueba();
    //   if(tiempo%2 == 0){

    //   }
    //   if (i>5){
    //       i =0;
    //   }
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    }



     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    // public void prueba(){
    //     if(entradas.isDown()){ 
	// 		if(tiempo > 0.02f){ 
	// 			tiempo = 0;
    //             for (int i = 0; i < mordred.anim.length; i++) {
                    
	// 			mordred.anim[i].setPosition(mordred.anim[i].getX()+30, mordred.anim[i].getY());
    //             System.out.println(mordred.anim[i].getX());
                
    //             }
                
    //         }
    //     }
    //     if(entradas.isUp()){
    //         System.out.println("s");
	// 		if(tiempo > 0.1f){
	// 			tiempo = 0;
    //             System.out.println("d");
	// 			mordred.setX(mordred.getX()-1);	
				
	// 		}
	// 	}
    // }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
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
