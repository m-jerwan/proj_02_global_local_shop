package models;

public class Farm {

    private int id;
    private String farmName;
    private String farmerName;
    private String bio;
    private String address;
    private FuelConversionFactorType fuelConversionFactorType;

    public Farm(String farmName, String farmerName, String address, FuelConversionFactorType fuelConversionFactorType) {
        this.farmName = farmName;
        this.farmerName = farmerName;
        this.address = address;
        this.fuelConversionFactorType = fuelConversionFactorType;
    }

    public Farm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FuelConversionFactorType getFuelConversionFactorType() {
        return fuelConversionFactorType;
    }

    public void setFuelConversionFactorType(FuelConversionFactorType fuelConversionFactorType) {
        this.fuelConversionFactorType = fuelConversionFactorType;
    }
}
