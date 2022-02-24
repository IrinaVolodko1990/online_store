package by.volodko.epam.online_store.model.validator;


public class ProductValidator {
    private static final String BRAND_REGEX = "^[\\p{Graph}А-Яа-я\\s]{1,50}";
    private static final String PRODUCT_NAME_REGEX = "^[\\p{Graph}А-Яа-я\\s]{1,50}";
    private static final String PRICE_REGEX = "^\\d+[.,]?\\d{1,2}$";


    private ProductValidator() {
    }

    public static boolean isValidBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.trim().isEmpty()) {
            return false;
        }
        return brand.matches(BRAND_REGEX);
    }

    public static boolean isValidProductName(String productName) {
        if (productName == null || productName.isEmpty() || productName.trim().isEmpty()) {
            return false;
        }
        return productName.matches(PRODUCT_NAME_REGEX);
    }

    public static boolean isValidPrice(String price) {
        if (price == null || price.isEmpty() || price.trim().isEmpty() || price.equals("0.0")||price.equals("0,0")) {
            return false;
        }
        return price.matches(PRICE_REGEX);
    }

    public static boolean isValidNumberInStock(int numberInStock) {
        return numberInStock >= 0;
    }

    //   public static booleanIsValidImage(?){
    //   return ?!=null;
    //   }


}
