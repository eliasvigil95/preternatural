package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Character;


public interface CharacterRepository extends JpaRepository <Character, Integer> {

	List<Character> getCharactersByFirstname(String firstname);
	List<Character> getCharactersByLastname(String lastname);
	List<Character> getCharactersByRole(int role);
	List<Character> getCharactersBySpecies(int species);
	List<Character> getCharactersByAge(int age);
	List<Character> getCharactersByStage(int stage);
	List<Character> findAll();
}
