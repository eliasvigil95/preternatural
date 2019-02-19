package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTER_ROLES")
public class CharRole {

	public CharRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharRole(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "CHAR_ROLE_ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CharRole [id=" + id + ", title=" + title + "]";
	}
	
}
