package Controllers;
import db.DBCustomer;
import db.DBFarm;
import db.DBHelper;
import db.DBShop;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;



public class ShopController {


    public ShopController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        get("/shop", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/shop/shop_error.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        post("/shop", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int customerId = Integer.parseInt( req.queryParams("customerId"));
            Customer customer = DBHelper.find(customerId, Customer.class);
            model.put("customer", customer);
            List<Product> allProducts = DBShop.allProductsForShop();
            model.put("allProducts", allProducts);
            model.put("template", "templates/shop/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/confirmation", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int customerId = Integer.parseInt( req.queryParams("customerId"));

//            TODO: get all checked items/ create an array to store them, pass them into confirmation page

// HARDCODING FROM:/
            Shop shop = new Shop("new shop");
            Customer customer_1 = new Customer ("Pat", "Edinburgh", shop);
            Basket basket = new Basket(customer_1);
            customer_1.addBasket(basket);
            Farm farm_1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
            Farm farm_2 = new Farm("HillView", "Kevlag", "Alloa 8", FuelConversionFactorType.DIESEL);
            Product product_1 = new Product("Mary Rose potatoes", GroupType.TUBERS, TagType.ORGANIC,1, farm_1, shop, 2.50);
            Product product_2 = new Product("Jones potatoes ", GroupType.TUBERS, TagType.ORGANIC,1.5, farm_2, shop, 1.34);
            Product product_3 = new Product("strawberries", GroupType.FRUITS, TagType.ORGANIC,.3, farm_2, shop,2.30);
            customer_1.giveMeLastBasket().addToBasket(product_1);
            customer_1.giveMeLastBasket().addToBasket(product_2);
            customer_1.giveMeLastBasket().addToBasket(product_3);

            model.put("customer", customer_1);

//            TODO: write querry to get unique farms from THIS customers basket


            model.put("template", "templates/shop/confirmation.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
