package at.tewan.tmjg.entity;

import java.net.InetAddress;

import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	
	private String name;
	private InetAddress adress;
	
	public Player(int id, Vector2 position) {
		super(id, position);
	}
	
}
