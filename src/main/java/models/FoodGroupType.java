package models;

public enum FoodGroupType {
    PULSES("pulses/beans", 1),
    DAIRY("dairy", 1),
    FRUITS("fruits/berries", 1),
    GRAINS("grains", 1),
    HERBS("herbs", 1),
    MEAT("meats/pultry", 1),
    MISC("miscellaneous", 1),
    NUTS("nuts/seeds", 1),
    OILS("oils", 1),
    PROCESSED("processed foods", 1),
    ROOT("root crops", 1),
    SEAFOOD("seafood", 1),
    TUBERS("tubers", 1),
    VEGETEABLES("vegeteables", 1);

    private String description;
    private double foodConversionFactor;


    FoodGroupType(String description, double foodConversionFactor) {
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
