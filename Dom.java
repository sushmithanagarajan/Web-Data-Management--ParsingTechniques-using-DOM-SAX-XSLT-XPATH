package project8;
import org.w3c.dom.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class Dom {
public static void main(String args[]) {		
		try {	
			//Specify the location of the XML file
			File inputFile = new File("reed.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document document = docBuilder.parse(inputFile);
			//Normalize the Document Element
			document.getDocumentElement().normalize();
			NodeList collectionList = document.getElementsByTagName("course");
			System.out.println("===================Output for Query 1========================");
			for(int i = 0 ; i < collectionList.getLength() ; i ++) {
				
				Node collectionNode = collectionList.item(i);
				//check if levels of node and parent are same to access them over
				if(collectionNode.getNodeType() == Node.ELEMENT_NODE) {
					Element collectionElement = (Element) collectionNode;
					if(collectionElement.getElementsByTagName("subj").item(0).getTextContent().equals("MATH")) {
						NodeList subjectList = collectionElement.getElementsByTagName("place");
						for(int j = 0 ; j < subjectList.getLength() ; j ++) {
							Node subjectNode = subjectList.item(j);
							if(subjectNode.getNodeType() == Node.ELEMENT_NODE) {
								Element element = (Element) subjectNode;
								if(element.getElementsByTagName("building").item(0).getTextContent().equals("LIB") && element.getElementsByTagName("room").item(0).getTextContent().equals("204"))
								{
									
									System.out.println(collectionElement.getElementsByTagName("title").item(0).getTextContent());
								}
								
						}	
					}
					}
				}
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}