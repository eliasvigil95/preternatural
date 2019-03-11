package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.preternatural.PreternaturalProject.models.Character;
import com.preternatural.PreternaturalProject.models.CharacterRole;
import com.preternatural.PreternaturalProject.models.CharacterRole2;
import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.repositories.CharacterRepository;

@Service("characterService")
public class CharacterService {

	private CharacterRepository characterRepository;
	
	@Autowired
	public void setCharacterRepository(CharacterRepository characterRepository) {
		this.characterRepository = characterRepository;
	}
	
	public List<Character> getAllCharacters() {
		return characterRepository.findAll();
	}
	
	public Character getCharacterById(int id) {
		Optional<Character> p = characterRepository.findById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public void deleteCharacterById(int id) {
		characterRepository.deleteById(id);
	}
	
	public List<Character> getCharactersByFirstname(String firstname) {
		return characterRepository.getCharactersByFirstname(firstname);
	}
	
	public List<Character> getCharactersByLastname(String lastname) {
		return characterRepository.getCharactersByLastname(lastname);
	}
	
	public List<Character> getCharactersByRole(CharacterRole role) {
		return characterRepository.getCharactersByRole(role);
	}
	
	public List<Character> getCharactersByRole2(CharacterRole2 role2) {
		return characterRepository.getCharactersByRole2(role2);
	}
	
	public List<Character> getCharactersByAge(int age) {
		return characterRepository.getCharactersByAge(age);
	}
	
	
	public List<Character> getCharactersBySpecies(Species species) {
		return characterRepository.getCharactersBySpecies(species);
	}
	public List<Character> getCharactersByStage(Stage stage) {
		return characterRepository.getCharactersByStage(stage);
	}
	
	public void createCharacter(Character character) {
		characterRepository.save(character);
	}
	
	public int updateCharacter(Character character) {
		Character p = characterRepository.save(character);
		if (p != null) {
			return p.getId();
		} else {
			return 0;
		}
	}
	
}
