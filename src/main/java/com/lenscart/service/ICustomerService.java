package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNameAlreadyExistException;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.exception.WrongUsernameAndPassword;

@Service
public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws CustomerNameAlreadyExistException;

	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException;

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword;

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException;

}