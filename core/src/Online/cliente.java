package Online;

import personajes.personajePrefab;

public class cliente {
    private static HiloCliente hiloC;
  
    protected boolean escenarios;
    private static personajePrefab j1;
    private static personajePrefab j2;
    
    
    public cliente(){
    hiloC= new HiloCliente();
    hiloC.start();
        

    }
    public static HiloCliente getHiloC() {
        return hiloC;
    }

     public static void setJ1(personajePrefab j1) {
         cliente.j1 = j1;
     }
     public static void setJ2(personajePrefab j2) {
         cliente.j2 = j2;
     }
     public static personajePrefab getJ1() {
         return j1;
     }
     public static personajePrefab getJ2() {
         return j2;
     }
    public static String getMsg(){
        return hiloC.getMsg();
    }
    public static void enviarMensaje(String string){
          hiloC.enviarMensaje(string);
    }
    public static int getCantidad(){
        return hiloC.getCant();
    }
    
}
