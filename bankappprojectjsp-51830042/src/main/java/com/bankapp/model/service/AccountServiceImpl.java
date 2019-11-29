package com.bankapp.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptionhandler.AccountNotFoundEx;
import com.bankapp.exceptionhandler.CustomerNotFoundEx;
import com.bankapp.exceptionhandler.NotSufficientFundEx;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepo;
import com.bankapp.model.repo.AccountTransactionRepo;
import com.bankapp.model.repo.CustomerRepo;
import com.bankapp.model.repo.TransactionLogRepo;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;
@Autowired
private AccountTransactionRepo  accountTransactionRepo;
	@Autowired
	private TransactionLogRepo transactionLogRepo;
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	
	}

	@Override
	public Account findAccountById(Long accountNumber) {
		
		return accountRepo.findByAccountNumber(accountNumber);
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepo.deleteByAccountNumber(accountNumber);

	}

	@Override
	public Account addAccount(Account account) {
		
		return accountRepo.save(account);
		
		
		
	}

	@Override
	public Account updateAccount(Long id, Account account) {
		Account AccountToBeUpdated=accountRepo.findById(id).orElseThrow(AccountNotFoundEx::new);
		AccountToBeUpdated.setBalance(account.getBalance());
			return accountRepo.save(AccountToBeUpdated);
	}

	@Override
	public void deposit(Long id, double amount) {
		Account account=accountRepo.findById(id).orElseThrow(AccountNotFoundEx::new);
		account.setBalance(account.getBalance()+amount);
		AccountTransaction accountTransaction=new AccountTransaction("deposit",amount,account);
		 
		TransactionLog transactionLog=new TransactionLog(null,id,"deposit",amount,"shylu","done");
		transactionLogRepo.save(transactionLog);
				accountTransactionRepo.save(accountTransaction);
		 accountRepo.save(account);
	}

	@Override
	public void withdraw(Long id, double amount) {
		Account account=accountRepo.findById(id).orElseThrow(AccountNotFoundEx::new);
		if(account.getBalance()-amount<1000)
			throw new  NotSufficientFundEx();
		account.setBalance(account.getBalance()-amount);
		AccountTransaction accountTransaction=new AccountTransaction("withdraw",amount,account);
		 
		TransactionLog transactionLog=new TransactionLog(id,null,"withdraw",amount,"shylu","done");
		transactionLogRepo.save(transactionLog);
				accountTransactionRepo.save(accountTransaction);
		 accountRepo.save(account);
		
	}

	@Override
	public void transfer(Long fromAccount, Long toAccount, double amount) {
		Account account = accountRepo.findById(fromAccount).orElseThrow(AccountNotFoundEx::new);
		account.setBalance(account.getBalance()-amount);
		AccountTransaction accountTransaction = new AccountTransaction("withdraw", amount,account);
		account.addTransaction(accountTransaction);
		accountRepo.save(account);
		
		Account account1 = accountRepo.findById(toAccount).orElseThrow(AccountNotFoundEx::new);
		account1.setBalance(account.getBalance()+amount);
		AccountTransaction accountTransaction1 = new AccountTransaction("deposit", amount,account);
		account.addTransaction(accountTransaction1);
		accountRepo.save(account);
		TransactionLog transactionLog = new TransactionLog(fromAccount, toAccount,
				"transfer", amount, "anu", "done");
		transactionLogRepo.save(transactionLog);
		
	
	}

	@Override
	public void blockAccount(Account account) {
		// TODO Auto-generated method stub
		
		accountRepo.save(account);
		
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findCustomerById(Long id) {
		
		return customerRepo.findById(id).orElseThrow(CustomerNotFoundEx::new);
	}

	@Override
	public Account findAccountByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		return accountRepo.findByAccountNumber(accountNumber);
	}

	@Override
	public List<TransactionLog> findAllTransactionLog() {
		
		return transactionLogRepo.findAll();
	}



}
