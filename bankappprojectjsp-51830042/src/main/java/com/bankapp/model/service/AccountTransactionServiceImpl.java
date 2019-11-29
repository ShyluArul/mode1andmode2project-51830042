package com.bankapp.model.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.exceptionhandler.AccountTransactionNotFoundException;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.repo.AccountTransactionRepo;

@Service
@Transactional
public class AccountTransactionServiceImpl implements AccountTransactionService{
	
	private AccountTransactionRepo accountTransactionRepo;
@Autowired
	public AccountTransactionServiceImpl(AccountTransactionRepo accountTransactionRepo) {
		this.accountTransactionRepo = accountTransactionRepo;
	}
@Override
public List<AccountTransaction> getAllTransactions() {

	return accountTransactionRepo.findAll();
}
@Override
public Optional<AccountTransaction> findTransactionsById(Long id) {
	return accountTransactionRepo.findById(id);
}
@Override
public void deleteTransactions(Long id) {
	accountTransactionRepo.deleteById(id);
	
}
/*@Override
public AccountTransaction addTransactions(AccountTransaction accountTransaction) {
return accountTransactionRepo.save(accountTransaction);
}
@Override
public AccountTransaction updateTransactions(Long id, AccountTransaction accountTransaction) {
	AccountTransaction accountTransactionToBeUpdated=accountTransactionRepo.findById(id)
			.orElseThrow(AccountTransactionNotFoundException::new);
	accountTransactionToBeUpdated.setAmount(accountTransaction.getAmount());
	return accountTransactionRepo.save(accountTransactionToBeUpdated);
	
}
*/
	

}
