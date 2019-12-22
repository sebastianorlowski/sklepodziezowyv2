package Service;
import Impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import work.Boots;
import work.Cloth;
import work.Product;

import java.util.ArrayList;
import java.util.List;
public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {

        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Skin"));
        products.add(new Cloth(2,"Trousers", 299.00,5.00, "BUE", 10, "30/32", "Jeans"));
        products.add(new Boots(3, "Shoes", 399.99, 0.5,"WHITE", 1, 43, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);

    }

    @Test
    public void testGetAllProductsNegative() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Skin"));
        products.add(new Cloth(2,"Trousers", 299.00,5.00, "BUE", 10, "30/32", "Jeans"));
        products.add(new Boots(3, "Shoes", 399.99, 0.5,"WHITE", 1, 43, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Product(5, "Shoes", 99.00, 1.00, "WHITE", 5));
        List<Product> productsFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(products, productsFromTestClass);

    }

    @Test
    public void testGetCountProductsPositive() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Skin"));
        products.add(new Cloth(2,"Trousers", 299.00,5.00, "BUE", 10, "30/32", "Jeans"));
        products.add(new Boots(3, "Shoes", 399.99, 0.5,"WHITE", 1, 43, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int productsFromTestClass = productService.getCountProducts();
        Assert.assertEquals(3, productsFromTestClass);

    }

    @Test
    public void testGetCountProductsNegative() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Skin"));
        products.add(new Cloth(2,"Trousers", 299.00,5.00, "BUE", 10, "30/32", "Jeans"));
        products.add(new Boots(3, "Shoes", 399.99, 0.5,"WHITE", 1, 43, true));

        ProductServiceImpl productService = new ProductServiceImpl();
        final int productFromTestClass = productService.getCountProducts();
        Assert.assertNotEquals(3, productFromTestClass);

    }

    @Test
    public void testGetProductByProductName() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Jeans");
        products.add(cloth);
        products.add(new Boots(2, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("T-Shirt");

        Assert.assertEquals(cloth, product);

    }

    @Test
    public void testNoGetProductByProductName() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Jeans");
        products.add(cloth);
        products.add(new Boots(2, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Coś");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWarehouse() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 2, "M", "Jeans"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductFromTest = productService.isProductOnWarehouse("T-Shirt");

        Assert.assertTrue(isProductFromTest);
    }

    @Test
    public void testIsntProductOnWarehouse() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 0, "S", "Jeans"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductFromTest = productService.isProductOnWarehouse("T-Shirt");

        Assert.assertFalse(isProductFromTest);
    }
    @Test
    public void testIsProductExist() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 150.99, 1.20, "RED", 0, "S", "Jeans"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductFromTest = productService.isProductExist(1);

        Assert.assertTrue(isProductFromTest);
    }




}


