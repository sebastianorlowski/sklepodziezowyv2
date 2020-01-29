package work;

import dao.UserRegisterLoginFacadeImpl;
import api.*;
import service.*;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startApp() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("2 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static Product createBootsProduct() {
        String productName;
        double price, weight;
        String color;
        int productCount, size;
        boolean isNaturalSkin;

        System.out.println("Enter the name of boots");
        productName = scanner.nextLine();

        System.out.println("Enter the price of boots");
        price = scanner.nextDouble();

        System.out.println("Enter the weight of boots");
        weight = scanner.nextDouble();

        System.out.println("Enter the color of boots");
        color = scanner.nextLine();

        System.out.println("Enter the pairs of boots");
        productCount = scanner.nextInt();

        System.out.println("Enter the size of boots");
        size = scanner.nextInt();

        System.out.println("Are they made of natural skin?");
        isNaturalSkin = scanner.nextBoolean();

        return new Boots(1L, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    public static Product createClothProduct() {
        String productName;
        double price, weight;
        String color;
        int productCount;
        String size;
        String material;

        System.out.println("Enter the name of cloth");
        productName = scanner.nextLine();

        System.out.println("Enter the price of cloth");
        price = scanner.nextDouble();

        System.out.println("Enter the weight of cloth");
        weight = scanner.nextDouble();

        System.out.println("Enter the colors of cloth");
        color = scanner.nextLine();

        System.out.println("Enter the pairs of cloth");
        productCount = scanner.nextInt();

        System.out.println("Enter the size of cloth");
        size = scanner.nextLine();

        System.out.println("Enter the material of cloth");
        material = scanner.nextLine();

        return new Cloth(1L, productName, price, weight, color, productCount, size, material);
    }

    public static Product createOtherProduct() {
        String productName;
        double price, weight;
        String color;
        int productCount;


        System.out.println("Enter the name of cloth");
        productName = scanner.nextLine();

        System.out.println("Enter the price of cloth");
        price = scanner.nextDouble();

        System.out.println("Enter the weight of cloth");
        weight = scanner.nextDouble();

        System.out.println("Enter the colors of cloth");
        color = scanner.nextLine();

        System.out.println("Enter the pairs of cloth");
        productCount = scanner.nextInt();

        return new Product(1L, productName, price, weight, color, productCount);
    }


    public static void main(String[] args) {

        UserRegisterLoginFacadeImpl userRegisterLoginFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean logOn = true;
        int read;

        while (appOn) {
            startApp();
            read = scanner.nextInt();

            switch (read) {

                case 1:
                    System.out.println("Enter login");
                    String loginLog = scanner.nextLine();
                    System.out.println("Enter password");
                    String passwordLog = scanner.nextLine();
                    if (userRegisterLoginFacade.loginUser(loginLog, passwordLog)) {
                        logOn = true;
                        System.out.println("You have logged in!");
                    } else {
                        System.out.println("Wrong login or password! Try Again!");
                    }
                    break;

                case 2:
                    System.out.println("Create new login");
                    String loginReg = scanner.nextLine();
                    System.out.println("Create password");
                    String passwordReg = scanner.nextLine();
                    User user = new User(1L, loginReg, passwordReg);
                    if (userRegisterLoginFacade.registerUser(user)) {
                        System.out.println("You have registered! Congratulations!");
                    } else {
                        System.out.println("Error! You havent registered! Try Again!");
                    }
                    break;

                case 0:
                    appOn = false;
                    break;
            }

            while (logOn) {
                loggedMenu();
                read = scanner.nextInt();

                switch (read) {
                    case 1:
                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                        }

                        if (productService.saveProduct(product)) {
                            System.out.println("You created a product!");
                        } else {
                            System.out.println("Product could not be created!");
                        }
                }
            }

        }

    }
}
