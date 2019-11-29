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
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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

	public class StandaloneMvcTestViewResolver extends InternalResourceViewResolver {

	    public StandaloneMvcTestViewResolver() {
	        super();
	    }

	    @Override
	    protected AbstractUrlBasedView buildView(final String viewName) throws Exception {
	        final InternalResourceView view = (InternalResourceView) super.buildView(viewName);
	        // prevent checking for circular view paths
	        view.setPreventDispatchLoop(false);
	        return view;
	    }
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/mgr/**").access("hasRole('ROLE_MGR') or hasRole('ROLE_ADMIN')")
		.antMatchers("/clerk/**").access("hasRole('ROLE_CLERK') or hasRole('ROLE_MGR') or hasRole('ROLE_ADMIN')")
		.antMatchers("/loginPage").access("permitAll")
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
