package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exceptionhandler.TransactionLogNotFoundEx;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.TransactionLogService;

@RestController
@RequestMapping(path = "/api")
public class TransactionLogRestController {

	private TransactionLogService transactionLogService;

	@Autowired
	public TransactionLogRestController(TransactionLogService transactionLogService) {
		super();
		this.transactionLogService = transactionLogService;
	}

	@GetMapping(path = "/txlog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getAllTransactionLog() {
		return new ResponseEntity<List<TransactionLog>>(transactionLogService.getAllTransactionLog(), HttpStatus.OK);
	}

	@GetMapping(path = "/txlog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionLog> getAnCustomer(@PathVariable(name = "id") Long id) {
		TransactionLog transactionLog = transactionLogService.findTransactionLogById(id)
				.orElseThrow(TransactionLogNotFoundEx::new);
		return new ResponseEntity<TransactionLog>(transactionLog, HttpStatus.OK);
	}

	@DeleteMapping(path = "/txlog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTransactionLog(@PathVariable(name = "id") Long id) {
		transactionLogService.deleteTransactionLog(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
}
