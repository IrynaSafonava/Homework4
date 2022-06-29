package by.it_academy.parser.DOM;

import by.it_academy.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DomParserDemo {

    private static final String XML_PATH = "src/main/resources/example.xml";
    private static Journal journal = new Journal();

    public static void main(String[] args) {
        Document document = DomParserUtils.parseXmlDocument(XML_PATH);
        NodeList nodeList = DomParserUtils.getNodeList(document);
        setJournalWithXmlValues(nodeList, journal);
        System.out.println(journal.toString());
    }

    public static void setJournalWithXmlValues(NodeList nodeList, Journal journal){
        DomParserUtils.getNodeListStream(nodeList).forEach(node -> {
                NodeList childNodes = node.getChildNodes();
                DomParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setJournalWithXmlNodeValues(journal, childNode);
                    }
                });
        });
    }

    public static Journal setJournalWithXmlNodeValues(Journal journal, Node node){
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()){
            case "title": journal.setTitle(content);
            break;
            case "contacts": journal.setContacts(content);
            break;
            case "articles": journal.setArticles(content);
            break;
        }
        return journal;
    }
}
