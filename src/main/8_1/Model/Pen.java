package Model;

public class Pen {
    private Color color;
    private boolean capped;

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    // your code here
    public Pen(Color color) {
        this.color = color;
        this.capped = true;
    }
    public Pen() {
        this.color = Color.RED;
        this.capped = true;
    }
    public String draw() {
        if (capped) {
            return "";
        } else {
            return "Drawing " + color.toString();
        }
    }
    public void capOff() {
        capped = false;
    }
    public void capOn() {
        capped = true;
    }
    public void changeColor(Color newColor) {
        this.color = newColor;
    }
}