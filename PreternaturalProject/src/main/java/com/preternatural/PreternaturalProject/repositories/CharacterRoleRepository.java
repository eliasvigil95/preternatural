package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.CharacterRole;

/*
 * CharacterRoleRepository contains CRUD methods that will be used in the 
 * CharacterRoleService. These methods are associated with the 
 * CHARACTER_ROLES table.
 */
public interface CharacterRoleRepository extends JpaRepository <CharacterRole, Integer> {

	CharacterRole findRoleByTitle(String title);
}
