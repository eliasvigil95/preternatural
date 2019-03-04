package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.preternatural.PreternaturalProject.models.Persona;
import com.preternatural.PreternaturalProject.models.PersonaRole;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.repositories.PersonaRepository;

@Service("personaService")
public class PersonaService {

	private PersonaRepository personaRepository;
	
	@Autowired
	public void setPersonaRepository(PersonaRepository charRepository) {
		this.personaRepository = charRepository;
	}
	
	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}
	
	public Persona getPersonaById(int id) {
		Optional<Persona> p = personaRepository.findById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public void deletePersonaById(int id) {
		personaRepository.deleteById(id);
	}
	
	public List<Persona> getPersonasByFirstname(String firstname) {
		return personaRepository.getPersonasByFirstname(firstname);
	}
	
	public List<Persona> getPersonasByLastname(String lastname) {
		return personaRepository.getPersonasByLastname(lastname);
	}
	
	public List<Persona> getPersonasByRole(PersonaRole role) {
		return personaRepository.getPersonasByRole(role);
	}
	
	public List<Persona> getPersonasByAge(int age) {
		return personaRepository.getPersonasByAge(age);
	}
	
	
	public List<Persona> getPersonasBySpecies(Species species) {
		return personaRepository.getPersonasBySpecies(species);
	}
	public List<Persona> getPersonasByStage(Stage stage) {
		return personaRepository.getPersonasByStage(stage);
	}
	
	public void createPersona(Persona persona) {
		personaRepository.save(persona);
	}
	
	public int updatePersona(Persona persona) {
		Persona p = personaRepository.save(persona);
		if (p != null) {
			return p.getId();
		} else {
			return 0;
		}
	}
	
}
