package Controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class ProductsController {

    public ProductsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints(){


        get("/products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Basket> baskets =DBHelper.getAll(Basket.class);
            List<Shop> shops =DBHelper.getAll(Shop.class);
            List<Farm> farms = DBHelper.getAll(Farm.class);
            EnumSet<TagType> tags = EnumSet.allOf(TagType.class);
            EnumSet<GroupType> foodGroupTypes = EnumSet.allOf(GroupType.class);
            model.put("foodgrouptypes", foodGroupTypes);
            model.put("tags", tags);
            model.put("baskets", baskets);
            model.put("shops", shops);
            model.put("farms", farms);
            model.put("template", "templates/products/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Product> products = DBHelper.getAll(Product.class);
            model.put("products", products);
            model.put("template", "templates/products/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/products/:id", (req, res) -> {
            Product product = DBHelper.find(Integer.parseInt(req.params(":id")), Product.class);
            Map<String, Object> model = new HashMap<>();
            model.put("product", product);
            model.put("template", "templates/products/show.vtl");
            return new ModelAndView(model,"templates/layout.vtl");
        }, new VelocityTemplateEngine());




    }

}
