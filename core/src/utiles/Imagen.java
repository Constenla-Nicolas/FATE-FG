package utiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

 

public class Imagen extends Actor {

	private Texture t;
	private Sprite s;
	private float x = 0,y = 0;
	public Imagen(String escenario1) {
		t = new Texture(escenario1);
		s = new Sprite(t);
		 
	}
	
	public void dispose(){
		t.dispose();
	 

	}
	public Texture getT() {
		return t;
	}
	
	public void dibujar() {
		s.draw(Render.batch);
	}
	public void setTransparencia(Float a) {
		s.setAlpha(a);
	}
	public void setSize(float width, float height) {
		s.setSize(width, height);
	}
	public void setPosition(float x, float y){
		s.setX(x);
		s.setY(y);
	}
	public Vector2 getPosition(){
		return new Vector2(x,y);
	}
	public float getAlto(){
		return s.getHeight();
	}
	public float getAncho(){
		return s.getWidth();
	}
}
