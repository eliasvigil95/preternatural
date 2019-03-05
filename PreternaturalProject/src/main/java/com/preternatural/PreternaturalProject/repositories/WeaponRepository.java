package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preternatural.PreternaturalProject.models.Weapon;

/*
 * WeaponRepository contains CRUD methods that will be used in the WeaponService. 
 * These methods are associated with the WEAPONS table.
 */
public interface WeaponRepository extends JpaRepository <Weapon, Integer> {

	Weapon getWeaponById(int id);
	Weapon getWeaponByName(String name);
	void deleteWeaponByName (String name);
	
}
