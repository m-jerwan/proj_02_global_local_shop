import db.DBCustomer;
import db.DBHelper;
import db.DBShop;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Farm farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        String bio = "cool bio";
        farm1.setBio(bio);
        DBHelper.save(farm1);

        Shop shop = new Shop("new shop");
        DBHelper.save(shop);

        Customer customer = new Customer ("Pat", "Edinburgh", shop);
        DBHelper.save(customer);
        Customer customer2 = new Customer ("Marcin", "Edinburgh", shop);
        DBHelper.save(customer2);

        Basket basket_1 = new Basket(customer);
        Basket basket2 = new Basket(customer2);
        DBHelper.save(basket_1);
        DBHelper.save(basket2);
        List<Basket> giveMeBaskets = DBHelper.getAll(Basket.class);

        customer.addBasket(basket_1);
        DBHelper.update(customer);



        Product product1 = new Product("potatoes", GroupType.DAIRY, TagType.ORGANIC,1, farm1, shop);
        DBHelper.save(product1);

        product1.setProductName("ziemniaki");
        DBHelper.update(product1);

        Product productTest = DBHelper.find(1, Product.class);

        List<Product> productTest2 =  DBHelper.getAll(Product.class);

//        DBHelper.delete(product1);

        List<Product> productList = DBShop.allProductsForShop();

        List<Basket> baskets = DBHelper.getAll(Basket.class);

        List<Customer> basketsTest = DBHelper.getAll(Customer.class);

        List<Farm> farms = DBHelper.getAll(Farm.class);

        List<Shop>  shops = DBHelper.getAll(Shop.class);

        List<Basket> basketsOfCustomer = DBCustomer.allBaskets(customer);
    }
}
