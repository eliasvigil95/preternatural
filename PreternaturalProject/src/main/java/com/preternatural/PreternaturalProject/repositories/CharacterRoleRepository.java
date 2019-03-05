package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.CharacterRole;

public interface CharacterRoleRepository extends JpaRepository <CharacterRole, Integer> {

	CharacterRole findRoleByTitle(String title);
}
