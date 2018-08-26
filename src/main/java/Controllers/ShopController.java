package Controllers;
import db.DBHelper;
import models.Farm;
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



//index
        post("/shop", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int customerId = Integer.parseInt( req.queryParams("customerSignIn"));
            model.put("customerId", customerId);
            model.put("template", "templates/shop/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




    }

}
