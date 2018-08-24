package db;

import models.*;


public class Seeds {

    public static void seedData(){
        Shop shop = new Shop("new shop");
        DBHelper.save(shop);

        Farm farm_1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        Farm farm_2 = new Farm("HillView", "Kevlag", "Alloa 8", FuelConversionFactorType.DIESEL);
        Farm farm_3 = new Farm("BenAvis", "Smith", "BogAvenue", FuelConversionFactorType.HYBRID);
        String bio1 = "cool bio";
        String bio2 = "super cool bio";
        String bio3 = "It is full of stars";
        farm_1.setBio(bio1);
        farm_2.setBio(bio2);
        farm_3.setBio(bio3);
        DBHelper.save(farm_1);
        DBHelper.save(farm_2);
        DBHelper.save(farm_3);


        Customer customer_1 = new Customer ("Pat", "Edinburgh", shop);
        Customer customer_2 = new Customer ("Mike", "Livingston", shop);
        Customer customer_3 = new Customer ("Stuu", "Glasgow", shop);
        DBHelper.save(customer_1);
        DBHelper.save(customer_2);
        DBHelper.save(customer_3);

        Basket basket_1 = new Basket(customer_1);
        Basket basket_2 = new Basket(customer_2);
        Basket basket_3 = new Basket(customer_3);
        DBHelper.save(basket_1);
        DBHelper.save(basket_2);
        DBHelper.save(basket_3);

        Product product_1 = new Product("Mary Rose potatoes", GroupType.TUBERS, TagType.ORGANIC,1, farm_1, shop);
        Product product_2 = new Product("Jones potatoes ", GroupType.TUBERS, TagType.ORGANIC,1.5, farm_2, shop);
        Product product_3 = new Product("strawberries", GroupType.FRUITS, TagType.ORGANIC,.3, farm_2, shop);
        Product product_4 = new Product("chicken", GroupType.MEAT, TagType.ORGANIC,.5, farm_3, shop);
        DBHelper.save(product_1);
        DBHelper.save(product_2);
        DBHelper.save(product_3);
        DBHelper.save(product_4);

    }
}
