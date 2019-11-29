package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptionhandler.CustomerNotFoundEx;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
private CustomerRepo customerRepo;
@Autowired
public CustomerServiceImpl(CustomerRepo customerRepo) {
	
	this.customerRepo = customerRepo;
}

@Override
public List<Customer> getAllCustomers() {
	
	return customerRepo.findAll();
}

@Override
public Optional<Customer> findCustomerById(Long id) {
	return customerRepo.findById(id);
}

@Override
public void deleteCustomer(Long id) {
	customerRepo.deleteById(id);
	
}

@Override
public Customer addCustomer(Customer customer) {
	return customerRepo.save(customer);
}

@Override
public Customer updateCustomer(Long id, Customer customer) {
	Customer CustomerToBeUpdated=customerRepo.findById(id).orElseThrow(CustomerNotFoundEx::new);
	CustomerToBeUpdated.setPhone(customer.getPhone());
	return customerRepo.save(CustomerToBeUpdated);
}




}
