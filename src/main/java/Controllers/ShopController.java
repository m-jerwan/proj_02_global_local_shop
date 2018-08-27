package Controllers;
import db.DBCustomer;
import db.DBFarm;
import db.DBHelper;
import db.DBShop;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
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
            Customer customer_1 = DBHelper.find(customerId, Customer.class);
            List<Basket> tempBasketList = DBCustomer.allBaskets(customer_1);
            customer_1.setBaskets(tempBasketList);

            Basket emptyBasket = new Basket(customer_1);
            customer_1.addBasket(emptyBasket);

            List<Integer> tempArrayOfIDs = new ArrayList<>();        //iterating through querry params to extract ids of checked products
            for (String entry: req.queryParams()
                 ) {
                if (entry.contains("prod_")) {
                    String temp = entry.substring(5);
                    tempArrayOfIDs.add(Integer.parseInt(temp));
                }
            }

                    //iterating through tempArrayOfIDs to extract products and add them to last basket

            for (Integer entry: tempArrayOfIDs) {
                Product orderedProduct = DBHelper.find(entry, Product.class);

                customer_1.giveMeLastBasket().addToBasket(orderedProduct);
            }


//            TODO: get all checked items/ create an array to store them, pass them into confirmation page



            model.put("customer", customer_1);

//            TODO: write querry to get unique farms from THIS customers basket

            model.put("template", "templates/shop/confirmation.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
