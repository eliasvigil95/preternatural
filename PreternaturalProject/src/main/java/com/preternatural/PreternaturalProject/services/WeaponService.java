package com.preternatural.PreternaturalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.Weapon;
import com.preternatural.PreternaturalProject.repositories.WeaponRepository;

@Service("weaponService")
public class WeaponService {

	private WeaponRepository weaponRepository;
	
	@Autowired
	public void setWeaponRepository(WeaponRepository weaponRepository) {
		this.weaponRepository = weaponRepository;
	}
	
	public List<Weapon> getAllWeapons() {
		return weaponRepository.findAll();
	}
	
	public Weapon getWeaponById(int id) {
		
		Optional<Weapon> w = weaponRepository.findById(id);
		
		if (w.isPresent()) {
			return w.get();
		} 
		
		else {
			return null;
		}
	}
	
	public void deleteWeaponById(int id) {
		weaponRepository.deleteById(id);
	}
	
	public void deleteWeaponByName(String name) {
		weaponRepository.deleteWeaponByName(name);
	}
	
	public Weapon getWeaponByName(String weapon_name) {
		return weaponRepository.getWeaponByName(weapon_name);
	}
	
	public void createWeapon(Weapon weapon) {
		weaponRepository.save(weapon);
	}
	
	public int updateWeapon(Weapon weapon) {
		Weapon w = weaponRepository.save(weapon);
		if (w != null) {
			return w.getId();
		} else {
			return 0;
		}
	}
}
