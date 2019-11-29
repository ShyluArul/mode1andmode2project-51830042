package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.TransactionLog;

public interface TransactionLogService {
	
	List<TransactionLog> findAllTransactionLog();
	public Optional<TransactionLog>findTransactionLogById(Long id);
	public void deleteTransactionLog(Long id);
	/*public TransactionLog addTransactionLog(TransactionLog transactionLog);
	public TransactionLog updateTransactionLog(Long id,TransactionLog transactionLog);
*/
}
