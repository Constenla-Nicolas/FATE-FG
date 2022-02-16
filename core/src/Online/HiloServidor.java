package Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.badlogic.gdx.Gdx;

import Entradas.direcciones;
import Screens.SeleccionEscenarios;
import Screens.SeleccionPJ;
import Screens.Batalla.Escenarios;
 
import utiles.Config;
import utiles.Render;
import utiles.Retratos;
import Screens.Background;
 

public class HiloServidor extends Thread {
    private DatagramSocket s;
    private boolean err=false,creado=false;
    private int puerto = 8080; 
    private int contconexion=0;
    private SvClientes[] Usuario = new SvClientes[2]; 
    private int nroUsuario;
    private int cont;
    String msg ;
    int cant;
   
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
        enviarAtodos("cerrar");
        System.out.println("cerrando server");
        if (!s.isClosed()) {
           s.close();
        }
        this.interrupt();
    }
   public String getMsg() {
       return msg;
   }
   public int getCant() {
       return cant;
   }
    public void enviarAtodos(String string) {
        if (getUsuario()==getUsuarios()[0]) {
            string=string+"<>0";
            
        }
        else if(getUsuario()==getUsuarios()[1]){
            string=string+"<>1";
        }
        System.out.println("entro en enviar a todos "+ string);
        byte[] data = string.getBytes();
        for (int i = 0; i < Usuario.length; i++) {
       try {  
        DatagramPacket dp = new DatagramPacket(data, data.length,Usuario[i].getIp(),Usuario[i].getPuerto());
        s.send(dp);
        } catch (IOException e) {
          
            e.printStackTrace();
        }     

        }
        //System.out.println("se va a enviar a todos "+ string);  
    }

    public DatagramSocket getSocket() {
        return s;
    }
    public void enviarHP(String string){
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
                for (int i = 0; i < Config.getListInput().size(); i++) {
                 Config.getListInput().get(i).handleInput(); 
          }

      }
        
    
    public SvClientes[] getUsuarios() {
        return Usuario;
    }
    public SvClientes getUsuario() {
         return Usuario[nroUsuario];
     }
     public void identificarUsuario(DatagramPacket dp){
         
        for (int i = 0; i < Usuario.length; i++) {
          if(Usuario[i].getIp().equals(dp.getAddress()) && Usuario[i].getPuerto()==dp.getPort()){
              nroUsuario=i;
               
          }
          
        }
     
        
     }

    

     private void procesarMensaje(DatagramPacket dp) {
         
        
        
         msg= new String(dp.getData()).trim();
         msg=msg.toLowerCase();
       
    
          
           if (msg.equals("conectar")){
             
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
                       enviarAtodos("seleccionpj");
                       Config.ONLINE=true;
                    break;
                    default:
                    enviarMensaje("Sv lleno, intente mas tarde", dp.getAddress(), dp.getPort());
                        break;
                }}
                else{
                
                identificarUsuario(dp);
                switch (msg) {
                    case "seleccionescenarios":
                        Config.eraseInput(Config.getListInput().get(0));
                    Gdx.app.postRunnable(new Runnable() {
                        public void run(){
                            Render.app.setScreen(new SeleccionEscenarios(Usuario[0].getP1(),Usuario[1].getP1()));
                        }
                    }); 
                    break;
                    case "seleccionpj":
                    
                    Gdx.app.postRunnable(new Runnable() {
                        public void run(){
                            Render.app.setScreen(new SeleccionPJ());
                        }
                    }); 
                    break;
                    case "escenarios":
                    
                    
                         Config.eraseInput(Config.getListInput().get(0));
                    System.out.println("estoy a punto de crear un escenario");
                    Gdx.app.postRunnable(new Runnable() {
                        public void run(){
                            
                            Render.app.setScreen(new Escenarios(Background.values()[SeleccionEscenarios.getOpc()].getRoot(), Usuario[0].getP1(), Usuario[1].getP1()));
                        }
                    });
                  
                    break;
                    case "terminarpelea":
                    Gdx.app.postRunnable(new Runnable() {
                        public void run(){
                            
                            Render.app.setScreen(new SeleccionPJ());
                        }
                    });
                    break;
                    case "cerrar":
                    enviarAtodos("cerrar");
                    Gdx.app.postRunnable(new Runnable() {
                    public void run(){
                    Usuario[0]=null;
                    Usuario[1]=null;
                    contconexion=0;
                    // System.out.println("Volviendo al menu...");
                    Render.app.setScreen(new SeleccionPJ());
    
                     }
                    });
                    this.interrupt();
    
               break;
                    default:
                    if (msg.contains("personajes.astolfo")) {
                    System.out.println("llego astolfo");
                    Usuario[nroUsuario].setP1(Retratos.ASTOLFO.getClase()); 
                    }
                    else if (msg.contains("personajes.mordred")) {
                        System.out.println("llego mordred");
                        Usuario[nroUsuario].setP1(Retratos.MORDRED.getClase()); 
                    }
                    else if(msg.contains("personajes.jeanne")){
                        Usuario[nroUsuario].setP1(Retratos.JEANNE.getClase()); 
                    }
                    else if(msg.contains("personajes.atalante")){

                    }
                    break;
                }
                 
                //enviarAtodos(dir.getString());
                
                llamarEvento();
                }
         
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
     public int getnroUsuario() {
         return nroUsuario;
     }

  
}
