package com.recipe.main;

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

        int port = 27017;
        String dbname = "recipe";
        String username = "";
        String password = "";
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().build();
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), mongoClientOptions);
        mongoClient.setWriteConcern(WriteConcern.SAFE);
        DB db = mongoClient.getDB(dbname);
        return db;
    }
}
