import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Farm farm1 = new Farm("Animal Farm", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        String bio = "cool bio";
        farm1.setBio(bio);

        ArrayList<Enum> tags = new ArrayList<Enum>();
        tags.add(TagType.ORGANIC);
        Product product = new Product("potatoes", FoodGroupType.TUBERS, tags,1, farm1);


    }
}
