package at.tewan.tmjg.net;

import at.tewan.tmjg.net.packets.Packet;

public interface PacketListener {
	public void handlePacket(Packet packet);
}
