import java.util.Arrays;
import java.util.HashMap;

import com.company.api.RecipeAPI;
import com.company.controller.RecipeController;
import com.company.model.Recipe;
import com.company.model.Step;



public class Test {

	public static void main(String[] args) {
		
		HashMap<String, String> asd = new HashMap<>();
		
		asd.get("123");
		
		RecipeAPI api = new RecipeAPI();
		Recipe co = new Recipe("A","B","C", Arrays.asList(new Step("S1", "s2")));
		api.createCompany(co);
		
		System.out.println(api.listCompanies());
		
		RecipeController controle = new RecipeController(api);

	}

}
