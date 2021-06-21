package org.xml.marshell.Xml;

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
import java.util.ArrayList;
import java.util.List;

public class telefonlisteXmlReader {

    public List<Telefonliste> xmlReader1(String filePath, String ElementsByTagName)
    {
        List<Telefonliste> telefonList = null;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(ElementsByTagName);
            // now XML is loaded as Document in memory, lets convert it to Object List
            telefonList = new ArrayList<Telefonliste>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                telefonList.add(getTelefonList(nodeList.item(i)));
            }

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        return telefonList;

    }

    private static Telefonliste getTelefonList(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        Telefonliste telefonliste = new Telefonliste();
        ToolBox toolBox = new ToolBox();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            telefonliste.setId(Integer.parseInt(toolBox.getTagValue("id", element)));
            telefonliste.setFirstName(toolBox.getTagValue("firstName", element));
            telefonliste.setLastName(toolBox.getTagValue("lastName", element));
            telefonliste.setMobilePhone(Integer.parseInt(toolBox.getTagValue("mobilePhone", element)));
        }
        return telefonliste;
    }



}
