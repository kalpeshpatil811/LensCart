package com.lenscart.entity;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/***************************
 * Customer Entity Class
 *
 * Created By: Akshata Gurupwar
 * Date: 08/08/2022
 ***************************/

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customerId")
	private int customerId;

	@NotEmpty(message = "CustomerName should not be Empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "CustomerName should contain Only letters")
	@Column(name = "customerName")
	private String customerName;

	@Column(name = "email")
	@Email(message = "Email should be in valid format")
	private String email;

	@Pattern(regexp = "^[0-9]{10}$", message = "Number should contain only 10 digits ")
	@Column(name = "number")
	private String number;

	@Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$", message = "Password should be in valid format")
	@Column(name = "password")
	private String password;

	@Column(name = "address")
	@NotBlank(message = "Customer address should not be blank")
	private String address;

	@Column(name = "role")
	@NotBlank(message = "Role should not be blank")
	private String role = "customer";

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, String email, String number, String password, String role,
			String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.number = number;
		this.password = password;
		this.address = address;
		this.role = role;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
