package com.bankapp.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.*;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void addUser(AppUser user) {
		getSession().save(user);
	}

	@Override
	public AppUser getUserByEmail(String email) {

		return (AppUser) getSession()
				.createQuery("select u from AppUser u where u.email=:email and valid=true")
				.setParameter("email", email).uniqueResult();

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<AppUser> getAllUsers() {
		return getSession().createQuery("from AppUser").list();
	}
	@Override
	public AppUser updateUser(AppUser user) {
		// TODO Auto-generated method stub
	
		getSession().update(user);
		return user;
		
	}

	@Override
	public AppUser getUserById(int id) {
		return getSession().get(AppUser.class, id);
	
	}

	@Override
	public void deleteUser(int id) {
		AppUser usertoBeDeleted = getSession().get(AppUser.class,id);
		getSession().delete(usertoBeDeleted);
		
	}
}











