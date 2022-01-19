package Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class HudBarra extends ApplicationAdapter {
    private Skin skin;
    private ProgressBar barravida1;
    private ProgressBar barravida2;
    private ProgressBar super1;
    private ProgressBar super2;
    private Stage stage;

    public void Restarvida1(float a) {
        barravida1.setValue(a);   
    }
    public void Restarvida2(float a) {
        barravida2.setValue( a);   
    }
    public void Actualizarsuper1(float a) {
        super1.setValue(a);   
    }
    public void Actualizarsuper2(float a) {
        super2.setValue(a);   
    }
    

    public HudBarra() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("hudbarras/hud.json"));
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.align(Align.top);
        table.setFillParent(true);

        Table table1 = new Table();
        table1.setBackground(skin.getDrawable("hud_frame without_custom_meter"));

      barravida1 = new ProgressBar(0.0f, 100.0f, 1.0f, false, skin, "BarraVida1");
        barravida1.setValue(100.0f);
        table1.add(barravida1).padLeft(10.0f).padRight(25.0f).padBottom(18.0f).expandX().minWidth(0.0f).prefWidth(500.0f);
        table.add(table1).expandX().align(Align.topLeft).prefWidth(450.0f);

        table1 = new Table();
        table1.setBackground(skin.getDrawable("hud_frame without_custom_meter_flipped"));

        barravida2 = new ProgressBar(0.0f, 100.0f, 1.0f, false, skin, "BarraVida2");
        table1.add(barravida2).padLeft(25.0f).padRight(10.0f).padBottom(16.0f).prefWidth(500.0f);
        table.add(table1).expandX().align(Align.topRight).prefWidth(450.0f);
        stage.addActor(table);

        table = new Table();
        table.padLeft(0.0f);
        table.padRight(0.0f);
        table.padTop(0.0f);
        table.padBottom(7.0f);
        table.align(Align.bottom);
        table.setFillParent(true);

        table1 = new Table();
        table1.align(Align.bottomLeft);

        super1 = new ProgressBar(0.0f, 100.0f, 1.0f, false, skin, "barrasuper");
        super1.setValue(100.0f);
        table1.add(super1).prefWidth(300.0f);
        table.add(table1).expandX().align(Align.left);

        table1 = new Table();
        table1.align(Align.top);

        super2 = new ProgressBar(0.0f, 100.0f, 1.0f, false, skin, "barrasuper2");
        table1.add(super2).prefWidth(300.0f);
        table.add(table1).expandX().align(Align.right);
        stage.addActor(table);
    }

    public void dibujar() {
        // Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
