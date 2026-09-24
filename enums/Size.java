package enums;

public enum Size {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
