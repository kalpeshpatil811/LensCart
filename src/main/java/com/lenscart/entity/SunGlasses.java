package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sunGlasses")
public class SunGlasses {
	@Id
	@GeneratedValue
	@Column(name = "sunGlassId")
	private int sunGlassId;

	@Column(name = "sunGlassName")
	@NotBlank(message = "Sunglass name should not be empty")
	private String sunGlassName;

	@Column(name = "brand")
	@NotBlank(message = "Sunglass brand should not be empty")
	private String brand;

	@Column(name = "price")
	@NotNull(message = "Sunglass price should not be empty")
	private double price;

	@Column(name = "frameColor")
	@NotBlank(message = "Sunglass frame color should not be empty")
	private String frameColor;

	@Column(name = "frameShape")
	@NotBlank(message = "Sunglass frame shape should not be empty")
	private String frameShape;

	@Column(name = "glassColor")
	@NotBlank(message = "Sunglass glass color should not be empty")
	private String glassColor;

	@Column(name = "weight")
	@NotNull(message = "Sunglass weight should not be empty")
	private double weight;

	@Column(name = "image")
	@NotBlank(message = "Sunglass image should not be empty")
	private String image;

	public SunGlasses() {
		super();
	}

	public SunGlasses(int sunGlassId, String sunGlassName, String brand, double price, String frameColor,
			String frameShape, String glassColor, double weight, String image) {
		super();
		this.sunGlassId = sunGlassId;
		this.sunGlassName = sunGlassName;
		this.brand = brand;
		this.price = price;
		this.frameColor = frameColor;
		this.frameShape = frameShape;
		this.glassColor = glassColor;
		this.weight = weight;
		this.image = image;
	}

	public int getSunGlassId() {
		return sunGlassId;
	}

	public void setSunGlassId(int sunGlassId) {
		this.sunGlassId = sunGlassId;
	}

	public String getSunGlassName() {
		return sunGlassName;
	}

	public void setSunGlassName(String sunGlassName) {
		this.sunGlassName = sunGlassName;
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

	public String getFrameColor() {
		return frameColor;
	}

	public void setFrameColor(String frameColor) {
		this.frameColor = frameColor;
	}

	public String getFrameShape() {
		return frameShape;
	}

	public void setFrameShape(String frameShape) {
		this.frameShape = frameShape;
	}

	public String getGlassColor() {
		return glassColor;
	}

	public void setGlassColor(String glassColor) {
		this.glassColor = glassColor;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
