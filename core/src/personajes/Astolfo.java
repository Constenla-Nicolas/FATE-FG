package personajes;

 

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 

import utiles.Imagen;

public class Astolfo extends personajePrefab {

    public Imagen img;
    public Astolfo(){
        img = new Imagen("Astolfo/Stance1.png");
        img.setPosition((Gdx.graphics.getWidth()/2), Gdx.graphics.getHeight()/2);
        setAnims();     
   
    }

@Override
public void setAnims() {
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Intro.atlas");
    intro = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Stance.atlas");
    stance = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Win.atlas");
    win = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Walk.atlas");
    walk = new Animation<TextureRegion>(1f/15F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque1.atlas");
    ataque1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque2.atlas");
    ataque2 = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque3.atlas");
    ataque3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Ataque4.atlas");
    ataque4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Jump1.atlas");
    jump = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Crouch.atlas");
    crouch = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Fall.atlas");
    fall = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Guard.atlas");
    guard = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Dash.atlas");
    dash = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/DmgTaken.atlas");
    dmgTaken = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air1.atlas");
    air1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air2.atlas");
    air2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/Air3.atlas");
    air3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/CasseurDeLogistille.atlas");
    special1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/HippogriffRide.atlas");
    special2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/TrapArgalia.atlas");
    special3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PiercedLance.atlas");
    special4 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());
    
    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/SmallHorn.atlas");
    special5 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/AirTrapArgalia.atlas");
    special6 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PhantomFlight.atlas");
    noblePhantasm = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/CasseurDeLogistilleVFX.atlas");
    vfx1 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/FullActivationVFX.atlas");
    vfx2 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/SmallHornVFX.atlas");
    vfx3 = new Animation<TextureRegion>(1f/7F, textureAtlas.getRegions());

    textureAtlas = new TextureAtlas("Astolfo/SpriteSheets/PhantomFlightVFX.atlas");
    vfx4 = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());

    

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

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
}

    }
 

    

