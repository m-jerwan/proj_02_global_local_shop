package models;

import java.util.ArrayList;
import java.util.List;

public enum FuelConversionFactorType {

    PETROL ("petrol", 2.45),
    DIESEL ("diesel", 2.45),
    BIODIESEL ("biodiesel", 2.45),
    HYBRID ("hybrid", 2.45),
    ELECTRIC("electric", 2.45);

    private String description;
    private double fuelConversionFactor;

    FuelConversionFactorType(String description, double fuelConversionFactor) {
        this.description = description;
        this.fuelConversionFactor = fuelConversionFactor;
    }

    public String getDescription() {
        return description;
    }

    public double getFuelConversionFactor() {
        return fuelConversionFactor;
    }

    public static List<FuelConversionFactorType> getAllFuelTypes(){
        List<FuelConversionFactorType> fuelConversionFactorTypes = new ArrayList<>();
        fuelConversionFactorTypes.add(PETROL);
        fuelConversionFactorTypes.add(DIESEL);
        fuelConversionFactorTypes.add(BIODIESEL);
        fuelConversionFactorTypes.add(HYBRID);
        fuelConversionFactorTypes.add(ELECTRIC);
        return fuelConversionFactorTypes;
    }

}
