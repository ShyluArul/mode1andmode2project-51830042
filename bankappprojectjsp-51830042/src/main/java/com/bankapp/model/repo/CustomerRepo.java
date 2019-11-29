package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	public List<Customer> findAll();
	public Customer findByName(String name);
	public Customer findByEmail(String email);
	

}
