package com.bankapp.model.dao;
import java.util.*;



public interface UserDao {
	public List<AppUser> getAllUsers();
	public void addUser(AppUser user);
	public AppUser getUserByEmail(String email);
	public AppUser updateUser(AppUser user);
	public AppUser getUserById(int id);
	public void deleteUser(int id);

}
