package personajes;

import java.util.ArrayList;
import java.util.FormattableFlags;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
 
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

import utiles.Imagen;
import utiles.Render;
import utiles.Config;
public class Mordred extends personajePrefab{
     public Sprite s; 
     public float elapsedTime = 0;
    
    public int currentFrame = 1;
    public int maxFrames = 6;
    private Animation<TextureRegion> mordredRUN;
    private Animation<TextureRegion> mordredJUMP;
    private TextureRegion mordredSTANCE;
    TextureRegion[] frames; 
    public Mordred(){
        textureAtlas = new TextureAtlas("Moedred/MordredAll.atlas");
        mordredSTANCE= new TextureRegion(textureAtlas.findRegion("Stance1"));
        frames = new TextureRegion[textureAtlas.getRegions().size];
        System.out.println(mordredSTANCE.toString());
        setAnims(); 
        
        texRegion = mordredSTANCE;
      //  s = new Sprite(texRegion);
      //  s.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
       
}
    @Override
    public void setAnims() {
        // for (int i = 0; i < 4; i++) {
             
        //     frames[i] = textureAtlas.findRegion("Jump",i+1);
            
        // } 
        Array<AtlasRegion> f = new Array<AtlasRegion>();
         f = textureAtlas.findRegions("Jump");
       // frames=textureAtlas.findRegions("Jump");
      
      for (int i = 0; i < f.size; i++) {
          System.out.println(f.isEmpty());
          System.out.println(f.items); 
      }
       
      //  intro= new Animation<TextureRegion>(20f, textureAtlas.findRegions("Intro"+i));
            mordredJUMP= new Animation<TextureRegion>(0.2f, f.toArray());
            
        // for (int i = 0; i < 7; i++) {
        //     frames[i]= textureAtlas.findRegion("Win"+(i));
        //      System.out.println(frames[i].toString());
        // }
        // mordredRUN= new Animation<TextureRegion>(0.2f,frames);
       
    }

    public void MostrarMor(){
        Render.batch.draw(texRegion, Config.HEIGHT/2, Config.WIDTH/2);
        
      }

      public TextureRegion getFrame(float dt){
        estadoactual=getState();
        TextureRegion region;
        switch (estadoactual) {
            case CORRER:
                region = mordredRUN.getKeyFrame(statetimer,true);
                break; 
            case STANCE:
             region= mordredSTANCE;
            break;
            default:
                region =mordredJUMP.getKeyFrame(statetimer,true);
                break;
        }
        statetimer= estadoactual == estadoanterior ? statetimer + dt :0;
        estadoanterior =estadoactual;
        return region;
      }
 
      @Override
      public void update(float dt) {
         texRegion=getFrame(dt);
      }
    private Estado getState() {
      if (opc>=1) {
          return Estado.CORRER;
      }
      if (opc<=0){return Estado.SALTAR;}
     else if  (opc==0){return Estado.STANCE;}
        return Estado.STANCE;
    }
 
 
}
