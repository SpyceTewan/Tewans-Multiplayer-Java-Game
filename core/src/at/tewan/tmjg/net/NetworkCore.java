package at.tewan.tmjg.net;

import static at.tewan.tmjg.util.StartParameters.START_ARGS;

import com.badlogic.gdx.Gdx;


public class NetworkCore {
	
	public static int PORT = 3555;
	public static final String TAG = "Network Core";
	
	private GameServer server;
	private GameClient client;
	
	public NetworkCore(String ipAdress) {
		if(START_ARGS.contains("-server")) {
			Gdx.app.log(TAG, "Starting as server and client!");
			server = new GameServer();
			server.start();
		}else {
			Gdx.app.log(TAG, "Starting as client!");
		}
		
		client = new GameClient(ipAdress);
		client.start();
		
		if(START_ARGS.contains("-pingpong")) client.sendData("ping".getBytes());
	}
}
