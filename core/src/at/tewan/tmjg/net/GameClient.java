package at.tewan.tmjg.net;

import static at.tewan.tmjg.Constants.PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.badlogic.gdx.Gdx;

import at.tewan.tmjg.net.packets.Packet;

public class GameClient extends Thread {
	private static final String TAG = "Client";
	
	private InetAddress ipAdress;
	private DatagramSocket socket;
	
	public GameClient(String ipAdress) {
		try {
			this.socket = new DatagramSocket();
			this.ipAdress = InetAddress.getByName(ipAdress);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {		
		while(true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Gdx.app.log(TAG, "Received " + new String(packet.getData()));
		}
	}
	
	public void sendData(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAdress, PORT);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendPacket(Packet packet) throws IOException {
		DatagramPacket data = new DatagramPacket(packet.getPacket(), packet.getPacket().length, ipAdress, PORT);
		
		socket.send(data);
	}
}
