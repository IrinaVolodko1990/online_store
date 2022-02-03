package by.volodko.epam.online_store.model.entity;

public enum Status {
    NOT_ACTIVATED ("not_activated"),
    ACTIVATED ("activated"),
    BLOCKED("blocked")
    ;
    private String value;

    Status(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
