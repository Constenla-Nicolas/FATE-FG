package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class HiloServidor extends Thread {
    private DatagramSocket s;
    private boolean err=false;
    int puerto = 3074; 
 
 
     public HiloServidor(){
         try {
             s= new DatagramSocket(puerto);
             System.out.println("servidor creado");
         } catch (SocketException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
          
     }
     @Override
     public void run(){
        
         do {
             
             byte[] a = new byte[1024];
             DatagramPacket dp = new DatagramPacket(a, a.length);
             try {  
                 s.receive(dp); 
                 procesarMensaje(dp);
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
         } while (!err);
            
             
         
 
     }
     private void procesarMensaje(DatagramPacket dp) {
          
         String msg = new String(dp.getData()).trim();
         System.out.println(msg);
     }
     private void enviarMensaje(String msg){
         byte[] data = msg.getBytes();
         InetAddress ipdestino;
         try {
             ipdestino =  InetAddress.getByName("192.168.0.66");
             
             DatagramPacket dp = new DatagramPacket(data, data.length,ipdestino,puerto);
             s.send(dp);
         } catch (IOException e) {
           
             e.printStackTrace();
         }
     }
 
}
