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
import static spark.Spark.post;

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



        post("/products", (req, res) ->{
            String productName = req.queryParams("productName");
            Double productWeight = Double.parseDouble(req.queryParams("productWeight"));
            int shopId = Integer.parseInt(req.queryParams(("shop")));
            Shop shop = DBHelper.find(shopId, Shop.class);
            int farmId = Integer.parseInt(req.queryParams(("farm")));
            Farm farm = DBHelper.find(farmId, Farm.class);
            int basketId = Integer.parseInt(req.queryParams(("basket")));
            Basket basket = DBHelper.find(basketId, Basket.class);
            GroupType groupType = GroupType.valueOf(req.queryParams("foodGroupType"));
            TagType tag = TagType.valueOf(req.queryParams("tagType"));
//            String TagType = (req.queryParams("tagType"));
            Product product = new Product(productName, groupType, tag, productWeight, farm, shop);
            DBHelper.save(product);
            res.redirect("/products");
            return null;

        }, new VelocityTemplateEngine());




        post("/customers", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams(("shop")));
            Shop shop = DBHelper.find(shopId, Shop.class);
            String customerName = req.queryParams("customerName");
            String customerAddress = req.queryParams("customerAddress");
            Customer customer = new Customer(customerName, customerAddress, shop);
            DBHelper.save(customer);
            res.redirect("/customers");
            return null;
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
