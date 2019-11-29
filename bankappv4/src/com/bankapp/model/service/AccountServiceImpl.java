package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	
	@Override
	public void transferFund(int fromAccount, int toAccount, double amount) {
		accountDao.withdraw(fromAccount, amount);
		accountDao.deposit(toAccount, amount);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public Account saveAccount(Account account) {
		return accountDao.saveAccount(account);
	}

	@Override
	public Account getAccount(int id) {
		return accountDao.getAccount(id);
	}

	@Override
	public void deposit(int accountId, double amount) {
		accountDao.deposit(accountId, amount);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		accountDao.withdraw(accountId, amount);
	}
	
	@Override
	public void blockAccount(int accountId) {
		accountDao.blockAccount(accountId);
	}

	@Override
	public void deleteAccount(int accountId) {
		accountDao.deleteAccount(accountId);
	}

	@Override
	public void unBlockAccount(int accountId) {
		accountDao.unBlockAccount(accountId);
	}

	

	@Override
	public Account updateAccount(Account account) {
		
		return accountDao.updateAccount(account);
	}

}
