package com.recipe.controller;


import com.recipe.api.RecipeAPI;
import com.recipe.model.Recipe;
import com.google.gson.Gson;
import com.recipe.util.ConfigProperties;
import com.recipe.util.PropertyId;

import spark.Spark;

public class RecipeController {


	private static Gson json = new Gson();
	
	
	public RecipeController(RecipeAPI api) {
		
                Spark.port(Integer.valueOf(
                        ConfigProperties.getProperty(PropertyId.RECIPE_SPARK_PORT) != null ?
                                ConfigProperties.getProperty(PropertyId.RECIPE_SPARK_PORT) :  System.getenv("PORT")));
		
		Spark.get("/recipies", (req, res) -> {
			res.type("application/json");
			res.status(200);
			return json.toJson(api.listRecipies());
		});
		
		Spark.get("/recipies/:id", (req, res) -> {
			String id = req.params(":id");
			res.type("application/json");
			try {
				res.status(200);
				return json.toJson(api.getRecipe(id));
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
		
		Spark.post("/recipies", (req, res) -> {
			Recipe recipe = json.fromJson(req.body(), Recipe.class);
			res.type("application/json");
			try {
				res.status(200);
				return json.toJson(api.createRecipe(recipe));
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
		
		Spark.put("/recipies/:id", (req, res) -> {
			String id = req.params(":id");
			Recipe recipe = json.fromJson(req.body(), Recipe.class);
			res.type("application/jason");
			try {
				return json.toJson(api.updateRecipe(id, recipe));
			} catch (Exception e) {
				return "{\"error\": \""+e+"\"}";
			}
			//return json.toJson(api.updateRecipe(id, name, address, city, country, email, phoneNumber, owners));
		});
		
		Spark.delete("/recipies/:id", (req, res) -> {
			String id = req.params(":id");
			res.type("application/json");
			try {
				res.status(200);
				api.deleteRecipe(id);
				return "{\"result\": \"True\"}";
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
	}
}
