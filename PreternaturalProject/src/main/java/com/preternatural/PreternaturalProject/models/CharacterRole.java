package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTER_ROLES")
public class CharacterRole {

	public CharacterRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharacterRole(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public CharacterRole(String title) {
		super();
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
		return "CharacterRole [id=" + id + ", title=" + title + "]";
	}
	
}
