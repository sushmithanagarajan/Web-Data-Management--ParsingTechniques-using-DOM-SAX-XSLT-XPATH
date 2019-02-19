package project8;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class xpath {

	
	 public static void main(String[] args) {
	      
	      try {
	         File inputFile = new File("reed.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         XPath xPath =  XPathFactory.newInstance().newXPath();
	         
	         //Query for question 1
	         
	         String expression1 = "/root/course[subj='MATH']/place[building='LIB'and room='204']/../title";
	         NodeList nodeList1 = (NodeList) xPath.compile(expression1).evaluate(doc, XPathConstants.NODESET);
	         System.out.println("===============Output for Query 1=======================");
	              for (int i = 0; i < nodeList1.getLength(); i++) {
	                 
	                 System.out.println("Query1 :" + nodeList1.item(i).getTextContent());
	              }
	         
	         //Query for question 2
	         String expression2 = "/root/course[subj='MATH' and crse='412']/instructor";
	         NodeList nodeList2 = (NodeList) xPath.compile(expression2).evaluate(doc, XPathConstants.NODESET);
	         System.out.println("===================Output for Query 2=======================");
             for (int j = 0; j < nodeList2.getLength(); j++) {
                
            	
                System.out.println("Query2 :" + nodeList2.item(j).getTextContent());
             }
	         
	         //Query for question 3
	         String expression3 = "/root/course[instructor='Wieting']/title";
	         NodeList nodeList3 = (NodeList) xPath.compile(expression3).evaluate(doc, XPathConstants.NODESET);
	         System.out.println("===================Output for Query 3========================");
             for (int k = 0; k < nodeList3.getLength(); k++) {
            	
                System.out.println("Query3 :" + nodeList3.item(k).getTextContent());
             }
	         
	      
	      }
	      catch (ParserConfigurationException e) {
	          e.printStackTrace();
	       } catch (SAXException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	      catch (XPathExpressionException e) {
	          e.printStackTrace();
	       }
	     
	 }
}
