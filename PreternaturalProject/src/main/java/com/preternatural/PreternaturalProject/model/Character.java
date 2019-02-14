package com.preternatural.PreternaturalProject.model;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTERS")
public class Character {

	public Character(int id, String picture, String firstname, String lastname, CharRole role, CharRole role2,
			String description, Species species, int age, Stage stage) {
		super();
		this.id = id;
		this.picture = picture;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.role2 = role2;
		this.description = description;
		this.species = species;
		this.age = age;
		this.stage = stage;
	}

	public Character() {
		super();
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHARACTER_ID")
	private int id;
	
	@Column(name = "PICTURE")
	private String picture; 
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CHAR_ROLE_ID")
	private CharRole role;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CHAR_ROLE_ID_2", nullable = true)
	private CharRole role2;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "SPECIES_ID")
	private Species species;
	
	@Column(name = "AGE")
	private int age; 
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "STAGE_ID")
	private Stage stage;

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

	public CharRole getRole() {
		return role;
	}

	public void setRole(CharRole role) {
		this.role = role;
	}

	public CharRole getRole2() {
		return role2;
	}

	public void setRole2(CharRole role2) {
		this.role2 = role2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", picture=" + picture + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", role=" + role + ", role2=" + role2 + ", description=" + description + ", species=" + species
				+ ", age=" + age + ", stage=" + stage + "]";
	}
	
	
	
}
