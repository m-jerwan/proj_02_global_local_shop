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

public class FarmController {


    public FarmController() { setupEndPoints();}


    public void setupEndPoints() {
//index
        get("/farms", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Farm> farms = DBHelper.getAll(Farm.class);
            model.put("farms", farms);
            model.put("template", "templates/farms/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//new
        get("/farms/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Farm> farms = DBHelper.getAll(Farm.class);
            model.put("farms", farms);
            model.put("template", "templates/farms/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

//create

        //THIS IS NOT USED YET
        post("/farms", (req, res) -> {

            //todo: get all info from queryParams

            Farm farm = new Farm(); //todo: not def constructor
            DBHelper.save(farm);
            res.redirect("/farms");
            return null;
        });

//show
        get("/farms/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Farm farm = DBHelper.find(Integer.parseInt(req.params(":id")), Farm.class);
            model.put("farm", farm);
            model.put("template", "templates/farms/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
//edit
        get("/farms/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Farm farm = DBHelper.find(Integer.parseInt(req.params(":id")), Farm.class);
            model.put("farm", farm);
            model.put("template", "templates/farms/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());









    }
}
