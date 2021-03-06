package dao;

import utils.FileUtils;
import api.ProductDao;
import work.Product;
import parser.ProductParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String fileName = "products.data";
    private static ProductDaoImpl instance = null;

    private ProductDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static ProductDaoImpl getInstance() {
        if(instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance; }





    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine);
            if(product != null) {
                products.add(product);
            }
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return products;
    }

    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws IOException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for(Product product : products) {
            if(productId == product.getId()) {
                return product;
            }
                   }
        return null;
    }

    public Product getProductByProductName(String productName) throws IOException{
        List<Product> products = getAllProducts();

        for(Product product : products) {
            if(productName.equals(product.getProductName())) {
                return product;
            }
                    }
        return null;
    }

    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for(Product product : products) {
            if(productId == product.getId()) {
                products.remove(productId);
            }
            else {
                return;
            }
                    }

    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            if (productName.equals(product.getProductName())) {
                products.remove(productName);
            } else {
                return;
            }
        }
    }


}
