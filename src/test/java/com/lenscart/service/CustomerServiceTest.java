package com.lenscart.service;

import org.springframework.boot.test.context.SpringBootTest;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;

	@Mock
	private CustomerRepository repository;

	@InjectMocks
	private Customer customer;

	@BeforeEach
	public void setUp() {
		// Customer customer = new Customer();
		customer.setCustomerName("Karan");
		customer.setEmail("ram@gmail.com");
		customer.setNumber("8765432098");
		customer.setPassword("Ramayam@34");
	}

	@Test
	public void testAddCustomer() {
		Mockito.doReturn(customer).when(repository).save(Mockito.any());
		assertEquals(customer.getCustomerName(), service.addCustomer(customer).getCustomerName());
		assertEquals(customer.getEmail(), service.addCustomer(customer).getEmail());
		assertEquals(customer.getNumber(), service.addCustomer(customer).getNumber());
	}

	@Test
	public void testGetCustomerByName() throws CustomerNotFoundException {
		String customerName = "Karan";

		Mockito.when(repository.findByCustomerName(customerName)).thenReturn(customer);
		assertEquals(customerName, service.getCustomerByName(customerName).getCustomerName());

	}

	@Test
	public void testLogin() throws CustomerNotFoundException, WrongPasswordException {
		String customerName = "Karan";
		String password = "Ramayam@34";

		Mockito.when(repository.findByCustomerName(customerName)).thenReturn(customer);
		assertEquals(customerName, service.getCustomerByName(customerName).getCustomerName());
		assertEquals(password, service.getCustomerByName(customerName).getPassword());

	}

}
