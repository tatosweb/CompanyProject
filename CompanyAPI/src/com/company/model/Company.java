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
	public void setCompanyId(String id) {
		this.CompanyId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}else{
			throw new IllegalArgumentException("The Name is Mandatory");
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address != null && !address.isEmpty()){
			this.address = address;
		}else{
			throw new IllegalArgumentException("The Address is Mandatory");
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city != null && !city.isEmpty()){
			this.city = city;
		}else{
			throw new IllegalArgumentException("The City is Mandatory");
		}
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		if(country != null && !country.isEmpty()){
			this.country = country;
		}else{
			throw new IllegalArgumentException("The Country is Mandatory");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

}
