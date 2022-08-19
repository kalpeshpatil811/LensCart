package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/***************************
 * Cart Entity Class
 *
 * Created By: Kalpesh Patil
 * Date: 08/08/2022
 ***************************/

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	@Column(name = "itemId")
	private int itemId;

	@Column(name = "name")
	@NotBlank(message = "Cart item name should not be empty")
	private String name;

	@Column(name = "brand")
	@NotBlank(message = "Cart item brand should not be empty")
	private String brand;

	@Column(name = "price")
	@NotNull(message = "Cart item price should not be empty")
	private double price;

	@Column(name = "image")
	@NotBlank(message = "Cart image should not be empty")
	private String image;

	@Column(name = "customerId")
	@NotNull(message = "Cart customer id should not be empty")
	private int customerId;

	public Cart() {
		super();
	}

	public Cart(int itemId, String name, String brand, double price, String image, int customerId) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.image = image;
		this.customerId = customerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
