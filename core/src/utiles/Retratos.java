package utiles;

import personajes.personajePrefab;

public enum Retratos {
    
    ASTOLFO("pngs/Astolfo1.png","pngs/Astolfo2.png","personajes.Astolfo"),
    MORDRED("pngs/Mordred1.png","pngs/Mordred2.png","personajes.Mordred"),
    JEANNE("pngs/Jeanne1.png","pngs/Jeanne2.png","personajes.Jeanne"),
    ATALANTE("pngs/Atalante1.png","pngs/Atalante2.png","personajes.Atalante");
   
    private String root;
    private String clase;
    private String root2;
    private Retratos(String root, String root2,String clase){
        this.root=root;
        this.root2=root2;
        this.clase=clase;
    }

    
    public String getRoot2() {
        return root2;
    }
    public String getRoot() {
        return root;
    }
    
    
    public personajePrefab getClase(){
        Class c;
        personajePrefab p =null;
        try {
            c = Class.forName(this.clase); 
            p = (personajePrefab) c.newInstance();
        
        } catch (ClassNotFoundException e) {
         
            e.printStackTrace();
        } catch (InstantiationException e) {
         
            e.printStackTrace();
        } catch (IllegalAccessException e) {
         
            e.printStackTrace();
        }
      return p;
    }





}
