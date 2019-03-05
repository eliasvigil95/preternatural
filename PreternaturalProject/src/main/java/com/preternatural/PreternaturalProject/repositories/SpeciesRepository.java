package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Species;

/*
 * SpeciesRepository contains CRUD methods that will be used in the SpeciesService. 
 * These methods are associated with the SPECIES table.
 */
public interface SpeciesRepository extends JpaRepository <Species, Integer>{

	Species findSpeciesByName(String species_name);
}
