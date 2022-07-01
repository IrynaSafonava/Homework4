package by.it_academy.parser.StAX;

import by.it_academy.entity.Article;
import by.it_academy.entity.Contacts;
import by.it_academy.entity.Hotkey;
import by.it_academy.entity.Journal;
import org.w3c.dom.ls.LSOutput;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StAXParserDemo {
    private static final String XML_PATH = "src/main/resources/example.xml";

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        Journal currJournal = null;
        List<Article> articleList = null;
        List<Hotkey> hotkeysList = null;
        Hotkey hotkey = null;
        Article article = null;
        Contacts contacts = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(XML_PATH));


        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    if ("journal".equals(reader.getLocalName())) {
                        currJournal = new Journal();
                        System.out.println("Start element journal");
                    }
                    if ("contacts".equals(reader.getLocalName())) {
                        contacts = new Contacts();
                        System.out.println("Created contacts");
                    }
                    if ("articles".equals(reader.getLocalName())) {
                        articleList = new ArrayList<>();
                        System.out.println("Start element articles");
                    }
                    if ("article".equals(reader.getLocalName())) {
                        article = new Article();
                        article.setId(reader.getAttributeValue(0));
                        System.out.println("Create article: " + article);
                    }
                    if ("hotkeys".equals(reader.getLocalName())) {
                        hotkeysList = new ArrayList<>();
                        System.out.println("Start element hotkeys");
                    }
                    if ("hotkey".equals(reader.getLocalName())) {
                        hotkey = new Hotkey();
                        System.out.println("Create hotkey" + hotkey);
                    }
                }
                case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                case XMLStreamConstants.END_ELEMENT -> {
                    switch (reader.getLocalName()) {
                        case "journal" -> {
                            currJournal.setArticles(articleList);
                            currJournal.setContacts(contacts);
                        }
                        case "title" -> currJournal.setTitle(tagContent);
                        case "tel" -> contacts.setTel(tagContent);
                        case "address" -> contacts.setAddress(tagContent);
                        case "article" -> articleList.add(article);
                        case "email" -> contacts.setEmail(tagContent);
                        case "url" -> contacts.setUrl(tagContent);
                        case "author" -> article.setAuthor(tagContent);
                        case "hotkeys" -> hotkeysList.add(hotkey);
                    }
                }
            }

        }
        System.out.println(currJournal);
    }
}