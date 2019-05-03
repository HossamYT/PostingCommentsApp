/**
 * 
 */
package com.appzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appzone.model.User;
import com.appzone.repository.UserRepository;

/**
 * @author Hossam Youssef
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		User user = userRepository.findOne(id);
		if (user != null)
			return user;
		else
			return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user != null)
			return user;
		else
			return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user != null)
			return user;
		else
			return null;
	}

}
