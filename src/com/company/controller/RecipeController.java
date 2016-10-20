package com.company.controller;


import com.company.api.RecipeAPI;
import com.company.model.Recipe;
import com.google.gson.Gson;

import spark.Spark;

public class RecipeController {


	private static Gson json = new Gson();
	
	
	public RecipeController(RecipeAPI api) {
		
		//Spark.port(Integer.valueOf(System.getenv("PORT")));
		Spark.port(Integer.valueOf("4567"));
		
		Spark.get("/companies", (req, res) -> {
			res.type("application/json");
			res.status(200);
			return json.toJson(api.listCompanies());
		});
		
		Spark.get("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			res.type("application/json");
			try {
				res.status(200);
				return json.toJson(api.getCompany(id));
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
		
		Spark.post("/companies", (req, res) -> {
			Recipe company = json.fromJson(req.body(), Recipe.class);
			res.type("application/json");
			try {
				res.status(200);
				return json.toJson(api.createCompany(company));
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
		
		Spark.put("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			Recipe company = json.fromJson(req.body(), Recipe.class);
			res.type("application/jason");
			try {
				return json.toJson(api.updateCompany(id, company));
			} catch (Exception e) {
				return "{\"error\": \""+e+"\"}";
			}
			//return json.toJson(api.updateCompany(id, name, address, city, country, email, phoneNumber, owners));
		});
		
		Spark.delete("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			res.type("application/json");
			try {
				res.status(200);
				api.deleteCompany(id);
				return "{\"result\": \"True\"}";
			} catch (Exception e) {
				res.status(500);
				return "{\"error\": \""+e+"\"}";
			}
			
		});
	}
}
