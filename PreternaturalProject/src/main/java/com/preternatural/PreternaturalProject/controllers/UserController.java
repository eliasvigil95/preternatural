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
	
	/*
	 * This method calls the getAllUsers method from userService to get all 
	 * Users from the database whenever a GET request is made to this endpoint. 
	 * If it is successful, it will return a list of all Users in the database 
	 * along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/users/all
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a username (String) [gets from URL] and passes 
	 * it to another function which checks the database for a User with that 
	 * username whenever a GET request is made to this endpoint. If it's 
	 * successful, it will return that User along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/users/Username
	 */
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a username (String) [gets from URL] and passes 
	 * it to another function which checks the database for a User with that 
	 * username whenever a POST request is made to this endpoint. If it's 
	 * successful, it will delete that User.
	 * 
	 * ENDPOINT: localhost:8085/users/delete
	 */
	@PostMapping(value = "/delete")
	@Transactional
	public void deleteUserByUsername(@RequestBody String user) {
		JSONObject json = new JSONObject(user);
		userService.deleteUserByUsername(json.getString("username"));
	}
	
	/*
	 * This method takes in a String (in JSON format) from the Request Body, creates 
	 * a JSON Object using that String and then uses the information from the JSON
	 * Object to create a new User whenever a POST request is made to this 
	 * endpoint. If it's successful, it returns a status code of 200.
	 */
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
	
	/*
	 * This method takes in a String (in JSON format) from the RequestBody, creates 
	 * a JSON Object using that String and then uses the information from the JSON
	 * Object to select a User and update their details whenever a PUT request is 
	 * made to this endpoint. 
	 * 
	 * ENDPOINT: localhost:8085/users/update
	 */
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
