package personajes;
 
 
 
import javax.swing.Action;
import javax.swing.Timer;
import javax.tools.Diagnostic;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 

import utiles.Imagen;
 

 

public abstract class personajePrefab implements Action{
    protected TextureAtlas textureAtlas;
   protected float cargasuper;
   protected TextureRegion texRegion;
  protected float x, y, w, h;
  protected int vidamax;
  protected int opc;
  private Imagen i;
  private  int vidaActual;
  public enum Estado{CORRER, SALTO, ANIMACION, STUN}
  protected Estado estadoactual, estadoanterior;
  protected float statetimer=0;
  protected static Imagen spriteImagen;
  
  public Animation<TextureRegion> intro;
  public Animation<TextureRegion> stance;
  public Animation<TextureRegion> win;
  public Animation<TextureRegion> walk;
  public Animation<TextureRegion> ataque1;
  public Animation<TextureRegion> ataque2;
  public Animation<TextureRegion> ataque3;
  public Animation<TextureRegion> ataque4;
  public Animation<TextureRegion> jump;
  public Animation<TextureRegion> crouch;
  public Animation<TextureRegion> fall;
  public Animation<TextureRegion> guard;
  public Animation<TextureRegion> dash;
  public Animation<TextureRegion> dmgTaken;
  public Animation<TextureRegion> air1;
  public Animation<TextureRegion> air2;
  public Animation<TextureRegion> air3;
  public Animation<TextureRegion> air4;
  public Animation<TextureRegion> special1;
  public Animation<TextureRegion> special2;
  public Animation<TextureRegion> special3;
  public Animation<TextureRegion> special4;
  public Animation<TextureRegion> special5;
  public Animation<TextureRegion> special6;
  public Animation<TextureRegion> noblePhantasm;
  public Animation<TextureRegion> vfx1;
  public Animation<TextureRegion> vfx2;
  public Animation<TextureRegion> vfx3;
  public Animation<TextureRegion> vfx4;
  private Timer tiempo;
    public personajePrefab(){
         tiempo= new Timer(200, this);
      
    } 

    protected void iniciar(){
        tiempo.start();
        
    }

    public void update(float dt){

    }
     public void setAnims() {
        
    }
    public Imagen getImagen() {
        return i;
    }
    public void setImagen(Imagen i){

        this.i = i;
        
    }
    public void setInput(int opc){
        this.opc=opc;
    }
    public void setX(float x){
        this.x = x;

    }
	public void setY(float y){
        this.y = y;
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
 public void setVidaActual(int vidaActual) {
     this.vidaActual = vidaActual;
 }
 public void setVidamax(int vidamax) {
     this.vidamax = vidamax;
 }
 
 public float getCargasuper() {
     return cargasuper;
 }
	public Estado getEstado(){
        return estadoactual;
    }
    public void setEstado(Estado estado){
        this.estadoactual = estado;
    }
  
    

}
