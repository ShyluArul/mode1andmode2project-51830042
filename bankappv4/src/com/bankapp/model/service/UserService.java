package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.AppUser;

public interface UserService {
	public void addUser(AppUser user);
	public AppUser getUserByEmail(String email);
	public List<AppUser> getAllUsers();
	AppUser updateUser(AppUser user);
	public AppUser getUserById(int id);
	public void deleteUser(int id);
}
