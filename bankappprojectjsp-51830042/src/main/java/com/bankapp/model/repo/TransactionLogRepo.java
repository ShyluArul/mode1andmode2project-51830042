package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.TransactionLog;

@Repository
public interface TransactionLogRepo extends JpaRepository<TransactionLog, Long> {
	
	@Query("select t from TransactionLog t ")
	List<TransactionLog> findAllTransactionLog();
}
