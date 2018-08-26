package Controllers;

import db.DBHelper;
import db.Seeds;
import models.Customer;
import models.Farm;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        staticFileLocation("/public");

        Seeds.seedData();


        FarmController farmController = new FarmController();
        CustomersController customersController = new CustomersController();
        ProductsController productsController = new ProductsController();
        ShopController shopController = new ShopController();


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Farm> farms = DBHelper.getAll(Farm.class);
            model.put("farms", farms);

            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("customers", customers);
            return new ModelAndView(model, "templates/index.vtl");
        }, new VelocityTemplateEngine());

    }
}
