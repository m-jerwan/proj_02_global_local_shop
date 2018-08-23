package models;

public enum TagType {
    ORGANIC("organic");

    private String description;

    TagType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
