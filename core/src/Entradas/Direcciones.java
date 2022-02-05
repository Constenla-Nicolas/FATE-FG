package Entradas;

import com.badlogic.gdx.Screen;

public enum Direcciones {
    CONECTAR("conectar"),
    ATAQUEF("fuerte"),
    ATAQUEM("medio"),
    ATAQUED("debil"),
    SALTAR("saltar"),
    AGACHARSE("crouch"),
    SELECCIONESCENARIOS("Screens/"),
    ESCENARIOS("Screens.SeleccionEscenarios"),
    PELEATERMINADA("Screens.PeleaTerminada"),
    SELECCIONPJ("Screens.SeleccionPJ"),
    ENTER("66"),
    ARRIBA("19"),
    ABAJO("20"),
    IZQUIERDA("21"),
    DERECHA("22");
    String string;
    boolean active;
    
    Direcciones(String string){
        this.string=string;
    }

    public void doActive() {
        active= true;
    
   }
   public boolean isActive() {
       
       
       return active;
   }
   public void dontActive() {
    active=false;
}
  
 
    public String getString() {
        return string;
    }

  
    // public Screen getClase(){
    //     Class c;
    //     Screen p =null;
    //     try {
    //         c = Class.forName(this.string); 
    //         p = (Screen) c.newInstance();
        
    //     } catch (ClassNotFoundException e) {
             
    //         e.printStackTrace();
    //     } catch (InstantiationException e) {
             
    //         e.printStackTrace();
    //     } catch (IllegalAccessException e) {
             
    //         e.printStackTrace();
    //     }
    //   return p;
    // }

    

    
}

