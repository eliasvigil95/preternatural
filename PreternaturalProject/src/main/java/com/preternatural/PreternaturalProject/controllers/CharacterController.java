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
	 
	@GetMapping("/all")
	public ResponseEntity<List<Character>> getAllCharacters() {
		return new ResponseEntity<> (characterService.getAllCharacters(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/character/{requestId}")
	public ResponseEntity<Character> getCharacterById(@PathVariable int requestId) {
		return new ResponseEntity<>(characterService.getCharacterById(requestId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByFirstname/{requestFirst}")
	public ResponseEntity<List<Character>> getCharactersByFirstname(@PathVariable String requestFirst) {
		return new ResponseEntity<>(characterService.getCharactersByFirstname(requestFirst), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByLastname/{requestLast}")
	public ResponseEntity<List<Character>> getCharactersByLastname(@PathVariable String requestLast) {
		return new ResponseEntity<>(characterService.getCharactersByLastname(requestLast), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByRole/{requestRoleId}")
	public ResponseEntity<List<Character>> getCharactersByRole(@PathVariable int requestRoleId) {
		CharacterRole role = characterRoleService.getCharacterRoleById(requestRoleId);
		return new ResponseEntity<>(characterService.getCharactersByRole(role), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByRole2/{requestRoleId2}")
	public ResponseEntity<List<Character>> getCharactersByRole2(@PathVariable int requestRoleId2) {
		CharacterRole2 role2 = characterRoleService.getCharacterRole2ById(requestRoleId2);
		return new ResponseEntity<>(characterService.getCharactersByRole2(role2), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByAge/{age}")
	public ResponseEntity<List<Character>> getCharactersByAge(@PathVariable int age) {
		return new ResponseEntity<>(characterService.getCharactersByAge(age), HttpStatus.OK);
	}
	

	@GetMapping(value = "/getBySpecies/{requestSpeciesId}") 
	public ResponseEntity<List<Character>> getCharactersBySpecies(@PathVariable int requestSpeciesId){
		Species species = speciesService.getSpeciesById(requestSpeciesId);
		return new ResponseEntity<>(characterService.getCharactersBySpecies(species), HttpStatus.OK);
	}
	

	@GetMapping (value = "/getByStage/{requestStageId}")
	public ResponseEntity<List<Character>> getCharactersByStage(@PathVariable int requestStageId) {
		Stage stage = stageService.findStageById(requestStageId);
		return new ResponseEntity<>(characterService.getCharactersByStage(stage), HttpStatus.OK);
	}
	

	@PostMapping(value = "/create")
	public ResponseEntity<Character> createCharacter(@RequestBody String characterString) {
		JSONObject json = new JSONObject(characterString);
		Character c = new Character();
		if(json != null) {
			c.setAge(json.getInt("age"));
			c.setDescription(json.getString("description"));
			c.setFirstname(json.getString("firstname"));
			c.setLastname(json.getString("lastname"));
			c.setPicture(json.getString("picture"));
			
		}
		
		Species species = speciesService.getSpeciesByName(json.getString("species"));
		c.setSpecies(species);
		
		Stage stage = stageService.findStageByName(json.getString("stage"));
		c.setStage(stage);
		
		CharacterRole role1 = characterRoleService.getCharacterRoleByTitle(json.getString("role1"));
		c.setRole(role1);
		
		CharacterRole2 role2 = characterRoleService.getCharacterRole2ByTitle(json.getString("role2"));
		c.setRole2(role2);
		
		characterService.createCharacter(c);
		
		return new ResponseEntity<Character>(HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/update")
	public void updateCharacter(@RequestBody String characterString) {
		JSONObject json = new JSONObject(characterString);
		Character c = characterService.getCharacterById(json.getInt("characterId"));
		
		if (json != null) {
			c.setAge(json.getInt("age"));
			c.setDescription(json.getString("description"));
			c.setFirstname(json.getString("firstname"));
			c.setLastname(json.getString("lastname"));
			c.setPicture(json.getString("picture"));
			
		}
		
		CharacterRole cr = characterRoleService.getCharacterRoleByTitle(json.getString("Role 1"));
		c.setRole(cr);
		
		CharacterRole2 cr2 = characterRoleService.getCharacterRole2ByTitle(json.getString("Role 2"));
		c.setRole2(cr2);
		
		Species spec = speciesService.getSpeciesByName(json.getString("species"));
		c.setSpecies(spec);
		
		Stage stage = stageService.findStageByName(json.getString("stage"));
		c.setStage(stage);
		
		characterService.updateCharacter(c);
		
		
	}
	
}
