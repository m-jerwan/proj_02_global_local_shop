package models;

public enum FuelConversionFactorType {

    PETROL ("petrol", 2.45),
    DIESEL ("diesel", 2.45),
    BIODIESEL ("biodiesel", 2.45),
    HYBRID ("hybrid", 2.45),
    ELECTRIC("electric", 2.45);

    private String petrolType;
    private double fuelConversionFactor;

    FuelConversionFactorType(String petrolType, double fuelConversionFactor) {
        this.petrolType = petrolType;
        this.fuelConversionFactor = fuelConversionFactor;
    }


    public String getPetrolType() {
        return petrolType;
    }

    public double getFuelConversionFactor() {
        return fuelConversionFactor;
    }

}
