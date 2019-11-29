package com.bankapp.model.dao;
import java.util.*;
public interface AccountDao {
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
