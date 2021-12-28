package Entradas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
 

public class Entradas implements InputProcessor {

    private boolean down = false, up = false, enter = false;
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
    public boolean isEnter(){
        return enter;
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