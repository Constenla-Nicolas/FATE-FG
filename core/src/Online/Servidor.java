package Online;

public class Servidor {
    static HiloServidor hs;
    public static void main(String[] args) {
      
        hs= new HiloServidor();
        hs.start();
       
    }
}
