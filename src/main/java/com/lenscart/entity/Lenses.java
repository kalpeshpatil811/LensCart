package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lenses")

public class Lenses {
	@Id
	@GeneratedValue
	
	@Column(name = "lensId")
	private int lensId;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "lensImage")
	private String lensImage;
	
	@Column(name = "shape")
	private String shape;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private int quantity;


public Lenses() {
	super();
}


public Lenses(int lensId, String brand, String lensImage, String shape, String color, double price,
		int quantity) {
	super();
	this.lensId = lensId;
	this.brand = brand;
	this.lensImage = lensImage;
	this.shape = shape;
	this.color = color;
	this.price = price;
	this.quantity = quantity;
}


public int getLensId() {
	return lensId;
}

public void setLensId(int lensId) {
	this.lensId = lensId;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getLenseImage() {
	return lensImage;
}

public void setLenseImage(String lensImage) {
	this.lensImage = lensImage;
}
public String getShape() {
	return shape;
}

public void setShape(String shape) {
	this.shape = shape;
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

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

//@Override
//public String toString() {
//	return "Lenses [lenseId=" + lensId + ", brand=" + brand + ", shape=" + shape
//			+ ", color=" + color + ", price=" + price + ", quantity =" + quantity + "]";
//}


}