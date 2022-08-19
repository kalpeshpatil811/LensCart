package com.lenscart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Customer;
import com.lenscart.exception.CustomerNameAlreadyExistException;
import com.lenscart.exception.CustomerNotFoundException;
import com.lenscart.exception.WrongPasswordException;
import com.lenscart.exception.WrongUsernameAndPassword;
import com.lenscart.service.ICustomerService;

/*********
 * Customer Controller Class
 *
 * Created By: Akshata Gurupwar
 * Date: 09/08/2022
 *********/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	// PostMapping

	/*
	 * Method: addCustomer(@Valid @RequestBody Customer customer) Description: It
	 * allows to add the Customer
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNameAlreadyExistException {
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// GetMapping By name

	/*
	 * Method: getCustomerByName(@PathVariable("customerName") String customerName)
	 * Description: It allows you to get the customer by Name.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("customer/customerName/{customerName}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("customerName") String customerName)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerByName(customerName), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method: customerLogin(@RequestBody Customer customer, HttpSession session)
	 * Description: It checks the valid login credentials.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("customer/login")
	public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer, HttpSession session)
			throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerService.loginCustomer(customer);
		session.setAttribute("customer", customer1);
		return new ResponseEntity<>(customer1, HttpStatus.OK);
	}

	// GetMapping

	/*
	 * Method: logout(HttpSession session) Description: It used to logout from
	 * application.
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("customer/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.getAttribute("customer") != null) {
			session.invalidate();
			return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
		}
	}

	// Put Mapping

	/*
	 * Method: updateCustomer(@Valid @RequestBody Customer customer) Description: It
	 * allows to update the Customer
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PutMapping("customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	// DeleteMapping

	/*
	 * Method: deleteCustomer(@PathVariable("customerId") int customerId)
	 * Description: It allows to remove the customer.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getCustomerById(@PathVariable("customerId") int customerId)
	 * Description: It allows you to get the Customer by I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

}