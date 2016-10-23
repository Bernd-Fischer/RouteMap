package ayaschxml;

import java.util.ArrayList;

public class GameConfig {
	private int start = 0;
	private ArrayList<String> findingObjects = new ArrayList<>();
	
	public GameConfig() {
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public ArrayList<String> getFindingObjects() {
		return findingObjects;
	}

	public void setFindingObjects(ArrayList<String> findingObjects) {
		this.findingObjects = findingObjects;
	}
	
	public void pushFindingObject(String Object) {
		this.findingObjects.add(Object);
	}

}
