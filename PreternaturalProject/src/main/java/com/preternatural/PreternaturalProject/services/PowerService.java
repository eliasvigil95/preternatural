package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.Power;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.repositories.PowerRepository;

@Service("powerService")
public class PowerService {

	private PowerRepository powerRepository;
	
	@Autowired
	public void setPowerRepository(PowerRepository powerRepository) {
		this.powerRepository = powerRepository;
	}
	
	public List<Power> getAllPowers() {
		return powerRepository.findAll();
	}
	
	public Power getPowerById(int id) {
		Optional<Power> pow = powerRepository.findById(id);
		if (pow.isPresent()) {
			return pow.get();
		} else {
			return null;
		}
	}
	
	public void deletePowerById(int id) {
		powerRepository.deleteById(id);
	}
	
	public Power getPowerByName(String name) {
		return powerRepository.getPowerByName(name);
	}
	
	public void deletePowerByName(String name) {
		powerRepository.deletePowerByName(name);
	}
	
	public List<Power> getPowersByStage(Stage stage) {
		return powerRepository.getPowersByStage(stage);
	}
	
	public void createPower(Power power) {
		powerRepository.save(power);
	}
	
	public int updatePower(Power power) {
		Power pow = powerRepository.save(power);
		if (pow != null) {
			return pow.getId();
		} else {
			return 0;
		}
	}
	
	
}
