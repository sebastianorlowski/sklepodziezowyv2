package enums;

public enum Color {
    BLACK("#000000"), WHITE("#FFFFFFF"), RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"), YELLOW("#FFFF00");

    private String color;

    Color(String color) {
        this.color = color;
    }
    public String getHex() {
        return color;
    }
}
