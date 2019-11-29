package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.AppUser;
import com.bankapp.model.dao.UserDao;
@Service
@Transactional
public  class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(AppUser user) {
		userDao.addUser(user);
	}

	@Override
	public AppUser getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<AppUser> getAllUsers() {
		return userDao.getAllUsers();
	}
	@Override
	public AppUser updateUser(AppUser user){
		return userDao.updateUser(user);
	}

	@Override
	public AppUser getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}


}
