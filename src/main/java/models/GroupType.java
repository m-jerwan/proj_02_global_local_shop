package models;

public enum GroupType {

    PULSES("Pulses/beans", 1, 45),
    DAIRY("Dairy", 1, 45),
    FRUITS("Fruits/Berries", 4.567, 45),
    GRAINS("Grains", 1, 45),
    HERBS("Herbs", 1, 45),
    MEAT("Meats/Pultry", 4.567, 45),
    MISC("Miscellaneous", 1, 45),
    NUTS("Nuts/seeds", 1, 45),
    OILS("Oils", 1, 45),
    PROCESSED("Processed foods", 1, 45),
    ROOT("Root crops", 1, 45),
    SEAFOOD("Seafood", 1, 45),
    TUBERS("Tubers", 4.567, 45),
    VEGETEABLES("Vegeteables", 1, 45);

    private String description;
    private double foodConversionFactor;
    private double travelDistance;

    GroupType(String description, double foodConversionFactor, double travelDistance) {
        this.description = description;
        this.foodConversionFactor = foodConversionFactor;
        this.travelDistance = travelDistance;
    }

    public String getDescription() {
        return description;
    }

    public double getFoodConversionFactor() {
        return foodConversionFactor;
    }

    public double getTravelDistance() {
        return travelDistance;
    }
}
