package at.tewan.tmjg.net.packets;

import java.net.InetAddress;

public class Packet {
	public static enum PacketType {
		INVALID(-1), LOGIN(00), DISCONNECT(01);
		
		private int id;
		
		private PacketType(int id) {
			this.id = id;
		}
		
		public int getId() {
			return this.id;
		}
	}
	
	private int packetId;
	private String data;
	private InetAddress adress;
	
	public Packet(String rawData) {
		this.packetId = Integer.parseInt(rawData.substring(0, 2));
		this.data = rawData.substring(2);
	}
	
	public Packet(int id) {
		this.packetId = id;
	}
	
	public Packet(int id, String data) {
		this.packetId = id;
		this.data = data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setAdress(InetAddress adress) {
		this.adress = adress;
	}
	
	public InetAddress getAdress() {
		return this.adress;
	}
	
	public int getPacketId() {
		return packetId;
	}
	
	public String getData() {
		return data;
	}
	
	public byte[] getPacket() {
		String output = packetId + data;
		
		if(packetId < 10 && packetId >= 0) {
			output = 0 + output;
		}
		
		
		return output.getBytes();
	}
	
	public static PacketType lookupPacketId(String data) {
		int id = -1;
		try {
			id = Integer.parseInt(data.substring(0, 2));
		} catch(Exception e) {
		}
		
		return PacketType.values()[id];
	}
}
