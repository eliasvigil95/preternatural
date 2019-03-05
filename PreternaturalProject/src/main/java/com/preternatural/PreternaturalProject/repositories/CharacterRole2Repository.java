package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.CharacterRole2;

public interface CharacterRole2Repository extends JpaRepository <CharacterRole2, Integer> {
	
	CharacterRole2 findRole2ByTitle(String title2);
}

	
