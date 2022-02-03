package by.volodko.epam.online_store.model.entity;

public enum DeliveryType {
    COURIER("courier"),
    PICK_UP("pick_up"),
    POST("post");

    private String value;

    DeliveryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
