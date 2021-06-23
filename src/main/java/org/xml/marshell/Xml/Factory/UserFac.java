package org.xml.marshell.Xml.Factory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.marshell.Model.User;

public class UserFac extends  XmlMarshelling{

    @Override
    public User getUserList(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        org.xml.marshell.Model.User user = new org.xml.marshell.Model.User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setId(Integer.parseInt(getXmlTagValue("id", element)));
            user.setFirstName(getXmlTagValue("firstName", element));
            user.setLastName(getXmlTagValue("lastName", element));
            user.setGender(getXmlTagValue("gender", element));
            user.setAge(Integer.parseInt(getXmlTagValue("age", element)));
        }
        return user;
    }
}
