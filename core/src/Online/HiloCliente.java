package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HiloCliente extends Thread {
    DatagramSocket s;
    boolean err=false;
    private InetAddress ipserver;
    private int puerto = 3074; 
    
    public HiloCliente(){
        
        try {
            s= new DatagramSocket();
            ipserver = InetAddress.getByName("192.168.0.66");
            enviarMensaje("conexion establecida");
        } catch (SocketException | UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
       
        while(!err){
            byte[] a = new byte[1024];
            DatagramPacket dp = new DatagramPacket(a, a.length);
            try {
                s.receive(dp);
                procesarMensaje(dp);
            } catch (IOException e) {
                 
                e.printStackTrace();
            }
            
        }

    }
    private void procesarMensaje(DatagramPacket dp) {
        String msg = new String(dp.getData().toString().trim());
        System.out.println(msg);
    }
    public void enviarMensaje(String msg){
        byte[] data = msg.getBytes();

        try {
      
            DatagramPacket dp = new DatagramPacket(data, data.length,ipserver,puerto);
            s.send(dp);
        } catch (IOException e) {
          
            e.printStackTrace();
        }
        
    }

}
