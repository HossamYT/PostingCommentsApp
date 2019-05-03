/**
 * 
 */
package com.appzone.service;

import com.appzone.model.User;

/**
 * @author Hossam Youssef
 *
 */
public interface UserService {

	public User getUserById(int id);
	
	public User getUserByUsername(String username);

	public User getUserByUsernameAndPassword(String username, String password);
	
	public User createUser (User user);
}
