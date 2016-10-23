package ayaschxml;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
	
	private int id = 0;
	private String name;
	/**
	 * 0 = west
	 * 1 = south
	 * 2 = east
	 * 3 = north
	 */
	private int[] direction = { 0, 0, 0, 0,};
	private ArrayList<String> object = new ArrayList<>();
	
	public Room() {	
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the direction
	 */
	public int[] getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int[] direction) {
		this.direction = direction;
	}

	/**
	 * @return the object
	 */
	public ArrayList<String> getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(ArrayList<String> object) {
		this.object = object;
	}
	
	public void pushObject(String object) {
		this.object.add(object);
	}
	
	
}
