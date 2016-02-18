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
	 * @param Company company with the data to create
	 * @return Company created with the given data
	 * 
	 * company method creates a new company with the given data
	 */
	public Company createCompany(Company company) {
		company.setCompanyId();
		company.isValid();
		companies.put(company.getCompanyId(), company);
		return company;
	}
	
	/**
	 * @param Company with the data to update
	 * @return Company with the updated values
	 * 
	 * company method update a company with the given data
	 */
	public Company updateCompany(String companyId, Company reqCompany) {
		if(companies.containsKey(companyId)){
			Company company = companies.get(companyId);
			company.setName(reqCompany.getName());
			company.setAddress(reqCompany.getAddress());
			company.setCity(reqCompany.getCity());
			company.setCountry(reqCompany.getCountry());
			company.setEmail(reqCompany.getEmail());
			company.setPhoneNumber(reqCompany.getPhoneNumber());
			company.setOwners(reqCompany.getOwners());

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
