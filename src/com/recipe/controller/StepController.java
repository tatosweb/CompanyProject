package com.recipe.controller;


import com.recipe.api.StepAPI;
import com.recipe.model.Step;
import com.google.gson.Gson;
import com.recipe.util.ConfigProperties;
import com.recipe.util.PropertyId;

import java.util.HashMap;

import spark.Request;
import spark.Response;
import spark.Route;

public class StepController {


    private static Gson json = new Gson();
    
    private static final String API_CONTEXT = "/api/v1";
    
    public StepController(StepAPI api) {
        
        Spark.port(Integer.valueOf(
            ConfigProperties.getProperty(PropertyId.RECIPE_SPARK_PORT) != null ?
                ConfigProperties.getProperty(PropertyId.RECIPE_SPARK_PORT) :  System.getenv("PORT")));

        Spark.get(API_CONTEXT + "/recipies", (req, res) -> {
            res.type("application/json");
            res.status(200);
            return json.toJson(api.listSteps());
        });
        
        Spark.get(API_CONTEXT + "/recipies/:id", (req, res) -> {
            String id = req.params(":id");
            res.type("application/json");
            try {
                res.status(200);
                return json.toJson(api.geStep(id));
            } catch (Exception e) {
                res.status(500);
                return "{\"error\": \""+e+"\"}";
            }
            
        });
        
        Spark.post(API_CONTEXT + "/recipies", (req, res) -> {
            res.type("application/json");
            try {
                res.status(200);
                return json.toJson(api.createStep(req.body()));
            } catch (Exception e) {
                res.status(500);
                return "{\"error\": \""+e+"\"}";
            }
            
        });
        
        Spark.put(API_CONTEXT + "/recipies/:id", (req, res) -> {
            String id = req.params(":id");
            res.type("application/jason");
            try {
                return json.toJson(api.updateStep(id, req.body()));
            } catch (Exception e) {
                return "{\"error\": \""+e+"\"}";
            }
            //return json.toJson(api.updateRecipe(id, name, address, city, country, email, phoneNumber, owners));
        });
        
        Spark.delete(API_CONTEXT + "/recipies/:id", (req, res) -> {
            String id = req.params(":id");
            res.type("application/json");
            try {
                res.status(200);
                api.deleteStep(id);
                return "{\"result\": \"True\"}";
            } catch (Exception e) {
                res.status(500);
                return "{\"error\": \""+e+"\"}";
            }
            
        });
    }
}
