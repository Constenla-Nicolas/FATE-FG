package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class HiloServidor extends Thread {
    private DatagramSocket s;
    private boolean err=false;
    private int puerto = 14022; 
    private int posicionConexion=0;
    private String[][] Usuario = new String[2][2]; 
    
     public HiloServidor(){
         try {
             s= new DatagramSocket(puerto);
             System.out.println("sv creado");
         } catch (SocketException e) {
             
             e.printStackTrace();
         }
      
          
     }
     @Override
     public void run(){
        
        
         do {
              
             if (s.isClosed()) { // ignore error if the socket was intentionally closed.
                    System.out.println("[SERVER] Socket Exception: Could not receive packet.");
                }
             
             byte[] a = new byte[1024];
             DatagramPacket dp = new DatagramPacket(a, a.length);
             try {  System.out.println("entre al try");
                 s.receive(dp); 
                 
                procesarMensaje(dp);
              
             } catch (Exception e) {
                
                 
                 e.printStackTrace();
             }
         } while (!err);
     System.out.println("error afuera del do whle "+ err);
 
     }
     private void procesarMensaje(DatagramPacket dp) {
          
         String msg = new String(dp.getData()).trim();
         System.out.println("msg");
            if (msg.equals("conectar")) {
                 System.out.println("usuario conectado");
                 for (int i = 0; i < Usuario.length-1; i++) {
                 Usuario[posicionConexion][i]=dp.getAddress().toString();
                 Usuario[posicionConexion][i+1]=Integer.toString(dp.getPort());
               
                 }
                    posicionConexion++;
                    System.out.println("cliente 1: "+ Usuario[0][0]);
                    System.out.println(Usuario[0][1]);
                    System.out.println("cliente 2: "+ Usuario[1][0]);
                    System.out.println(Usuario[1][1]); 
            }
                 
               
                    
        
         
         
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
