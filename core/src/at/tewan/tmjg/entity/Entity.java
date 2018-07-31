package at.tewan.tmjg.entity;

import com.badlogic.gdx.math.Vector2;

public class Entity {
	private Vector2 position;
	private int id;
	
	public Entity(int id) {
		this.id = id;
	}
	
	public Entity(int id, Vector2 position) {
		this.id = id;
		this.position = position;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
