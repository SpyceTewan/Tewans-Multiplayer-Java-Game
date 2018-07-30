package at.tewan.tmjg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import at.tewan.tmjg.Constants;
import at.tewan.tmjg.Core;
import at.tewan.tmjg.util.StartParameters;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.SCREEN_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;
		config.resizable = false;
		config.title = "TMJG";		
		
		StartParameters.init(args);
		
		new LwjglApplication(new Core(), config);
	}
}
