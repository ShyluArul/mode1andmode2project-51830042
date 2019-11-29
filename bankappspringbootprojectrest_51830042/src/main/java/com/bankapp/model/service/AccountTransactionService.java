package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.AccountTransaction;

public interface AccountTransactionService {
	public List<AccountTransaction> getAllTransactions();
	 
	//public void deleteTransactions(Long id);
	/*public AccountTransaction addTransactions(AccountTransaction accountTransaction);
	public AccountTransaction updateTransactions(Long id,AccountTransaction accountTransaction);
*/
	public Optional<AccountTransaction> findTransactionById(Long id);
}
