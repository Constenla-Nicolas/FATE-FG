package Online;

public class Cliente {
    static private HiloCliente hc;
    static private boolean err;
    public static void main(String[] args) {
        hc = new HiloCliente();
        hc.start();
      // int opc;
       hc.enviarMensaje("conectar");
    
       do {System.out.println("elija opcion");
      // for (int j = 0; j <Opciones.values().length; j++) {
      //        System.out.println(j+") "+Opciones.values()[j].getName());
             
      //   }
      //    opc =  Utilidades.ingresarEntero(0,1); Utilidades.s.nextLine();
      //   if(opc==1){break;}
      //   String msg = Utilidades.s.nextLine();
         
          
      } while (true); 
    }
}
