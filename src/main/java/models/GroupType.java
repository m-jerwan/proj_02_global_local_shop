package models;

public enum GroupType {

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

    private String foodType;
    private double foodConversionFactor;

    GroupType(String foodType, double foodConversionFactor) {
        this.foodType = foodType;
        this.foodConversionFactor = foodConversionFactor;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getFoodConversionFactor() {
        return foodConversionFactor;
    }
}
