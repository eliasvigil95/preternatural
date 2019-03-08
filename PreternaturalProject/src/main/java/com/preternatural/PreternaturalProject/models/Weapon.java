package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table(name = "WEAPONS")
public class Weapon {

	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weapon(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WEAPON_ID")
	private int id;
	
	@Column(name = "WEAPON_NAME")
	private String name;
	
	@Column(name = "WEAPON_DESCRIPTION")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
