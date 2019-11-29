package com.bankapp.web.forms;

public class AccountBlockBean {
	
	private boolean blocked;
	
	private Long accountNumber;

	/**
	 * @return the blocked
	 */
	public synchronized boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked the blocked to set
	 */
	public synchronized void setBlocked(boolean blocked) {
		this.blocked = blocked;
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
	
	
	
	
	

}
