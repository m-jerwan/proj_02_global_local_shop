import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Enum> tags = new ArrayList<Enum>();
        tags.add(TagType.ORGANIC);
        Product product = new Product("potatoes", FoodGroupType.TUBERS, tags,1);

        Farm farm = new Farm("Animal Farm", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        String bio = "cool bio";
        farm.setBio(bio);

    }
}
