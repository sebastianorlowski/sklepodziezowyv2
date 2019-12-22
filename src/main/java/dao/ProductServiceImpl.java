package dao;

import api.ProductService;
import work.Product;
import java.util.*;


public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl(){
        this.products = new ArrayList<Product>();
    }
    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getCountProducts() {
        return products.size();
    }

    public Product getProductByProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
            return null;
        }


    public boolean isProductOnWarehouse(String productName) {
        for (Product product : products) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
            return false;

    }

    public boolean isProductExist(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
            return false;

    }

    public boolean isProductExist(int productId) {
        for (Product product : products) {
            if (product.getId() == (productId)) {
                return true;
            }
        }
            return false;

    }

}
