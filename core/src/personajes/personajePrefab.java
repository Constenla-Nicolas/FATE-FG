package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Imagen;
import utiles.procesoInput;
import utiles.procesoInput;

public class personajePrefab {

  private int x;
  private int y;
  private int vidamax;
  private  int vidaActual;
  public static Imagen spriteImagen;
  procesoInput action = new procesoInput();
  
    public personajePrefab(){
        
        Gdx.input.setInputProcessor(action);
    }


	public void jump(){
      y+= (action.keyDown(Input.Keys.W))? 15 : 0;
    }
    public int getx(){
        return x;
    }
	public int gety(){
        return y;
    }
	
	 
	 

}
