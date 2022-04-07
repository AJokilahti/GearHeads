package com.AleksiJokilahti.GearHeads.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;		// Auto generated id
	private String name; 			// for example guitar, drums, mics
	
	@JsonIgnore						// ignores JSON for GET, prevents infinite loop
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Instrument> instruments;
	
	public Category() {
		super();
		this.categoryId = null;
		this.name = null;
	}

	public Category(Long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	// SETTERS
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	// GETTERS
	public Long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}
	
	
	
	
}
