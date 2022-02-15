package personajes;



import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.Timer;
import javax.tools.Diagnostic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;

import utiles.Imagen;




public abstract class personajePrefab implements Action{
    protected TextureAtlas textureAtlas;
   protected float cargasuper;
   protected TextureRegion texRegion;
  protected float x, y;
  protected float anteriorX, anteriorY;
int texWidth, texHeight;
Imagen img;
  protected int vidamax = 100;
  protected int opc;
  public boolean a1, a2, a3, leftW = false;
  private  int vidaActual;
  public enum Estado{CORRER, CORRERL, SALTO, ANIMACION, STUN, STANCE, AGACHADO, ATAQUED, ATAQUEM ,ATAQUEF, AEREO1, AEREO2, AEREO3 ,ESPECIAL1, ESPECIAL2, ESPECIAL3}
  protected Estado estadoActual, estadoAnterior;
  protected float statetimer=0;
  protected Rectangle collide;
  protected Rectangle hitbox= new Rectangle();
  protected Texture hitboxRED;
  public TextureRegion currentFrame, previusFrame;
  public Animation<TextureRegion> intro;
  public Animation<TextureRegion> stance;
  public Animation<TextureRegion> win;
  public Animation<TextureRegion> walk;
  public Animation<TextureRegion> walkLeft;
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




  public Rectangle getCollide() {
      return collide;
  }
    public personajePrefab(){
    
    }
    public void setHitbox(float width,float height ) {
       hitbox.set(x, y, width, height);
    }
    public void setCollide(int x, int y) {
        collide.setCenter(x, y);
    }


    public void update(float dt){

    }
     public void setAnims() {

    }
    public Texture getHitboxRED() {
        return hitboxRED;
    }
    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setInput(int opc){
        this.opc=opc;
    }
    public void setAnteriorX(float anteriorX) {
        this.anteriorX = anteriorX;
    }
    public float getAnteriorX() {
        return anteriorX;
    }
    public void setAnteriorY(float anteriorY) {
        this.anteriorY = anteriorY;
    }
    public float getAnteriorY() {
        return anteriorY;
    }
    public void setX(float x){
        this.x = x;
        collide.setPosition(x, y);
        hitbox.setPosition(x, y);

    }
	public void setY(float y){
        this.y = y;
         collide.setPosition(x, y);
        hitbox.setPosition(x, y);
    }

    public float getX(){
        return x;
    }
	public float getY(){
        return y;
    }

    public float getW() {
        return img.getAncho();
    }
	public float getH() {
        return img.getAlto();
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
        return estadoActual;
    }
    public void setEstado(Estado estado){
        this.estadoActual = estado;
        // System.out.println(estadoActual);
    }
    public Estado getEstadoAnterior(){
        return estadoAnterior;
    }
    public void setEstadoAnterior(Estado estado){
        this.estadoAnterior = estado;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub

    }
    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }



}
