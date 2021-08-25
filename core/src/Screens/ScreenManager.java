package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {
    static Game game = null;
	static Screen pantallaCarga;
	static Screen MenuPrincipal;

	
	private ScreenManager() {}
	
   //This is called by Game from inside the "create()" method.
	public static void initialize(Game game) {
		ScreenManager.game = game;

		pantallaCarga = new pantallaCarga();
		MenuPrincipal = new MenuPrincipal();
	}
	
	public static void setpantallaCarga() {
		game.setScreen(pantallaCarga);
	}	

	public static void setMainMenu() {
		game.setScreen(MenuPrincipal);
	}
}
