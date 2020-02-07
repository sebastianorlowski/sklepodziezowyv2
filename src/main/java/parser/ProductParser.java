package parser;

import work.Boots;
import work.Cloth;
import work.Product;
import enums.*;


public class ProductParser {
    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getId(productStr.substring(0,1));

        switch (productType) {

            case PRODUCT_ID:
                return convertToProduct(productStr);

            case BOOTS_ID:
                return convertToBoots(productStr);

            case CLOTH_ID:
                return convertToCloth(productStr);
        }
        return null;
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        double price = Double.parseDouble(productInformations[3]);
        double weight = Double.parseDouble(productInformations[4]);
        Color color = ColorParser.parseColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        double price = Double.parseDouble(productInformations[3]);
        double weight = Double.parseDouble(productInformations[4]);
        Color color = ColorParser.parseColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseMaterial(productInformations[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

            Long id = Long.parseLong(productInformations[1]);
            String productName = productInformations[2];
            double price = Double.parseDouble(productInformations[3]);
            double weight = Double.parseDouble(productInformations[4]);
            Color color = ColorParser.parseColor(productInformations[5]);
            int productCount = Integer.parseInt(productInformations[6]);
            int size = Integer.parseInt(productInformations[7]);
            SkinType skinType = SkinParser.parseSkin(productInformations[8]);

            return new Boots(id, productName, price, weight, color, productCount, size, skinType);

        }





    }

