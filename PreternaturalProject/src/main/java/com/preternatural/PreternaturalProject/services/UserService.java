package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.User;
import com.preternatural.PreternaturalProject.repositories.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	public User getUserById(int id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public int updateUser(User user) {
		User u = userRepository.save(user);
		if (u != null) {
			return u.getId();
		} else {
			return 0;
		}
	}
}
