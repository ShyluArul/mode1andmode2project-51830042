package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.dao.Account;

public interface AccountService {
	public void transferFund(int fromAccount, int toAccount, double amount);
	public List<Account> getAllAccounts();
	public Account saveAccount(Account account);
	public Account getAccount(int id);
	
	public void deposit(int accountId, double amount);
	public void withdraw(int accountId, double amount);
	
	public void blockAccount(int accountId);
	public void deleteAccount(int accountId);//logical delete
	
	public void unBlockAccount(int accountId);
	
	public Account updateAccount(Account account);
}
