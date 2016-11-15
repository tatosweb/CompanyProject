package com.recipe.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.recipe.model.Recipe;
import com.recipe.model.Step;


/**
 * @author Jorge Ramirez
 *
 */
public class RecipeAPI {

	private Map<String, Recipe> recipies = new HashMap<String, Recipe>();
	
	/**
	 * @return List<Recipe> a list with all the recipies
	 * 
	 * recipe method create a list of all the recipies
	 */
	public List<Recipe> listRecipies() { 
		return new ArrayList<>(recipies.values());
	}
	
	/**
	 * @param recipeId of the recipe to search
	 * @return Recipe with the respective id
	 * 
	 * company method returns a recipe that match with the given id
	 */
	public Recipe getRecipe(String recipeId) {
		Recipe recipe = recipies.get(recipeId);
		if(recipe != null){
			return recipe;
		}else{
			throw new NoSuchElementException("The recipe does not exist");
		}
	}
	
	/**
	 * @param Recipe recipe with the data to create
	 * @return Recipe created with the given data
	 * 
	 * recipe method creates a new recipe with the given data
	 */
	public Recipe createRecipe(Recipe recipe) {
		recipe.setRecipeId();
		recipe.isValid();
                for(Step step:recipe.getSteps()){
                    // step.setStepId();
                }
		recipies.put(recipe.getRecipeId(), recipe);
		return recipe;
	}
	
	/**
	 * @param Recipe with the data to update
	 * @return Recipe with the updated values
	 * 
	 * recipe method update a recipe with the given data
	 */
	public Recipe updateRecipe(String recipeId, Recipe reqRecipe) {
		if(recipies.containsKey(recipeId)){
			Recipe recipe = recipies.get(recipeId);
			recipe.setName(reqRecipe.getName());
			recipe.setDescription(reqRecipe.getDescription());
			recipe.setScore(reqRecipe.getScore());
			recipe.setSteps(reqRecipe.getSteps());

			return recipe;
		}else{
			throw new NoSuchElementException("The Recipe does not exists");
		}
	}
	
	/**
	 * @param recipeId
	 * 
	 * recipe method, delete a recipe with the given id
	 */
	public void deleteRecipe(String recipeId){
		if(recipies.containsKey(recipeId)){
			recipies.remove(recipeId);
		}else{
			throw new NoSuchElementException("The recipe does not exists");
		}
	}
	
}
