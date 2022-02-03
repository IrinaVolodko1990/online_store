package by.volodko.epam.online_store.model.entity;

public enum UserDiscount {
    WHITE (0),
    BRONZE (5),
    SILVER (10),
    GOLD (15);

    private int value;

   UserDiscount(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
