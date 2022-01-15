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
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Intro.atlas");
        bruh = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

      //  s = new Sprite(texRegion);
      //  s.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
       
}
    

   

    public void MostrarMor(){
       
        
      }

 
}
