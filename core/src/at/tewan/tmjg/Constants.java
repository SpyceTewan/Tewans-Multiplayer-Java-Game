package at.tewan.tmjg;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

public class Constants {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int MAP_SIZE_WIDTH = 4000;
	public static final int MAP_SIZE_HEIGHT = 4000;
	public static final int SPAWN_POSITION_X = MathUtils.random(MAP_SIZE_WIDTH);
	public static final int SPAWN_POSITION_Y = MathUtils.random(MAP_SIZE_HEIGHT);
	
	public static final float COLOR_MAIN_R = 233;
	public static final float COLOR_MAIN_G = 75;
	public static final float COLOR_MAIN_B = 58;
	
	public static final int PLAYER_SPEED = 10;
	public static final int PLAYER_RADIUS = 32;
	
	public static final String NET_HOST = "localhost";
	public static final int NET_PORT = 9889;
	
	public static final int PORT = 3559;
	
	public static OrthographicCamera camera;
}
