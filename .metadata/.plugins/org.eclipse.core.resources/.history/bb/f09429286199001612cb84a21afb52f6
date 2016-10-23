package ayaschxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Map map = new Map();
		map = Parser.parseXML(new File("map.xml"));
		
		try {
		 FileReader fr = new FileReader("config1.txt");
		    BufferedReader br = new BufferedReader(fr);

		    int start = Integer.parseInt(br.readLine());
		    System.out.println(start);
		    
		    String line;
		    ArrayList<String> findingObjects = new ArrayList<>();
		    while((line = br.readLine()) != null) {
		    	findingObjects.add(line);
		    }
		    br.close();
		    
		    for (int i = 0; i < findingObjects.size(); i++) {
				System.out.println(findingObjects.get(i));
			}
		    
		} catch(Exception e) {
			
		}
		
		
		
		
	
	}

}
