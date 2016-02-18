package com.company.controller;

import java.util.List;

import com.company.api.CompanyAPI;
import com.company.model.Company;
import com.google.gson.Gson;

import spark.Spark;

public class CompanyController {

	
	private static Gson json = new Gson();
	
	
	public CompanyController(CompanyAPI api) {
		
		
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
			Company company = json.fromJson(req.body(), Company.class);
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
			Company company = json.fromJson(req.body(), Company.class);
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
