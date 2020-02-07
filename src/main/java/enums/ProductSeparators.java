package enums;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"), PRODUCT_ID("P"), CLOTH_ID("C"), BOOTS_ID("B");

    private String productSeparators;

    ProductSeparators(String productSeparators) {
        this.productSeparators = productSeparators;
    }

    public String toString() {
        return productSeparators;
    }

    public String getProductSeparators() {
        return productSeparators;
    }

    public static ProductSeparators getId(String productSeparators) {
        for(ProductSeparators id : ProductSeparators.values()) {
            if(id.getProductSeparators().equals(productSeparators)) {
                return id;
            }
        }
        return null;
    }




}
