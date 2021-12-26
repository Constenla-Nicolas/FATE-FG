package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
 
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import utiles.Imagen;
import utiles.procesoInput;
 

public abstract class personajePrefab {
  private procesoInput combo1[];
  private int x;
  private int y;
  private int vidamax;
  private  int vidaActual;
  public AtlasRegion Sprites;
  public static Imagen spriteImagen;
  procesoInput action = new procesoInput();
  
    public personajePrefab(){
        
        Gdx.input.setInputProcessor(action);
    }


    public int getx(){
        return x;
    }
	public int gety(){
        return y;
    }
	
    public int getVidaActual() {
        return vidaActual;
    }
	public int getVidamax() {
        return vidamax;
    }
	 

}
