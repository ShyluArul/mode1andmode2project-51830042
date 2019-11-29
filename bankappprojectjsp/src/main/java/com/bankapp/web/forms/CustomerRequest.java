package com.bankapp.web.forms;

public class CustomerRequest {
	
	private Long accountNumber;
	private String phone;
	
	private String email;
	
	
	/**
	 * @return the accountNumber
	 */
	
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
	 * @return the phone
	 */
	public synchronized String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public synchronized void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	
	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public synchronized void setEmail(String email) {
		this.email = email;
	}
	
	

}
