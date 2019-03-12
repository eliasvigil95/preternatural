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

import com.preternatural.PreternaturalProject.models.Weapon;
import com.preternatural.PreternaturalProject.services.WeaponService;

@RestController
@CrossOrigin
@RequestMapping("/weapons")
public class WeaponController {

	private WeaponService weaponService;
	
	@Autowired
	public void setWeaponService(WeaponService weaponService) {
		this.weaponService = weaponService;
	}
	
	/*
	 * This method calls the getAllWeapons method from weaponService to get all weapons
	 * from the database. If it's successful, it returns all Weapons from the database 
	 * along with a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/weapons/all
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Weapon>> getAllWeapons() {
		return new ResponseEntity<>(weaponService.getAllWeapons(), HttpStatus.OK);
	}
	
	/*
	 * This method takes in an int (obtained from the URL path) and passes it to another 
	 * function which searches the database for a Weapon with an ID that matches that int
	 * whenever a GET request is made to this endpoint. If it's successful, it returns the
	 * Weapon along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/weapons/getById/Weapon ID
	 */
	@GetMapping("/getById/{requestId}")
	public ResponseEntity<Weapon> getWeaponById(@PathVariable int requestId) {
		return new ResponseEntity<>(weaponService.getWeaponById(requestId),HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to another 
	 * function which searches the database for a Weapon that matches that String 
	 * whenever a GET request is made to this endpoint. If it's successful, it returns the
	 * Weapon along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/weapons/getByName/Weapon Name
	 */
	@GetMapping("/getByName/{requestName}")
	public ResponseEntity<Weapon> getWeaponByName(@PathVariable String requestName) {
		return new ResponseEntity<>(weaponService.getWeaponByName(requestName), HttpStatus.OK);
	}
	

	/*
	 * This method takes in a String (obtained from the URL path) and passes it to another 
	 * function which searches the database for a Weapon to delete that matches that String 
	 * whenever a POST request is made to this endpoint. If it's successful, the weapon is 
	 * deleted from the database. 
	 * 
	 * ENDPOINT: localhost:8085/weapons/deleteByName/Name Of The Weapon
	 */
	@PostMapping(value = "/delete")
	@Transactional 
	// "No EntityManager with actual transaction available for current thread - 
	// cannot reliably process 'persist' call" will happen if @Transactional is not here. 
	public void deleteWeaponByName(@RequestBody String requestName) {
		JSONObject json = new JSONObject(requestName);
		weaponService.deleteWeaponByName(json.getString("Name"));
	}
	
	/*
	 * This method takes in a String (in JSON format) from the Request Body, creates a 
	 * JSON Object using that String and then uses the information from the JSON Object
	 * to create a new Weapon whenever a POST request is made to this endpoint. If it's 
	 * successful, it returns a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/weapons/create
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<Weapon> createWeapon(@RequestBody String weaponString) {
		
		// takes in weaponString from the Request Body and creates a JSON Object
		// called json
		JSONObject json = new JSONObject(weaponString);
		
		// creates a new instance of the Weapon class
		Weapon w = new Weapon();
		
		if (json != null) {
			
			// gets the value of "weapon_name" key from json and 
			// sets it to be the new Weapon's name. 
			w.setName(json.getString("Name"));
			
			// gets the value of  "description" key from json and 
			// sets it to be the new Weapon's description. 
			w.setDescription(json.getString("Description"));
			
			// calls the createWeapon method from weaponService, 
			// passes in Weapon w and then creates a new Weapon
			// in the database
			weaponService.createWeapon(w);
		}
		
		// returns a status code of 200.
		return new ResponseEntity<Weapon>(HttpStatus.OK);
		
	}
	
	/*
	 * This method takes in a String (in JSON format) from the Request Body, 
	 * creates a JSON Object using that String and then uses the information 
	 * from the JSON Object to select a Weapon and update its details whenever
	 * a PUT request is made to this endpoint. 
	 * 
	 * ENDPOINT: localhost:8085/weapons/update
	 */
	@PutMapping(value = "/update")
	public void updateWeapon(@RequestBody String weaponString) {
		
		// takes in weaponString from the Request Body and creates a JSON 
		// Object called json
		JSONObject json = new JSONObject(weaponString);
		
		// gets the value of "weapon_id" key from json and uses it to search for
		// a weapon with that id and set it equal to Weapon w. 
		Weapon w = weaponService.getWeaponById(json.getInt("ID"));
		
		if (json != null) {
			
			// gets the value of "weapon_name" key from json 
			// and sets it to be the name of Weapon w . 
			w.setName(json.getString("Name"));
			
			// gets the value of "weapon_description" from json 
			// and sets it to be Weapon w's description . 
			w.setDescription(json.getString("Description"));
			
			// calls the updateWeapon method from weaponService, passes in 
			// Weapon w and updates the weapon in the database. 
			weaponService.updateWeapon(w);
		} 
	}
}
