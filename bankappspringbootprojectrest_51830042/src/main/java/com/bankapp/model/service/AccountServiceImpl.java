package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptionhandler.AccountNotFoundEx;
import com.bankapp.exceptionhandler.NotSufficientFundEx;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
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
	public Optional<Account> findAccountById(Long id) {
		
		return accountRepo.findById(id);
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepo.findById(id);

	}

	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account updateAccount(Long id, Account account) {
		Account AccountToBeUpdated=accountRepo.findById(id).
				orElseThrow(AccountNotFoundEx::new);
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
		this.withdraw(fromAccount, amount);
		this.deposit(toAccount, amount);
	
	}

	@Override
	public void blockAccount(Long accNo) {
		// TODO Auto-generated method stub
		
	}

}
