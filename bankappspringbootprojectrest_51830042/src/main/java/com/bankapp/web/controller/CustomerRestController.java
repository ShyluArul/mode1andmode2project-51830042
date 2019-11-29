package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.bankapp.exceptionhandler.CustomerNotFoundEx;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.CustomerService;

@RestController
@RequestMapping(path="/api")
public class CustomerRestController {
	

	private CustomerService customerService;
	@Autowired
	public CustomerRestController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	

	@GetMapping(path="/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>>getAllCustomer(){
		return new  ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	

	@GetMapping(path="/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer>getAnCustomer(@PathVariable(name="id")Long id){
		Customer customer=customerService.findCustomerById(id).orElseThrow(CustomerNotFoundEx::new);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	
	}
	
	@DeleteMapping(path="/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteACustomer(@PathVariable(name="id")Long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path="customer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer>updateAnCustomer(@PathVariable(name="id")Long id,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
		@PostMapping(path="customer")
		public ResponseEntity<Customer>addAnCustomer(@Valid @RequestBody Customer customer){
			return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
		}
	
}
