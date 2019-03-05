package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.Power;
import com.preternatural.PreternaturalProject.models.Stage;

public interface PowerRepository extends JpaRepository<Power, Integer> {

	Power getPowerById(int id);
	Power getPowerByName(String name);
	void deletePowerByName(String name);
	List<Power> getPowersByStage(Stage stage);
	
	
}
