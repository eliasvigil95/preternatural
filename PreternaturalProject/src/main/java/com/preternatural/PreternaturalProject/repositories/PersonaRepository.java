package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Persona;
import com.preternatural.PreternaturalProject.models.PersonaRole;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;


public interface PersonaRepository extends JpaRepository <Persona, Integer> {

	List<Persona> getPersonasByFirstname(String firstname);
	List<Persona> getPersonasByLastname(String lastname);
	List<Persona> getPersonasByRole(PersonaRole role);
	List<Persona> getPersonasBySpecies(Species species);
	List<Persona> getPersonasByAge(int age);
	List<Persona> getPersonasByStage(Stage stage);
	List<Persona> findAll();
	
	
}
