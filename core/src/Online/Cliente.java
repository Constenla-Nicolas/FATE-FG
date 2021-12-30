package Online;

import personajes.personajePrefab;

public class Cliente {
    static private HiloCliente hc;
    static private boolean err;
    static private personajePrefab pj;
    public Cliente(){
        hc = new HiloCliente();
        hc.start();
      // int opc;
       hc.enviarMensaje("conectar");
       
    } 
    public static personajePrefab getPj() {
        return pj;
    }
}
