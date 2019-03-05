package com.preternatural.PreternaturalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.Weapon;

public interface WeaponRepository extends JpaRepository <Weapon, Integer> {

	Weapon getWeaponById(int id);
	Weapon getWeaponByName(String name);
	void deleteWeaponByName (String name);
	
}
