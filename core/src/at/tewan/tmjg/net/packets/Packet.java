package at.tewan.tmjg.net.packets;

public abstract class Packet {
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
	
	private byte packetId;
	
	public Packet(int id) {
		this.packetId = id;
	}
}
