package com.preternatural.PreternaturalProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHARACTER_ROLES_2")
public class CharacterRole2 {

	public CharacterRole2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharacterRole2(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public CharacterRole2(String title) {
		super();
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "CHAR_ROLE_ID_2")
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
		return "CharacterRole2 [id=" + id + ", title=" + title + "]";
	}
}
