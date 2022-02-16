package personajes;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.FormattableFlags;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
 
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 

import utiles.Imagen;
import utiles.Render;
import utiles.Config;
public class Mordred extends personajePrefab{
     public Sprite s; 
     public float elapsedTime = 0;
    
    public int currentFrame = 1;
    public int maxFrames = 6;

    

    @Override
    public String getNombre() {
      return "mordred";
    }
    

   

    public void MostrarMor(){
       
        
      }
      @Override
      public void setAnims() {

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Intro.atlas");
        intro = new Animation<TextureRegion>(1f/10F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Stance.atlas");
        stance = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Win.atlas");
        win = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Walk.atlas");
        walk = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque1.atlas");
        ataque1 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque2.atlas");
        ataque2 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque3.atlas");
        ataque3 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Ataque4.atlas");
        ataque4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Jump.atlas");
        jump = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Crouch.atlas");
        crouch = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Fall.atlas");
        fall = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Guard.atlas");
        guard = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Dash.atlas");
        dash = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/DmgTaken.atlas");
        dmgTaken = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air1.atlas");
        air1 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air2.atlas");
        air2 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air3.atlas");
        air3 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/Air4.atlas");
        air4 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BloodySlash.atlas");
        special1 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BloodySlashEX.atlas");
        special2 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/CrimsonCharge.atlas");
        special3 = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/CrimsonThunder.atlas");
        special4 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());
        
        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/HeavySplitter.atlas");
        special5 = new Animation<TextureRegion>(1f/9F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/RadiantThrust.atlas");
        special6 = new Animation<TextureRegion>(1f/12F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/ClarentBlood.atlas");
        noblePhantasm = new Animation<TextureRegion>(1f/13F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BloodySlashVFX.atlas");
        vfx1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/BloodySlashEXVFX.atlas");
        vfx2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/CrimsonThunder.atlas");
        vfx3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

        textureAtlas = new TextureAtlas("Moedred/SpriteSheets/ClarentBloodVFX.atlas");
        vfx4 = new Animation<TextureRegion>(1f/30F, textureAtlas.getRegions());

        ATAQUE1SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE004.wav")); 
        ATAQUE2SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE003.wav")); 
        ATAQUE3SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE004.wav")); 
        AEREO1SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE004.wav")); 
        AEREO2SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE003.wav")); 
        AEREO3SOUND = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/SE004.wav")); 
      }




      @Override
      public Object getValue(String key) {
    
        return null;
      }




      @Override
      public void putValue(String key, Object value) {
          
        
      }




      @Override
      public void setEnabled(boolean b) {
        
        
      }




      @Override
      public boolean isEnabled() {
        
        return false;
      }




      @Override
      public void addPropertyChangeListener(PropertyChangeListener listener) {
      
        
      }




      @Override
      public void removePropertyChangeListener(PropertyChangeListener listener) {
        
        
      }




      @Override
      public void actionPerformed(ActionEvent e) {
        
        
      }

 
}
