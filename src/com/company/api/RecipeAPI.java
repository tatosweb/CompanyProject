package com.company.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.company.model.Recipe;


/**
 * @author Jorge Ramirez
 *
 */
public class RecipeAPI {

	private Map<String, Recipe> companies = new HashMap<String, Recipe>();
	
	/**
	 * @return List<Company> a list with all the companies
	 * 
	 * company method create a list of all the companies
	 */
	public List<Recipe> listCompanies() { 
		return new ArrayList<>(companies.values());
	}
	
	/**
	 * @param CompanyId of the company to search
	 * @return Company with the respective id
	 * 
	 * company method returns a company that match with the given id
	 */
	public Recipe getCompany(String CompanyId) {
		Recipe company = companies.get(CompanyId);
		if(company != null){
			return company;
		}else{
			throw new NoSuchElementException("The Company does not exist");
		}
	}
	
	/**
	 * @param Company company with the data to create
	 * @return Company created with the given data
	 * 
	 * company method creates a new company with the given data
	 */
	public Recipe createCompany(Recipe company) {
		company.setRecipeId();
		company.isValid();
		companies.put(company.getRecipeId(), company);
		return company;
	}
	
	/**
	 * @param Company with the data to update
	 * @return Company with the updated values
	 * 
	 * company method update a company with the given data
	 */
	public Recipe updateCompany(String companyId, Recipe reqCompany) {
		if(companies.containsKey(companyId)){
			Recipe company = companies.get(companyId);
			company.setName(reqCompany.getName());
			company.setDescription(reqCompany.getDescription());
			company.setScore(reqCompany.getScore());
			company.setSteps(reqCompany.getSteps());

			return company;
		}else{
			throw new NoSuchElementException("The Company does not exists");
		}
	}
	
	/**
	 * @param CompanyId
	 * 
	 * company method, delete a company with the given id
	 */
	public void deleteCompany(String CompanyId){
		if(companies.containsKey(CompanyId)){
			companies.remove(CompanyId);
		}else{
			throw new NoSuchElementException("The Company does not exists");
		}
	}
	
}
