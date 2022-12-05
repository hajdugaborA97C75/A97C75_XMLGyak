package hu.domparse.a97c75;

import java.io.*;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;
import org.xml.sax.*;

public class DomModifyA97C75 {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException { {
        
		String xmlFilePath = "XMLA97C75.xml"; //File beolvasása
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		
		Node masodikGyogyszer = document.getElementsByTagName("gyogyszer").item(1); //A 2. gyógyszer elem gyerekelemeinek megkeresése
		NodeList masodikGyogyszerNodeList = masodikGyogyszer.getChildNodes();
		
		for (int i = 0; i < masodikGyogyszerNodeList.getLength(); i++) { //A 2. gyógyszer elem hatóanyagának megváltoztatása acetilszalicilsavra
			Node element = masodikGyogyszerNodeList.item(i);
			if ("hatoanyag".equals(element.getNodeName())) {
				element.setTextContent("acetilszalicilsav");
			}
		}
		
		Element ar = document.createElement("Ár"); //A 2. gyógyszer elemhez hozzáadunk egy Ár elemet is.
		ar.appendChild(document.createTextNode("1759"));
		masodikGyogyszer.appendChild(ar);
		
		Node elsoDolgozo = document.getElementsByTagName("dolgozo").item(0); //Az 1. dolgozó elem gyerekelemeinek megkeresése
		NodeList elsoDolgozoNodeList = elsoDolgozo.getChildNodes();
		
		for (int i = 0; i < elsoDolgozoNodeList.getLength(); i++) { //A 1. dolgozó elem házszámának megváltoztatása 42-re
			Node element = elsoDolgozoNodeList.item(i);
			if ("cim".equals(element.getNodeName())) {
				NodeList elementNodeList = element.getChildNodes();
				for (int j = 0; j < element.getChildNodes().getLength(); j++){
					Node element2 = elementNodeList.item(j);
					if ("hazszam".equals(element2.getNodeName())) {
						element2.setTextContent("42");
					}
				}
			}
		}
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); //A módosításokat feltöltjük az XML file-ba
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlFilePath));
		transformer.transform(source, result);
		
		System.out.println("Változtatások sikeresen eszközölve az XML file-on!!!!"); //Nyugtázzuk az elvégzett módosításokat
		}
	}
}