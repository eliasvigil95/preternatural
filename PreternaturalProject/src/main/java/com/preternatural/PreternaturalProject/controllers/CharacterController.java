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
import com.preternatural.PreternaturalProject.services.CharacterService;;

@RestController
@CrossOrigin
@RequestMapping("/characters")
public class CharacterController {

	private CharacterService characterService;
	private CharacterRoleService characterRoleService;
	
	@Autowired
	public void setCharacterService(CharacterService characterService) {
		this.characterService = characterService;
	}
	
	@Autowired
	public void setPersonaRoleService (CharacterRoleService characterRoleService) {
		this.characterRoleService = characterRoleService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Character>> getAllCharacters() {
		return new ResponseEntity<> (characterService.getAllCharacters(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/character/{requestId}")
	public ResponseEntity<Character> getCharacterById(@PathVariable String requestId) {
		int id = Integer.parseInt(requestId);
		return new ResponseEntity<>(characterService.getCharacterById(id), HttpStatus.OK);
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
		Species species = new Species();
		species.setId(requestSpeciesId);
		if (requestSpeciesId == 1) {
			species.setName("Human");
		}
		if (requestSpeciesId == 2) {
			species.setName("Carrier");
		}
		if (requestSpeciesId == 3) {
			species.setName("Preterhuman");
		}
		return new ResponseEntity<>(characterService.getCharactersBySpecies(species), HttpStatus.OK);
	}
	

	@GetMapping (value = "/getByStage/{requestStageId}")
	public ResponseEntity<List<Character>> getCharactersByStage(@PathVariable int requestStageId) {
		Stage stage = new Stage();
		stage.setId(requestStageId);
		if (requestStageId == -1) {
			stage.setName("None");
		}
		if (requestStageId == 0) {
			stage.setName("Unmanifested");
		}
		if (requestStageId == 1) {
			stage.setName("Basic");
		}
		if (requestStageId == 2) {
			stage.setName("Intermediate");
		}
		if (requestStageId == 3) {
			stage.setName("Advanced");
		}
		if (requestStageId == 4) {
			stage.setName("Expert");
		}
		return new ResponseEntity<>(characterService.getCharactersByStage(stage), HttpStatus.OK);
	}
	
	// *****
	@PostMapping(value = "/create")
	public ResponseEntity<Character> createCharacter(@RequestBody String characterString) {
		JSONObject json = new JSONObject(characterString);
		Character p = new Character();
		if(json != null) {
			p.setAge(json.getInt("age"));
			p.setDescription(json.getString("description"));
			p.setFirstname(json.getString("firstname"));
			p.setLastname(json.getString("lastname"));
			p.setPicture(json.getString("picture"));
			
			
		}
		
		Species species = new Species();
		species.setId(json.getInt("species_id"));
		species.setName(json.getString("species_name"));
		p.setSpecies(species);
		
	
		
		Stage stage = new Stage();
		stage.setId(json.getInt("stage_id"));
		stage.setName(json.getString("stage_name"));
		p.setStage(stage);
		
		
		String role1_title = json.getString("role1_title");
		CharacterRole role1 = characterRoleService.getCharacterRoleByTitle(role1_title);
		p.setRole(role1);
		
		
		String role2_title = json.getString("role2_title");
		CharacterRole2 role2 = characterRoleService.getCharacterRole2ByTitle(role2_title);
		p.setRole2(role2);
		
		
		characterService.createCharacter(p);
		
		return new ResponseEntity<Character>(HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/update")
	public void updateCharacter(@RequestBody String characterString) {
		JSONObject json = new JSONObject(characterString);
		Character p = characterService.getCharacterById(json.getInt("characterId"));
		
		if (json != null) {
			p.setAge(json.getInt("age"));
			p.setDescription(json.getString("description"));
			p.setFirstname(json.getString("firstname"));
			p.setLastname(json.getString("lastname"));
			p.setPicture(json.getString("picture"));
			
		}
		
		CharacterRole pr = new CharacterRole();
		pr.setId(json.getInt("charRoleId"));
		pr.setTitle(json.getString("charRoleTitle"));
		p.setRole(pr);
		
		CharacterRole2 pr2 = new CharacterRole2();
		pr2.setId(json.getInt("charRoleId2"));
		pr2.setTitle(json.getString("charRoleTitle2"));
		p.setRole2(pr2);
		
		Species spec = new Species();
		spec.setId(json.getInt("speciesId"));
		spec.setName(json.getString("speciesName"));
		p.setSpecies(spec);
		
		Stage stage = new Stage();
		stage.setId(json.getInt("stageId"));
		stage.setName(json.getString("stageName"));
		p.setStage(stage);
		
		characterService.updateCharacter(p);
		
		
	}
	
}
