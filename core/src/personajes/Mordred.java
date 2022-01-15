package personajes;

import java.util.ArrayList;
import java.util.FormattableFlags;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
 
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import utiles.Imagen;
import utiles.Render;
import utiles.Config;
public class Mordred extends personajePrefab{
     public Sprite s; 
     public float elapsedTime = 0;
    
    public int currentFrame = 1;
    public int maxFrames = 6;
    public Animation<TextureRegion> bruh;

    

    public Mordred(){
        spriteImagen= new Imagen("mordredSheet.png");
        b = new SpriteBatch();
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Intro.atlas");
        bruh = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
        
        texRegion = mordredSTANCE;
      //  s = new Sprite(texRegion);
      //  s.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
       
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
