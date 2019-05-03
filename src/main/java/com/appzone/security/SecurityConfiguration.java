/**
 * 
 */
package com.appzone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.appzone.util.ConstantValues;

/**
 * @author Hossam Youssef
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(customUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/user/loginUser").permitAll()
		.antMatchers("/comment/pendingComments", "/comment/approvedComments","/comment/allComments","/user/id").access("hasRole(" + ConstantValues.MODERATOR_USER + ")")
		.anyRequest().permitAll().and()
		.formLogin();
		 
		http.csrf().disable();
	}

}
