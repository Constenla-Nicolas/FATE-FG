package Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

 
import utiles.Config;
import utiles.Render;
 

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Label cuentaAtras;
    private Label tiempotexto;
    private Integer timer;
    public Hud(SpriteBatch batch){
        
        viewport = new FitViewport( Config.WIDTH,Config.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,batch);
        table();
        
    }

   public void mostrarHud(){
      
       Render.batch.setProjectionMatrix(stage.getCamera().combined);
       stage.draw();
   }
   private void table() {
       Table table = new Table();
       table.top();
       table.setFillParent(true);
        cuentaAtras = new Label(String.format("%02d", timer),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        tiempotexto= new Label("TIME",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        table.add(tiempotexto).expandX().padTop(10);
        table.row();
        table.add(cuentaAtras).expandX().padTop(10);
        stage.addActor(table);
   }
}
