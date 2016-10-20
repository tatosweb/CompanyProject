package com.company.main;

import com.company.api.RecipeAPI;
import com.company.controller.RecipeController;

public class Main {

	public static void main(String[] args) {
		RecipeAPI api = new RecipeAPI();
		new RecipeController(api);
	}
}
