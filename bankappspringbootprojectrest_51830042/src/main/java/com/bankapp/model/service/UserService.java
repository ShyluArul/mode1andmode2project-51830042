package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.User;

public interface UserService {
	public List<User>getAllUsers();
	public Optional<User>findUserById(Long id);
	public void deleteUser(Long id);
	public User addUser(User user);
	public User updateUser(Long id,User user);

}
