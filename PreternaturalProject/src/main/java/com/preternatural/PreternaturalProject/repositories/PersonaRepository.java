package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Persona;


public interface PersonaRepository extends JpaRepository <Persona, Integer> {

	List<Persona> getPersonasByFirstname(String firstname);
	List<Persona> getPersonasByLastname(String lastname);
	List<Persona> getPersonasByRole(int role);
	List<Persona> getPersonasBySpecies(int species);
	List<Persona> getPersonasByAge(int age);
	List<Persona> getPersonasByStage(int stage);
	List<Persona> findAll();
	
	
}
