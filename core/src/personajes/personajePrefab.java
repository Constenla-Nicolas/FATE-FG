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
  private  int vidaActual=100;
  public enum Estado{CORRER, CORRERL, SALTO, ANIMACION, STUN, STANCE, AGACHADO, ATAQUED, ATAQUEM ,ATAQUEF, AEREO1, AEREO2, AEREO3 ,ESPECIAL1, ESPECIAL2, ESPECIAL3}
  protected Estado estadoActual, estadoAnterior;
  protected float statetimer=0;
  protected Rectangle collide;
  protected Rectangle hitbox= new Rectangle();
    
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
  public int velocidad =0;


 
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
    public void dispose(){
        for (int i = 0; i < intro.getKeyFrames().length; i++) {
            intro.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i <  stance.getKeyFrames().length; i++) {
             stance.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < win.getKeyFrames().length; i++) {
            win.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < walk.getKeyFrames().length; i++) {
            walk.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < walkLeft.getKeyFrames().length; i++) {
            walkLeft.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < ataque1.getKeyFrames().length; i++) {
            ataque1.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < ataque2.getKeyFrames().length; i++) {
            ataque2.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < ataque3.getKeyFrames().length; i++) {
            ataque3.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < ataque4.getKeyFrames().length; i++) {
            ataque4.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < jump.getKeyFrames().length; i++) {
            jump.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < crouch.getKeyFrames().length; i++) {
            crouch.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < fall.getKeyFrames().length; i++) {
            fall.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < guard.getKeyFrames().length; i++) {
            guard.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < dash.getKeyFrames().length; i++) {
            dash.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < dmgTaken.getKeyFrames().length; i++) {
            dmgTaken.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < air1.getKeyFrames().length; i++) {
            air1.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < air2.getKeyFrames().length; i++) {
            air2.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < air3.getKeyFrames().length; i++) {
            air3.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < air4.getKeyFrames().length; i++) {
            air4.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special1.getKeyFrames().length; i++) {
            special1.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special2.getKeyFrames().length; i++) {
            special2.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special3.getKeyFrames().length; i++) {
            special3.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special4.getKeyFrames().length; i++) {
            special4.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special5.getKeyFrames().length; i++) {
            special5.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < special6.getKeyFrames().length; i++) {
            special6.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < noblePhantasm.getKeyFrames().length; i++) {
            noblePhantasm.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < vfx1.getKeyFrames().length; i++) {
            vfx1.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < vfx2.getKeyFrames().length; i++) {
            vfx2.getKeyFrames()[i].getTexture().dispose();
        }for (int i = 0; i < vfx3.getKeyFrames().length; i++) {
            vfx3.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < vfx4.getKeyFrames().length; i++) {
            vfx4.getKeyFrames()[i].getTexture().dispose();
        }
        currentFrame.getTexture().dispose();
        previusFrame.getTexture().dispose();
        texRegion.getTexture().dispose();
        for (int i = 0; i < textureAtlas.getRegions().size; i++) {
                textureAtlas.getRegions().get(i).getTexture().dispose();
     
        }
    
    }


}
