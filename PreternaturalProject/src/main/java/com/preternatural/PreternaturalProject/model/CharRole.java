package com.preternatural.PreternaturalProject.model;

import javax.persistence.*;

@Entity
@Table(name = "CHARACTER_ROLES")
public class CharRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "CHAR_ROLE_ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
}
