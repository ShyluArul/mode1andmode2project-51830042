package com.bankapp.model.dao;

public class AccountNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 8358753458409321100L;
	public AccountNotFoundException(String message) {
		super(message);
		
	}

}
