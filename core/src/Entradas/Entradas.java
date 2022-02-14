package Entradas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;

import Online.HiloCliente;
import Online.cliente;
import utiles.Config;
 
 
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
    protected boolean space=false;
    protected boolean inputflag=true;
    
   
 
    public Entradas() {
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
    public boolean isS() {
        return s;
    }
    public boolean isSpace() {
        return space;
    }
    public void stopInput(){
    inputflag=false;
    

    }
    public void startInput(){
    inputflag=true;
    }
     
    @Override
    public boolean keyDown(int keycode) {
       
    if (inputflag) { 
        
        
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
    if(keycode==Keys.S){
        s=true;
    }
    if(keycode==Keys.A){
        a=true;
    }
     if (keycode==Keys.SPACE) {
         space=true;
     }
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
        if(keycode==Keys.A){
            a= false;
       
        }
        if(keycode==Keys.S){
            s=false;  
        }
        if (keycode==Keys.SPACE) {
            space=true;
        }
        return false;
    }

    public void mandarOnline(int keycode) {
        
       
        if(Config.ONLINE){
            for (int i = 15; i < Direcciones.values().length; i++) {
          if (keycode==Integer.parseInt(Direcciones.values()[i].getString())) {
               
             
          cliente.getHiloC().enviarMensaje(Direcciones.values()[i].getString());
        }   
        }
        }
    }
    @Override
    public boolean keyTyped(char character) {
         
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
         
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
         
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
         
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
         
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
         
        return false;
    }

}