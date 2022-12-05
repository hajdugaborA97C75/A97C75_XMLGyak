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
        
		String xmlFilePath = "XMLA97C75.xml"; //File beolvas�sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		
		Node masodikGyogyszer = document.getElementsByTagName("gyogyszer").item(1); //A 2. gy�gyszer elem gyerekelemeinek megkeres�se
		NodeList masodikGyogyszerNodeList = masodikGyogyszer.getChildNodes();
		
		for (int i = 0; i < masodikGyogyszerNodeList.getLength(); i++) { //A 2. gy�gyszer elem hat�anyag�nak megv�ltoztat�sa acetilszalicilsavra
			Node element = masodikGyogyszerNodeList.item(i);
			if ("hatoanyag".equals(element.getNodeName())) {
				element.setTextContent("acetilszalicilsav");
			}
		}
		
		Element ar = document.createElement("�r"); //A 2. gy�gyszer elemhez hozz�adunk egy �r elemet is.
		ar.appendChild(document.createTextNode("1759"));
		masodikGyogyszer.appendChild(ar);
		
		Node elsoDolgozo = document.getElementsByTagName("dolgozo").item(0); //Az 1. dolgoz� elem gyerekelemeinek megkeres�se
		NodeList elsoDolgozoNodeList = elsoDolgozo.getChildNodes();
		
		for (int i = 0; i < elsoDolgozoNodeList.getLength(); i++) { //A 1. dolgoz� elem h�zsz�m�nak megv�ltoztat�sa 42-re
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
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); //A m�dos�t�sokat felt�ltj�k az XML file-ba
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlFilePath));
		transformer.transform(source, result);
		
		System.out.println("V�ltoztat�sok sikeresen eszk�z�lve az XML file-on!!!!"); //Nyugt�zzuk az elv�gzett m�dos�t�sokat
		}
	}
}