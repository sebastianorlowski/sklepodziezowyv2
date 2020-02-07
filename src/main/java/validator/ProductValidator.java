package validator;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import work.Product;

public class ProductValidator {

    private static ProductValidator instance = null;
    private double MIN_PRICE_PRODUCT = 0.0f;
    private int MIN_COUNT_OF_PRODUCT = 0;
    private double MIN_PRODUCT_WEIGHT = 0.0f;
    private int NAME_OF_PRODUCT_LENGTH = 0;

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductWeightNoPositiveException, ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException {
        if (minPriceProduct(product.getPrice()))
            throw new ProductPriceNoPositiveException("Price cannot be zero!");

        if (minCountOfProduct(product.getProductCount()))
            throw new ProductCountNegativeException("Count of products cannot be less than zero!");

        if (minProductWeight(product.getWeight()))
            throw new ProductWeightNoPositiveException("Weight cannot be zero!");

        if (minNameOfProductLength(product.getProductName()))
            throw new ProductNameEmptyException("Name cannot be empty!");

        return true;
    }

    private boolean minPriceProduct(double price) {
        return price > MIN_PRICE_PRODUCT;
    }

    private boolean minCountOfProduct(int count) {
        return count >= MIN_COUNT_OF_PRODUCT;
    }

    private boolean minProductWeight(double weight) {
        return weight > MIN_PRODUCT_WEIGHT;
    }

    private boolean minNameOfProductLength(String productName) {
        return productName.length() > NAME_OF_PRODUCT_LENGTH;
    }
}
