package utiles;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
 

 

public class Imagen extends Actor {

	private Texture t;
	private Sprite s;
	private float x = 0,y = 0;
	public Imagen(String string) {
		t = new Texture(string);
		s = new Sprite(t);
	
		 
	}
	public Imagen(Pixmap p) {
		t = new Texture(p);
		s = new Sprite(t);
		 
	}
	
	public void dispose(){
		t.dispose();
	 

	}

	public void Rotar(float degrees) {
		s.rotate(degrees);
	}
	public Texture getT() {
		return t;
	}
 
	public void darVuelta(Boolean x,boolean y){

		s.flip(x, y);
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
    public Sprite getS() {
        return s;
    }
}
