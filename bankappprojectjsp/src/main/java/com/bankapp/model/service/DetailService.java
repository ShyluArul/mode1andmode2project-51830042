package com.bankapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.User;



@Service
@Transactional
public class DetailService implements UserDetailsService {
	@Autowired
	private AppUserService userService;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userService.findByEmail(email);
		System.out.println(user);
		if(user==null)
			throw new UsernameNotFoundException("user is not found");
		else
			
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),AuthorityUtils
				.createAuthorityList(user.getRoles()));
	}
	

}





