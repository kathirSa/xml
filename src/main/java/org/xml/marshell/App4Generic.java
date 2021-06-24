package org.xml.marshell;

import org.w3c.dom.NodeList;
import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Model.User;
import org.xml.marshell.Xml.Factory.XmlFactory;
import org.xml.marshell.Xml.Factory.XmlMarshelling;

import java.util.ArrayList;
import java.util.List;

public class App4Generic {

    public static void main(String[] args ) {

        XmlFactory xmlFactory;
        XmlMarshelling xmlMarshelling;

        xmlMarshelling = XmlFactory.getXmlObjectList("Telefon");

        NodeList nodeList = xmlMarshelling.xmlDomTreeToJavaNodeList("xmlfolder/telefonliste.xml", "telefon");

        List<Telefonliste> telefonList = null;
        telefonList = new ArrayList<Telefonliste>();

        for(int i = 0 ; i < nodeList.getLength(); i++){
            telefonList.add((Telefonliste) xmlMarshelling.getTelefonListGeneric(nodeList.item(i)));

        }


        // lets print User list information
        for (Telefonliste emp: telefonList) {
            System.out.println(emp.toString());
        }

        System.out.println("-----");
        System.out.println("-----");
        System.out.println("Telefon 2");




        xmlMarshelling = XmlFactory.getXmlObjectList("User");

        nodeList = xmlMarshelling.xmlDomTreeToJavaNodeList("xmlfolder/user.xml","User");

        List<User> Users = new ArrayList<User>();
        for(int i = 0 ; i < nodeList.getLength(); i++){
            Users.add((User) xmlMarshelling.getTelefonListGeneric(nodeList.item(i)));

        }

        for (User u1: Users){
            System.out.println(u1.toString());
        }





    }
}
