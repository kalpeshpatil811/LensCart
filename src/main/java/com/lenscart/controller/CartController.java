package com.lenscart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Cart;
import com.lenscart.service.ICartService;

/***************************
 * Cart Controller Class
 *
 * Created By: Kalpesh Patil
 * Date: 09/08/2022
 ***************************/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class CartController {
	@Autowired
	private ICartService cartService;

	// GetMapping

	/*
	 * Method: getAllCartItems() Description: It allows to get all the Cart Items.
	 * 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC
	 * and REST controllers.
	 * 
	 * @RestController: It is used to create RESTful web services using MVC.
	 * 
	 * @Autowired: It enables to inject object dependency implicitly.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@GetMapping("cart")
	public ResponseEntity<List<Cart>> getAllCartItems() {
		return new ResponseEntity<List<Cart>>(cartService.getAllCartItems(), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method: addToCart(@Valid @RequestBody Cart cartItem) Description: It allows
	 * to add the Cart Item.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("cart")
	public ResponseEntity<Cart> addToCart(@Valid @RequestBody Cart cartItem) {
		return new ResponseEntity<Cart>(cartService.addToCart(cartItem), HttpStatus.OK);
	}

	// DeleteMapping by I'd

	/*
	 * Method: removeFromCart(@PathVariable("itemId") int itemId) Description: It
	 * allows to remove the Cart Item by Item I'd.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("cart/{itemId}")
	public ResponseEntity<List<Cart>> removeFromCart(@PathVariable("itemId") int itemId) {
		List<Cart> cartList = cartService.removeFromCart(itemId);
		return new ResponseEntity<List<Cart>>(cartList, HttpStatus.OK);
	}

	// DeleteMapping by I'd

	/*
	 * Method: removeAllByCustomerId(@PathVariable("customerId") int customerId)
	 * Description: It allows to remove the All Cart Items by Customer I'd.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("cart/c/{customerId}")
	public ResponseEntity<String> removeAllByCustomerId(@PathVariable("customerId") int customerId) {
		String response = cartService.removeAllByCustomerId(customerId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getAllCartItemsByCustomerId(@PathVariable("customerId") int
	 * customerId) Description: It allows you to get the Cart Items by Customer I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("cart/{customerId}")
	public ResponseEntity<List<Cart>> getAllCartItemsByCustomerId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<List<Cart>>(cartService.getAllCartItemsByCustomerId(customerId), HttpStatus.OK);
	}
}
