package personajes;
 
 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
 

import utiles.Imagen;

 

public abstract class personajePrefab{
  
  private float x, y, w, h;
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

    public void setX(float x){
        i.setX(this.x);

    }
	public void setY(float y){
        i.setY(this.y);;
    }

    public float getX(){
        return x;
    }
	public float getY(){
        return y;
    }

    public float getW() {
        return w;
    }
	public float getH() {
        return h;
    }
    public int getVidaActual() {
        return vidaActual;
    }
	public int getVidamax() {
        return vidamax;
    }
	 

}
