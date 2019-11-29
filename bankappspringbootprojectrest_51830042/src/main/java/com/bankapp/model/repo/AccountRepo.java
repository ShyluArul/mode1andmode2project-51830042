package com.bankapp.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	public Optional<Account>findById(Long id);

}
