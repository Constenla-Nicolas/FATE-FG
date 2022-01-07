package Screens;

public enum Background {
    ESCENARIO1("EscenariosBatalla/20.jpg","pngs/1.png"),
    ESCENARIO2("EscenariosBatalla/872045.jpg","pngs/2.png"),
    ESCENARIO3("EscenariosBatalla/033.png","pngs/2.png"),
    ESCENARIO4("EscenariosBatalla/du.png","pngs/3.png");
   
    private String root;
   private String root2;
    Background(String root,String root2){
        this.root=root;
        this.root2=root2;
    }

    public String getRoot() {
        return root;
    }
    public String getRoot2() {
        return root2;
    }
}
