package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.preternatural.PreternaturalProject.models.Character;
import com.preternatural.PreternaturalProject.repositories.CharacterRepository;

@Service("characterService")
public class CharacterService {

	private CharacterRepository charRepository;
	
	@Autowired
	public void setCharacterRepository(CharacterRepository charRepository) {
		this.charRepository = charRepository;
	}
	
	public List<Character> getAllCharacters() {
		return charRepository.findAll();
	}
	
	public Character getCharacterById(int id) {
		Optional<Character> c = charRepository.findById(id);
		if (c.isPresent()) {
			return c.get();
		} else {
			return null;
		}
	}
	
	public void deleteCharacterById(int id) {
		charRepository.deleteById(id);
	}
	
	public List<Character> getCharactersByFirstname(String firstname) {
		return charRepository.getCharactersByFirstname(firstname);
	}
	
	public List<Character> getCharactersByLastname(String lastname) {
		return charRepository.getCharactersByLastname(lastname);
	}
	
	public List<Character> getCharactersByRole(int role) {
		return charRepository.getCharactersByRole(role);
	}
	
	public List<Character> getCharactersByAge(int age) {
		return charRepository.getCharactersByAge(age);
	}
	
	
	public List<Character> getCharactersBySpecies(int species) {
		return charRepository.getCharactersBySpecies(species);
	}
	public List<Character> getCharactersByStage(int stage) {
		return charRepository.getCharactersByStage(stage);
	}
	
	public void createCharacter(Character character) {
		charRepository.save(character);
	}
	
	public int updateCharacter(Character character) {
		Character c = charRepository.save(character);
		if (c != null) {
			return c.getId();
		} else {
			return 0;
		}
	}
	
}
