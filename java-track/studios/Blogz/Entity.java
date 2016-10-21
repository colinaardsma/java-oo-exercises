package Blogz;

import java.util.ArrayList;

public abstract class Entity {
	private final int uid;
	private static ArrayList<Entity> entityList = new ArrayList<Entity>();

	public Entity() {
		this.uid = entityList.size() + 1;
		Entity.entityList.add(this);
	}
	
	public int getUID() {
		return this.uid;
	}
	
}
