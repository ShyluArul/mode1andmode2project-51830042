package com.bankapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepo;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

private UserRepo userRepo;
@Autowired
	public AppUserServiceImpl(UserRepo userRepo) {
	super();
	this.userRepo = userRepo;
}

	@Override
	public void addAppUser(User user) {
	userRepo.save(user);
		
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
