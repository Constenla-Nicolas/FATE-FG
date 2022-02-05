package Online;

import Entradas.Entradas;
import personajes.personajePrefab;

public class cliente {
    private static HiloCliente hiloC;
    public static boolean cliente1=false;
    protected boolean escenarios;
    protected boolean SeleccionEscenarios;
    
    
    public cliente(){
    hiloC= new HiloCliente();
    hiloC.start();
        

    }
    public static HiloCliente getHiloC() {
        return hiloC;
    }

     
    
}
