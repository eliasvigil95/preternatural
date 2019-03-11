package com.preternatural.PreternaturalProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.Species;
import com.preternatural.PreternaturalProject.repositories.SpeciesRepository;

@Service("speciesService")
public class SpeciesService {

	private SpeciesRepository speciesRepository;
	
	@Autowired
	public void setSpeciesRepository(SpeciesRepository speciesRepository) {
		this.speciesRepository = speciesRepository;
	}
	
	
	public Species getSpeciesById(int id) {
		Optional<Species> spec = speciesRepository.findById(id);
		if (spec.isPresent()) {
			return spec.get();
		} else {
			return null;
		}
	}
	
	public Species getSpeciesByName(String species_name) {
		return speciesRepository.findSpeciesByName(species_name);
	}
}
