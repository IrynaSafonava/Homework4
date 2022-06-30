package by.it_academy.entity;

import java.util.List;

public class Journal {
    private String title;
    private Contacts contacts;
    private List<Article> articles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal \n {" +
                "title='" + title + '\'' +
                ", \n contacts=" + contacts +
                ", \n articles=" + articles +
                '}';
    }
}
