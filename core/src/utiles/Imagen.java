package utiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Render;
public class Imagen {
	private Texture t;
	public Sprite s;
	public Imagen(String ruta) {
		t= new Texture(ruta);
		s= new Sprite(t);
	}
	public void dibujar() {
		s.draw(Render.bacth);
	}
	public void setTransparencia (float a){
		s.setAlpha(a);
	}
	public void setSize(float ancho, float alto) {
		s.setSize(ancho,alto);
		
	}
	public float getAlto(){
		return s.getHeight();
	}
	public float getAncho(){
		return s.getWidth();
	}
	
	
}
