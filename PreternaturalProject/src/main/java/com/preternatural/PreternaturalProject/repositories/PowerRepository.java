package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.Power;
import com.preternatural.PreternaturalProject.models.Stage;

/*
 * PowerRepository contains CRUD methods that will be used in the PowerService. 
 * These methods are associated with the POWERS table.
 */
public interface PowerRepository extends JpaRepository<Power, Integer> {

	Power getPowerById(int id);
	Power getPowerByName(String name);
	void deletePowerByName(String name);
	List<Power> getPowersByStage(Stage stage);
	
	
}
