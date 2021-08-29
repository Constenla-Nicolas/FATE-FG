package utiles;

public enum Retratos {
    
    MORDED("pngs/pngwing.com (8).png"),ASTOLFO("pngs/pngwing.com (6).png"),ATALANTE("pngs/pngwing.com (1).png"),JEANNE("pngs/pngwing.com (4).png");

    private String ruta;


    private Retratos(String ruta){
    this.ruta=ruta;

    
    }
    public String getRuta() {
        return ruta;
    }







}
