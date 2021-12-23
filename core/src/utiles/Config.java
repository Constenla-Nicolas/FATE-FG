package utiles;

 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Config {// ancho y alto de la resolucion del juego en base a la resolucion del monitor
    public static final int WIDTH =Gdx.graphics.getDisplayMode().width; 
    public static final int HEIGHT = Gdx.graphics.getDisplayMode().height;
    ///////////////////////////////////////////////////////////////////////

   
    private static Camera camara;
    private static Viewport viewport;
    private static int percentaje;
 
    public static void initialize(){
        // no borres la linea de abajo, todavia la estoy testeando
        //Gdx.graphics.setWindowedMode(Gdx.graphics.getDisplayMode().width,Gdx.graphics.getDisplayMode().height);
        
        camara = new OrthographicCamera(WIDTH,HEIGHT);
        camara.normalizeUp();
        
        viewport = new FitViewport(WIDTH, HEIGHT, camara); 
        viewport.update(WIDTH, HEIGHT,true);
        Render.batch.setProjectionMatrix(camara.combined);
    }
   
public static Viewport getViewport() {
    return viewport; 
}
public static void updateCamara(){
    camara.update();
}

/**
 * Para cuando quieras definir el tamanio de un texto, titulo, etc. en base a la resolucion interna del juego
 * 
 * @param porc    porcentaje de pantalla que va a ocupar
 * @param xyvalue config.HEIGHT o config.WIDTH
 */

public static int tamanioDeAlgo(int porc,int xyvalue){
    percentaje = porc;
   return (porc*xyvalue/100);
}

/**
 * Para centrar cualquier cosa
 * 
 * @return posicion en pantalla
 * Llamar y definir primero tamanioDeAlgo() si o si;
 * @param xyvalue por donde se va a centrar, usar config.WIDTH o config.HEIGHT para centrar horizontal o vertical respectivamente
 */
public static int centrado(int xyvalue){

    return (xyvalue/2-(Config.tamanioDeAlgo(percentaje,xyvalue))/2);
}

}
