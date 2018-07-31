package at.tewan.tmjg.server;

import java.io.IOException;
import java.util.ArrayList;

import at.tewan.tmjg.Constants;
import at.tewan.tmjg.JSON;
import at.tewan.tmjg.Player;
import at.tewan.tmjg.networking.PositionPacket;
import nl.pvdberg.pnet.client.Client;
import nl.pvdberg.pnet.event.PNetListener;
import nl.pvdberg.pnet.packet.Packet;
import nl.pvdberg.pnet.packet.PacketReader;
import nl.pvdberg.pnet.server.Server;
import nl.pvdberg.pnet.server.util.PlainServer;

public class ServerCore implements PNetListener {
	
	public ArrayList<Player> players;
	public PacketReader reader;
	
	public ServerCore() {
		players = new ArrayList<Player>();
	}
	
	public static void main(String[] args) throws IOException {
		Server server = new PlainServer();
		server.setListener(new ServerCore());
		server.start(Constants.NET_PORT);
	}

	@Override
	public void onConnect(Client client) {
		Player player = new Player();
		player.id = players.size();
		
		players.add(player);
		System.out.println("New Player connected.");
	}

	@Override
	public void onDisconnect(Client arg0) {
		
	}

	@Override
	public void onReceive(Packet packet, Client client) throws IOException {
		reader = new PacketReader(packet);
		PositionPacket data = JSON.json.fromJson(reader.readString(), PositionPacket.class);
		
		for(Player player : players) {
			
		}
	}
}
