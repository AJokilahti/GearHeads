package com.AleksiJokilahti.GearHeads.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	// ID, NOT NULL, NOT UPDATABLE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "userid", nullable=false, updatable=false)
	private Long userid;
	
	// USERNAME, NOT NULL, UNIQUE
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	// PASSWORD, NOT NULL
	@Column(name="password", nullable=false)
	private String password;
	
	// EMAIL, NOT NULL
	@Column(name="email", nullable=false)
	private String email;
	
	// ROLE, NOT NULL
	@Column(name="role", nullable=false)
	private String role;
	
	@JsonIgnore						// ignores JSON for GET, prevents infinite loop
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Instrument> instruments;
	
	// CONSTRUCTOR WITHOUT FIELDS
	public User() {
		
	}
	
	// CONSTRUCTOR WITH STRINGS
	public User (String username, String password, String email, String role) {
		super();
		this.username=username;
		this.password=password;
		this.email=email;
		this.role=role;
	}

	public Long getUserId() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	
	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setUserId(Long userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public String toString() {
		return "User [id=" + userid + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
	
	
}
