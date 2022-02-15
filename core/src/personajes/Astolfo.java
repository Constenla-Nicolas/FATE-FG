package personajes;

 

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import utiles.Imagen;

public class Astolfo extends personajePrefab {

    public Imagen img;
    public Astolfo(){
        collide=new Rectangle(0, 0, 50, 60);
        setHitbox(1, 1);
    }
    

@Override
public void setAnims() {

    
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Intro.atlas");
    
    intro = new Animation<TextureRegion>(1f/14F, textureAtlas.getRegions());
    

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Stance.atlas");
    stance = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Win.atlas");
    win = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Walk.atlas");
    walk = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque1.atlas");
    ataque1 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque2.atlas");
    ataque2 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque3.atlas");
    ataque3 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque4.atlas");
    ataque4 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Jump1.atlas");
    jump = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Crouch.atlas");
    crouch = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Fall.atlas");
    fall = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Guard.atlas");
    guard = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Dash.atlas");
    dash = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/DmgTaken.atlas");
    dmgTaken = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air1.atlas");
    air1 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air2.atlas");
    air2 = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air3.atlas");
    air3 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/CasseurDeLogistille.atlas");
    special1 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/HippogriffRide.atlas");
    special2 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/TrapArgalia.atlas");
    special3 = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PiercedLance.atlas");
    special4 = new Animation<TextureRegion>(1f/13F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/SmallHorn.atlas");
    special5 = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/AirTrapArgalia.atlas");
    special6 = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PhantomFlight.atlas");
    noblePhantasm = new Animation<TextureRegion>(1f/33F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/CasseurDeLogistilleVFX.atlas");
    vfx1 = new Animation<TextureRegion>(1f/20F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/FullActivationVFX.atlas");
    vfx2 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/SmallHornVFX.atlas");
    vfx3 = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PhantomFlightVFX.atlas");
    vfx4 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

    

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
 

    

