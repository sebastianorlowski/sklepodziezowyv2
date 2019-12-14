package api;

import work.Product;
import java.util.*;

public interface ProductService {

    List<Product> getAllProducts();
    Integer getCountProducts();
    Product getProductByProductName (String productName);
    boolean isProductOnWarehouse(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(Long productId);

}
