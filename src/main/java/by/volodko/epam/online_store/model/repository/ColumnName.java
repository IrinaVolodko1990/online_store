package by.volodko.epam.online_store.model.repository;

public final class ColumnName {
    /*users Table*/
    public static final String USER_ID = "user_id";
    public static final String USER_LOGIN = "login";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_PHONE = "phone_number";
    public static final String USER_ROLE = "user_role_id";
    public static final String USER_STATUS = "user_status_id";
    public static final String USER_DISCOUNT = "discount_id";
    public static final String USER_BIRTHDAY = "birthday_date";
    public static final String COMMENT_ABOUT_USER = "comment";


    /*users_discounts Table*/
    public static final String DISCOUNT_ID = "id";
    public static final String DISCOUNT = "discount";


    /*users_roles Table*/
    public static final String ROLES_ID = "id";
    public static final String ROLES_NAME = "role_description";

    /*users_status Table*/
    public static final String STATUS_ID = "id";
    public static final String STATUS_NAME = "status_description";

    /*products Table*/
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_DESCRIPTION = "description";
   // public static final String PRODUCT_IMAGE = "image";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_AVAILABLE = "isAvailable";
    public static final String PRODUCT_CATEGORY = "category_id";
    public static final String PRODUCT_BRAND = "brand";
   // public static final String PRODUCT_NUMBER_IN_STOCK = "number_in_stock";

    /*products_categories Table */
    public static final String PRODUCT_TYPES_ID = "id";
    public static final String PRODUCT_TYPES_TYPE = "category_description";



    /*orders table*/
    public static final String ORDERS_ID = "id";
    public static final String ORDERS_ORDER = "order";
    public static final String ORDERS_DATE ="date";
    public static final String ORDERS_STATUS_ID = "order_status_id";
    public static final String ORDERS_SUMMARY_PRICE = "summary_price";
    public static final String ORDERS_USER_ID = "user_id";

    /*orders_status table*/
    public static final String ORDER_STATUS_ID = "id";
    public static final String ORDER_STATUS = "status";

    /*Purchases table*/
    public static final String PURCHASES_ID = "id";
    public static final String PURCHASES_ORDER_ID = "order_id";
    public static final String PURCHASES_PRODUCT_ID = "product_id";

    private ColumnName() {
    }
}
