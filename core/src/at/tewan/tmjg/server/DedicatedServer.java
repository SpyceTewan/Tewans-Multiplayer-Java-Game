package at.tewan.tmjg.server;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import at.tewan.tmjg.entity.Entity;
import at.tewan.tmjg.entity.Player;
import at.tewan.tmjg.net.PacketListener;
import at.tewan.tmjg.net.packets.Packet;
import at.tewan.tmjg.net.packets.Packet.PacketType;

public class DedicatedServer implements PacketListener {
	
	private static final String TAG = "Dedicated Server";
	
	private ArrayList<Entity> entities;
	
	public DedicatedServer() {
		entities = new ArrayList<Entity>();
	}

	@Override
	public void handlePacket(Packet packet) {
		
		Gdx.app.debug(TAG, "Packet Received: " + packet.getPacketId() + ":" + packet.getData());
		
		if(packet.getPacketId() == PacketType.LOGIN.getId()) {
			Gdx.app.log(TAG, "[" + packet.getAdress().getHostAddress() + "] Player " + packet.getData().trim() + " connected");´
			
			Player newPlayer = new Player(entities.size(), new Vector2(100, 100));
			entities.add(newPlayer);
		}
		
		if(packet.getPacketId() == PacketType.DISCONNECT.getId()) {
			Gdx.app.log(TAG, "[" + packet.getAdress().getHostAddress() + "] Player " + packet.getData().trim() + " disconnected");
		}
	}
	
}
