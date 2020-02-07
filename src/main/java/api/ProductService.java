package api;

import work.Product;

import java.io.IOException;
import java.util.*;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;
    Integer getCountProducts() throws IOException;
    Product getProductByProductName (String productName) throws IOException;

    boolean isProductOnWarehouse(String productName) throws IOException;
    boolean isProductExist(String productName) throws IOException;
    boolean isProductExist(Long productId) throws IOException;

    boolean saveProduct(Product product);


}
