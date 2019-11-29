package com.bankapp.model.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
