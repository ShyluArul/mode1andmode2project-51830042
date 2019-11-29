package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptionhandler.UserNotFoundEx;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private UserRepo userRepo;

	@Autowired
	public UserServiceImpl(com.bankapp.model.repo.UserRepo userRepo) {
		
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
	return userRepo.findById(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);

	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User userToBeUpdated =userRepo.findById(id).orElseThrow(UserNotFoundEx::new);
		userToBeUpdated.setName(user.getName());
		return userRepo.save(userToBeUpdated);
}

}
