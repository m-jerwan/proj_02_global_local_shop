import db.DBHelper;
import models.*;

public class Runner {
    public static void main(String[] args) {
        Farm farm1 = new Farm("Animal Farm", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        String bio = "cool bio";
        farm1.setBio(bio);
        DBHelper.save(farm1);

        Product product1 = new Product("potatoes", GroupTypeNew.DAIRY, TagType.ORGANIC,1, farm1);
        DBHelper.save(product1);

    }
}
