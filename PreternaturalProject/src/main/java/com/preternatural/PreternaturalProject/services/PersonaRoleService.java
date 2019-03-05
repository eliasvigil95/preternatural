package com.preternatural.PreternaturalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.PersonaRole;
import com.preternatural.PreternaturalProject.repositories.PersonaRoleRepository;

@Service("personaRoleService")
public class PersonaRoleService {

	private PersonaRoleRepository personaRoleRepository;
	
	@Autowired
	public void setPersonaRoleRepository(PersonaRoleRepository personaRoleRepository) {
		this.personaRoleRepository = personaRoleRepository;
	}
	
	public PersonaRole getPersonalRoleByTitle(String title) {
		return personaRoleRepository.findRoleByTitle(title);
	}
}
