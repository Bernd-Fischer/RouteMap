package ayaschxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Map map = new Map();
		map = Parser.parseXML(new File("map.xml"));
		ArrayList<GameConfig> gameConfigArray = new ArrayList<>();
		
		try {
			GameConfig gameconfig = new GameConfig();
			FileReader fr = new FileReader("config1.txt");
		    BufferedReader br = new BufferedReader(fr);

		    gameconfig.setStart(Integer.parseInt(br.readLine())-1);
		    
		    String line;
		    ArrayList<String> findingObjects = new ArrayList<>();
		    while((line = br.readLine()) != null) {
		    	findingObjects.add(line);
		    }
		    
		    gameconfig.setFindingObjects(findingObjects);
		    gameConfigArray.add(gameconfig);	    
		    br.close();
		    
		    
		   RouteCalculator routeCalculator = new RouteCalculator(map, gameconfig);
		   		    
		} catch(Exception e) {
			
		}		
	
	}

}
