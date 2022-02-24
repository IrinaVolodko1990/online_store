package by.volodko.epam.online_store.model.entity;

public enum UserDiscount {
    WHITE ("0"),
    BRONZE ("5"),
    SILVER ("10"),
    GOLD ("15");

    private String value;

   UserDiscount(String value) {
        this.value = value;
    }

   public String getValue() {
        return value;
    }
}
