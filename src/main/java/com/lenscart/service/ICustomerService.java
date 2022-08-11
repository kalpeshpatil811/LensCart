package com.lenscart.service;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.exception.WrongUsernameAndPassword;

@Service
public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException;

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword;
	
	
	 
}
