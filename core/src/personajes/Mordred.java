package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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

    

    public Mordred(){
        spriteImagen= new Imagen("mordredSheet.png");
        b = new SpriteBatch();
        textureAtlas = new TextureAtlas("Moedred/MordredAll.atlas");
        textureRegion = textureAtlas.findRegion("Walk1");
        s = new Sprite(textureRegion);
        s.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/2);
        


   

    
}
    

    public void MostrarMor(){
  
    }

 
 
}
