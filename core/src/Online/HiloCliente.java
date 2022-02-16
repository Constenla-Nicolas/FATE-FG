package Online;

import java.io.IOException;
 
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.PatternSyntaxException;

import com.badlogic.gdx.Gdx;

import Entradas.Direcciones;
import Screens.Background;
import Screens.MenuPrincipal;
import Screens.SeleccionEscenarios;
import Screens.SeleccionPJ;
import Screens.Batalla.Escenarios;
import Screens.Batalla.PeleaTerminada;
import utiles.Config;
import utiles.Render;
 

public class HiloCliente extends Thread {
    DatagramSocket s;
    private boolean err=false, prmera=true;
    private InetAddress ipserver;
    private int puerto = 8080; 
    String msg;
    private int idcliente;
    private String parte1;//partes del string
    private String parte2;
    private int cont,cont2;
    private String parte3;
    private String parte4;
    private int nmb;
    Enumeration e;
    Enumeration ee;
    private int persona;
    public HiloCliente(){
         
        try 
        {
             e = NetworkInterface.getNetworkInterfaces(); 
            while(e.hasMoreElements())
            {
        NetworkInterface n = (NetworkInterface) e.nextElement();
     Enumeration ee = n.getInetAddresses();
     while (ee.hasMoreElements())
      {
          ipserver = (InetAddress) ee.nextElement();
         
                 }
            }
     
            s= new DatagramSocket();
            
            System.out.println(ipserver);
            enviarMensaje("conectar");
        } catch (SocketException e) {
             
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
               

                
            }  catch(SocketException e){
                System.out.println("instruccion no aceptada, socket ya cerrado");
            }
            catch (IOException e) {
                 
                e.printStackTrace();
            }
           
            
            
        }

    }
    private void llamarEvento() {
          
           
                
                for (int i = 0; i < Config.getListInput().size(); i++) {
                   Config.getListInput().get(i).handleInput();
                 
                  
             
                }
                
                
          
      
        
    }
    
    public String getMsg() {
        return msg;
    }
    public void stopSv(){
        enviarMensaje("cerrar");
         
        if (!s.isClosed()) {
           s.close();
        }
        this.interrupt();
    }
    public void identificarMensaje(){
    //  System.out.println("entro en identifiar mensaje: " +msg);
         
        try {
            String partes[]= msg.split("<>"); 

            parte1= partes[0];
            parte2= partes[1];
            // System.out.println("parte 1 "+parte1);
            // System.out.println("p2 "+parte2);
       if (parte1.contains(",")) {
            String partes2[]=parte1.split(","); 
           
           parte3 = partes2[0];
           parte4=partes2[1];
          
            
            // System.out.println("parte 1 "+parte1);
            // System.out.println("p2 "+parte2);
            // System.out.println("Que "+parte3); 
            // System.out.println("Cuanto "+ Float.parseFloat(parte4)); 
            parte1=parte3;
            
            persona= Integer.parseInt(parte2); 
            }
       
        msg=parte1;
        } catch (PatternSyntaxException e) {       
           
        }
       
    //    System.out.println(msg);
    }
    public int getPersona() {
        return persona;
    }
    
     public int getIdcliente() {
         return idcliente;
     }
   
     public float getCant() {
         return Float.parseFloat(parte4);
     }
    
public boolean MiPropioMensaje(){
        
        if (Integer.parseInt(parte2)!=idcliente) {
                    //System.out.println("llego la id "+parte2+" y el id mio  es "+idcliente);
                    return false;
                    }

        else{
            return true;
        }
    }



    private void procesarMensaje(DatagramPacket dp) {
         
       msg = new String(dp.getData()).trim();
       msg= msg.toLowerCase();
       
        if (prmera) {
            primeraConexion();
            prmera=false;
            System.out.println("soy el cliente "+ idcliente);
        }
        else if(!prmera){
           
            identificarMensaje();
            
          decidirAccion();
          llamarEvento();
        }
    }
    private void primeraConexion() {
        if (Integer.parseInt(msg)==0) {
            idcliente=0;
        }
        else if(Integer.parseInt(msg)==1){
           idcliente=1;
        }
    }
    
    public void decidirAccion(){
        switch (msg) { 
            case "seleccionpj":
             
               
               Config.ONLINE=true;
               Gdx.app.postRunnable(new Runnable() {
                public void run(){
                    // System.out.println("creando selecPJ....");
                    Render.app.setScreen(Direcciones.SELECCIONPJ.getClase());
   
                }
            });

            break;
            
           case "cerrar":
                Gdx.app.postRunnable(new Runnable() {
                public void run(){
                // System.out.println("Volviendo al menu...");
                Render.app.setScreen(new MenuPrincipal());

                 }
                });
                this.interrupt();

           break;
            case "seleccionescenario":
             
            if (cont==0) {
                Config.eraseInput(Config.getListInput().get(0));
                Gdx.app.postRunnable(new Runnable() {
                public void run(){
                    // System.out.println("creando selecesc....");
                    Render.app.setScreen(new SeleccionEscenarios(cliente.getJ1(),cliente.getJ2()));
          
                }
            });
            }
            cont++;
         
            
            
            break;
            case "escenarios":
             
                if (cont2==0) {

                    // System.out.println("voy a hacer algo con escenario");
                    Config.eraseInput(Config.getListInput().get(0));
            Gdx.app.postRunnable(new Runnable() {
                public void run(){
                    Render.app.setScreen(new Escenarios(Background.values()[SeleccionEscenarios.getOpc()].getRoot(), cliente.getJ1(), cliente.getJ2()));
                }
            });
                }
                  
             cont2++;
            
            
            break;
             
            default:
            break;
        }




      
       }
    
    public void enviarMensaje(String msg){
        // System.out.println("este mensaje se va a enviar " + msg);
        byte[] data = msg.getBytes();
        
        try {
      
            DatagramPacket dp = new DatagramPacket(data, data.length,ipserver,puerto);
            s.send(dp);
        } catch (IOException e) {
          
            e.printStackTrace();
        }  
        
        
    }
    
    public int getPuerto() {
        return puerto;
    }
}
