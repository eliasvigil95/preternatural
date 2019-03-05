package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.User;

public interface UserRepository extends JpaRepository <User, Integer> {

	public User getUserByUsername(String username);
	public void deleteUserByUsername(String username);
	
}
