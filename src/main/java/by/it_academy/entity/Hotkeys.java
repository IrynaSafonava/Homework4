package by.it_academy.entity;

public class Hotkeys {
    private String hotkeys;

    public String getHotkey() {
        return hotkeys;
    }

    public void setHotkey(String hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "{" +
                "hotkey='" + hotkeys + '\'' +
                '}';
    }
}
