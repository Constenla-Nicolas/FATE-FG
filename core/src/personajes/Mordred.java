package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utiles.Render;
import utiles.Imagen;

public class Mordred extends personajePrefab{
    public Imagen img;
    public Imagen anim[] = new Imagen[6];
    String fuente[] = {"Moedred/Walk1.png", "Moedred/Walk2.png", "Moedred/Walk3.png", "Moedred/Walk4.png", "Moedred/Walk5.png", "Moedred/Walk6.png"};
    SpriteBatch b;
    

    public Mordred(){
        spriteImagen= new Imagen("mordredSheet.png");
        img = new Imagen("Moedred/win7.png");
        img.setSize(Gdx.graphics.getHeight()/2, Gdx.graphics.getHeight()/2);
        img.setPosition(Gdx.graphics.getHeight()/2, Gdx.graphics.getHeight()/2);
for (int i = 0; i < anim.length; i++) {
    anim[i] = new Imagen(fuente[i]);
    anim[i].setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/4);
    anim[i].setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

    
}
    }
    public Imagen GetImagen(){

        return img;

    }

    public void MostrarMor(){
  
    }

 
 
}
