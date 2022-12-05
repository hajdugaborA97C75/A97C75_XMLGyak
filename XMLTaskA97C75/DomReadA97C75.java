package hu.domparse.a97c75;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class DomReadA97C75 {

	public static void main(String[] args)
		
		throws ParserConfigurationException, IOException, SAXException {

	        File xml = new File("XMLA97C75.xml"); //Az XML file beolvasása
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //DocumentBuilderFactory inicializálása
	        
	        DocumentBuilder docBuilder = factory.newDocumentBuilder(); // A builder példányosítása
	        Document document = docBuilder.parse(xml); //A dokumentum konvertálása hogy értse az xml-t
	        document.getDocumentElement().normalize(); 
	        
	        ReadFile(document); //Kiíratjuk az összes adatot
	    }
	
	public static void ReadFile(Document document) { //Az adatok beolvasása és kiíratása
		
		  NodeList nodeList1 = document.getElementsByTagName("raktar"); //Lista létrehozása a gyermekelemeknek a raktár kulcsszóra
	        for (int i = 0; i < nodeList1.getLength(); i++) {
	            Node rNode = nodeList1.item(i);

	            if (rNode.getNodeType() == Node.ELEMENT_NODE) { //Elemek id-hez adása
	                Element element1 = (Element) rNode;
	                String raktar_id = element1.getAttribute("RID"); //Attribútumok eltárolása
	                
	                Node rNode1 = element1.getElementsByTagName("iranyitoszam").item(0); //Elemek eltárolása
	                String iranyitoszam = rNode1.getTextContent();
	                
	                Node rNode2 = element1.getElementsByTagName("varos").item(0);
	                String varos = rNode2.getTextContent();
	                
	                Node rNode3 = element1.getElementsByTagName("utca").item(0);
	                String utca = rNode3.getTextContent();
	                
	                Node rNode4 = element1.getElementsByTagName("hazszam").item(0);
	                String hazszam = rNode4.getTextContent();
	                
	                System.out.println("Raktár adatok:\n\tRaktár ID: " + raktar_id + ", Cím: (Irányítószám: " 
					+ iranyitoszam + ", Város: " + varos + ", Utca: " + utca + ", Házszám: " + hazszam + ").\n"); //Az eltárolt adatok kiírása
	                
	            }
	        }
	       
	        NodeList nodeList2 = document.getElementsByTagName("gyogyszertar");
	        for (int i = 0; i < nodeList2.getLength(); i++) {
	            Node gytNode = nodeList2.item(i);
	            
	            if (gytNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element2 = (Element) gytNode;
	                String gyogyszertar_id = element2.getAttribute("GysztID");
	                
	                Node gysztNode1 = element2.getElementsByTagName("iranyitoszam").item(0);
	                String iranyitoszam = gysztNode1.getTextContent();
	                
	                Node gysztNode2 = element2.getElementsByTagName("varos").item(0);
	                String varos = gysztNode2.getTextContent();
	                
	                Node gysztNode3 = element2.getElementsByTagName("utca").item(0);
	                String utca = gysztNode3.getTextContent();
	                
	                Node gysztNode4 = element2.getElementsByTagName("hazszam").item(0);
	                String hazszam = gysztNode4.getTextContent();
	                
	                Node gysztNode5 = element2.getElementsByTagName("nev").item(0);
	                String nev = gysztNode5.getTextContent();
	                
	                System.out.println("Gyógyszertár adatok:\n\tGyógyszertár ID: " + gyogyszertar_id + ", Gyógyszertár név: " + nev +
	                ", Cím: (Irányítószám: " + iranyitoszam + ", Város: " + varos + ", Utca: "+ utca + ", Házszám: " + hazszam + ").\n");
	            }
	        }
	        
	        NodeList nodeList3 = document.getElementsByTagName("gyogyszer");
	        for (int i = 0; i < nodeList3.getLength(); i++) {
	            Node gyNode = nodeList3.item(i);
	            
	            if (gyNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element3 = (Element) gyNode;
	                String gyogyszer_id = element3.getAttribute("GyszID");
	                
	                Node gyszNode1 = element3.getElementsByTagName("receptre_kaphato").item(0);
	                String receptre_kaphato = gyszNode1.getTextContent();
	                
	                Node gyszNode2 = element3.getElementsByTagName("hatoanyag").item(0);
	                String hatoanyag = gyszNode2.getTextContent();
	                
	                Node gyszNode3 = element3.getElementsByTagName("tipus").item(0);
	                String tipus = gyszNode3.getTextContent();
	                
	                Node gyszNode4 = element3.getElementsByTagName("nev").item(0);
	                String nev = gyszNode4.getTextContent();
	                
	                
	                System.out.println("Gyógyszer adatok:\n\tGyógyszer ID: " + gyogyszer_id + ", Név: " + nev + 
					", Receptre kapható: " + receptre_kaphato + ", Hatóanyag: " + hatoanyag + ", Típus: " + tipus + ".\n");
	            }
	        }
	        
	        NodeList nodeList4 = document.getElementsByTagName("vasarlo");
	        for (int i = 0; i < nodeList4.getLength(); i++) {
	            Node vNode = nodeList4.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element4 = (Element) vNode;
	                String vasarlo_id = element4.getAttribute("VID");
	                
	                Node vNode1 = element4.getElementsByTagName("nev").item(0);
	                String nev = vNode1.getTextContent();
	                
	                Node vNode2 = element4.getElementsByTagName("haziorvos").item(0);
	                String haziorvos = vNode2.getTextContent();
	                
	                Node vNode3 = element4.getElementsByTagName("gyogyszererzekenyseg").item(0);
	                String gyogyszererzekenyseg = vNode3.getTextContent();
	                
	                System.out.println("Vásárló adatok:\n\tVásárló ID: " + vasarlo_id + ", Név: " + nev + ", Háziorvos: " + haziorvos +
	                ", Gyógyszerérzékenység: " + gyogyszererzekenyseg + ".\n");
	            }    
	        }
	        
	        NodeList nodeList5 = document.getElementsByTagName("dolgozo");
	        for (int i = 0; i < nodeList5.getLength(); i++) {
	            Node rNode = nodeList5.item(i);

	            if (rNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element5 = (Element) rNode;
	                String dolgozo_id = element5.getAttribute("DID");
	                
	                Node dNode1 = element5.getElementsByTagName("nev").item(0);
	                String nev = dNode1.getTextContent();
	                
	                Node dNode2 = element5.getElementsByTagName("iranyitoszam").item(0);
	                String iranyitoszam = dNode2.getTextContent();
	                
	                Node dNode3 = element5.getElementsByTagName("varos").item(0);
	                String varos = dNode3.getTextContent();
	                
	                Node dNode4 = element5.getElementsByTagName("utca").item(0);
	                String utca = dNode4.getTextContent();
	                
	                Node dNode5 = element5.getElementsByTagName("hazszam").item(0);
	                String hazszam = dNode5.getTextContent();
	                
	                System.out.println("Dolgozó adatok:\n\tDolgozó ID: " + dolgozo_id + ", Név: " + nev + 
	                ", Cím: (Irányítószám: " + iranyitoszam + ", Város: " + varos + ", Utca: " + utca + ", Házszám: " + hazszam + ").\n");
	                
	            }
	        }
	        
	        NodeList nodeList6 = document.getElementsByTagName("gyogyszertarvezeto");
	        for (int i = 0; i < nodeList6.getLength(); i++) {
	            Node rNode = nodeList6.item(i);

	            if (rNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element6 = (Element) rNode;
	                String gyogyszertar_vezeto_id = element6.getAttribute("GyvID");
	                
	                Node gyvNode1 = element6.getElementsByTagName("nev").item(0);
	                String nev = gyvNode1.getTextContent();
	                
	                Node gyvNode2 = element6.getElementsByTagName("iranyitoszam").item(0);
	                String iranyitoszam = gyvNode2.getTextContent();
	                
	                Node gyvNode3 = element6.getElementsByTagName("varos").item(0);
	                String varos = gyvNode3.getTextContent();
	                
	                Node gyvNode4 = element6.getElementsByTagName("utca").item(0);
	                String utca = gyvNode4.getTextContent();
	                
	                Node gyvNode5 = element6.getElementsByTagName("hazszam").item(0);
	                String hazszam = gyvNode5.getTextContent();
	                
	                System.out.println("Gyógyszertár vezető adatok:\n\tGyógyszertár vezető ID: "+ gyogyszertar_vezeto_id +", Név: " + nev +
	                ", Cím: (Irányítószám: " + iranyitoszam + ", Város: " + varos + ", Utca: " + utca + ", Házszám: " + hazszam + ").\n");
	                
	            }
	        }
	        
	        
	        NodeList nodeList7 = document.getElementsByTagName("szallitas");
	        for (int i = 0; i < nodeList7.getLength(); i++) {
	            Node szNode = nodeList7.item(i);
	            
	            if (szNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element7 = (Element) szNode;
	                String gyogyszertar_id = element7.getAttribute("GysztID");
	                String raktar_id = element7.getAttribute("RID");
	                
	                Node szNode1 = element7.getElementsByTagName("datum").item(0);
	                String datum = szNode1.getTextContent();
	                
	                Node szNode2 = element7.getElementsByTagName("fuvarozo_ceg").item(0);
	                String fuvarozo_ceg = szNode2.getTextContent();
	                
	                Node szNode3 = element7.getElementsByTagName("osszeg").item(0);
	                String osszeg = szNode3.getTextContent();
	                
	                System.out.println("Szállítási adatok:\n\tGyógyszertár ID: " + gyogyszertar_id + ", Raktár ID: " + raktar_id + ", Dátum: " + datum 
					+", Fuvarozó cég: " + fuvarozo_ceg + ", Összeg: " + osszeg + ".\n");
	            }
	        } 
	        
	        NodeList nodeList8 = document.getElementsByTagName("vasarlas");
	        for (int i = 0; i < nodeList8.getLength(); i++) {
	            Node vNode = nodeList8.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element8 = (Element) vNode;
	                String gyogyszertar_id = element8.getAttribute("GysztID");
	                String vasarlo_id = element8.getAttribute("VID");
	                
	                Node vNode1 = element8.getElementsByTagName("osszeg").item(0);
	                String osszeg = vNode1.getTextContent();
	                
	                Node vNode2 = element8.getElementsByTagName("fizetesi_mod").item(0);
	                String fizetesi_mod = vNode2.getTextContent();
	                
	                System.out.println("Vásárlási adatok:\n\tGyógyszertár ID: " + gyogyszertar_id + ", Vásárló ID: " + vasarlo_id + ", Összeg: " + osszeg
					+", Fizetési mód: " + fizetesi_mod + ".\n");
	            }
	        }
	        
	        NodeList nodeList9 = document.getElementsByTagName("betegseg");
	        for (int i = 0; i < nodeList9.getLength(); i++) {
	            Node bNode = nodeList9.item(i);
	            
	            if (bNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element9 = (Element) bNode;
	                String vasarlo_id = element9.getAttribute("VID");
	                String gyogyszer_id = element9.getAttribute("GyszID");
	                
	                Node bNode1 = element9.getElementsByTagName("panasz").item(0);
	                String panasz = bNode1.getTextContent();
	                
	                System.out.println("Betegség adatok:\n\tVásárló ID: " + vasarlo_id + ", Gyógyszer ID: " + gyogyszer_id +", Panasz: " + panasz + ".\n");
	            }
	        }
	        
	        NodeList nodeList10 = document.getElementsByTagName("vezetes");
	        for (int i = 0; i < nodeList10.getLength(); i++) {
	            Node vNode = nodeList10.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element10 = (Element) vNode;
	                String gyogyszertar_id = element10.getAttribute("GysztID");
	                String gyogyszertar_vezeto_id = element10.getAttribute("GyvID");
	                
	                System.out.println("Vezetés adatok:\n\tGyógyszertár ID: " + gyogyszertar_id + ", Gyógyszertár vezető ID: " + gyogyszertar_vezeto_id + ".\n");
	            }
	        }
	        
	        NodeList nodeList11 = document.getElementsByTagName("alkalmazott");
	        for (int i = 0; i < nodeList11.getLength(); i++) {
	            Node vNode = nodeList11.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element11 = (Element) vNode;
	                String dolgozo_id = element11.getAttribute("DID");
	                String gyogyszertar_vezeto_id = element11.getAttribute("GyvID");
	                
	                System.out.println("Alkalmazott adatok:\n\tGyógyszertár vezető ID: " + gyogyszertar_vezeto_id + ", Dolgozó ID: " + dolgozo_id + ".\n");
	            }
	        }
	}
}
