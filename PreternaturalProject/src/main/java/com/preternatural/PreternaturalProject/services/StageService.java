package com.preternatural.PreternaturalProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.repositories.StageRepository;

@Service("stageService")
public class StageService {

	private StageRepository stageRepository;
	
	@Autowired
	public void setStageRepository(StageRepository stageRepository) {
		this.stageRepository = stageRepository;
	}
	
	public Stage findStageById(int id) {
		Optional<Stage> s = stageRepository.findById(id);
		if (s.isPresent()) {
			return s.get();
		} else {
			return null;
		}
	}
	
	public Stage findStageByName(String stage_name) {
		return stageRepository.findStageByName(stage_name);
	}
	
	
}
