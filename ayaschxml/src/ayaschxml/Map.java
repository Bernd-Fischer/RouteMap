package ayaschxml;

import java.util.ArrayList;

public class Map {
	
	private ArrayList<Room> roomArrayList = new ArrayList<>();

	public Map() {
	}

	/**
	 * @return the room
	 */
	public ArrayList<Room> getRoom() {
		return roomArrayList;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(ArrayList<Room> room) {
		this.roomArrayList = room;
	}
}
