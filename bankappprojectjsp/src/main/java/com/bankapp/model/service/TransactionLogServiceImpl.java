package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.TransactionLogRepo;

@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService {

private TransactionLogRepo transactionLogRepo;
@Autowired
	public TransactionLogServiceImpl(TransactionLogRepo transactionLogRepo) {
	super();
	this.transactionLogRepo = transactionLogRepo;
}

	

	@Override
	public Optional<TransactionLog> findTransactionLogById(Long id) {
		return transactionLogRepo.findById(id);
	}

	@Override
	public void deleteTransactionLog(Long id) {
		transactionLogRepo.deleteById(id);// TODO Auto-generated method stub
		
	}



	@Override
	public List<TransactionLog> findAllTransactionLog() {
		return transactionLogRepo.findAllTransactionLog();
	}

	/*@Override
	public TransactionLog addTransactionLog(TransactionLog transactionLog) {
		return transactionLogRepo.save(transactionLog);
	}

	@Override
	public TransactionLog updateTransactionLog(Long id, TransactionLog transactionLog) {
		TransactionLog transactionLogToBeUpdated=transactionLogRepo.findById(id)
				.orElseThrow(TransactionLogNotFoundEx::new);
		transactionLogToBeUpdated.setTxType(transactionLog.getTxType());
		return transactionLogRepo.save(transactionLogToBeUpdated);
	}
*/
}
