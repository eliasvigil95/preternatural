package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table (name = "POWERS")
public class Power {

	public Power(int id, String picture, String name, String description, Stage stage) {
		super();
		this.id = id;
		this.picture = picture;
		this.name = name;
		this.description = description;
		this.stage = stage;
	}

	public Power() {
		super();
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POWER_ID")
	private int id;
	
	@Column(name = "PICTURE")
	private String picture;
	
	@Column(name = "POWER_NAME")
	private String name;
	
	@Column(name = "POWER_DESCRIPTION")
	private String description;
	
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

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Power [id=" + id + ", picture=" + picture + ", name=" + name + ", description=" + description
				+ ", stage=" + stage + "]";
	}
	
	
}
