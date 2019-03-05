package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Species;

public interface SpeciesRepository extends JpaRepository <Species, Integer>{

	Species findSpeciesByName(String species_name);
}
