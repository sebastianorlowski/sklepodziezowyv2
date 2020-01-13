package service;

import api.ProductDao;
import dao.ProductDaoImpl;
import work.Product;

import java.io.IOException;
import java.util.*;


public class ProductServiceImpl implements api.ProductService {

    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");
    private static ProductServiceImpl instance = null;
    private ProductServiceImpl() {

    }

    public static ProductServiceImpl getInstance() {
        if(instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }



    public Integer getCountProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    public Product getProductByProductName(String productName) throws IOException {
        for (Product product : getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
            return null;
        }


    public boolean isProductOnWarehouse(String productName) throws IOException {
        for (Product product : getAllProducts()) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
            return false;

    }

    public boolean isProductExist(String productName) throws IOException {
        for (Product product : getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
            return false;

    }

    public boolean isProductExist(int productId) throws IOException {
        for (Product product : getAllProducts()) {
            if (product.getId() == (productId)) {
                return true;
            }
        }
            return false;

    }

}
