package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector2;

public class Text {
    BitmapFont font;
    GlyphLayout layout;

    private float x = 0,y = 0;
    private String text = "";

    public Text(String fontRoute, int dimension, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontRoute));
        FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = dimension;
        parameter.color = color;
        parameter.shadowColor = Color.BLACK;
        parameter.shadowOffsetX = 1;
        parameter.shadowOffsetY = 1;



        font = generator.generateFont(parameter);
        layout = new GlyphLayout();
    }
    public void dibujar(){
        font.draw(Render.batch, text, x, y);
    }
    public void setColor(Color color){
        font.setColor(color);
    }
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public void setX(Float x){
        this.x = x;
    }
    public void setY(Float y){
        this.y = y;
    }
    public void setTexto(String texto){
        this.text = texto;
        layout.setText(font, texto);
    }
    public String getText(){
        return text;
    }
    public float getWidth(){
        return layout.width;
    }
    public float getHeight(){
        return layout.height;
    }
    public Vector2 getDimension(){
        return new Vector2(layout.width, layout.height);
    }
    public Vector2 getPosition(){
        return new Vector2(x, y);
    }

}
