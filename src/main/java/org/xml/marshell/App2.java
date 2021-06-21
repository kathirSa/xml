package org.xml.marshell;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Xml.ToolBox;
import org.xml.marshell.Xml.GenericsXmlReader;

import java.util.ArrayList;
import java.util.List;


public class App2
{




    public static void main(String[] args ) {


        GenericsXmlReader genericsXmlReader = new GenericsXmlReader();
        NodeList nodeList =  genericsXmlReader.xmlReader1("xmlfolder/telefonliste.xml", "telefon");

        List<Telefonliste> telefonList = null;
        telefonList = new ArrayList<Telefonliste>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            telefonList.add(getTelefonList(nodeList.item(i)));
        }

        // lets print User list information
        for (Telefonliste emp: telefonList) {
            System.out.println(emp.toString());
        }



    }

    private static Telefonliste getTelefonList(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        ToolBox toolBox = new ToolBox();
        Telefonliste telefonliste = new Telefonliste();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            telefonliste.setId(Integer.parseInt(ToolBox.getTagValue("id", element)));
            telefonliste.setFirstName(ToolBox.getTagValue("firstName", element));
            telefonliste.setLastName(ToolBox.getTagValue("lastName", element));
            telefonliste.setMobilePhone(Integer.parseInt(ToolBox.getTagValue("mobilePhone", element)));
        }
        return telefonliste;
    }









}

