package models;

public enum TagType {
    ORGANIC("organic"),
    VEGAN("vegan");

    private String description;

    TagType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
