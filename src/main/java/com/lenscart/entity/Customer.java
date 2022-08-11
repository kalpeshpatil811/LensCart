package com.lenscart.entity;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "customer")

public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "customerId")
    private int customerId;
	
	@NotEmpty(message="CustomerName should not be Empty")
	@Pattern(regexp="^[a-zA-z]+$", message="CustomerName should contain Only letters")
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "email")
	@Email(message="Email should be in valid format")
    private String email;
	
	@Pattern(regexp="^[0-9]{10}$", message="Number should contain only 10 digits ")
	@Column(name ="number")
    private String number;
	
	@Pattern(regexp="^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$", message="Password should be in valid format")
	@Column(name = "password")
	private String password;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerName, String email, String number, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.number = number;
		this.password = password;
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
	
	
    
	
	

	
}
