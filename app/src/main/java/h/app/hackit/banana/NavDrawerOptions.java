package h.app.hackit.banana;

public class NavDrawerOptions {
    String text;
    int img;

    public NavDrawerOptions(String text) {
        this.text = text;
    }

    public NavDrawerOptions(String text, int img) {
        this.text = text;
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
