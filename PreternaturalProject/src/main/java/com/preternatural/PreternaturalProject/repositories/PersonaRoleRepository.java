package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.PersonaRole;

public interface PersonaRoleRepository extends JpaRepository <PersonaRole, Integer> {

	PersonaRole findRoleByTitle(String title);
}
