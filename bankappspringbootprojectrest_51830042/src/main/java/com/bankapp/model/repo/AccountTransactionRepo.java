package com.bankapp.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.AccountTransaction;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {

	//public Optional<AccountTransaction> findByAccountaccNo(Long accNo);

 	
	//List<AccountTransaction> findAll();

public Optional<AccountTransaction>findById(Long id);
}
