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

import com.preternatural.PreternaturalProject.models.CharRole;
import com.preternatural.PreternaturalProject.models.Character;
import com.preternatural.PreternaturalProject.models.Role;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.services.CharacterService;

@RestController
@CrossOrigin
@RequestMapping("/characters")
public class CharacterController {

	private CharacterService characterService;
	
	@Autowired
	public void setCharacterservice(CharacterService characterService) {
		this.characterService = characterService;
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
	
//	@GetMapping(value = "/getByRole/{requestRoleId}")
//	public ResponseEntity<List<Character>> getCharactersByRole(@PathVariable String requestRoleId) {
//		int id = Integer.parseInt(requestRoleId);
//		return new ResponseEntity<>(characterService.getCharactersByRole(id), HttpStatus.OK);
//	}
	
	@GetMapping(value = "/getByAge/{age}")
	public ResponseEntity<List<Character>> getCharactersByAge(@PathVariable int age) {
		return new ResponseEntity<>(characterService.getCharactersByAge(age), HttpStatus.OK);
	}
	
//	@GetMapping(value = "/getBySpecies/{requestSpeciesId}") 
//	public ResponseEntity<List<Character>> getCharactersBySpecies(@PathVariable int requestSpeciesId){
//		Species s = new Species();
//		s.setId(requestSpeciesId);
//		return new ResponseEntity<>(characterService.getCharactersBySpecies(s), HttpStatus.OK);
//	}
	
//	@GetMapping (value = "/getByStage/{requestStageId}")
//	public ResponseEntity<List<Character>> getCharactersByStage(@PathVariable int requestStageId) {
//		Stage s = new Stage();
//		s.setId(requestStageId);
//		return new ResponseEntity<>(characterService.getCharactersByStage(s), HttpStatus.OK);
//	}
	
//	@PostMapping(value = "/create")
//	public ResponseEntity<Character> createCharacter(@RequestBody String characterString) {
//		JSONObject json = new JSONObject(characterString);
//		Character c = new Character();
//		
//		if (json != null) {
//			c.setAge(json.getInt("age"));
//			c.setDescription(json.getString("description"));
//			c.setFirstname(json.getString("firstname"));
//			c.setLastname(json.getString("lastname"));
//			c.setPicture(json.getString("picture"));
//			
//		}
//		
//		CharRole cr = new CharRole();
//		cr.setId(json.getInt("charRoleId"));
//		cr.setTitle(json.getString("charRoleTitle"));
//		c.setRole(cr);
//		
//		CharRole cr2 = new CharRole();
//		cr2.setId(json.getInt("charRoleId2"));
//		cr2.setTitle(json.getString("charRoleTitle2"));
//		c.setRole2(cr2);
//		
//		Species spec = new Species();
//		spec.setId(json.getInt("speciesId"));
//		spec.setName(json.getString("speciesName"));
//		c.setSpecies(spec);
//		
//		Stage stage = new Stage();
//		stage.setId(json.getInt("stageId"));
//		stage.setName(json.getString("stageName"));
//		c.setStage(stage);
//		
//		characterService.createCharacter(c);
//		return new ResponseEntity<Character>(HttpStatus.OK);
//	}
	
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
		
		CharRole cr = new CharRole();
		cr.setId(json.getInt("charRoleId"));
		cr.setTitle(json.getString("charRoleTitle"));
		c.setRole(cr);
		
		CharRole cr2 = new CharRole();
		cr2.setId(json.getInt("charRoleId2"));
		cr2.setTitle(json.getString("charRoleTitle2"));
		c.setRole2(cr2);
		
		Species spec = new Species();
		spec.setId(json.getInt("speciesId"));
		spec.setName(json.getString("speciesName"));
		c.setSpecies(spec);
		
		Stage stage = new Stage();
		stage.setId(json.getInt("stageId"));
		stage.setName(json.getString("stageName"));
		c.setStage(stage);
		
		characterService.updateCharacter(c);
		
	}
	
}
