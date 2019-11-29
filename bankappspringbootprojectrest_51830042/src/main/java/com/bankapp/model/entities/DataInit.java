package com.bankapp.model.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.UserService;

//@Component
public class DataInit implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(DataInit.class);
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountTransactionService accountTransactionService;

	@Autowired

	private UserService userService;

	@Override
	public void run(String... args) throws Exception {

		Address address1 = new Address("123", "nagercoil", "62921", "tamilnadu", "India");
		Address address2 = new Address("456", "bangalore", "54457", "karnataka", "India");
		Address address3 = new Address("789", "thirussur", "56465", "kerala", "India");

		Customer customer1 = new Customer("sreena", "sreena123", "sreena@123", "56465453", address1);
		Customer customer2 = new Customer("anu", "anu123", "anu@123", "67576576", address2);
		Customer customer3 = new Customer("alna", "alna123", "alna@123", "09898789786", address3);

		address1.setCustomer(customer1);
		address2.setCustomer(customer2);
		address3.setCustomer(customer3);

		/*
		 * customerService.addCustomer(customer1);
		 * customerService.addCustomer(customer2);
		 * customerService.addCustomer(customer3);
		 * 
		 */
		Account account1 = new Account(1000, false, customer1, AccountType.CURRENT);
		Account account2 = new Account(2000, false, customer2, AccountType.CURRENT);
		Account account3 = new Account(3000, false, customer3, AccountType.SAVING);

		customer1.setAccount(account1);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		/*
		 * account1.setCustomer(customer1); account2.setCustomer(customer2);
		 * account3.setCustomer(customer3);
		 */
		accountService.addAccount(account1);
		accountService.addAccount(account2);
		accountService.addAccount(account3);

		userService.addUser(new User("shylu", "shy123", "shy@gmail.com", "348786876", "Bangalore",
				new String[] { "ROLE_ADMIN" }, true));
		userService.addUser(new User("shalu", "sha123", "sha@gmail.com", "348786876", "chennai",
				new String[] { "ROLE_MGR" }, true));
		userService.addUser(new User("shashy", "shashy123", "shashy@gmail.com", "348786876", "nagercoil",
				new String[] { "ROLE_CLERK" }, true));

	}
}
