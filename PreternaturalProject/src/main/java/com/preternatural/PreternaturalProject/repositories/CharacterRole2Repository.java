package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.CharacterRole2;

/*
 * CharacterRole2Repository contains CRUD methods that will be used in the 
 * CharacterRoleService. These methods are associated with the 
 * CHARACTER_ROLES_2 table.
 */
public interface CharacterRole2Repository extends JpaRepository <CharacterRole2, Integer> {
	
	CharacterRole2 findRole2ByTitle(String title2);
}

	
