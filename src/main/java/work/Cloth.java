package work;

import enums.Material;
import enums.ProductSeparators;
import enums.Color;

public class Cloth extends Product {
    private String size;
    private Material material;

    public Cloth(Long id, String productName, double price, double weight, Color color, int productCount,
                 String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    public String toString() {
        return super.toString() + ProductSeparators.CLOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
    }
}
