package by.it_academy.entity;

public class Hotkey {
    private String hotkey;

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return "{" +
                "hotkey='" + hotkey + '\'' +
                '}';
    }
}
