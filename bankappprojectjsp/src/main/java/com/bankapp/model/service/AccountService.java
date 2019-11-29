package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;

public interface AccountService {
	public List<Account>getAllAccounts();
	public Account findAccountById(Long id);
	public Account findAccountByAccountNumber(Long accountNumber);
	public void deleteAccount(Long accountNumber);
	public Account addAccount(Account account);
	public Account updateAccount(Long id,Account account);
	public void deposit(Long id,double amount);
	public void withdraw(Long id,double amount);
	public void transfer(Long fromAccount,Long toAccount,double amount);
	public void blockAccount(Account account);
	public Customer addCustomer(Customer customer);
	public Customer findCustomerById(Long id);
	public Customer updateCustomer(Customer customer);
	public List<Customer>getAllCustomers();
	public List<TransactionLog> findAllTransactionLog();
	
	
}
