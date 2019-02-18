package com.preternatural.PreternaturalProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	@GetMapping(value = "/getByRole/{requestRoleId}/{requestRoleTitle}")
	public ResponseEntity<List<Character>> getCharactersByRole(@PathVariable int requestRoleId, @PathVariable String requestRoleTitle) {
		Role r = new Role();
		r.setId(requestRoleId);
		r.setTitle(requestRoleTitle);
		return new ResponseEntity<>(characterService.getCharactersByRole(r), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByAge/{age}")
	public ResponseEntity<List<Character>> getCharactersByAge(@PathVariable int age) {
		return new ResponseEntity<>(characterService.getCharactersByAge(age), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBySpecies/{requestSpeciesId}/{requestSpeciesName}") 
	public ResponseEntity<List<Character>> getCharactersBySpecies(@PathVariable int requestSpeciesId, @PathVariable String requestSpeciesName){
		Species s = new Species();
		s.setId(requestSpeciesId);
		s.setName(requestSpeciesName);
		return new ResponseEntity<>(characterService.getCharactersBySpecies(s), HttpStatus.OK);
	}
	
	@GetMapping (value = "/getByStage/{requestStageId}/{requestStageName}")
	public ResponseEntity<List<Character>> getCharactersByStage(@PathVariable int requestStageId, @PathVariable String requestStageName) {
		Stage s = new Stage();
		s.setId(requestStageId);
		s.setName(requestStageName);
		return new ResponseEntity<>(characterService.getCharactersByStage(s), HttpStatus.OK);
	}
	
	
	
}
