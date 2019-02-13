package com.preternatural.model;

import javax.persistence.*;

@Entity
@Table(name = "USERROLE")
public class Role {

	public Role(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public Role() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "TITLE")
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
		return "Role [id=" + id + ", title=" + title + "]";
	}
}
