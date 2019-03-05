package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Stage;

/*
 * StageRepository contains CRUD methods that will be used in the StageService. 
 * These methods are associated with the STAGES table.
 */
public interface StageRepository extends JpaRepository <Stage, Integer>{

	Stage findStageByName(String stage_name);
}
