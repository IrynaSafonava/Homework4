package by.it_academy.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static by.it_academy.parser.DomParserUtils.parseXmlDocument;

public class Runner {
    public static final String XML_PATH = "example.xml";

    public static void main(String[] args) {
        Document document = parseXmlDocument(XML_PATH);
        Node root = document.getFirstChild();
        System.out.println(root.getNodeName());
        NodeList journalNodeList = root.getChildNodes();
        for (int i = 0; i < journalNodeList.getLength(); i++) {
            if (journalNodeList.item(i) instanceof Element) {
                System.out.println(journalNodeList.item(i).getNodeName());
            }
            NodeList contactsNodeList = journalNodeList.item(i).getChildNodes();
            for (int j = 0; j < contactsNodeList.getLength(); j++) {
                if (contactsNodeList.item(j) instanceof Element) {
                    System.out.println(contactsNodeList.item(j).getNodeName());
                }
            }
        }
    }
}
