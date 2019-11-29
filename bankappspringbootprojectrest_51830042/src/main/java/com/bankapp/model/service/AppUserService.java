package com.bankapp.model.service;

import com.bankapp.model.entities.User;

public interface AppUserService {
	public void addAppUser(User user);
	public User findByEmail(String email);
	

}
