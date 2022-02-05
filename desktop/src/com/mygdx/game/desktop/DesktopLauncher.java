package com.mygdx.game.desktop;

// CLIENTE
  
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FateFightingGacha;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height=720;
		config.width=1024;
	 // config.fullscreen=true;
		
		new LwjglApplication(new FateFightingGacha(), config);
	
		 
	}
}
