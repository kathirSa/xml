package org.xml.marshell;

import org.w3c.dom.NodeList;
import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Model.User;
import org.xml.marshell.Xml.Factory.XmlFactory;
import org.xml.marshell.Xml.Factory.XmlMarshelling;

import java.util.ArrayList;
import java.util.List;

public class App3 {




    public static void main(String[] args ) {

        XmlFactory xmlFactory;
        XmlMarshelling xmlMarshelling;

        xmlMarshelling = XmlFactory.getXmlObjectList("Telefon");

        NodeList nodeList = xmlMarshelling.xmlDomTreeToJavaNodeList("xmlfolder/telefonliste.xml", "telefon");

        List<Telefonliste> telefonList = null;
        telefonList = new ArrayList<Telefonliste>();

        for(int i = 0 ; i < nodeList.getLength(); i++){
            telefonList.add(xmlMarshelling.getTelefonList(nodeList.item(i)));

        }


        // lets print User list information
        for (Telefonliste emp: telefonList) {
            System.out.println(emp.toString());
        }

        System.out.println("-----");
        System.out.println("-----");
        System.out.println("Telefon 2");

        List<Telefonliste> telefonList2 = null;
        telefonList2 = new ArrayList<Telefonliste>();
        telefonList2=  xmlMarshelling.getAllTelefonList(xmlMarshelling,"xmlfolder/telefonliste.xml","telefon");

        // lets print User list information
        for (Telefonliste emp: telefonList2) {
            System.out.println(emp.toString());
        }
        System.out.println("-----");
        System.out.println("-----");
        System.out.println("-----");


        xmlMarshelling = XmlFactory.getXmlObjectList("User");

        nodeList = xmlMarshelling.xmlDomTreeToJavaNodeList("xmlfolder/user.xml","User");

        List<User> Users = new ArrayList<User>();
        for(int i = 0 ; i < nodeList.getLength(); i++){
            Users.add(xmlMarshelling.getUserList(nodeList.item(i)));

        }

        for (User u1: Users){
            System.out.println(u1.toString());
        }





    }
}
