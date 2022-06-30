package by.it_academy.parser.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DomParserUtils {

    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("Error while creating");
            return null;
        }
    }

    public static Document parseXmlDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(new File(path));
            } catch (Exception e) {
                System.out.println("Error while parse doc");
            }
        }
        return document;
    }
}
