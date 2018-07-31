package at.tewan.tmjg.net.packets;

public class Packet01Logout extends Packet {

	public Packet01Logout(String reason) {
		super(PacketType.DISCONNECT.getId(), reason);
	}

}
