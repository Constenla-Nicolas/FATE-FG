package Entradas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
 
public class Entradas implements InputProcessor {

    protected boolean down = false;
    protected boolean up = false;
    protected boolean left = false;
    protected boolean right = false;
    protected boolean enter = false;
    protected boolean d=false;
    protected boolean a=false;
    protected boolean w=false;
    protected boolean s=false;
    Screen app;

    public Entradas(Screen app){    
        this.app = app;
    }
    public boolean isDown(){
        return down;
    }
    public boolean isUp(){
        return up;
    }
    public boolean isLeft(){
        return left;
    }
    public boolean isRight(){
        return right;
    }
    public boolean isEnter(){
        return enter;
    }
    public boolean isD(){
        return d;
    }
    public boolean isA() {
        return a;
    }
    public boolean isS(){
        return s;
    }
    

     
    @Override
    public boolean keyDown(int keycode) {
        
      //  app.tiempo = 0.08f; 

      if(keycode == Keys.DOWN){
        down = true;
    }
    if(keycode == Keys.UP){
        up = true;
    }
    if(keycode == Keys.ENTER){
        enter = true;
    }
    if(keycode == Keys.LEFT){
        left = true;
    }
    if(keycode == Keys.RIGHT){
        right = true;
    }
    if(keycode== Keys.D){
        d=true;
    }
    if(keycode== Keys.S){
        s=true;
    }
    if(keycode== Keys.A){
        a=true;
    }
    return false;
    }

    @Override
    public boolean keyUp(int keycode) {


        if(keycode == Keys.DOWN){
            down = false;
        }
        if(keycode == Keys.UP){
            up = false;
        }
        if(keycode == Keys.ENTER){
            enter = false ;
          
        }
        if(keycode == Keys.LEFT){
            left = false;
        }
        if(keycode == Keys.RIGHT){
            right = false;
        }
        if (keycode==Keys.D) {
            d = false;   
        }
        if(keycode== Keys.S){
            s=false;
        }
        if(keycode== Keys.A){
            a=false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        // TODO Auto-generated method stub
        return false;
    }

}