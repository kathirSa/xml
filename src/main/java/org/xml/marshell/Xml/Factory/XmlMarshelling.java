package org.xml.marshell.Xml.Factory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Model.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlMarshelling {

    public static String getXmlTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public NodeList xmlDomTreeToJavaNodeList(String filePath, String ElementsByTagName)
    {
        NodeList nodeList = null;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            nodeList = doc.getElementsByTagName(ElementsByTagName);
            // now XML is loaded as Document in memory, lets convert it to Object List


        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        return nodeList;

    }

    public Telefonliste getTelefonList(Node node) {
        return null;
    }
    public <Thing> Thing getTelefonListGeneric(Node node) {
        return null;
    }
    public List<Telefonliste> getAllTelefonList(XmlMarshelling xmlMarshelling,String filePath, String ElementsByTagName)
    {
        return null;
    }
    public User getUserList(Node node) {
        return null;
    }
}
