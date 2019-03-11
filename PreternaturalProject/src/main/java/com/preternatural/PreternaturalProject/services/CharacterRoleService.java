package com.preternatural.PreternaturalProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.CharacterRole;
import com.preternatural.PreternaturalProject.models.CharacterRole2;
import com.preternatural.PreternaturalProject.repositories.CharacterRole2Repository;
import com.preternatural.PreternaturalProject.repositories.CharacterRoleRepository;

@Service("characterRoleService")
public class CharacterRoleService {

	private CharacterRoleRepository characterRoleRepository;
	private CharacterRole2Repository characterRole2Repository;
	
	@Autowired
	public void setCharacterRoleRepository(CharacterRoleRepository characterRoleRepository) {
		this.characterRoleRepository = characterRoleRepository;
	}
	
	@Autowired
	public void setCharacterRole2Repository(CharacterRole2Repository characterRole2Repository) {
		this.characterRole2Repository = characterRole2Repository;
	}
	
	
	public CharacterRole getCharacterRoleById(int id) {
		Optional<CharacterRole> cr = characterRoleRepository.findById(id);
		if (cr.isPresent()) {
			return cr.get();
		} else {
			return null;
		}
	}
	
	public CharacterRole getCharacterRoleByTitle(String title) {
		return characterRoleRepository.findRoleByTitle(title);
	}
	
	public CharacterRole2 getCharacterRole2ById(int id) {
		Optional<CharacterRole2> cr2 = characterRole2Repository.findById(id);
		if (cr2.isPresent()) {
			return cr2.get();
		} else {
			return null;
		}
	}
	
	public CharacterRole2 getCharacterRole2ByTitle(String title2) {
		return characterRole2Repository.findRole2ByTitle(title2);
	}
	
	
	
}
