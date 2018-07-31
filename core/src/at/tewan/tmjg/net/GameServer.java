package at.tewan.tmjg.net;

import static at.tewan.tmjg.Constants.PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.badlogic.gdx.Gdx;

import at.tewan.tmjg.net.packets.Packet;


public class GameServer extends Thread {
	private static final String TAG = "Server";
	
	private DatagramSocket socket;
	private PacketListener packetListener;
	
	public GameServer() {
		
		Gdx.app.log(TAG, "Initializing...");
		
		try {
			this.socket = new DatagramSocket(PORT);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		Gdx.app.log(TAG, "Beginning to listen to port: " + PORT);
		
		while(true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Packet pack = new Packet(new String(data));
			pack.setAdress(packet.getAddress());
			
			packetListener.handlePacket(pack);
		}
	}
	
	public void sendData(byte[] data, InetAddress ipAdress, int port) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAdress, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPacketHandler(PacketListener listener) {
		this.packetListener = listener;
	}
	
}
