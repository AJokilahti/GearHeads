package com.AleksiJokilahti.GearHeads.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Instrument {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;			// unique autogenerated id, not null, not editable
	
	private String brand; 		// brand of the instrument (Fender, Ludwig, etc.)
	private String model; 		// model of the instrument (Stratocaster, LM402, etc.
	private int year;			// year of production
	private String serial;		// serial number of the instrument
	private String dateAdded;	// date when added to collection
	private double priceBought;	// the price payed for the instrument
	private String condition;	// condition of the instrument
	private String desc;		// description, additional info
	
	// @ManyToOne
	//private Category category;	// category of the instrument;
	
	// NULL constructor
	public Instrument() {
		super();
		this.id=null;
		//this.category = null;
		this.brand = null;
		this.model = null;
		this.year = 0;
		this.serial = null;
		this.dateAdded = null;
		this.priceBought = 0.00;
		this.condition = null;
		this.desc = null;
	}
	
	public Instrument(Long id, Category category, String brand, String model, int year, String serial, String dateAdded,
			double priceBought, String condition, String desc) {
		super();
		this.id = id;
		//this.category = category;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.serial = serial;
		this.dateAdded = dateAdded;
		this.priceBought = priceBought;
		this.condition = condition;
		this.desc = desc;
	}

	public Instrument(Category category, String brand, String model, int year, String serial, String dateAdded,
			double priceBought, String condition, String desc) {
		super();
		//this.category = category;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.serial = serial;
		this.dateAdded = dateAdded;
		this.priceBought = priceBought;
		this.condition = condition;
		this.desc = desc;
	}

	//SETTERS
	public void setId(Long id) {
		this.id = id;
	}
	/*public void setCategory(Category category) {
		this.category = category;
	}*/
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public void setPriceBought(double priceBought) {
		this.priceBought = priceBought;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	// GETTERS
	public Long getId() {
		return id;
	}
	/*public Category getCategory() {
		return category;
	}*/
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}
	public String getSerial() {
		return serial;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public double getPriceBought() {
		return priceBought;
	}
	public String getCondition() {
		return condition;
	}
	public String getDesc() {
		return desc;
	}
	
	@Override
	public String toString() {
		return "Instrument [id=" + id + ", Category=" + /*category + */", brand=" + brand + ", model=" + model + ", year=" + year + ", serial="
				+ serial + ", dateAdded=" + dateAdded + ", priceBought=" + priceBought + ", condition=" + condition
				+ ", desc=" + desc + "]";
	}
	
	
}
