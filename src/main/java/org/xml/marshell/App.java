package org.xml.marshell;


import org.xml.marshell.Model.Telefonliste;
import org.xml.marshell.Model.User;
import org.xml.marshell.Xml.telefonlisteXmlReader;
import org.xml.marshell.Xml.userXmlReader;

import java.util.List;


public class App
{
    public static void main( String[] args ) {
        userXmlReader xmlReader0 = new userXmlReader();
        List<User> userList = xmlReader0.xmlReader1("xmlfolder/user.xml", "User");

        // lets print User list information
        for (User emp: userList) {
            System.out.println(emp.toString());
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        telefonlisteXmlReader telefonlisteXmlReader = new telefonlisteXmlReader();
        List<Telefonliste> telefonliste0 = telefonlisteXmlReader.xmlReader1("xmlfolder/telefonliste.xml", "telefon");
        // lets print User list information
        for(Telefonliste emp: telefonliste0){
            System.out.println(emp.toString());
        }


        System.out.println("");
        System.out.println("");
        System.out.println(getfirst(5));
        System.out.println(getfirst("Hallo"));


    }

    public static <Thing> Thing getfirst(Thing x){
        return x;
    }







}

