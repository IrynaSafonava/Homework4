package by.it_academy.demo;

import by.it_academy.parser.DOM.DOMParser;
import by.it_academy.parser.StAX.StAXParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Runner {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        System.out.println("\n==============================");
        System.out.println("Journal parsed via DOM parser \n");
        DOMParser.parseWithDom();
        System.out.println("\n==============================");
        System.out.println("Journal parsed via StAX parser \n");
        StAXParser.parseXMLWithStAX();
    }
}
