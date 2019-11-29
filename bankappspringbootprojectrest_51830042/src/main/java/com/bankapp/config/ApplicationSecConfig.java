package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@EnableWebSecurity
public class ApplicationSecConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService detailService;

	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.userDetailsService(detailService);
	}
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
/*
	@Autowired
	private BasicAuthenticationEntryPoint authEntryPoint;
*/
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/mgr/**").hasAnyRole("MGR", "ADMIN")
				.antMatchers("/clerk/**").hasAnyRole("MGR", "ADMIN", "CLERK")
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);

	
}*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/user/**").hasAnyAuthority("ROLE_ADMIN")
				.antMatchers("/api/account/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MGR")
				//.antMatchers("/account/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MGR")
				.antMatchers("/api/customer/**").hasAnyAuthority
				("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")
				
				.antMatchers("/api/acctx/**").hasAnyAuthority
				("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")
				
				.antMatchers("/api/txlog/**").hasAnyAuthority
				("ROLE_ADMIN")
				.antMatchers("/home/**").permitAll()
				.and().httpBasic().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
}