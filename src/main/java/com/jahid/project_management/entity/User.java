package com.jahid.project_management.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	@Id		
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer id;
	

	@Column(length=128, nullable=false)
	private String name;
	
	@Column(length=128, nullable=false)
	private String email;
	
	@Column(length=50, nullable=false)
	private String password;
	

	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String password) {
		this.id =id;
		this.name=name;
		this.email=email;
		this.password=password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
}