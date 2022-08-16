package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNameAlreadyExistException;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.exception.WrongUsernameAndPassword;
import com.lenscart.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNameAlreadyExistException {

		Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
		if (customer1 != null) {
			throw new CustomerNameAlreadyExistException("CustomerName already exist");
		} else {
			customerRepo.save(customer);
			return customer;
		}
	}

	@Override
	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException {

		Customer customer = customerRepo.findByCustomerName(customerName);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("No Such Customer Exist");
		}
	}

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
		if (customer1 != null) {
			if (customer.getPassword().equals(customer1.getPassword())) {
				return customer1;
			} else {
				throw new WrongPasswordException("Wrong Password");
			}
		} else {
			throw new WrongUsernameAndPassword("Wrong USername or Password");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		try {
			Customer customer = customerRepo.findById(customerId).get();
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present, enter correct Id");
		}
	}

	@Override
	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException {
		try {
			customerRepo.deleteById(customerId);
			return customerRepo.findAll();
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present, enter correct Id");
		}
	}

}