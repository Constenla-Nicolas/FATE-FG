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
   int opc;
   private Imagen fightstage;
   Hud hud;
   float ts;
   float period= 0.9f;
   Mordred mordred;
   Entradas entradas = new Entradas(this);
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
        mordred = new Mordred();                                     
        Gdx.input.setInputProcessor(entradas);
       
    }

    @Override
    public void render(float delta) {
        inputSelec();
        mordred.setInput(opc);
        mordred.update(delta);
        
       // mordred.elapsedTime += delta;
        
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
        
       // b.draw(mordred.s, mordred.s.getX(), mordred.s.getY(), mordred.s.getWidth(), mordred.s.getHeight());
        
        
        //mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Stance1")));
		
        ts +=Gdx.graphics.getDeltaTime();
        if(ts > period){
            ts-=period; 
            
     //   movimiento();
        mordred.MostrarMor();
        }
        

         
        
         b.end(); 
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());
   
    }



    
//     public void movimiento(){
        
// 		if(entradas.isDown()){ 	//entradas = input entrys
//             mordred.currentFrame++;
          
            
//             if(mordred.currentFrame > 3){
//                 mordred.currentFrame = 1;
//             }
//          //   mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Air 1-"+ mordred.currentFrame)));
//             System.out.println(mordred.s.getWidth());
//             mordred.s.setSize(500, 500);
            
// 			}
// 		if(entradas.isUp()){
//             mordred.currentFrame--;
//             if(mordred.currentFrame < 1){
//                 mordred.currentFrame = mordred.maxFrames;
//             }
            
//             mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Walk" + mordred.currentFrame)));
//             mordred.s.setX(mordred.s.getX()+10);
		
            
 
//     }
// }
     
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
