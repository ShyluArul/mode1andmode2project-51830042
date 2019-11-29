package com.bankapp.model.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;

import com.bankapp.model.service.UserService;

//@Component
public class DataInit implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(DataInit.class);
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountTransactionService accountTransactionService;

	@Autowired

	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		/*Address address1 = new Address("sree nivas","palakkad","2345","kerala","india");
		Address address2 = new Address("anu nivas","palakkad","2345","kerala","india");
		Address address3 = new Address("alna nivas","trissur","2345","kerala","india");
		
		Customer customer1 = new Customer("sreena", "sreena123", "sreena@123", "56465453",address1);
		Customer customer2 = new Customer("anu", "anu123", "anu@123", "67576576",address3);
		Customer customer3 = new Customer("alna", "alna123", "alna@123", "09898789786",address2);
		customer1.setAddress(address1);
		customer2.setAddress(address3);
		customer3.setAddress(address2);
		Account account1 = new Account(12345L,1000, false, customer1, AccountType.CURRENT);
		Account account2 = new Account(12346L,2000, false, customer2, AccountType.CURRENT);
		Account account3 = new Account(123457L,3000, false, customer3, AccountType.SAVING);

		customer1.setAccount(account1);
		customer2.setAccount(account2);

		customer3.setAccount(account3);
		accountService.addAccount(account1);
		accountService.addAccount(account2);
		accountService.addAccount(account3);*/

		userService.addUser(new User("shylu", "shy123", "shy@gmail.com", "348786876", "Bangalore",
				new String[] { "ROLE_ADMIN" }, true));
		userService.addUser(new User("shalu", "sha123", "sha@gmail.com", "348786876", "chennai",
				new String[] { "ROLE_MGR" }, true));
		userService.addUser(new User("shashy", "shashy123", "shashy@gmail.com", "348786876", "nagercoil",
				new String[] { "ROLE_CLERK" }, true));

	}
}
