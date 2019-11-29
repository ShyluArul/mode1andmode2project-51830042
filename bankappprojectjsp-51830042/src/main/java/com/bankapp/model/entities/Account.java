package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account_table")
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private Long accountNumber;
	
	private double balance;
	private boolean block;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private Customer customer;

	private AccountType accountType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
	private List<AccountTransaction> accountTransactions = new ArrayList<AccountTransaction>();

	public void addTransaction(AccountTransaction accountTransaction) {
		accountTransactions.add(accountTransaction);
	}

	

	/**
	 * @return the id
	 */
	public synchronized Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public synchronized void setId(Long id) {
		this.id = id;
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



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setAccount(this);
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<AccountTransaction> getAccountTransactions() {
		return accountTransactions;
	}

	public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
		this.accountTransactions = accountTransactions;
	}

	

	public Account(Long accountNumber,double balance, boolean block, Customer customer, AccountType accountType) {
		super();
		this.accountNumber=accountNumber;
		this.balance = balance;
		this.block = block;
		this.customer = customer;
		this.accountType = accountType;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
