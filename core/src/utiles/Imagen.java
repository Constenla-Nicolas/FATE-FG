package utiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Imagen {

	private Texture t;
	private Sprite s;
	private float x = 0,y = 0;
	public Imagen(String ruta) {
		t = new Texture(ruta);
		s = new Sprite(t);
	}
	
	public void dispose(){
		t.dispose();
	 

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
