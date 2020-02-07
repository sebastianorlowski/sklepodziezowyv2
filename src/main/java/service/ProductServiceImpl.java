package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import validator.ProductValidator;
import work.Product;

import java.io.IOException;
import java.util.List;


public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = ProductDaoImpl.getInstance();
    private static ProductServiceImpl instance = null;
    ProductValidator productValidator = ProductValidator.getInstance();



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

    public boolean isProductExist(Long productId) throws IOException {
        for (Product product : getAllProducts()) {
            if (product.getId() == (productId)) {
                return true;
            }
        }
            return false;

    }

    public boolean saveProduct(Product product) {
        try {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return false;
        }


    }


