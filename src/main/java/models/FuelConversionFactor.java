package models;

public enum FuelConversionFactor {

    PETROL ("PETROL", 2.45),
    ;


    private String petrolType;
    private double fuelConversionFactor;

    FuelConversionFactor(String petrolType, double fuelConversionFactor) {
        this.petrolType = petrolType;
        this.fuelConversionFactor = fuelConversionFactor;
    }


    public String getPetrolType() {
        return petrolType;
    }

    public void setPetrolType(String petrolType) {
        this.petrolType = petrolType;
    }

    public double getFuelConversionFactor() {
        return fuelConversionFactor;
    }

    public void setFuelConversionFactor(double fuelConversionFactor) {
        this.fuelConversionFactor = fuelConversionFactor;
    }
}
