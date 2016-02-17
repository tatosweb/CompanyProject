import java.util.ArrayList;
import java.util.Arrays;

import com.company.api.CompanyAPI;
import com.company.controller.CompanyController;

import spark.Spark;


public class Test {

	public static void main(String[] args) {
		
		CompanyAPI api = new CompanyAPI();
		api.createCompany("asd", "direccion", "ciudad", "pais", "MAIL", "222332", Arrays.asList("yo"));
		
		System.out.println(api.listCompanies());
		
		CompanyController controle = new CompanyController(api);

	}

}
