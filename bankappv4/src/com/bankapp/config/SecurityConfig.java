package com.bankapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().withUser("anu").password("{noop}anu121").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("gunika").password("{noop}gunika121").roles("CLERK");
		auth.inMemoryAuthentication().withUser("sree").password("{noop}sree121").roles("MGR");
		auth.inMemoryAuthentication().withUser("alna").password("{noop}alna121").roles("CLERK");
		
	}
	
	@Override
	public void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/loginPage").access("permitAll")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/mgr/**").access("hasRole('ROLE_MGR') or hasRole('ROLE_ADMIN')")
		.antMatchers("/clerk/**").access("hasRole('ROLE_CLERK') or hasRole('ROLE_MGR') or hasRole('ROLE_ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/loginPage")
		.failureUrl("/loginPage?error").usernameParameter("name")
		.passwordParameter("password")
		.and()
		.logout()
		.logoutSuccessUrl("/loginPage?logout");
	}

}
