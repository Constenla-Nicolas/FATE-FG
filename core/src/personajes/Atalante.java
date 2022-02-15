package personajes;
 
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import utiles.Imagen;

public class Atalante extends personajePrefab{
    public Atalante(){
        collide=new Rectangle(0, 0, 50, 60);
        setHitbox(10, 10);
    }


 

@Override
public void setAnims() {
    hitboxRED = new Texture("hitbox general.png");
    super.setAnims();
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
