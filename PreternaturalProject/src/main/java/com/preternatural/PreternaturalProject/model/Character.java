package com.preternatural.PreternaturalProject.model;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTERS")
public class Character {

	public Character() {
		super();
	}
	public Character(int id, String picture, String firstname, String lastname, int role, String description,
			String species, int age, String level) {
		super();
		this.id = id;
		this.picture = picture;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.description = description;
		this.species = species;
		this.age = age;
		this.level = level;
	}
	private int id;
	private String picture; 
	private String firstname;
	private String lastname;
	private int role;
	private String description;
	private String species;
	private int age; 
	private String level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", picture=" + picture + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", role=" + role + ", description=" + description + ", species=" + species + ", age=" + age
				+ ", level=" + level + "]";
	}
	
}
