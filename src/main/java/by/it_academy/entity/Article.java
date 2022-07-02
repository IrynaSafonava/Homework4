package by.it_academy.entity;

import java.util.List;

public class Article {

    private String id;
    private String title;
    private String author;
    private String url;
    private List<Hotkey> hotkey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Hotkey> getHotkeys() {
        return hotkey;
    }

    public void setHotkeys(List<Hotkey> hotkeys) {
        this.hotkey = hotkeys;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkey +
                '}';
    }
}
