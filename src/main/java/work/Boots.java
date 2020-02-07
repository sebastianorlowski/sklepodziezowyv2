package work;
import enums.*;

public class Boots extends Product {
    private int size;
    private SkinType skinType;

    public Boots(Long id, String productName, double price, double weight, Color color, int productCount, int size,
                 SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;

    }

    public int getSize() {
        return size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    public String toString() {
        return super.toString() + ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                getBasicProductString() + size +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + skinType;
    }
}
