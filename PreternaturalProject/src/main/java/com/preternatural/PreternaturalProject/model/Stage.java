package com.preternatural.PreternaturalProject.model;

import javax.persistence.*;

@Entity
@Table (name = "STAGES")
public class Stage {

	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAGE_ID")
	private int id; 
	
	@Column(name = "STAGE_NAME")
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
		return "Stage [id=" + id + ", name=" + name + "]";
	}
}
