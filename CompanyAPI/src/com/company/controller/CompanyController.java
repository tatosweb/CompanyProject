package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import com.company.api.CompanyAPI;
import com.google.gson.Gson;

import spark.Spark;

public class CompanyController {

	
	private static Gson json = new Gson();
	
	
	public CompanyController(CompanyAPI api) {
		
		
		Spark.get("/companies", (req, res) -> json.toJson(api.listCompanies()));
		
		Spark.get("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			return json.toJson(api.getCompany(id));
		});
		
		Spark.post("/companies", (req, res) -> {
			String name = req.queryParams("name");
			String address = req.queryParams("address");
			String city = req.queryParams("city");
			String country = req.queryParams("country");
			String email = req.queryParams("email");
			String phoneNumber = req.queryParams("phoneNumber");
			List<String> owners = json.fromJson(req.queryParams("owners"), List.class);
			
			return json.toJson(api.createCompany(name, address, city, country, email, phoneNumber, owners));
		});
		
		Spark.put("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			String name = req.queryParams("name");
			String address = req.queryParams("address");
			String city = req.queryParams("city");
			String country = req.queryParams("country");
			String email = req.queryParams("email");
			String phoneNumber = req.queryParams("phoneNumber");
			List<String> owners = json.fromJson(req.queryParams("owners"), List.class);
			
			return json.toJson(api.updateCompany(id, name, address, city, country, email, phoneNumber, owners));
		});
		
		Spark.delete("/companies/:id", (req, res) -> {
			String id = req.params(":id");
			api.deleteCompany(id);
			return "{result: True}";
		});
	}
}
