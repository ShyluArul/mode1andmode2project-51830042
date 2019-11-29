package com.bankapp.model.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
	 return 	sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").list();
	}

	@Override
	public Account saveAccount(Account account) {
		 getSession().save(account);
		 return account;
	}

	@Override
	public Account getAccount(int id) {
		Account account=getSession().get(Account.class, id);
		return account;
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account=getAccount(accountId);
		if(account==null)
		{
			throw new AccountNotFoundException("Account with id"+accountId+"is not found");
		}
		else{
				
		account.setBalance(account.getBalance()+amount);
		getSession().update(account);
	}
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account=getAccount(accountId);
		if(account==null){
			throw new AccountNotFoundException("Account with id"+accountId+"is not found");
		}
		if(account.getBalance()<amount)
			throw new NotSufficientFundException();
		
		account.setBalance(account.getBalance()-amount);
		getSession().update(account);
	}

	@Override
	public void blockAccount(int accountId) {
		/*Query<Account>  query =getSession().
				createQuery("update Account set block=true where id=:accountId",Account.class);
		query.set
		*/
	}

	@Override
	public void deleteAccount(int accountId) {
		Account accountToBeDeleted=getAccount(accountId);
		if(accountToBeDeleted==null){
			throw new AccountNotFoundException("account with id"+accountId+" is not found");
		}
		getSession().delete(accountToBeDeleted);
		
	}

	@Override
	public void unBlockAccount(int accountId) {
		
	}

	

	@Override
	public Account updateAccount( Account account) {
		
		getSession().update(account);
		return account;
	}

}
