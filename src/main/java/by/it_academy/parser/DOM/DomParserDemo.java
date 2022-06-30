package by.it_academy.parser.DOM;

import by.it_academy.entity.Article;
import by.it_academy.entity.Contacts;
import by.it_academy.entity.Hotkeys;
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
        NodeList nodeListRoot = document.getDocumentElement().getChildNodes();
        setJournalWithXmlValues(nodeListRoot);
    }

    public static void setJournalWithXmlValues(NodeList nodeListRoot) {
        for (int i = 0; i < nodeListRoot.getLength(); i++) {
            if (nodeListRoot.item(i) instanceof Element) {
                setJournalWithXmlNodeValues(journal, nodeListRoot.item(i));
            }
        }
        System.out.println(journal.toString());
    }

    public static void setJournalWithXmlNodeValues(Journal journal, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title":
                journal.setTitle(content);
                break;
            case "contacts":
                journal.setContacts(setContactsWithXmlNodeValues(node));
                break;
            case "articles":
                journal.setArticles(serArticlesWithXmlNodeValues(node));
                break;
        }
    }

    public static Contacts setContactsWithXmlNodeValues(Node node) {
        Contacts contacts = new Contacts();
        NodeList contactsChildNodeList = node.getChildNodes();
        for (int i = 0; i < contactsChildNodeList.getLength(); i++) {
            if (contactsChildNodeList.item(i) instanceof Element) {
                setContactsWithXmlChildNodeValues(contacts, contactsChildNodeList.item(i));
            }
        }
        return contacts;
    }

    public static void setContactsWithXmlChildNodeValues(Contacts contacts, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "address":
                contacts.setAddress(content);
                break;
            case "tel":
                contacts.setTel(content);
                break;
            case "email":
                contacts.setEmail(content);
                break;
            case "url":
                contacts.setUrl(content);
                break;
        }
    }

    public static List<Article> serArticlesWithXmlNodeValues(Node node) {
        List<Article> articles = new ArrayList<>();
        NodeList articlesChildNodeList = node.getChildNodes();
        for (int i = 0; i < articlesChildNodeList.getLength(); i++) {
            if (articlesChildNodeList.item(i) instanceof Element) {
                Article article = new Article();
                article.setId(articlesChildNodeList.item(i).getAttributes().getNamedItem("ID").getNodeValue());
                NodeList articleChildNodes = articlesChildNodeList.item(i).getChildNodes();
                for (int j = 0; j < articleChildNodes.getLength(); j++) {
                    if (articleChildNodes.item(j) instanceof Element) {
                        setArticleWithXmlChildNodeValues(article, articleChildNodes.item(j));
                    }
                }
                articles.add(article);
            }
        }
        return articles;
    }

    public static void setArticleWithXmlChildNodeValues(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title":
                article.setTitle(content);
                break;
            case "author":
                article.setAuthor(content);
                break;
            case "url":
                article.setUrl(content);
                break;
            case "hotkeys":
                article.setHotkey(setHotkeysWithXmlNodeValues(node));
                break;
        }
    }

    public static List<Hotkeys> setHotkeysWithXmlNodeValues(Node node) {
        List<Hotkeys> hotkeys = new ArrayList<>();
        NodeList hotkeysChildNodeList = node.getChildNodes();
        for (int i = 0; i < hotkeysChildNodeList.getLength(); i++) {
            if (hotkeysChildNodeList.item(i) instanceof Element) {
                Hotkeys hotkey = new Hotkeys();
                setHotkeysWithXmlChildNodeValues(hotkey, hotkeysChildNodeList.item(i));
                hotkeys.add(hotkey);
            }
        }
        return hotkeys;
    }

    public static void setHotkeysWithXmlChildNodeValues(Hotkeys hotkeys, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        hotkeys.setHotkey(content);
    }
}
