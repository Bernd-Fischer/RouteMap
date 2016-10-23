package ayaschxml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

	public static Map parseXML(File xmlFile) {
		
		Map map = new Map();
	
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList roomList = doc.getElementsByTagName("room");
			
			ArrayList<Room> roomArrayList = new ArrayList<>();
			
			for (int temp = 0; temp < roomList.getLength(); temp++) {
				Room room = new Room();
				
				Node nNode = roomList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					room.setId(Integer.parseInt(eElement.getAttribute("id")));
					
					room.setName(eElement.getAttribute("name"));
					
					int[] direction = {
						0 , 0 , 0, 0
					};
					
					if (eElement.getAttribute("west") != "") {
						direction[0] = Integer.parseInt(eElement.getAttribute("west"));
					}
					if (eElement.getAttribute("south") != "") {
						direction[1] = Integer.parseInt(eElement.getAttribute("south"));
					}
					if (eElement.getAttribute("east") != "") {
						direction[2] = Integer.parseInt(eElement.getAttribute("east"));
					}
					if (eElement.getAttribute("north") != "") {
						direction[3] = Integer.parseInt(eElement.getAttribute("north"));
					}
				
					room.setDirection(direction);

					NodeList objectList = eElement.getElementsByTagName("object");
					if (objectList != null) {
						for (int i = 0; i < objectList.getLength(); i++) {
							Node objectNode = objectList.item(i);
							Element objectElement = (Element) objectNode;
							room.pushObject(objectElement.getAttribute("name"));								
						}	
					}
					roomArrayList.add(room);					 
				}
			}
			map.setRoom(roomArrayList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
