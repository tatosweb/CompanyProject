import java.util.Arrays;
import java.util.HashMap;

import com.recipe.api.RecipeAPI;
import com.recipe.controller.RecipeController;
import com.recipe.model.Recipe;
import com.recipe.model.Step;



public class Test {

	public static void main(String[] args) {
		
		HashMap<String, String> asd = new HashMap<>();
		
		asd.get("123");
		
		RecipeAPI api = new RecipeAPI();
		Recipe co = new Recipe("A","B","C", Arrays.asList(new Step("S1", "s2")));
		api.createRecipe(co);
		
		System.out.println(api.listRecipies());
		
		RecipeController controle = new RecipeController(api);

	}

}
