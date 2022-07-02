package by.it_academy.parser.StAX;

import by.it_academy.entity.Article;
import by.it_academy.entity.Contacts;
import by.it_academy.entity.Hotkey;
import by.it_academy.entity.Journal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    private static final String XML_FILE_PATH = "src/main/resources/example.xml";

    private static Journal journal;
    private static List<Article> articleList;
    private static List<Hotkey> hotkeysList;
    private static int event;
    private static String tagContent;
    private static String tagName;

    public static void parseXMLWithStAX() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(XML_FILE_PATH));
        while (reader.hasNext()) {
            event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> parseStartElement(reader);
                case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
            }
        }
        System.out.println(journal);
    }

    private static void parseStartElement(XMLStreamReader reader) throws XMLStreamException {
        tagName = reader.getLocalName();
        if ("journal".equals(tagName)) {
            journal = new Journal();
        }
        if ("contacts".equals(tagName)) {
            setContactsWithValues(reader);
        }
        if ("articles".equals(tagName)) {
            articleList = new ArrayList<>();
        }
        if ("article".equals(tagName)) {
            setArticlesWithValues(reader);
        }
        if ("title".equals(tagName)) {
            journal.setTitle(reader.getElementText());
        }
    }

    private static void setContactsWithValues(XMLStreamReader reader) throws XMLStreamException {
        Contacts contacts = new Contacts();
        while (reader.hasNext() && !tagName.equals("articles") && event != 2) {
            event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                tagName = reader.getLocalName();
                if ("address".equals(tagName)) {
                    contacts.setAddress(reader.getElementText());
                }
                if ("tel".equals(tagName)) {
                    contacts.setTel(reader.getElementText());
                }
                if ("email".equals(tagName)) {
                    contacts.setEmail(reader.getElementText());
                }
                if ("url".equals(tagName)) {
                    contacts.setUrl(reader.getElementText());
                }
            }
        }
        journal.setContacts(contacts);
    }

    private static void setArticlesWithValues(XMLStreamReader reader) throws XMLStreamException {
        Article article = new Article();
        article.setId(reader.getAttributeValue(0));
        while (reader.hasNext() && !tagName.equals("contacts") && event != 2) {
            event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                tagName = reader.getLocalName();
                if ("title".equals(tagName)) {
                    article.setTitle(reader.getElementText());
                }
                if ("author".equals(tagName)) {
                    article.setAuthor(reader.getElementText());
                }
                if ("url".equals(tagName)) {
                    article.setUrl(reader.getElementText());
                }
                if ("hotkeys".equals(tagName)) {
                    hotkeysList = new ArrayList<>();
                    article.setHotkeys(hotkeysList);
                }
                if ("hotkey".equals(tagName)) {
                    Hotkey hotkey = new Hotkey();
                    hotkey.setHotkey(reader.getElementText());
                    hotkeysList.add(hotkey);
                    article.setHotkeys(hotkeysList);
                }
            }
        }
        articleList.add(article);
        journal.setArticles(articleList);
    }
}