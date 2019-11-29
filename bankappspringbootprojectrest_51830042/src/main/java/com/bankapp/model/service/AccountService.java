package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;


import com.bankapp.model.entities.Account;

public interface AccountService {
	public List<Account>getAllAccounts();
	public Optional<Account>findAccountById(Long id);
	public void deleteAccount(Long id);
	public Account addAccount(Account account);
	public Account updateAccount(Long id,Account account);
	public void deposit(Long id,double amount);
	public void withdraw(Long id,double amount);
	public void transfer(Long fromAccount,Long toAccount,double amount);
	public void blockAccount(Long id);
	
}
