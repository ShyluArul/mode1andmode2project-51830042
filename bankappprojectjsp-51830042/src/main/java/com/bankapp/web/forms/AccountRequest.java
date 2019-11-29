package com.bankapp.web.forms;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bankapp.model.entities.AccountType;

public class AccountRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long accountNumber;
	private double balance;
	private boolean block;
	private AccountType accountType;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String postalCode;
	private String stateName;
	private String country;
	
	
	/**
	 * @return the accountNumber
	 */
	
	public synchronized double getBalance() {
		return balance;
	}
	/**
	 * @return the accountNumber
	 */
	public synchronized Long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public synchronized void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the id
	 */
	public synchronized Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public synchronized void setId(Long id) {
		this.id = id;
	}
	public synchronized void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized AccountType getAccountType() {
		return accountType;
	}
	public synchronized void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public synchronized boolean isBlock() {
		return block;
	}
	public synchronized void setBlock(boolean block) {
		this.block = block;
	}
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized String getPassword() {
		return password;
	}
	public synchronized void setPassword(String password) {
		this.password = password;
	}
	public synchronized String getEmail() {
		return email;
	}
	public synchronized void setEmail(String email) {
		this.email = email;
	}
	public synchronized String getPhone() {
		return phone;
	}
	public synchronized void setPhone(String phone) {
		this.phone = phone;
	}
	public synchronized String getAddress() {
		return address;
	}
	public synchronized void setAddress(String address) {
		this.address = address;
	}
	public synchronized String getCity() {
		return city;
	}
	public synchronized void setCity(String city) {
		this.city = city;
	}
	public synchronized String getPostalCode() {
		return postalCode;
	}
	public synchronized void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public synchronized String getStateName() {
		return stateName;
	}
	public synchronized void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public synchronized String getCountry() {
		return country;
	}
	public synchronized void setCountry(String country) {
		this.country = country;
	}
	
	

}
