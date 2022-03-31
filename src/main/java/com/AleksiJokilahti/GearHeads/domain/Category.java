package com.AleksiJokilahti.GearHeads.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;	 // Auto generated id
	private String name; // for example guitar, drums, mics
	
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
	
	
}
