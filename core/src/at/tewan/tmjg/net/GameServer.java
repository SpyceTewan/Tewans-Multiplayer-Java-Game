package at.tewan.tmjg.net;

import static at.tewan.tmjg.net.NetworkCore.PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.badlogic.gdx.Gdx;


public class GameServer extends Thread {
	private static final String TAG = "Server";
	
	private DatagramSocket socket;
	
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
			
			String message = new String(packet.getData());
			if(message.trim().equalsIgnoreCase("ping")) {
				Gdx.app.log(TAG, "Received a ping from " + packet.getAddress() + ":" + packet.getPort());
				sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
				
			}
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
	
}
