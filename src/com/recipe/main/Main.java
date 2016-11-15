package com.recipe.main;

import com.mongodb.*;

import com.recipe.api.RecipeAPI;
import com.recipe.controller.RecipeController;

public class Main {

	public static void main(String[] args) {
		RecipeAPI api = new RecipeAPI();
		new RecipeController(api);
	}

    private static DB mongo() throws Exception {

        MongoClient mongoClient = new MongoClient("localhost");
        return mongoClient.getDB("recipe");
    }
}
