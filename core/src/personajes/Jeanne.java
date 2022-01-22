package personajes;
 

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import utiles.Imagen;

public class Jeanne extends personajePrefab {
  
    public Jeanne(){
        spriteImagen = new Imagen("jeanneSheet");
        setAnims();     
    }

@Override
public void setAnims() {
    // TODO Auto-generated method stub
    super.setAnims();
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
