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
	 * from the database. If successful, it returns a status code of 200. 
	 * 
	 * Endpoint: localhost:8085/weapons/all
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Weapon>> getAllWeapons() {
		return new ResponseEntity<>(weaponService.getAllWeapons(), HttpStatus.OK);
	}
	
	/*
	 * This method calls the getWeaponById method from weaponService and passes in the id
	 * that was sent in the URL. If successful, it will return the weapon with that same id 
	 * and a status code of 200.
	 * 
	 * Example endpoint: localhost:8085/weapons/getById/11
	 */
	@GetMapping("/getById/{requestId}")
	public ResponseEntity<Weapon> getWeaponById(@PathVariable int requestId) {
		return new ResponseEntity<>(weaponService.getWeaponById(requestId),HttpStatus.OK);
	}
	
	/*
	 * This method calls the getWeaponByName method from weaponService and passes in the name 
	 * of the weapon that was sent in the URL. If a weapon with that name is in the database, 
	 * it will return that weapon and a status code of 200.
	 * 
	 * Example endpoint: localhost:8085/weapons/getByName/Object Safeguard
	 */
	@GetMapping("/getByName/{requestName}")
	public ResponseEntity<Weapon> getWeaponByName(@PathVariable String requestName) {
		return new ResponseEntity<>(weaponService.getWeaponByName(requestName), HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteByName/{requestName}")
	@Transactional
	public void deleteWeaponByName(@PathVariable String requestName) {
		weaponService.deleteWeaponByName(requestName);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Weapon> createWeapon(@RequestBody String weaponString) {
		
		JSONObject json = new JSONObject(weaponString);
		Weapon w = new Weapon();
		
		if (json != null) {
			
			w.setName(json.getString("weapon_name"));
			w.setDescription(json.getString("description"));
			
			weaponService.createWeapon(w);
		}
		
		return new ResponseEntity<Weapon>(HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/update")
	public void updateWeapon(@RequestBody String weaponString) {
		
		JSONObject json = new JSONObject(weaponString);
		Weapon w = weaponService.getWeaponById(json.getInt("weapon_id"));
		
		if (json != null) {
			
			w.setName(json.getString("weapon_name"));
			w.setDescription(json.getString("weapon_description"));
			
			weaponService.updateWeapon(w);
		} 
	}
}
