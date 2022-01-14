package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import utiles.Render;
import utiles.Imagen;

public class Mordred extends personajePrefab{
    public Imagen img;

    public float elapsedTime = 0;
    public SpriteBatch b;
    public TextureAtlas textureAtlas;
    public Sprite s; 
    TextureRegion textureRegion;
    public int currentFrame = 1;
    public int maxFrames = 6;
    public Animation<TextureRegion> bruh;

    

    public Mordred(){
        spriteImagen= new Imagen("mordredSheet.png");
        b = new SpriteBatch();
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Intro.atlas");
        bruh = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
        


   

    
}
    

   

 
 
}
