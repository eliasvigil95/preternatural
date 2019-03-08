package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table(name = "SPECIES")
public class Species {

	public Species() {
		super();
	}
	
	public Species(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPECIES_ID")
	private int id; 
	
	@Column(name = "SPECIES_NAME")
	private String name;
	
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
	@Override
	public String toString() {
		return "Species [id=" + id + ", name=" + name + "]";
	}
}
