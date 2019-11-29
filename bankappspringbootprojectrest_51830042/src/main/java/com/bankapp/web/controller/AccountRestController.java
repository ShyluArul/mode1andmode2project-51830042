package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exceptionhandler.AccountNotFoundEx;
import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path="/api")
public class AccountRestController {
	private AccountService accountService;
@Autowired
	public AccountRestController(AccountService accountService) {
		
		this.accountService = accountService;
	}
	@GetMapping(path="/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>>getAllAccount(){
		return new  ResponseEntity<List<Account>>(accountService.getAllAccounts(),HttpStatus.OK);
	}
	@GetMapping(path="/account/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>getAnAccount(@PathVariable(name="id")Long id){
		Account account=accountService.findAccountById(id).orElseThrow(AccountNotFoundEx::new);
		return new ResponseEntity<Account>(account,HttpStatus.OK);
		}
	@DeleteMapping(path="/account/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteAnAccount(@PathVariable(name="id")Long id){
		accountService.deleteAccount(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path="account/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>updateAnAccount(@PathVariable(name="id")Long id,@RequestBody Account account){
		return new ResponseEntity<Account>(accountService.updateAccount(id, account),HttpStatus.OK);
	}
		@PostMapping(path="account",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Account>addAnAccount(/*@Valid*/ @RequestBody Account account){
		
			/*Address address=new Address(request().g)
			*/
			return new ResponseEntity<Account>(accountService.addAccount(account),HttpStatus.CREATED);
		}
		@PutMapping(path="account/deposit/{id}/{amount}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void>depositamount(@PathVariable(name="id")Long id,
				@PathVariable(name="amount")double amount){
		 accountService.deposit(id, amount);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 }
		@PutMapping(path="account/withdraw/{id}/{amount}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void>withdrawamount(@PathVariable(name="id")Long id,
				@PathVariable(name="amount")double amount){
		 accountService.withdraw(id, amount);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 
		}
		@PutMapping(path="account/transfer/{fromAccount}/{toAccount}/{amount}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void>transferamount(@PathVariable(name="fromAccount")Long fromAccount,@PathVariable(name="toAccount")Long toAccount,
				@PathVariable(name="amount")double amount,@RequestBody Account account){
		 accountService.transfer(fromAccount, toAccount, amount);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		}}
