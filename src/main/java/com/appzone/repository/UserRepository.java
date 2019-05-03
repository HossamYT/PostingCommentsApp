/**
 * 
 */
package com.appzone.repository;

import org.springframework.data.repository.CrudRepository;

import com.appzone.model.User;

/**
 * @author Hossam Youssef
 *
 */
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);

}
