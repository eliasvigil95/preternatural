package com.preternatural.PreternaturalProject.controllers;

import java.util.List;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preternatural.PreternaturalProject.models.UserRole;
import com.preternatural.PreternaturalProject.models.User;
import com.preternatural.PreternaturalProject.services.UserRoleService;
import com.preternatural.PreternaturalProject.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private UserRoleService userRoleService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete")
	@Transactional
	public void deleteUserByUsername(@RequestBody String user) {
		JSONObject json = new JSONObject(user);
		userService.deleteUserByUsername(json.getString("username"));
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<User> createUser(@RequestBody String userString) {
		
		JSONObject json = new JSONObject(userString);
		User user = new User();
		
		if (json != null) {
			
			user.setEmail(json.getString("email"));
			user.setFirstname(json.getString("firstname"));
			user.setLastname(json.getString("lastname"));
			user.setPass(json.getString("password"));
			user.setRole(new UserRole(1, "User"));
			user.setUsername(json.getString("username"));
			
			userService.createUser(user);
		}
		
		
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
	@PutMapping(value = "/update")
	public void updateUser(@RequestBody String userString) {
		
		JSONObject json = new JSONObject(userString);
		User user = userService.getUserById(json.getInt("id"));
		
		if (json != null) {
			
			user.setEmail(json.getString("email"));
			user.setFirstname(json.getString("firstname"));
			user.setLastname(json.getString("lastname"));
			user.setUsername(json.getString("username"));
			user.setPass(json.getString("password"));
			
		}
		
		UserRole r = userRoleService.getUserRoleByTitle(json.getString("role"));
		user.setRole(r);
		
		userService.updateUser(user);
		
	}
}
