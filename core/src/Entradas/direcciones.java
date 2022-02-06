package Entradas;

import com.badlogic.gdx.Screen;

public enum direcciones {
    CONECTAR("conectar"),
    ENTER("66"),
    ARRIBA("19"),
    ABAJO("20"),
    IZQUIERDA("21"),
    DERECHA("22"),
    ATAQUEF("fuerte"),
    ATAQUEM("medio"),
    ATAQUED("debil"),
    SALTAR("saltar"),
    AGACHARSE("crouch"),
    SELECCIONPJ("Screens.SeleccionPJ"),
    SELECCIONESCENARIOS("Screens.SeleccionEscenarios"),
    ESCENARIOS("Screens.Escenarios"),
    PELEATERMINADA("Screens.PeleaTerminada");
    String string;
    
     boolean active;
    direcciones(String string){
        this.string=string;
        
    }

  

    public void doActive() {
         active= true;
     
    }
    public boolean isActive() {
        
        
        return active;
    }

   


    public String getString() {
        return string;
    }
    
    public Screen getClase(){
        Class c;
        Screen p =null;
        try {
            c = Class.forName(this.string); 
            p = (Screen) c.newInstance();
        
        } catch (ClassNotFoundException e) {
             
            e.printStackTrace();
        } catch (InstantiationException e) {
             
            e.printStackTrace();
        } catch (IllegalAccessException e) {
             
            e.printStackTrace();
        }
      return p;
    }



    
}
