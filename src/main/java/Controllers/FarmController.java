package Controllers;

import db.DBFarm;
import db.DBHelper;
import models.Farm;
import models.FuelConversionFactorType;
import models.Product;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.FuelConversionFactorType.DIESEL;
import static spark.Spark.get;
import static spark.Spark.post;

public class FarmController {


    public FarmController() {
        setupEndPoints();
    }


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
            model.put("template", "templates/farms/new.vtl");
            List<FuelConversionFactorType> fuelConversionFactorTypes = FuelConversionFactorType.getAllFuelTypes();
            model.put("fuelConversionFactorTypes", fuelConversionFactorTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

// & create

        post("/farms", (req, res) -> {
            String farmName = req.queryParams("farm_name");
            String farmerName = req.queryParams("farmer_name");
            String bio = req.queryParams("bio");
            String address = req.queryParams("address");
            FuelConversionFactorType fuel = DIESEL;             //todo: change String into Enum
            Farm newFarm = new Farm(farmName, farmerName, address, fuel);
            newFarm.setBio(bio);
            DBHelper.save(newFarm);
            res.redirect("/farms");
            return null;
        });

//show
        get("/farms/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Farm farm = DBHelper.find(Integer.parseInt(req.params(":id")), Farm.class);
            model.put("farm", farm);
            List<Product> allProductsFromFarm= DBFarm.allProductsFrom(farm);
            model.put("allProductsFromFarm", allProductsFromFarm);
            model.put("template", "templates/farms/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//edit
        //THIS IS NOT USED YET
        get("/farms/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Farm farm = DBHelper.find(Integer.parseInt(req.params(":id")), Farm.class);
            model.put("farm", farm);
            List<FuelConversionFactorType> fuelConversionFactorTypes = FuelConversionFactorType.getAllFuelTypes();
            model.put("fuelConversionFactorTypes", fuelConversionFactorTypes);
            model.put("template", "templates/farms/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
// & update
        //THIS IS NOT USED YET
        post("/farms/:id", (req, res) -> {

            String farmName = req.queryParams("farm_name");
            String farmerName = req.queryParams("farmer_name");
            String bio = req.queryParams("bio");
            String address = req.queryParams("address");
            FuelConversionFactorType fuel = DIESEL;             //todo: change String into Enum
            Farm newFarm = new Farm(farmName, farmerName, address, fuel);
            newFarm.setBio(bio);
            newFarm.setId(Integer.parseInt(req.params(":id")));
            DBHelper.update(newFarm);
            res.redirect("/farms/" + req.params(":id"));
            return null;
        });

//destroy/delete    //todo: CANT DELETE A FARM -  FOREIGN KEY CONSTRAINTS
        post("/farms/:id/delete", (req, res) -> {
            Farm farm = DBHelper.find(Integer.parseInt(req.params(":id")), Farm.class);
            DBHelper.delete(farm);
            res.redirect("/farms");
            return null;
        });










    }
}
