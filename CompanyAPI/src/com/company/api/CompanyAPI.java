package com.company.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.company.model.Company;

/**
 * @author Jorge Ramirez
 *
 */
public class CompanyAPI {

	private Map<String, Company> companies = new HashMap<String, Company>();
	
	/**
	 * @return List<Company> a list with all the companies
	 * 
	 * company method create a list of all the companies
	 */
	public List<Company> listCompanies() { 
		return new ArrayList<>(companies.values());
	}
	
	/**
	 * @param CompanyId of the company to search
	 * @return Company with the respective id
	 * 
	 * company method returns a company that match with the given id
	 */
	public Company getCompany(String CompanyId) {
		Company company = companies.get(CompanyId);
		if(company != null){
			return company;
		}else{
			throw new NoSuchElementException("The Company does not exist");
		}
	}
	
	/**
	 * @param name of the company
	 * @param address of the compay
	 * @param city of the company's location
	 * @param country of the company's location
	 * @param email of the company
	 * @param owners of the company
	 * @return Company created with the given data
	 * 
	 * company method creates a new company with the given data
	 */
	public Company createCompany(String name, String address, String city, String country, String email, String phoneNumber, List<String> owners) {
		Company newCompany = new Company(name, address, city, country, email, phoneNumber, owners);
		companies.put(newCompany.getCompanyId(), newCompany);
		return newCompany;
	}
	
	/**
	 * @param CompanyId id the company to update
	 * @param name of the company
	 * @param address of the compay
	 * @param city of the company's location
	 * @param country of the company's location
	 * @param email of the company
	 * @param owners of the company
	 * @return Comany with the updated values
	 * 
	 * company method update a company with the given data
	 */
	public Company updateCompany(String CompanyId, String name, String address, String city, String country, String email, String phoneNumber, List<String> owners) {
		Company company = companies.get(CompanyId);
		company.setName(name);
		company.setAddress(address);
		company.setCity(city);
		company.setCountry(country);
		company.setEmail(email);
		company.setPhoneNumber(phoneNumber);
		company.setOwners(owners);

		return company;
		
	}
	
	public void deleteCompany(String CompanyId){
		companies.remove(CompanyId);
	}
	
}
