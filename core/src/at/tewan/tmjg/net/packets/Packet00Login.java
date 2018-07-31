package at.tewan.tmjg.net.packets;

public class Packet00Login extends Packet {

	public Packet00Login(String playername) {
		super((byte) PacketType.LOGIN.getId(), playername);
	}

}
