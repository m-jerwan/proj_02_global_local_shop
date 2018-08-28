package Controllers;
import db.DBCustomer;
import db.DBFarm;
import db.DBHelper;
import db.DBShop;
import models.*;
import models.factories.ProductFactory;
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
//set:
            Map<String, Object> model = new HashMap<>();
            int customerId = Integer.parseInt( req.queryParams("customerId"));
            Customer customer_1 = DBHelper.find(customerId, Customer.class);
            Basket currentBasket = new Basket(customer_1);
//
            List<Basket> tempBasketList = DBCustomer.allBaskets(customer_1);
            ArrayList<Product> productsOrdered = ProductFactory.makeProductsFromParams( req.queryParams());
            currentBasket.addAllProductsOrderedToBasket(productsOrdered);
            tempBasketList.add(currentBasket);
            customer_1.setBaskets(tempBasketList);


                    //iterating through tempArrayOfIDs to extract products and add them to last basket/ add price to calc total/get tags/get Farms/get farm addresses

            Double basketTotal = 0.00;
            List<TagType> tagsFromOrder = new ArrayList<>();  //TODO WHAT IF ITS EMPTY????
            Double totalMilageBasket = 0.00;

            ArrayList< Farm> farmsFromOrder = new ArrayList<>();


//            for (Product productOrdered: productsOrdered) {
//                customer_1.giveMeLastBasket().addToBasket(productOrdered);
//                basketTotal += productOrdered.getPrice();
//
//                if (!tagsFromOrder.contains(productOrdered.getTag())) {
//                    tagsFromOrder.add(productOrdered.getTag());
//                }
//
//                totalMilageBasket += Distance.distanceBetween(customer_1, productOrdered);
//                farmsFromOrder.add( productOrdered.getFarm());
//            }

            ArrayList<Farm> uniqueFarms = Farm.uniqueFarmsOnly(farmsFromOrder);

            model.put("totalMilageBasket", totalMilageBasket);
            model.put("basketTotal", basketTotal);
            model.put("tagsFromOrder", tagsFromOrder);
            model.put("farmsFromOrder", uniqueFarms);
            model.put("customer", customer_1);

            model.put("template", "templates/shop/confirmation.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
