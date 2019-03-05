package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Stage;

public interface StageRepository extends JpaRepository <Stage, Integer>{

	Stage findStageByName(String stage_name);
}
