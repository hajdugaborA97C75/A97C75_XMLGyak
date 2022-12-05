package hu.domparse.a97c75;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryA97C75 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("XMLA97C75.xml");//Az XML file beolvas�sa
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//DocumentBuilderFactory inicializ�l�sa
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//A builder p�ld�nyos�t�sa
		 
		Document doc = dBuilder.parse(file);//A dokumentum konvert�l�sa hogy �rtse az xml-t
		doc.getDocumentElement().normalize();
		System.out.print("Gy�k�r elem: ");//A gy�k�relem ki�rat�sa
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("raktar");//A rakt�rak ment�se list�ba
        
        
        for (int i = 0; i < nList.getLength(); i++) {//A rakt�rak gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("RID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("gyogyszertar");
        
        for (int i = 0; i < nList.getLength(); i++) {//A gy�gyszert�rak gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("GysztID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("gyogyszer");
        
        for (int i = 0; i < nList.getLength(); i++) {//A gy�gyszerek gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("GyszID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("gy�gyszertarvezetok");
        
        for (int i = 0; i < nList.getLength(); i++) {//A gy�gyszert�r vezet�k gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("GyvID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("dolgozo");
        
        for (int i = 0; i < nList.getLength(); i++) {//A dolgoz�k gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("ID:"+elem.getAttribute("DID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("szallitas");
        
        for (int i = 0; i < nList.getLength(); i++) {//A sz�ll�t�sok gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("GysztID: "+elem.getAttribute("GysztID"));
            	System.out.println("RID: "+elem.getAttribute("RID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("vasarlas");
        
        for (int i = 0; i < nList.getLength(); i++) {//A sz�ll�t�sok gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("GysztID: "+elem.getAttribute("GysztID"));
            	System.out.println("VID: "+elem.getAttribute("VID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("betegseg");
        
        for (int i = 0; i < nList.getLength(); i++) {//A betegs�gek gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("GyszID: "+elem.getAttribute("GyszID"));
            	System.out.println("VID: "+elem.getAttribute("VID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
        
        nList = doc.getElementsByTagName("vasarlas");
        
        for (int i = 0; i < nList.getLength(); i++) {//A sz�ll�t�sok gyerek elemeinek megjelen�t�se a konzolon
        	Node node = nList.item(i);
            System.out.println("\nAktu�lis elem : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	System.out.println("GysztID: "+elem.getAttribute("GysztID"));
            	System.out.println("VID: "+elem.getAttribute("VID"));
            	NodeList nList2 = elem.getChildNodes();
            	for (int j = 0; j < nList2.getLength(); j++) {
            		Node node2 = nList2.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE && node2.getChildNodes().getLength() == 1) {
						System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
					}
					else {
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(node2.getNodeName()+":");
						}
						NodeList nList3 = node2.getChildNodes();
						for (int k = 0; k < nList3.getLength(); k++) {
							Node node3 = nList3.item(k);
							if (node3.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\t"+node3.getNodeName()+" : "+node3.getTextContent());
							}
						}
					}
				}
            }
		}
	}
}