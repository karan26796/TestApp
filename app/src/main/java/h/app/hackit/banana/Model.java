package h.app.hackit.banana;

public class Model {
    String textOne, textTwo;
    boolean isExpanded = false;

    public Model(String textOne, String textTwo, boolean isExpanded) {
        this.textOne = textOne;
        this.textTwo = textTwo;
        this.isExpanded = isExpanded;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getTextOne() {
        return textOne;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    public String getTextTwo() {
        return textTwo;
    }

    public void setTextTwo(String textTwo) {
        this.textTwo = textTwo;
    }
}
