package org.xml.marshell.Xml.Factory;

public class XmlFactory {

    public static XmlMarshelling getXmlObjectList(String ElementByTagName){

        XmlMarshelling xmlMarshelling = null;

        if(ElementByTagName.equals("Telefon"))
            xmlMarshelling = new Telefon();
        else if(ElementByTagName.equals("User"))
            xmlMarshelling = new UserFac();

        return xmlMarshelling;
    }
}
