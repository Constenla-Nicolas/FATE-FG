package Screens;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import Entradas.Entradas;
import personajes.Mordred;
import personajes.personajePrefab;
import utiles.Config;
import utiles.Imagen;
 
import utiles.Render;
public class Escenarios implements Screen,TieneFondo{
   SpriteBatch b;
   Rectangle player1Box;
   Rectangle player2Box;
   private Imagen fightstage;
   Hud hud;
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
        player1Box = new Rectangle(mordred.s.getX(), mordred.s.getY(), mordred.s.getWidth(), mordred.s.getHeight());
        player2Box = new Rectangle(mordred.s.getX(), mordred.s.getY(), mordred.s.getWidth(), mordred.s.getHeight());
       
    }

    @Override
    public void render(float delta) {
        mordred.elapsedTime += delta;
        Render.cleaner();
       b.begin();
        fightstage.dibujar();
        mordred.b.begin();
        b.draw(mordred.s, mordred.s.getX(), mordred.s.getY(), mordred.s.getWidth(), mordred.s.getHeight());
        
        
        mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Stance1")));
		
 
        movimiento();

        mordred.b.end(); 
 
        
         b.end(); 
       hud.mostrarHud();
     hud.getCuentaAtras().setText(hud.getSec());
        player1Box.setPosition(mordred.s.getX(), mordred.s.getY());
        System.out.println(player1Box.overlaps(player2Box));
    }



     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public void movimiento(){
        		
		if(entradas.isLeft()){ 	//entradas = input entrys
            mordred.currentFrame++;
            if(mordred.currentFrame > mordred.maxFrames){
                mordred.currentFrame = 1;
            }
            mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Walk"+ mordred.currentFrame)));
          
            mordred.s.flip(true, false);
            mordred.s.setX(mordred.s.getX()-5);
            
			}
		if(entradas.isRight()){
            mordred.currentFrame++;
            if(mordred.currentFrame > mordred.maxFrames){
                mordred.currentFrame = 1;
            }
            
            mordred.s.setRegion(mordred.textureAtlas.findRegion(String.format("Walk" + mordred.currentFrame)));
            if(mordred.s.getX() < Gdx.graphics.getWidth()- mordred.s.getWidth()) {
            mordred.s.setX(mordred.s.getX()+5);
            }
		
            
 
    }
}
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
