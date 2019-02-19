package com.preternatural.PreternaturalProject.models;

import javax.persistence.*;

@Entity
@Table (name = "USERS")
public class User {
	
	public User() {
		super();
	}
	
	public User(int id, String firstname, String lastname, String email, String username, String pass, UserRole role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int id; 
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASS")
	private String pass;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ROLE_ID")
	private UserRole role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", pass=" + pass + ", role=" + role + "]";
	}
}
