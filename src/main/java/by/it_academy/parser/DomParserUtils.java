package by.it_academy.parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserUtils {

    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Error while creating");
            return null;
        }
    }

    public static Document parseXmlDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (Exception e) {
                System.out.println("Error while parse doc");
            }
        }
        return document;
    }
}
