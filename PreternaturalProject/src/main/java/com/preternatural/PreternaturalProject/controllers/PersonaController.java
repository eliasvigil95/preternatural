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

import com.preternatural.PreternaturalProject.models.PersonaRole;
import com.preternatural.PreternaturalProject.models.Persona;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.services.PersonaService;;

@RestController
@CrossOrigin
@RequestMapping("/personas")
public class PersonaController {

	private PersonaService personaService;
	
	@Autowired
	public void setPersonaservice(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> getAllPersonas() {
		return new ResponseEntity<> (personaService.getAllPersonas(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/persona/{requestId}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable String requestId) {
		int id = Integer.parseInt(requestId);
		return new ResponseEntity<>(personaService.getPersonaById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByFirstname/{requestFirst}")
	public ResponseEntity<List<Persona>> getPersonasByFirstname(@PathVariable String requestFirst) {
		return new ResponseEntity<>(personaService.getPersonasByFirstname(requestFirst), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByLastname/{requestLast}")
	public ResponseEntity<List<Persona>> getPersonasByLastname(@PathVariable String requestLast) {
		return new ResponseEntity<>(personaService.getPersonasByLastname(requestLast), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByRole/{requestRoleId}")
	public ResponseEntity<List<Persona>> getPersonasByRole(@PathVariable int requestRoleId) {
		PersonaRole role = new PersonaRole();
		role.setId(requestRoleId);
		if (requestRoleId == 1) {
			role.setTitle("Protagonist");
		}
		else if (requestRoleId == 2) {
			role.setTitle("Deuteragonist");
		}
		else if (requestRoleId == 3) {
			role.setTitle("Antagonist");
		}
		else if (requestRoleId == 4) {
			role.setTitle("Secondary");
		}
		else if (requestRoleId == 5) {
			role.setTitle("Love Interest");
		}
		else if (requestRoleId == 6) {
			role.setTitle("Teritiary");
		}
		else if (requestRoleId == 7) {
			role.setTitle("Mentor");
		}
		else if (requestRoleId == 8) {
			role.setTitle("Flat");
		}
		return new ResponseEntity<>(personaService.getPersonasByRole(role), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByAge/{age}")
	public ResponseEntity<List<Persona>> getPersonasByAge(@PathVariable int age) {
		return new ResponseEntity<>(personaService.getPersonasByAge(age), HttpStatus.OK);
	}
	

	@GetMapping(value = "/getBySpecies/{requestSpeciesId}") 
	public ResponseEntity<List<Persona>> getPersonasBySpecies(@PathVariable int requestSpeciesId){
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
		return new ResponseEntity<>(personaService.getPersonasBySpecies(species), HttpStatus.OK);
	}
	

	@GetMapping (value = "/getByStage/{requestStageId}")
	public ResponseEntity<List<Persona>> getPersonasByStage(@PathVariable int requestStageId) {
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
		return new ResponseEntity<>(personaService.getPersonasByStage(stage), HttpStatus.OK);
	}
	
	// *****
	@PostMapping(value = "/create")
	public ResponseEntity<Persona> createPersona(@RequestBody String personaString) {
		JSONObject json = new JSONObject(personaString);
		Persona p = new Persona();
		
		if (json != null) {
			p.setAge(json.getInt("age"));
			p.setDescription(json.getString("description"));
			p.setFirstname(json.getString("firstname"));
			p.setLastname(json.getString("lastname"));
			p.setPicture(json.getString("picture"));
			
		}
		
		PersonaRole pr = new PersonaRole();
		pr.setId(json.getInt("charRoleId"));
		pr.setTitle(json.getString("charRoleTitle"));
		p.setRole(pr);
		
		PersonaRole pr2 = new PersonaRole();
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
		
		personaService.createPersona(p);
		return new ResponseEntity<Persona>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public void updateCharacter(@RequestBody String characterString) {
		JSONObject json = new JSONObject(characterString);
		Persona p = personaService.getPersonaById(json.getInt("characterId"));
		
		if (json != null) {
			p.setAge(json.getInt("age"));
			p.setDescription(json.getString("description"));
			p.setFirstname(json.getString("firstname"));
			p.setLastname(json.getString("lastname"));
			p.setPicture(json.getString("picture"));
			
		}
		
		PersonaRole pr = new PersonaRole();
		pr.setId(json.getInt("charRoleId"));
		pr.setTitle(json.getString("charRoleTitle"));
		p.setRole(pr);
		
		PersonaRole pr2 = new PersonaRole();
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
		
		personaService.updatePersona(p);
		
	}
	
}
