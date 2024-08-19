package com.binary.shopping.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String firstName;
	private String lastName;
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "customer")
	@JsonIgnore
	private List<Product> product;
	private long addressId;
	
	public Customer() {
	}
	
	

	public Customer(int customerId, String firstName, String lastName, List<Product> product, long addressId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.product = product;
		this.addressId = addressId;
	}



	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public long getAddressId() {
		return addressId;
	}



	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	
}
