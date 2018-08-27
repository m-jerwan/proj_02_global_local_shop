package models;

public enum GroupType {

    PULSES("Pulses/beans", 1),
    DAIRY("Dairy", 1),
    FRUITS("Fruits/Berries", 4.567),
    GRAINS("Grains", 1),
    HERBS("Herbs", 1),
    MEAT("Meats/Pultry", 4.567),
    MISC("Miscellaneous", 1),
    NUTS("Nuts/seeds", 1),
    OILS("Oils", 1),
    PROCESSED("Processed foods", 1),
    ROOT("Root crops", 1),
    SEAFOOD("Seafood", 1),
    TUBERS("Tubers", 4.567),
    VEGETEABLES("Vegeteables", 1);

    private String description;
    private double foodConversionFactor;

    GroupType(String description, double foodConversionFactor) {
        this.description = description;
        this.foodConversionFactor = foodConversionFactor;
    }

    public String getDescription() {
        return description;
    }

    public double getFoodConversionFactor() {
        return foodConversionFactor;
    }
}
