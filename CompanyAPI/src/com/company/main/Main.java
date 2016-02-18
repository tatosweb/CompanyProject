package com.company.main;

import com.company.api.CompanyAPI;
import com.company.controller.CompanyController;

public class Main {

	public static void main(String[] args) {
		CompanyAPI api = new CompanyAPI();
		new CompanyController(api);
	}
}
