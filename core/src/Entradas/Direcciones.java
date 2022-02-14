package Entradas;

import com.badlogic.gdx.Screen;

public enum Direcciones {
    ASTOLFO("A"),
    MORDRED("M"),
    JEANNE("J"),
    ATALANTE("AT"), 
    CONECTAR("conectar"),
    ATAQUEF("fuerte"),
    ATAQUEM("medio"),
    ATAQUED("debil"),
    SALTAR("saltar"),
    AGACHARSE("crouch"),
    SELECCIONESCENARIOS("SelecEscc"),
    ESCENARIOS("Screens.Escenarios"),
    PELEATERMINADA("Screens.PeleaTerminada"),
    SELECCIONPJ("Screens.SeleccionPJ"),
    POSX("POSX"),
    POSY("POSY"),
    HP("HP"),
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

  public void setPOSX(int nmb){
    this.string=Integer.toString(nmb);
  }

  public void setPOSY(int nmb){
    this.string=Integer.toString(nmb);
  }


   public void HPaRestar(int nmb){
    this.string=Integer.toString(nmb);
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
