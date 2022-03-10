package by.volodko.epam.online_store.model.entity;

public enum ProductCategory {
    RING ("ring"),
    NECK_JEWELRY ("neck_jewelry"),
    BRACELET("bracelet"),
    EARRINGS ("earrings"),
    JEWELRY_SET("jewelry_set");

    private String value;

    ProductCategory (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


