package xpathA97C75;

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

public class xPathA97C75
{
	public static void main(String[] args)
	{
		try
		{
			File xmlFile = new File("studentA97C75.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			String str1 = "/class/student";
			String str2 = "//student[@id='01']";
			String str3 = "//student";
			String str4 = "/class/student[2]";
			String str5 = "/class/student[last()]";
			String str6 = "/class/student[last()-1]";
			String str7 = "/class/student[position()>(last()-2)]";
			String str8 = "/class/*";
			String str9 = "//student[@*]";
			String str10 = "//*";
			String str11 = "/class/student[kor>20]";
			String str12 = "/class/student/vezeteknev | /class/student/keresztnev";
			NodeList nList = (NodeList) xPath.compile(str12).evaluate(doc,XPathConstants.NODESET);
			
			for (int i = 0; i < nList.getLength(); i++)
			{
				Node nNode = nList.item(i);
				System.out.println("\nAktualis elem: " + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode.getNodeName().equals("student"))
				{
					Element eElement = (Element) nNode;
					System.out.println("Hallgato ID: " 
							+ eElement.getAttribute("id"));
					System.out.println("Keresztnev: " 
							+ eElement
							.getElementsByTagName("keresztnev")
							.item(0)
							.getTextContent());
					System.out.println("Vezeteknev: " 
							+ eElement
							.getElementsByTagName("vezeteknev")
							.item(0)
							.getTextContent());
					System.out.println("Becenev: " 
							+ eElement
							.getElementsByTagName("becenev")
							.item(0)
							.getTextContent());
					System.out.println("Eletkor: " 
							+ eElement
							.getElementsByTagName("kor")
							.item(0)
							.getTextContent());
				}
			}
		} 
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (XPathExpressionException e)
		{
			e.printStackTrace();
		}
	}
}