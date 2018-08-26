package Controllers;
import db.DBCustomer;
import db.DBFarm;
import db.DBHelper;
import db.DBShop;
import models.Customer;
import models.Farm;
import models.Product;
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
            int customerId = Integer.parseInt( req.queryParams("customerSignIn"));
            Customer customer = DBHelper.find(customerId, Customer.class);
            model.put("customer", customer);
            List<Product> allProducts = DBShop.allProductsForShop();
            model.put("allProducts", allProducts);
            model.put("template", "templates/shop/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/confirmation", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/shop/confirmation.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
