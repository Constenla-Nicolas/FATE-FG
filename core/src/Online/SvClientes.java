package Online;

import java.net.InetAddress;

 
import com.badlogic.gdx.scenes.scene2d.Event;

import Entradas.direcciones;
import personajes.personajePrefab;
import utiles.Actualizable;
import utiles.Config;
 
public class SvClientes implements Actualizable {
    private InetAddress ip;
	private int puerto;
    private personajePrefab p1;
    private direcciones dir;
 
   
    public SvClientes(InetAddress ip, int puerto ){
        this.ip= ip;
        this.puerto =puerto;
        Config.addListener(this);
        
        
    }
   
    public InetAddress getIp() {
        return ip;
    }
    public int getPuerto() {
        return puerto;
    }
    public void setIp(InetAddress ip) {
        this.ip = ip;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    public personajePrefab getP1() {
        return p1;
    }
    public void setP1(personajePrefab p1) {
        this.p1 = p1;
    }
    public direcciones getDir() {
        return dir;
    }

    @Override
    public boolean handle(Event event) {
      
        return false;
    }

    @Override
    public String update() {
       
        return null;
    }
}
