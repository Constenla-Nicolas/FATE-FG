package Screens;

import java.net.BindException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Entradas.Entradas;
import Online.cliente;
import utiles.Config;
import utiles.GifDecoder;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;
import utiles.Text;
 

public class MenuPrincipal implements Screen,TieneFondo{
    Imagen menu,negroiImagen;
	Animation<TextureRegion> animation;
	SpriteBatch b;
	Text options[] = new Text[5];
	String  texts[] = {"Arcade", "Online", "Entrenamiento", "Galeria", "Salir del juego"};
	float elapsed = 0;
	private Entradas entradas= new Entradas();
	Boolean mostrar=false;
	 cliente cl;
	int opc = 1;
	public float tiempo = 0;

	@Override
	public void show() {
		 setFondo();
		setImgEspera();
		b = Render.batch;
		animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Fondos/Fem.gif").read());
		 
		Gdx.input.setInputProcessor(entradas);
		int avance = 80;
		 for (int i = 0; i < options.length; i++) {
		 	options[i] = new Text(Recursos.MENUFONT, 30, Color.WHITE);
		
		 	options[i].setTexto(texts[i]);
			
		 	options[i].setPosition((Config.WIDTH/2)-(options[i].getWidth()/2), (Config.HEIGHT/2)+(options[0].getHeight()/2)-(options[i].getHeight()+(avance*i)));

		 }
	 

		
	}
	private void inputwait(int tiempo) {

        synchronized(entradas){
            try {
                entradas.wait(100,1);
            } catch (InterruptedException e) {
             
                e.printStackTrace();
            }
        }
    }
	public  void labelInput(){
			 
		 
		if(entradas.isDown()){ 	//entradas = input entrys
			if(tiempo > 0.1f){ 	//tiempo = time
				tiempo = 0;
				opc++;			// opc= option;
				if(opc > 5){
					opc = 1;
				}
			}
		}
		if(entradas.isUp()){
			 
			if(tiempo > 0.1f){
				tiempo = 0;
				opc--;
				if(opc < 1){
					opc = 5;
				}
			}
		}
		for (int i = 0; i < options.length; i++) {
			if(i==(opc-1)){
				options[i].setColor(Color.RED);   
			}
			else{
				options[i].setColor(Color.WHITE);
			}
		}
		if(entradas.isEnter()){
			inputwait(100);
		 
			switch(opc){

				case 1:
			 
				Render.app.setScreen(new SeleccionPJ());  
				break;

				case 2:
				 cl= new cliente();
				mostrar=true;
				entradas.stopInput();
				break;

				case 3:
				Render.app.setScreen(new SeleccionPJ());
				break;

				case 5:
				Gdx.app.exit();
				break;
			}
		}
		}
	@Override
	public void render(float delta) {
		Render.cleaner();

		b.begin();
		if (mostrar) {
			negroiImagen.dibujar();
			entradas.stopInput();
		}
		Recursos.TITLEMUSIC.play();
		elapsed += Gdx.graphics.getDeltaTime();
		b.draw(animation.getKeyFrame(elapsed),0.0f, 0.0f,Config.WIDTH,Config.HEIGHT);
		menu.dibujar();
		for (int i = 0; i < options.length; i++) {
			options[i].dibujar();
		}
		tiempo += delta;
		
		labelInput();
		b.end();

		 
		
		
		
	}
	

 
	@Override
	public void resize(int width, int height) {
		Config.getViewport().update(width, height);
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
		Recursos.TITLEMUSIC.dispose();;
	menu.dispose();
	negroiImagen.dispose();
	for (int i = 0; i < animation.getAnimationDuration(); i++) {
		animation.getKeyFrames()[i].getTexture().dispose();
	}
	}
	@Override
	public void setFondo() {
		menu = new Imagen(Recursos.TITLESCREEN);
		menu.setSize(Config.tamanioDeAlgo(60,Config.WIDTH),Config.tamanioDeAlgo(60,Config.HEIGHT));
		menu.setPosition(Config.centrado(Config.WIDTH),Config.centrado(Config.WIDTH));
	}
	public void setImgEspera(){
		negroiImagen= new Imagen(Recursos.COLORESPERA);
		negroiImagen.setSize(Config.tamanioDeAlgo(38, Config.WIDTH), Config.tamanioDeAlgo(30, Config.HEIGHT));
		negroiImagen.setPosition(Config.centrado(Config.WIDTH), Config.centrado(Config.HEIGHT));
	}
    
}
