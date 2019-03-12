package com.preternatural.PreternaturalProject.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preternatural.PreternaturalProject.models.CharacterRole;
import com.preternatural.PreternaturalProject.models.CharacterRole2;
import com.preternatural.PreternaturalProject.models.Character;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.services.CharacterRoleService;
import com.preternatural.PreternaturalProject.services.CharacterService;
import com.preternatural.PreternaturalProject.services.SpeciesService;
import com.preternatural.PreternaturalProject.services.StageService;;

@RestController
@CrossOrigin
@RequestMapping("/characters")
public class CharacterController {

	private CharacterService characterService;
	private CharacterRoleService characterRoleService;
	private SpeciesService speciesService;
	private StageService stageService;
	
	@Autowired
	public void setCharacterService(CharacterService characterService) {
		this.characterService = characterService;
	}
	
	@Autowired
	public void setCharacterRoleService (CharacterRoleService characterRoleService) {
		this.characterRoleService = characterRoleService;
	}
	
	@Autowired
	public void setSpeciesService (SpeciesService speciesService) {
		this.speciesService = speciesService;
	}
	
	@Autowired
	public void setStageService (StageService stageService) {
		this.stageService = stageService;
	}
	
	/*
	 * This method calls the getAllCharacters method from characterService to get all
	 * Characters from the database whenever a GET request is made to this endpoint. 
	 * If it's successful, it returns a list of all Characters in the database along
	 * with a status code of 200. 
	 * 
	 *  ENDPOINT: localhost:8085/characters/all
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Character>> getAllCharacters() {
		return new ResponseEntity<> (characterService.getAllCharacters(), HttpStatus.OK);
	}
	
	/*
	 * This method takes in an int (obtained from the URL path) and passes it to 
	 * another function which searches the database for a Character with an ID that 
	 * matches that int whenever a GET request is made to this endpoint. If it's 
	 * successful, it returns the Character along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/characters/character/Character ID
	 */
	@GetMapping(value = "/character/{requestId}")
	public ResponseEntity<Character> getCharacterById(@PathVariable int requestId) {
		return new ResponseEntity<>(characterService.getCharacterById(requestId), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to 
	 * another function which searches the database for Characters with a first name 
	 * that matches that String whenever a GET request is made to this endpoint. If
	 * it's successful, it returns all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getByFirstname/First Name
	 */
	@GetMapping(value = "/getByFirstname/{requestFirst}")
	public ResponseEntity<List<Character>> getCharactersByFirstname(@PathVariable String requestFirst) {
		return new ResponseEntity<>(characterService.getCharactersByFirstname(requestFirst), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to 
	 * another function which searches the database for Characters with a last name 
	 * that matches that String whenever a GET request is made to this endpoint. If
	 * it's successful, it returns all relevant Characters and a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/characters/getByLastname/Last Name
	 */
	@GetMapping(value = "/getByLastname/{requestLast}")
	public ResponseEntity<List<Character>> getCharactersByLastname(@PathVariable String requestLast) {
		return new ResponseEntity<>(characterService.getCharactersByLastname(requestLast), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path), searches the database 
	 * for a matching CharacterRole and then searches the database for all Characters 
	 * with that CharacterRole when a GET request is made to this endpoint. If it's  
	 * successful, it return all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getByRole/Role
	 */
	@GetMapping(value = "/getByRole/{requestRole}")
	public ResponseEntity<List<Character>> getCharactersByRole(@PathVariable String requestRole) {
		CharacterRole role = characterRoleService.getCharacterRoleByTitle(requestRole);
		return new ResponseEntity<>(characterService.getCharactersByRole(role), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path), searches the database 
	 * for a matching CharacterRole2 and then searches the database for all Characters 
	 * with that CharacterRole2 when a GET request is made to this endpoint. If it's  
	 * successful, it return all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getByRole2/Role2
	 */
	@GetMapping(value = "/getByRole2/{requestRole2}")
	public ResponseEntity<List<Character>> getCharactersByRole2(@PathVariable String requestRole2) {
		CharacterRole2 role2 = characterRoleService.getCharacterRole2ByTitle(requestRole2);
		return new ResponseEntity<>(characterService.getCharactersByRole2(role2), HttpStatus.OK);
	}
	
	/*
	 * This method takes in an int (obtained from the URL path) and passes it to another
	 * function which searches the database for Characters that have an age matching 
	 * that int when a GET request is made to this endpoint. If it's successful, it
	 * returns all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getByAge/Age
	 */
	@GetMapping(value = "/getByAge/{age}")
	public ResponseEntity<List<Character>> getCharactersByAge(@PathVariable int age) {
		return new ResponseEntity<>(characterService.getCharactersByAge(age), HttpStatus.OK);
	}
	
	/*
	 * This method takes in String (obtained from the URL path) and passes it to another
	 * function which searches the database for Characters that are of a Species matching
	 * that String when a GET request is made to this endpoint. If it's successful, it 
	 * returns all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getBySpecies/Species
	 */
	@GetMapping(value = "/getBySpecies/{requestSpecies}") 
	public ResponseEntity<List<Character>> getCharactersBySpecies(@PathVariable String requestSpecies){
		Species species = speciesService.getSpeciesByName(requestSpecies);
		return new ResponseEntity<>(characterService.getCharactersBySpecies(species), HttpStatus.OK);
	}
	
	/*
	 * This method takes in String (obtained from the URL path) and passes it to another
	 * function which searches the database for Characters that are at a Stage matching
	 * that String when a GET request is made to this endpoint. If it's successful, it 
	 * returns all relevant Characters and a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/getByStage/Stage
	 */
	@GetMapping (value = "/getByStage/{requestStage}")
	public ResponseEntity<List<Character>> getCharactersByStage(@PathVariable String requestStage) {
		Stage stage = stageService.findStageByName(requestStage);
		return new ResponseEntity<>(characterService.getCharactersByStage(stage), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (in JSON format) from the Request Body, creates a  
	 * JSON Object using that String and then uses the information from the JSON Object
	 * to create a new Character whenever a POST request is made to this endpoint. If
	 * it's successful, returns a status code of 200. 
	 * 
	 * ENDPOINT: localhost:8085/characters/create
	 * 
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<Character> createCharacter(@RequestBody String characterString) {
		
		// takes in characterString from the Request Body 
		// and create a JSON Object called json
		JSONObject json = new JSONObject(characterString);
		
		// creates a new instance of the Character class
		Character c = new Character();
		
		if(json != null) {
			
			// gets the value of the "Age" key and 
			// sets it to be the new Character's age. 
			c.setAge(json.getInt("Age"));
			
			// gets the value of the "Description" key and
			// sets it to be the new Character's description.
			c.setDescription(json.getString("Description"));
			
			// gets the value of the "First Name" key and
			// sets it to be the new Character's first name.
			c.setFirstname(json.getString("First"));
			
			// gets the value of the "Last Name" key and
			// sets it to be the new Character's last name.
			c.setLastname(json.getString("Last"));
			
			// gets the value of the "Picture" key and
			// sets it to be the new Character's picture.
			c.setPicture(json.getString("Picture"));
			
		}
		
		// gets the value of "Role 1" from json and passes it to another 
		// which searches the database for a CharacterRole that matches. 
		CharacterRole role1 = characterRoleService.getCharacterRoleByTitle(json.getString("Role1"));
		
		// sets the new Character's Role to be that CharacterRole. 
		c.setRole(role1);
		
		// gets the value of "Role 2" from json and passes it to another function 
		// which searches the database for a CharacterRole2 that matches. 
		CharacterRole2 role2 = characterRoleService.getCharacterRole2ByTitle(json.getString("Role2"));
		
		// sets the new Character's Role2 to be that CharacterRole2. 
		c.setRole2(role2);
		
		// gets the value of "Species" from json and passes it to another 
		// function which searches the database for a Species that matches.
		Species species = speciesService.getSpeciesByName(json.getString("Species"));
		
		// sets the new Character's Species to be that Species
		c.setSpecies(species);
		
		// gets the value of "Stage" from json and passes it to another 
		// function which searches the database for a Stage that matches.
		Stage stage = stageService.findStageByName(json.getString("Stage"));
		
		// sets the new Character's Stage to be that Stage. 
		c.setStage(stage);
		
		// calls on the createCharacter function from characterService, passes in
		// Character c and then creates a new Character in the database.
		characterService.createCharacter(c);
		
		// returns a status code of 200. 
		return new ResponseEntity<Character>(HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/update")
	public void updateCharacter(@RequestBody String characterString) {
		
		// takes in characterString from the Request Body 
		// and create a JSON Object called json
		JSONObject json = new JSONObject(characterString);
		
		// takes in the "Character ID" key from json and uses it to select 
		// the Character with that id and set it equal to Character c. 
		Character c = characterService.getCharacterById(json.getInt("ID"));
		
		if (json != null) {
			
			// gets the value of the "Age" key and 
			// sets it to be the selected Character's age. 
			c.setAge(json.getInt("Age"));
						
			// gets the value of the "Description" key and
			// sets it to be the selected Character's description.
			c.setDescription(json.getString("Description"));
						
			// gets the value of the "First Name" key and
			// sets it to be the selected Character's first name.
			c.setFirstname(json.getString("First"));
						
			// gets the value of the "Last Name" key and
			// sets it to be the selected Character's last name.
			c.setLastname(json.getString("Last"));
						
			// gets the value of the "Picture" key and
			// sets it to be the selected Character's picture.
			c.setPicture(json.getString("Picture"));
			
		}
		
		// gets the value of "Role 1" from json and passes it to another 
		// which searches the database for a CharacterRole that matches. 
		CharacterRole cr = characterRoleService.getCharacterRoleByTitle(json.getString("Role1"));
		
		// sets the selected Character's Role to be that CharacterRole. 
		c.setRole(cr);
		
		// gets the value of "Role 2" from json and passes it to another function 
		// which searches the database for a CharacterRole2 that matches. 
		CharacterRole2 cr2 = characterRoleService.getCharacterRole2ByTitle(json.getString("Role2"));
		
		// sets the selected Character's Role2 to be that CharacterRole2. 
		c.setRole2(cr2);
		
		// gets the value of "Species" from json and passes it to another 
		// function which searches the database for a Species that matches.
		Species spec = speciesService.getSpeciesByName(json.getString("Species"));
		
		// sets the selected Character's Species to be that Species
		c.setSpecies(spec);
		
		
		// gets the value of "Stage" from json and passes it to another 
		// function which searches the database for a Stage that matches.
		Stage stage = stageService.findStageByName(json.getString("Stage"));
		
		// sets the new Character's Stage to be that Stage. 
		c.setStage(stage);
		
		// calls the updateCharacter function from characterService, passes in 
		// Character c and then updates the Character in the database. 
		characterService.updateCharacter(c);
		
		
	}
	
}
