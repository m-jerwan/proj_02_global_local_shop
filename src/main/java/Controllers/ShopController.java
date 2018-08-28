package Controllers;
import db.DBCustomer;
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
            allProducts =  Shop.updateArrayToHaveOnlyUniqueProducts(allProducts);
            model.put("allProducts", allProducts);

            model.put("template", "templates/shop/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/confirmation", (req, res) -> {
//set all var & fish db:
            Map<String, Object> model = new HashMap<>();
            int customerId = Integer.parseInt( req.queryParams("customerId"));
            Customer customer_1 = DBHelper.find(customerId, Customer.class);
            Basket currentBasket = new Basket(customer_1);
            List<TagType> tagsFromOrder = new ArrayList<>();
            Double totalMileageBasket = 0.00;
            Double basketTotal = 0.00;
            ArrayList< Farm> farmsFromOrder = new ArrayList<>();
            List<Basket> tempBasketList = DBCustomer.allBaskets(customer_1);
//exec:
            ArrayList<Product> productsOrdered = ProductFactory.makeProductsFromParams( req.queryParams());

            currentBasket.addAllProductsOrderedToBasket(productsOrdered);

            tempBasketList.add(currentBasket);
            customer_1.setBaskets(tempBasketList);
            basketTotal = currentBasket.calculate£TotalForBasket();
            currentBasket.putUniqueTagsFromBasketInto(tagsFromOrder);
            ArrayList<Farm> uniqueFarms = currentBasket.giveMeUniqueFarmsFromBasket();
            totalMileageBasket = currentBasket.calculateTotalMileageForBasket();


            DBHelper.save(currentBasket);
            model.put("totalMileageBasket", totalMileageBasket);
            model.put("basketTotal", basketTotal);
            model.put("tagsFromOrder", tagsFromOrder);
            model.put("farmsFromOrder", uniqueFarms);
            model.put("customer", customer_1);

            model.put("template", "templates/shop/confirmation.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
