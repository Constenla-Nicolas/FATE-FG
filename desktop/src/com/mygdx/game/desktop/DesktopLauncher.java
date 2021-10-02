package com.mygdx.game.desktop;


 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FateFightingGacha;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height=1000;
		config.width=600;
	  
		config.fullscreen=true;
		new LwjglApplication(new FateFightingGacha(), config);
	
		 
	}
}
