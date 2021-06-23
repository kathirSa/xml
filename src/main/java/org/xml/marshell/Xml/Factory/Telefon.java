package org.xml.marshell.Xml.Factory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Xml.ToolBox;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Telefon extends XmlMarshelling{


    @Override
    public Telefonliste getTelefonList(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        Telefonliste telefonliste = new Telefonliste();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            telefonliste.setId(Integer.parseInt(getXmlTagValue("id", element)));
            telefonliste.setFirstName(getXmlTagValue("firstName", element));
            telefonliste.setLastName(getXmlTagValue("lastName", element));
            telefonliste.setMobilePhone(Integer.parseInt(getXmlTagValue("mobilePhone", element)));
        }
        return telefonliste;
    }

   public List<Telefonliste> getAllTelefonList(XmlMarshelling xmlMarshelling,String filePath, String ElementsByTagName)
   {

       NodeList nodeList = xmlMarshelling.xmlDomTreeToJavaNodeList(filePath, ElementsByTagName);

       List<Telefonliste> telefonList = null;
       telefonList = new ArrayList<Telefonliste>();

       for(int i = 0 ; i < nodeList.getLength(); i++){
           telefonList.add(xmlMarshelling.getTelefonList(nodeList.item(i)));

       }

       return telefonList;
   }

}
