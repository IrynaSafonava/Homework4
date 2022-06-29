package by.it_academy.entity;

public class Article {
    private int id;
    private String title;
    private String author;
    private String url;
    private String[] hotkey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String[] getHotkey() {
        return hotkey;
    }

    public void setHotkey(String[] hotkey) {
        this.hotkey = hotkey;
    }
}
