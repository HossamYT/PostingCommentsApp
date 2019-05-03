/**
 * 
 */
package com.appzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appzone.model.User;
import com.appzone.service.UserService;
import com.appzone.util.CredentialsOfUser;

/**
 * @author Hossam Youssef
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public User findUserById(Integer id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public void LoginUserGet(){
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User LoginUser(@RequestBody CredentialsOfUser userCredentials) {
		User user = userService.getUserByUsernameAndPassword(userCredentials.getUsername(), userCredentials.getPassword());
		if (user != null)
			return user;
		else
			return null;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		if (createdUser != null)
			return createdUser;
		else
			return null;
	}
}