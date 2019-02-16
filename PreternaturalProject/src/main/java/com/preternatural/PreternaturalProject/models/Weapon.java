package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table(name = "WEAPONS")
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WEAPON_ID")
	private int id;
	
	@Column(name = "WEAPON_NAME")
	private String name;
	
	@Column(name = "WEAPON_DESCRIPTION")
	private String description;
}
