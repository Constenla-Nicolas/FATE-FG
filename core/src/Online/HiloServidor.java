package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import utiles.Config;

public class HiloServidor extends Thread {
    private DatagramSocket s;
    private boolean err=false;
    private int puerto = 3074; 
    private int posicionConexion=0;
    private String[][] Usuario = new String[2][2]; 
    
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
     private void procesarMensaje(DatagramPacket dp) throws NumberFormatException, UnknownHostException {
          
         String msg = new String(dp.getData()).trim();
            if (msg.equals("conectar")) {
                 System.out.println("usuario conectado");
               
                 Usuario[posicionConexion][0]=dp.getAddress().toString();
                 Usuario[posicionConexion][1]=Integer.toString(dp.getPort());
               
                 
                    posicionConexion++;
                
                if (posicionConexion>2) {
                    enviarMensaje("esperar",InetAddress.getByName(Usuario[0][0]), Integer.parseInt(Usuario[0][1]));
                    
                }
                  if(posicionConexion==2){
                      Config.ONLINE= true;
                    for (int i = 0; i < Usuario.length; i++) {
                        enviarMensaje("empieza", InetAddress.getByName(Usuario[i][0]), Integer.parseInt(Usuario[i][1]));
                    }
                }
                    System.out.println("cliente 1: "+ Usuario[0][0]);
                    System.out.println(Usuario[0][1]);
                    System.out.println("cliente 2: "+ Usuario[1][0 ]);
                    System.out.println(Usuario[1][1]); 
            }
                 
               
                    
        
         
         
     }
     private void enviarMensaje(String msg,InetAddress ip, int puerto){
         byte[] data = msg.getBytes();
         
         try {
             
             
             DatagramPacket dp = new DatagramPacket(data, data.length,ip,puerto);
             s.send(dp);
         } catch (IOException e) {
           
             e.printStackTrace();
         }
     }
 
}
