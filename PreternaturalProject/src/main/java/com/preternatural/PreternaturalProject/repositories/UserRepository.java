package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.User;

/*
 * UserRepository contains CRUD methods that will be used in the UserService. 
 * These methods are associated with the USERS table.
 */
public interface UserRepository extends JpaRepository <User, Integer> {

	public User getUserByUsername(String username);
	public void deleteUserByUsername(String username);
	
}
