package at.tewan.tmjg;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import at.tewan.tmjg.net.GameClient;
import at.tewan.tmjg.net.GameServer;
import at.tewan.tmjg.net.packets.Packet00Login;
import at.tewan.tmjg.net.packets.Packet01Logout;
import at.tewan.tmjg.server.DedicatedServer;
import at.tewan.tmjg.util.StartParameters;

public class Core extends ApplicationAdapter {
	
	private static final String TAG = "Core";
	
	private GameServer gameServer;
	private GameClient gameClient;
	private DedicatedServer dedicatedServer;
	
	@SuppressWarnings("static-access")
	@Override
	public void create () {
		Gdx.app.setLogLevel(Gdx.app.LOG_DEBUG);
		initNetwork();
		
		Packet00Login loginPacket = new Packet00Login("Stefan");
		try {
			gameClient.sendPacket(loginPacket);
		} catch (IOException e) {
			System.out.println("Failed to login");
		}
	}

	@Override
	public void render () {
		
	}
	
	@Override
	public void dispose () {
		try {
			gameClient.sendPacket(new Packet01Logout("Exited Game"));
		} catch (IOException e) {
			System.out.println("Failed to send logout package");
		}
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	public void initNetwork() {
		gameClient = new GameClient(JOptionPane.showInputDialog("Enter Server Adress"));
		gameClient.start();
		
		if(StartParameters.START_ARGS.contains("-server")) {
			gameServer = new GameServer();
			dedicatedServer = new DedicatedServer();
			gameServer.setPacketHandler(dedicatedServer);
			
			gameServer.start();
		}
	}
}
