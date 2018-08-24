import db.DBHelper;
import db.DBShop;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Farm farm1 = new Farm("Animal Farm", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        String bio = "cool bio";
        farm1.setBio(bio);
        DBHelper.save(farm1);

        Shop shop = new Shop("new shop");
        DBHelper.save(shop);

        Customer customer = new Customer ("Pat", "Edinburgh", shop);
        DBHelper.save(customer);

        Basket basket = new Basket(customer);
        DBHelper.save(basket);

        Product product1 = new Product("potatoes", GroupType.DAIRY, TagType.ORGANIC,1, farm1, shop);
        DBHelper.save(product1);

        product1.setProductName("ziemniaki");
        DBHelper.update(product1);

        Product productTest = DBHelper.find(1, Product.class);

        List<Product> productTest2 =  DBHelper.getAll(Product.class);

//        DBHelper.delete(product1);

        List<Product> productList = DBShop.allProductsForShop();


    }
}
