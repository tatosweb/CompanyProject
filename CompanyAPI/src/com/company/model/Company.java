/**
 * 
 */
package com.company.model;

import java.util.List;
import java.util.UUID;

/**
 * @author Jorge Ramirez
 * 
 */
public class Company {
	
	private String CompanyId;
	private String name;
	private String address;
	private String city;
	private String country;
	private String email;
	private String phoneNumber;
	private List<String> owners;
	
	/**
	 * @param name
	 * @param address
	 * @param city
	 * @param country
	 * @param email
	 * @param owners
	 */
	public Company(String name, String address, String city, String country, String email, String phoneNumber, List<String> owners) {
		this.CompanyId = UUID.randomUUID().toString();
		setName(name);
		setAddress(address);
		setCity(city);
		setCountry(country);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setOwners(owners);
	}
		
	
	public String getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId() {
		if(CompanyId == null || CompanyId.isEmpty()){
			this.CompanyId = UUID.randomUUID().toString();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address != null && !address.isEmpty()){
			this.address = address;
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city != null && !city.isEmpty()){
			this.city = city;
		}
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		if(country != null && !country.isEmpty()){
			this.country = country;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null && !email.isEmpty()){
			this.email = email;
		}
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber != null && !phoneNumber.isEmpty()){
			this.phoneNumber = phoneNumber;
		}
	}

	public List<String> getOwners() {
		return owners;
	}
	public void setOwners(List<String> owners) {
		if(owners != null && !owners.isEmpty()){
			this.owners = owners;
		}else{
			throw new IllegalArgumentException("The Owners are Mandatory");
		}
	}

	public void isValid()throws IllegalArgumentException {
		
		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("The Name are Mandatory");
		}
		if(address == null || address.isEmpty()){
			throw new IllegalArgumentException("The Addredd are Mandatory");
		}
		if(city == null || city.isEmpty()){
			throw new IllegalArgumentException("The City are Mandatory");
		}
		if(country == null || country.isEmpty()){
			throw new IllegalArgumentException("The Country are Mandatory");
		}
		if(owners == null || owners.isEmpty()){
			throw new IllegalArgumentException("The Owners are Mandatory");
		}
		
	}
}
