package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "frames")
public class Frames {
	
	@Id
	@GeneratedValue
	@Column(name = "frameId")
	private int frameId;
	
	@Column(name = "frameName")
	@NotBlank(message = "Frame name should not be null")
	private String frameName;
	
	
	@Column(name = "brand")
	@NotBlank(message = "Frame brand should not be null")
	private String brand;

	@Column(name = "color")
	@NotBlank(message = "Frame color should not be null")
	private String color;
	
	@Column(name = "price")
	@NotNull(message = "Frame price should not be null")
	private double price;
	
	@Column(name = "description")
	@NotBlank(message = "Frame description should not be null")
	private String description;
	
	@Column(name = "shapeOptions")
	@NotBlank(message = "Frame shape should not be null")
	private String shapeOptions;
	
	@Column(name = "size")
	@NotBlank(message = "Frame size should not be null")
	private String size;
	
	private String frameImage;
	
	public Frames() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFrameId() {
		return frameId;
	}
	public void setFrameId(int frameId) {
		this.frameId = frameId;
	}
	public String getFrameName() {
		return frameName;
	}
	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShapeOptions() {
		return shapeOptions;
	}
	public void setShapeOptions(String shapeOptions) {
		this.shapeOptions = shapeOptions;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFrameImage() {
		return frameImage;
	}
	public void setFrameImage(String frameImage) {
		this.frameImage = frameImage;
	}
	
	@Override
	public String toString() {
		return "Frames [frameId=" + frameId + ", frameName=" + frameName + ", brand=" + brand + ", color=" + color
				+ ", price=" + price + ", description=" + description + ", shapeOptions=" + shapeOptions + ", size="
				+ size + "]";
	}
	
	

}
