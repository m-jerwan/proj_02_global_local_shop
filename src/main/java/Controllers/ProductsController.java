package Controllers;

import db.DBHelper;
import models.Product;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class ProductsController {

    public ProductsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints(){


        get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Product> products = DBHelper.getAll(Product.class);
            model.put("products", products);
            model.put("template", "templates/products/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());





    }

}
