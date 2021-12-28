package personajes;
 
 
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
 

import utiles.Imagen;

 

public abstract class personajePrefab implements terminable {
  
  private int x;
  private int y;
  private int vidamax;
  private Imagen i;
  private  int vidaActual;
  public AtlasRegion Sprites;
  public static Imagen spriteImagen;
   
  
    public personajePrefab(){
        
      
    }
    public Imagen getImagen() {
        return i;
    }
    public void setImagen(Imagen i){

        this.i = i;
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
