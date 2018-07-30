package at.tewan.tmjg;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Environment {
	
	private static int gridsize = 100;
	private static Pixmap gridMap;
	private static Sprite gridSprite;
	public static SpriteBatch gridBatch;
			
	public static void init() {
		gridMap = new Pixmap(Constants.MAP_SIZE_WIDTH + 1, Constants.MAP_SIZE_HEIGHT + 1, Format.RGBA8888);
		gridSprite = new Sprite(new Texture(gridMap));
		gridBatch = new SpriteBatch();
		drawGrid();
	}
	
	private static void drawGrid() {
		gridMap.setColor(0.9f, 0.9f, 0.9f, 1f);
		
		for(int i = 0; i <= Constants.MAP_SIZE_WIDTH; i += gridsize) {
			gridMap.drawLine(0, i, Constants.MAP_SIZE_WIDTH, i);
			gridMap.drawLine(0, i, Constants.MAP_SIZE_WIDTH, i);
		}
		
		for(int i = 0; i <= Constants.MAP_SIZE_HEIGHT; i += gridsize) {
			gridMap.drawLine(i, 0, i, Constants.MAP_SIZE_HEIGHT);
			gridMap.drawLine(i, 0, i, Constants.MAP_SIZE_HEIGHT);
		}
		
		gridSprite.setTexture(new Texture(gridMap));
		gridSprite.setPosition(0, 0);
	}
	
	public static void render() {
		gridBatch.setProjectionMatrix(Constants.camera.combined);
		gridBatch.begin();
		gridSprite.draw(gridBatch);
		gridBatch.end();
	}
}
