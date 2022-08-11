package com.lenscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.exception.WrongUsernameAndPassword;
import com.lenscart.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException{
	
		     Customer customer= customerRepo.findByCustomerName(customerName);
		     if(customer!=null) {
		           return customer;
		     }
	         else {
			       throw new CustomerNotFoundException("No Such Customer Exist");
		     }
	}

    public Customer loginCustomer(Customer customer) throws WrongPasswordException,WrongUsernameAndPassword {
    	      Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
    	      if(customer1!=null)
    	      {
                       if (customer.getPassword().equals(customer1.getPassword())) {
                           return customer1;
                       }
                       else {
                 	        throw new WrongPasswordException("Wrong Password");
                       }
    	     }
             else{
        	  throw new WrongUsernameAndPassword("Wrong USername or Password");
        }
    }



}
