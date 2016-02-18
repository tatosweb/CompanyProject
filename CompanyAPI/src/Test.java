import java.util.Arrays;
import java.util.HashMap;

import com.company.api.CompanyAPI;
import com.company.controller.CompanyController;
import com.company.model.Company;



public class Test {

	public static void main(String[] args) {
		
		HashMap<String, String> asd = new HashMap<>();
		
		asd.get("123");
		
		CompanyAPI api = new CompanyAPI();
		Company co = new Company("asd", "direccion", "ciudad", "pais", "MAIL", "222332", Arrays.asList("yo"));
		api.createCompany(co);
		
		System.out.println(api.listCompanies());
		
		CompanyController controle = new CompanyController(api);

	}

}
