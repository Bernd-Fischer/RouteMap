package ayaschxml;

import java.util.ArrayList;

public class RouteCalculator {
	
	Map map;
	GameConfig gameConfig;
	Route route = null;
	ArrayList<String> searchedObject = new ArrayList<>();
	int lastRoom = 0;
	ArrayList<Integer> visitedRooms = new ArrayList<>();
	int currentRoom = 0;
	
	/**
	 * @param map
	 * @param gameConfig
	 */
	public RouteCalculator(Map map, GameConfig gameConfig) {
		this.map = map;
		this.gameConfig = gameConfig;
		
		for (int i = 0; i < gameConfig.getFindingObjects().size(); i++) {
			searchedObject.add(gameConfig.getFindingObjects().get(i));
		}
		
		
		makeRoute();
	}
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	private void makeRoute() {
		
		
		//ist ein gesuchtes objekt drin ?
			//ja - dann aus searchedobject raus
				//searchedObject leer ? dann fertig
		
			//nein - dann guck direction 0 - 4 dabei LastRoom beachten und visitedRooms
				//wenn nix gefunden dann last room
		
				// wenn gefunden lastroom id setzen setzen und wechseln
		
		currentRoom = gameConfig.getStart();
		
		while(searchedObject.size() != 0) {
		
		
		lastRoom = currentRoom;
		
		boolean isFound = isSearchedObjectIn();
		
		if (isFound == true) {
			//return;
		}
		
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			int nextRoom = map.getRoom().get(currentRoom).getDirection()[i];
			if (nextRoom != 0 && flag == false) {
				//for (int j = 0; j < visitedRooms.size(); j++) {
					//if (map.getRoom().get(nextRoom).getId() != visitedRooms.get(j)) {
						visitedRooms.add(currentRoom);
						lastRoom = currentRoom;
						currentRoom = map.getRoom().get(currentRoom).getDirection()[i];
						flag = true;
					//}		
				//}		
			}
		}
		if (flag == false) {
			currentRoom = lastRoom;
			lastRoom = visitedRooms.get(visitedRooms.size());	
		}
		
		}
		
		
	}
	
	private boolean isSearchedObjectIn() {
		for (int i = 0; i < map.getRoom().get(currentRoom).getObject().size(); i++) {
			for (int j = 0; j < searchedObject.size(); j++) {
				if (searchedObject.get(j) == map.getRoom().get(currentRoom).getObject().get(i)) {
					searchedObject.remove(j);
					System.out.println("gefunden!!! " + map.getRoom().get(currentRoom).getObject().get(i));
					return true;
				}			
			}
		}
		return false;
	}
	
	
	

}
