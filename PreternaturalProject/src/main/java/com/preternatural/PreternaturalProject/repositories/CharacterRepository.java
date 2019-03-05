package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Character;
import com.preternatural.PreternaturalProject.models.CharacterRole;
import com.preternatural.PreternaturalProject.models.CharacterRole2;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;


public interface CharacterRepository extends JpaRepository <Character, Integer> {

	List<Character> getCharactersByFirstname(String firstname);
	List<Character> getCharactersByLastname(String lastname);
	List<Character> getCharactersByRole(CharacterRole role);
	List<Character> getCharactersByRole2 (CharacterRole2 role2);
	List<Character> getCharactersBySpecies(Species species);
	List<Character> getCharactersByAge(int age);
	List<Character> getCharactersByStage(Stage stage);
	List<Character> findAll();
	
	
}
