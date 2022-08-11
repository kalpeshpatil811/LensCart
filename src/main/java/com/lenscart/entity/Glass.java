package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="glass")
public class Glass {
	
	@Id
	@GeneratedValue
	@Column(name = "glassId")
	private int glassId;
	
	@NotEmpty(message="Glass name should not be blank.")
	@Column(name = "glassName")
	private String glassName;
	
	@NotBlank(message="Glass brand should not be blank.")
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "price")
	@NotNull(message="Glass Price should not be blank.")
	private double price;
	
	@NotBlank(message="Glass type should not be blank.")
	@Column(name = "type")
	private String type;
	

	@Column(name = "powerRange")
	private double powerRange;
	
	@NotBlank(message="Glass Image should not be blank.")
	@Column(name="glassImage")
	private String glassImage;
	
	public String getGlassImage() {
		return glassImage;
	}

	public void setGlassImage(String glassImage) {
		this.glassImage = glassImage;
	}

	public Glass()
	{
		
	}

	public int getGlassId() {
		return glassId;
	}

	public void setGlassId(int glassId) {
		this.glassId = glassId;
	}

	public String getGlassName() {
		return glassName;
	}

	public void setGlassName(String glassName) {
		this.glassName = glassName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPowerRange() {
		return powerRange;
	}

	public void setPowerRange(double powerRange) {
		this.powerRange = powerRange;
	}
	
	
	
}
