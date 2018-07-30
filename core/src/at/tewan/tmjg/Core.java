package at.tewan.tmjg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import at.tewan.tmjg.net.NetworkCore;

public class Core extends ApplicationAdapter {
	
	private static final String TAG = "Core";
	
	private NetworkCore networkCore;
	
	@SuppressWarnings("static-access")
	@Override
	public void create () {
		Gdx.app.setLogLevel(Gdx.app.LOG_DEBUG);
		
		
		
		networkCore = new NetworkCore("localhost");
		
		
	}

	@Override
	public void render () {
		Environment.render();
	}
	
	@Override
	public void dispose () {
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
}
