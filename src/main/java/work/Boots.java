package work;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;
    public final static String PRODUCT_SEPARATOR = "#";

    public Boots(int id, String productName, double price, double weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    public String toString() {
        return super.toString() + PRODUCT_SEPARATOR +
                PRODUCT_SEPARATOR + size + '\'' +
                PRODUCT_SEPARATOR + isNaturalSkin +
                PRODUCT_SEPARATOR;
    }
}
