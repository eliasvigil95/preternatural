package com.preternatural.PreternaturalProject.model;

import javax.persistence.*;

@Entity
@Table (name = "POWERS")
public class Power {

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
	
	
}
