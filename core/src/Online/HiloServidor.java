package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
 
import Entradas.direcciones;
import utiles.Config;
 
 

public class HiloServidor extends Thread {
    private DatagramSocket s;
    private boolean err=false,creado=false;
    private int puerto = 25565; 
    private int contconexion=0;
    private SvClientes[] Usuario = new SvClientes[2]; 
    private int posconexion;

    
    private direcciones dir;
     public HiloServidor(){
        creado =crearserver();
      
          
     }

     private  boolean crearserver(){

        try {
            s= new DatagramSocket(puerto);
            System.out.println("sv creado en el puerto "+ puerto);
            return true;
        } catch (SocketException e) {
            System.out.println("No se pudo crear el sv en el puerto"+puerto);
            e.printStackTrace();
            return false;
        }
    }

    public void stopSv(){
        //enviarAtodos("server cerrado");
        System.out.println("cerrando server");
        if (!s.isClosed()) {
           s.close();
        }
        this.interrupt();
    }
    public direcciones getDir() {
        return dir;
    }
    public void enviarAtodos(String string) {
        if (getUsuario()==getUsuarios()[0]) {
            string=string+"<>0";
            
        }
        else if(getUsuario()==getUsuarios()[1]){
            string=string+"<>1";
        }
        byte[] data = string.getBytes();
        for (int i = 0; i < Usuario.length; i++) {
       try {    
        DatagramPacket dp = new DatagramPacket(data, data.length,Usuario[i].getIp(),Usuario[i].getPuerto());
        s.send(dp);
        } catch (IOException e) {
          
            e.printStackTrace();
        }     

        }
        
    }

    public DatagramSocket getS() {
        return s;
    }
     @Override
     public void run(){
            
        while (!creado) {//comprobar si el socket existe
                try {
                    Thread.sleep(2000);
                    puerto++;
                    creado=crearserver();
                } catch (InterruptedException e) {
                   
                }
           }
             do {
                 if (s.isClosed()) {
                     err=true;
                 }
                 else{
                     
                     byte[] a = new byte[1024];
               DatagramPacket dp = new DatagramPacket(a, a.length);
                try {  System.out.println("esperando mensaje");
                   s.receive(dp); 
                    
                   procesarMensaje(dp);
                   llamarEvento();
                   } catch (Exception e) {
                                   
                            if (s.isClosed()) {
                             System.out.println("el socket esta cerrado");
                             err=true;
                            }       
                                   
                               } 
                 }
              

             } while (!err);
          
             
             
              
      
     }
     private void llamarEvento() {
        if (dir.isActive()){
                for (int i = 0; i < Config.getListInput().size(); i++) {
                 Config.getListInput().get(i).handleInput(); 
          }

      }
        
    }
    public SvClientes[] getUsuarios() {
        return Usuario;
    }
    public SvClientes getUsuario() {
         return Usuario[posconexion];
     }
     public void identificarUsuario(DatagramPacket dp){
         
        for (int i = 0; i < Usuario.length; i++) {
          if(Usuario[i].getIp().equals(dp.getAddress()) && Usuario[i].getPuerto()==dp.getPort()){
              posconexion=i;
               
          }
          
        }
     
        
     }
     private void procesarMensaje(DatagramPacket dp) {
         
        
        
         String msg = new String(dp.getData()).trim();
          for (int i = 0; i < direcciones.values().length; i++) {
              if (direcciones.values()[i].getString().equals(msg)) {
                  dir= direcciones.values()[i];
                  
              }
          }
           if (dir==direcciones.CONECTAR){
             
                switch (contconexion) {
                    
                    case 0:
                        System.out.println("usuario conectado");
                     Usuario[contconexion]=new SvClientes(dp.getAddress(),dp.getPort());
                    
                      enviarMensaje("0" , Usuario[contconexion].getIp(), Usuario[contconexion].getPuerto());
                      
                      contconexion++;
                      break;
                    case 1:
                    System.out.println("usuario conectado");
                    Usuario[contconexion]=new SvClientes(dp.getAddress(),dp.getPort());
                    enviarMensaje("1", Usuario[contconexion].getIp(), Usuario[contconexion].getPuerto());
                       contconexion++;
                       enviarAtodos(direcciones.SELECCIONPJ.getString());
                       Config.ONLINE=true;
                    break;
                    default:
                    enviarMensaje("Sv lleno, intente mas tarde", dp.getAddress(), dp.getPort());
                        break;
                }}
          identificarUsuario(dp);
          dir.doActive();
         
        //  for (int i = 0; i < Usuario.length; i++) {
        //     System.out.println("cliente "+(i+1)+": "+ Usuario[i].getIp());
        //     System.out.println(Usuario[i].getPuerto());
        //  }
         
     } 
 
    public void enviarMensaje(String msg,InetAddress ipdestino, int puerto){
         byte[] data = msg.getBytes();
        
         try {
             
             
             DatagramPacket dp = new DatagramPacket(data, data.length,ipdestino,puerto);
             s.send(dp);
         } catch (IOException e) {
           
             e.printStackTrace();
         }
     }
     public int getPosconexion() {
         return posconexion;
     }

  
}
