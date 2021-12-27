package utiles;

import personajes.personajePrefab;

public enum Retratos {
    ASTOLFOSELEC("pngs/Astolfo2.png"),
    MORDREDSELEC("pngs/Mordred2.png"),
    JEANNESELEC("pngs/Jeanne2.png"),
    ATALANTESELEC("pngs/Atalante2.png"),
    ASTOLFO("pngs/Astolfo1.png"),
    MORDRED("pngs/Mordred1.png"),
    JEANNE("pngs/Jeanne1.png"),
    ATALANTE("pngs/Atalante1.png"),
    ASTOLFOPJ("personajes.Astolfo"),
    MORDREDPJ("personajes.Mordred"),
    JEANNEPJ("personajes.Jeanne"),
    ATALANTEPJ("personajes.Atalante");
    private String root;
    

    private Retratos(String root){
    this.root=root;  
    }
    // private Retratos(String root, String clase){

    // }
   
    public String getRoot() {
        return root;
    }
    
    
    public personajePrefab getClase(){
        Class c;
        personajePrefab p =null;
        try {
            c = Class.forName(this.root); 
            p = (personajePrefab) c.newInstance();
        
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      return p;
    }





}
