package Online;

import java.net.DatagramSocket;

import Entradas.direcciones;

public class server {
    private static  HiloServidor hl;
   
    public server(){
        hl = new HiloServidor();
        hl.start();
    }
    public static HiloServidor getHl() {
        return hl;
    }
    public  DatagramSocket getSocket(){
        return (hl.getSocket());
    }
    public void dispose() {

        if(hl!=null){hl.stopSv();}
    }
    public static String getMsg(){
        return hl.getMsg();
    }
    public static void enviarAtodos(String string){
        hl.enviarAtodos(string);
    }
    public static SvClientes getUsuario(){
 

         return hl.getUsuario();
    }
    public static SvClientes[] getUsuarios(){
        return hl.getUsuarios();
    }
   public int getCantidad(){
       return hl.getCant();
   }
}
