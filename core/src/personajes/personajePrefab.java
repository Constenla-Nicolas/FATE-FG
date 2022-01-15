package personajes;
 
 
 
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 

import utiles.Imagen;
import utiles.Render;

 

public abstract class personajePrefab{
    protected TextureAtlas textureAtlas;
   
   protected TextureRegion texRegion;
  private float x, y, w, h;
  protected int vidamax;
  protected int opc;
  private Imagen i;
  private  int vidaActual;
  protected enum Estado{CORRER,SALTAR,STANCE}
  Estado estadoactual, estadoanterior;
  protected float statetimer=0;
  protected static Imagen spriteImagen;
  public Animation<TextureRegion> intro;
    
    public personajePrefab(){
        
      
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
 public void setVidaActual(int vidaActual) {
     this.vidaActual = vidaActual;
 }
 public void setVidamax(int vidamax) {
     this.vidamax = vidamax;
 }
	 public void stanceAnim(){

     }

     public void introAnim(){

     }

     public void winAnim(){

     }
     public void walkAnim(){

     }
     public void ataque1Anim(){

    }
    public void ataque2Anim(){

    }
    public void ataque3Anim(){

    }
    public void ataque4Anim(){

    }
    public void jumpAnim(){

    }
    public void crouchAnim(){

    }
    public void fallAnim(){

    }    
    public void dashAnim(){

    }
    public void dmgTakenAnim(){

    }
    public void air1Anim(){

    }
    public void air2Anim(){

    }
    public void air3Anim(){

    }
    public void air4Anim(){

    }
    
    
    
    



}
