package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exceptionhandler.AccountTransactionNotFoundException;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.service.AccountTransactionService;

@RestController
@RequestMapping(path="/api")
public class AccountTransactionRestController {

	private AccountTransactionService accountTransactionService;
	@Autowired
	public AccountTransactionRestController(AccountTransactionService accountTransactionService) {
		super();
		this.accountTransactionService = accountTransactionService;
	}



	@GetMapping(path="/acctx", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransaction>>getAllAccountTransaction(){
		return new  ResponseEntity<List<AccountTransaction>>
		(accountTransactionService.getAllTransactions(),HttpStatus.OK);
	}
	
	

	@GetMapping(path="/acctx/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountTransaction>getAnAccountTransaction
	(@PathVariable(name="id")Long id){
		AccountTransaction accountTransaction=accountTransactionService.findTransactionById(id)
				.orElseThrow(AccountTransactionNotFoundException::new);
		return new ResponseEntity<AccountTransaction>(accountTransaction,HttpStatus.OK);
	
	}
	/*@DeleteMapping(path="/acctx/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteAnAccountTransaction(@PathVariable(name="id")Long id){
		accountTransactionService.deleteTransactions(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/
}
