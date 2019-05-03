/**
 * 
 */
package com.appzone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.appzone.model.User;
import com.appzone.service.UserService;
import com.appzone.util.ConstantValues;

/**
 * @author Hossam Youssef
 *
 */
@Configuration
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.getUserByUsername(username);
		if (user != null)
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					AuthorityUtils.createAuthorityList(ConstantValues.MODERATOR_USER, ConstantValues.NORMAL_USER));
		else
			throw new UsernameNotFoundException("Username not found");
	}

}
