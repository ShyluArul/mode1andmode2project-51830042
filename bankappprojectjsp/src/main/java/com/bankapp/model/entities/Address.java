package com.bankapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity@Table(name="address_table")
public class Address {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String city;
	private String postalCode;
	private String stateName;
	private String country;
	
@JoinColumn(name="customer_fk")
	@OneToOne 
	private Customer customer;

@JoinColumn(name="user_fk")
@OneToOne 
private User user;

	public Long getId() {
		return id;
	}
	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode
				+ ", stateName=" + stateName + ", country=" + country + "]";
	}


	public Address(String address, String city, String postalCode, String stateName, String country) {
		super();
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.stateName = stateName;
		this.country = country;
	}


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
