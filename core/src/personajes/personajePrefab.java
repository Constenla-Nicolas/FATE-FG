package personajes;
 
 
 
import javax.tools.Diagnostic;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 

import utiles.Imagen;
import utiles.Render;

 

public abstract class personajePrefab{
    protected TextureAtlas textureAtlas;
   protected float cargasuper;
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
  
    public personajePrefab(){
         
      
    } 

    public void mordredAnims(){
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Intro.atlas");
        intro = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Stance.atlas");
        stance = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Win.atlas");
        win = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Walk.atlas");
        walk = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque1.atlas");
        ataque1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque2.atlas");
        ataque2 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque3.atlas");
        ataque3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque4.atlas");
        ataque4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Jump.atlas");
        jump = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Crouch.atlas");
        crouch = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Fall.atlas");
        fall = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Guard.atlas");
        guard = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Dash.atlas");
        dash = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/DmgTaken.atlas");
        dmgTaken = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air1.atlas");
        air1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air2.atlas");
        air2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air3.atlas");
        air3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air4.atlas");
        air4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BodySlash.atlas");
        special1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BodySlashEX.atlas");
        special2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/CrimsonCharge.atlas");
        special3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/CrimsonThunder.atlas");
        special4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/HeavySplitter.atlas");
        special5 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/RadiantThrust.atlas");
        special6 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/ClarentBlood.atlas");
        noblePhantasm = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
    
    
    
    
    
    
    
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
 
 public float getCargasuper() {
     return cargasuper;
 }
	
  
    

}
